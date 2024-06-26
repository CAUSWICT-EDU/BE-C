package umc.study.domain;

import umc.study.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.enums.Gender;
import umc.study.domain.enums.Status;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10)
    private String name;

    @Column(nullable = false, length = 10)
    private String login_id;

    @Column(nullable = false, length = 13)
    private String password;

    @Column(nullable = false, length = 10)
    private String nickname;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Gender gender;

    @Column(nullable = false, length = 13)
    private String phone_num;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Status status = Status.ACTIVE;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Post> postList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<GroupBoardPost> groupBoardPostList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Group> groupList = new ArrayList<>();

    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL)
    private Locker locker;

    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL)
    private Setting setting;
}

