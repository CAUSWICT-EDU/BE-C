package com.example.demo.domain;

import com.example.demo.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class GroupNoticeboard extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 20)
    private String name;

    /*@OneToMany(mappedBy = "GroupNoticeboard", cascade = CascadeType.ALL)
    private List<GroupPost> groupPosts = new ArrayList<>();*/

    @OneToOne
    @JoinColumn(name = "group_id")
    private Group group;

}

