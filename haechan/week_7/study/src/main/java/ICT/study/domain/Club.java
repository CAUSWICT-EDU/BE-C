package ICT.study.domain;

import ICT.study.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Club extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL)
    private List<Board> BoardList = new ArrayList<>();

    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL)
    private List<Board> GroupMember = new ArrayList<>();

    @Column(nullable = false, length = 20)
    private String name;
    @Column(nullable = false, length = 60)
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10) DEFAULT 'PENDING'")
    private ICT.study.domain.enums.GroupStatus GroupStatus;
    private boolean isJoinable;
    private LocalDate inactiveDate;


}
