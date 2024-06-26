package umc.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.converter.MemberConverter;
import umc.study.domain.Member;
import umc.study.service.MemberCommandService;
import umc.study.apiPayload.ApiResponse;
import umc.study.web.dto.MemberRequest;
import umc.study.web.dto.MemberResponse;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {
    private final MemberCommandService memberCommandService;

    @PostMapping("/join")
    public ApiResponse<MemberResponse.JoinResultDTO> joinAPI(@RequestBody @Valid MemberRequest.JoinDto request){
        Member member=memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @GetMapping("/exception")
    public ApiResponse<MemberResponse.MemberExceptionDTO> exceptionAPI(@RequestParam String nickname){
        memberCommandService.CheckNickname(nickname);
        return ApiResponse.onSuccess(MemberConverter.toMemberExceptionDTO(nickname));
    }
}

