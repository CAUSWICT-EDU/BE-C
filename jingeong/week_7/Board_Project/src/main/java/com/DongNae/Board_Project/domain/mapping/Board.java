package com.DongNae.Board_Project.domain.mapping;

import com.DongNae.Board_Project.domain.Category;
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
public class Board extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name; // 게시판 이름

    private String description; // 게시판에 대한 간단한 설명

    @Enumerated(EnumType.STRING)
    private Category category;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    private Member admin; // 게시판을 생성한 유저

    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();

    public void update(final String name, final String description) {
        if (Strings.isNotEmpty(name)) { // 게시판 이름에 빈 문자열이면 업데이트 하지 않음
            this.name = name;
        }

        this.description = description; // 설명은 완전히 없애기 가능
    }
}
