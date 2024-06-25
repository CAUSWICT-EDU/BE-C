package study.domain;

import jakarta.persistence.*;
import lombok.*;
import study.domain.common.BaseEntity;
import study.domain.mapping.MemberGroup;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 40)
    private String name;

    @OneToMany(mappedBy = "Board", cascade = CascadeType.ALL)
    private List<Post> postList = new ArrayList<>();

}
