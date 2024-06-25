package com.IctProject.communityDemo.domain;

import com.IctProject.communityDemo.domain.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
// 여기서도 보안상의 이슈로 와일드카드 import는 최대한 지양하는 것이 좋은가?


@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;

    @Column(nullable = false, length = 20)
    private String firstName;

    @Column(nullable = false, length = 20)
    private String lastName;

    @Column(nullable = false, length = 11)
    private String mobile;

    @Column(nullable = false, length = 40)
    private String email;

    @Column(nullable = false, length = 20)
    private String nickname;

    @Column(nullable = true, length = 255) // 굳이 지정할 필요가 없긴 함 (기본값과 동일)
    private String icon;
    // .ico 파일의 경로를 지정하기 위해 String으로 선언
    // 예를 들어, private String icon = "src/main/resources/icons/user-icon.ico";

    @Column(nullable = false, length = 255)
    private String authorizedGroup;
    // .json 파일의 경로를 지정하기 위해 String으로 선언

    @Column(nullable = false, length = 255)
    private String authorizedPost;

    @Column(nullable = false)
    private boolean deactive;

    @ManyToOne
    @JoinColumn(name = "policy_id")
    private PolicyEntity policy;
}
