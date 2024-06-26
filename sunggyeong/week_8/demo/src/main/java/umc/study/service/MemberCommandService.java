package umc.study.service;

import umc.study.converter.MemberConverter;
import umc.study.domain.Member;
import umc.study.web.dto.MemberRequest;

public interface MemberCommandService {
    Member joinMember(MemberRequest.JoinDto request);
    void CheckNickname(String nickname);
}
