package umc.study.converter;

import umc.study.domain.Member;
import umc.study.domain.enums.Gender;
import umc.study.web.dto.MemberRequest;
import umc.study.web.dto.MemberResponse;

import java.time.LocalDateTime;

public class MemberConverter {
    public static MemberResponse.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponse.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequest.JoinDto request){
        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            default:
                throw new IllegalArgumentException("Invalid gender value: " + request.getGender());
        }

        return Member.builder()
                .gender(gender)
                .name(request.getName())
                .login_id(request.getLogin_id())
                .password(request.getPassword())
                .nickname(request.getNickname())
                .phone_num(request.getPhone_num())
                .build();
    }
    public static MemberResponse.MemberExceptionDTO toMemberExceptionDTO(String nickname){
        return MemberResponse.MemberExceptionDTO.builder()
                .nickname(nickname)
                .build();
    }
}

