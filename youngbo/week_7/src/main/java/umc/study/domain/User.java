package umc.study.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.Gender;
import umc.study.domain.enums.UserState;
import umc.study.domain.enums.SocialType;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;    //기본키

  @Column(nullable = false, length = 40)
  private String name;  //이름

  @Column(columnDefinition = "VARCHAR(10)")
  @Enumerated(EnumType.STRING)  //성별
  private Gender gender;

  @Column(nullable = false, length = 40)
  private String mail;    //메일주소

  @Column(nullable = false, length = 20)
  private String loginId;   //로그인아이디

  @Column(nullable = false, length = 20)
  private String password;  //비밀번호

  @Column(columnDefinition = "BIGINT")
  private int postNum;  //게시글 수

  @Column(columnDefinition = "BIGINT")
  private int commentNum; //댓글 수


  @Enumerated(EnumType.STRING)
  private SocialType socialType;  //메일 종류

  @Enumerated(EnumType.STRING)
  @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
  private UserState status;   //유저 상태(비활성화 여부)

  private LocalDate inactiveDate;   //비활성화 일자

  @OneToOne
  @JoinColumn(name = "locker_id")
  private Locker locker;
  
}

