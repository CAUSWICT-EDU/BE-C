package com.DongNae.Board_Project.domain.mapping.Gathering;

import com.DongNae.Board_Project.domain.mapping.BaseEntity;
import com.DongNae.Board_Project.domain.mapping.Post;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public class GatheringPostImage extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long id;

    @Column(nullable = false)
    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gathering_post_id")
    private GatheringPost gatheringPost;

    public void setGatheringPost(GatheringPost gatheringPost) {
        if (this.gatheringPost != null) {
            this.gatheringPost.getGatheringPostImages().remove(this);
        }
        this.gatheringPost = gatheringPost;
        gatheringPost.getGatheringPostImages().add(this);
    }
}
