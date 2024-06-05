package ICT.study.domain;

import ICT.study.domain.common.BaseEntity;
import ICT.study.domain.enums.BoardType;
import ICT.study.domain.mapping.Post;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import java.util.ArrayList;


@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Club club;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<Post> postList = new ArrayList<>();

    @Column(nullable = false, length = 20)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10) DEFAULT 'GENENAL'")
    private BoardType type;


}
