package com.DongNae.Board_Project.domain.mapping;

import com.DongNae.Board_Project.domain.mapping.Gathering.MemberGathering;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // DB 상 식별 id

    @Column(name = "account_id", unique = true)
    private String accountId; // 회원 가입 시 넣는 계정 id => 유저 간 겹칠 수 x

    private String password;
    private String username;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<MemberGathering> memberGatheringList = new ArrayList<>();

    // todo : 어떤 게시판일지 주제 잡고, 필요한 column 더 추가하기
}
