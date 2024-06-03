package com.DongNae.Board_Project.domain.mapping;

import com.DongNae.Board_Project.domain.Category;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public class Post extends BaseEntity{
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
    private User writer; // 작성자

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board; // 속해 있는 게시판

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    @Builder.Default
    private List<Comment> comments = new ArrayList<>(); // 달린 댓글

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    @Builder.Default
    private List<PostImage> postImages = new ArrayList<>(); // 게시글에 달 이미지

    public void setBoard(Board board) {
        if (this.board != null) {
            this.board.getPosts().remove(this);
        }
        this.board = board;
        board.getPosts().add(this);
    }

    public void update(final String title, final String body, final String category) {
            this.title = title;
            this.body = body;
            this.category = Category.valueOf(category);

        this.isUpdated = true;
    }

}
