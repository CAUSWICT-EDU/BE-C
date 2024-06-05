package com.DongNae.Board_Project.domain.mapping.Gathering;

import com.DongNae.Board_Project.domain.mapping.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class GatheringPostImage extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
