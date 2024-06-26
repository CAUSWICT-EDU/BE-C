package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.Builder.Default;
import umc.study.domain.enums.Sorting;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 20)
    private String name;
    private int page;
    private int size;
    @Enumerated(EnumType.STRING)
    private Sorting sort;
    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<Post> postList = new ArrayList<>();
}
