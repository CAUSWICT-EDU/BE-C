package umc.study.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.ErrorState;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.MemberHandler;
import umc.study.converter.MemberConverter;
import umc.study.domain.Member;
import umc.study.repository.MemberRepository;
import umc.study.web.dto.MemberRequest;
import umc.study.web.dto.MemberResponse;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {
    @Override
    @Transactional
    public Member joinMember(MemberRequest.JoinDto request){
        Member newMember = MemberConverter.toMember(request);
        return newMember;
    }
    @Override
    public void CheckNickname(String nickname){
        if(nickname == null)
            throw new MemberHandler(ErrorStatus.NICKNAME_NOT_EXIST);
    }
}
