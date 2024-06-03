package com.DongNae.Board_Project.domain.mapping;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.apache.logging.log4j.util.Strings;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public class GatheringBoard extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name; // 게시판 이름

    private String description; // 게시판에 대한 간단한 설명

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    private User admin; // 게시판을 생성한 유저

    @OneToMany(mappedBy = "gathering", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE) // 게시판이 지워지면, 게시글도 같이 날라감
    @Builder.Default // 빌더 사용시 초기화 무시 현상 해소
    private List<GatheringPost> gatheringPosts = new ArrayList<>();

    public void update(final String name, final String description) {
        if (Strings.isNotEmpty(name)) { // 게시판 이름에 빈 문자열이면 업데이트 하지 않음
            this.name = name;
        }

        this.description = description; // 설명은 완전히 없애기 가능
    }
}
