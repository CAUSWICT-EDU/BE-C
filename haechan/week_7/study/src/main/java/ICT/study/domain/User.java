package ICT.study.domain;

import ICT.study.domain.common.BaseEntity;
import ICT.study.domain.enums.UserStatus;
import ICT.study.domain.mapping.GroupMember;
import ICT.study.domain.mapping.Post;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<GroupMember> groupMemberList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> postList = new ArrayList<>();

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserSetting userSetting;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Locker locker;

    @Column(nullable = false, length = 20)
    private String name;
    @Column(nullable = false, length = 20)
    private String email;

    private long studentId;
    @Column(nullable = false, length = 20)
    private String studentMajor;
    @Column(nullable = false, length = 60)
    private String password;
    private Boolean isConfrimed;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10) DEFAULT 'PENDING'")
    private UserStatus status;
    private LocalDate inactiveDate;
}
