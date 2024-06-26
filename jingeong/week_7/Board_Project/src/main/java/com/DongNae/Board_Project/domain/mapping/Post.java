package com.DongNae.Board_Project.domain.mapping;

import com.DongNae.Board_Project.domain.BaseEntity;
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
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title; // 게시글 제목
    private String body; // 게시글 내용

    private boolean isUpdated; // 게시글 수정 여부

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer_id")
    private Member writer; // 작성자

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board; // 속해 있는 게시판

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>(); // 달린 댓글

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<PostImage> postImages = new ArrayList<>(); // 게시글에 달 이미지

    public void setBoard(Board board) {
        if (this.board != null) {
            this.board.getPosts().remove(this);
        }
        this.board = board;
        board.getPosts().add(this);
    }

    public void update(final String title, final String body) {
        this.title = title;
        this.body = body;
        this.isUpdated = true;
        // todo :  게시글 수정 시, 수정 전 내용 보이게
    }
}
