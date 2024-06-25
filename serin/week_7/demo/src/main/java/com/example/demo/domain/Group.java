package com.example.demo.domain;

import com.example.demo.domain.mapping.MemberApplication;
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
public class Group extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = true, length = 50)
    private String description;

    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private Status groupStatus;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<MemberApplication> memberApplicationList = new ArrayList<>();

}


