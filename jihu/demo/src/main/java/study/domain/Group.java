package study.domain;

import jakarta.persistence.*;
import lombok.*;
import study.domain.common.BaseEntity;
import study.domain.mapping.MemberGroup;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Group extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int totalMember;

    @OneToMany(mappedBy = "Group", cascade = CascadeType.ALL)
    private List<MemberGroup> memberGroupList = new ArrayList<>();

    @OneToMany(mappedBy = "Group", cascade = CascadeType.ALL)
    private List<GroupBoard> groupBoardList = new ArrayList<>();

}
