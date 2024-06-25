package com.DongNae.Board_Project.domain.mapping.Gathering;

import com.DongNae.Board_Project.domain.mapping.BaseEntity;
import com.DongNae.Board_Project.domain.mapping.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class GatheringComment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gathering_post_id")
    private GatheringPost gatheringPost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer_id")
    private Member writer;

    public void setGatheringPost(GatheringPost gatheringPost) {
        if (this.gatheringPost != null) {
            this.gatheringPost.getGatheringComments().remove(this);
        }
        this.gatheringPost = gatheringPost;
        gatheringPost.getGatheringComments().add(this);
    }

    public void update(final String content) {
        this.content = content;
    }
}

