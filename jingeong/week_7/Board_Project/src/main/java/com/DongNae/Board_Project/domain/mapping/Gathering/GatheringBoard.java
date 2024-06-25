package com.DongNae.Board_Project.domain.mapping.Gathering;

import com.DongNae.Board_Project.domain.mapping.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class GatheringBoard extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name; // 게시판 이름

    private String description; // 게시판에 대한 간단한 설명

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    private Member admin; // 게시판을 생성한 유저

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gathering_id")
    private Gathering gathering; // 속해 있는 게시판

    @OneToMany(mappedBy = "gatheringBoard", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<GatheringPost> gatheringPosts = new ArrayList<>();

    public void setGathering(Gathering gathering) {
        if (this.gathering != null) {
            this.gathering.getGatheringBoards().remove(this);
        }
        this.gathering = gathering;
        gathering.getGatheringBoards().add(this);
    }

    public void update(final String name, final String description) {
        if (Strings.isNotEmpty(name)) { // 게시판 이름에 빈 문자열이면 업데이트 하지 않음
            this.name = name;
        }

        this.description = description; // 설명은 완전히 없애기 가능
    }
}

