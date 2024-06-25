package com.DongNae.Board_Project.domain.mapping.Gathering;

import com.DongNae.Board_Project.domain.Category;
import com.DongNae.Board_Project.domain.mapping.BaseEntity;
import com.DongNae.Board_Project.domain.mapping.Member;
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
public class GatheringPost extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title; // 게시글 제목
    private String body; // 게시글 내용

    private boolean isUpdated; // 게시글 수정 여부

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer_id")
    private Member writer; // 작성자

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gathering_board_id")
    private GatheringBoard gatheringBoard; // 속해 있는 게시판

    @OneToMany(mappedBy = "gatheringPost", cascade = CascadeType.ALL)
    private List<GatheringComment> gatheringComments = new ArrayList<>(); // 달린 댓글

    @OneToMany(mappedBy = "gatheringPost", cascade = CascadeType.ALL)
    private List<GatheringPostImage> gatheringPostImages = new ArrayList<>(); // 게시글에 달 이미지

    public void setGatheringBoard(GatheringBoard gatheringBoard) {
        if (this.gatheringBoard != null) {
            this.gatheringBoard.getGatheringPosts().remove(this);
        }
        this.gatheringBoard = gatheringBoard;
        gatheringBoard.getGatheringPosts().add(this);
    }

    public void update(final String title, final String body, final String category) {
        this.title = title;
        this.body = body;
        this.category = Category.valueOf(category);

        this.isUpdated = true;
    }

}
