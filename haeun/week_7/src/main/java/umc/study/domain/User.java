package umc.study.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.Gender;
import umc.study.domain.enums.MemberStatus;
import umc.study.domain.enums.SocialType;
import umc.study.domain.mapping.ClubAccess;
import umc.study.domain.mapping.ClubMember;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

public class User extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 10)
  private String password;

  @Column(nullable = false, length = 20)
  private String name;

  @Enumerated(EnumType.STRING)
  @Column(columnDefinition = "VARCHAR(10)")
  private Gender gender;

  @Enumerated(EnumType.STRING)
  private SocialType socialType;

  @Enumerated(EnumType.STRING)
  @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
  private MemberStatus status;

  @Column(nullable = false, length = 50)
  private String email;

  @Column(nullable = false, length = 20)
  private String phonenumber;

  @Column(nullable = false)
  private LocalDate inactiveDate;

  @OneToMany(mappedBy = "User", cascade = CascadeType.ALL)
  private List<ClubAccess> AccessList = new ArrayList<>();

  @OneToMany(mappedBy = "User", cascade = CascadeType.ALL)
  private List<ClubMember> MyClubList = new ArrayList<>();


  private LocalDateTime createdAt;
  private LocalDateTime secessionAt;
}