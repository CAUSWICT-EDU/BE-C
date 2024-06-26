package umc.study.web.dto;

import lombok.Getter;

@Getter
public class MemberRequest {

    @Getter
    public static class JoinDto{
        private String name;
        private String login_id;
        private String password;
        private String nickname;
        private int gender;
        private String phone_num;
    }
}
