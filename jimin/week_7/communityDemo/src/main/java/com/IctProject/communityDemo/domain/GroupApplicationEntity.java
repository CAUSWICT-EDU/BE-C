package com.IctProject.communityDemo.domain;

import com.IctProject.communityDemo.domain.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class GroupApplicationEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long applicationId;

    @Column(nullable = false)
    private String requestedGroup;
    private boolean applicated;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private GroupCategoryEntity groupCategory;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;


}
