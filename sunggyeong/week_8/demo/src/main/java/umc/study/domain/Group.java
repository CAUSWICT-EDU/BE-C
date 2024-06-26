package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 20)
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<GroupBoard> boardList = new ArrayList<>();
}
