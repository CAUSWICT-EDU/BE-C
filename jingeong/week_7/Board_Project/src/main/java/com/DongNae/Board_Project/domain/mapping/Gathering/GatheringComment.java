package com.DongNae.Board_Project.domain.mapping.Gathering;

import com.DongNae.Board_Project.domain.mapping.BaseEntity;
import com.DongNae.Board_Project.domain.mapping.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
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
    private User writer;

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
