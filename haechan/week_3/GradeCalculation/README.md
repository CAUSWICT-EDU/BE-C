# 3주차 과제 - 학점산출 프로그램
---
## 기능 설명
학생 점수 데이터는 CSV 파일, 학점 정책 데이터는 JSON 파일 형식으로 작성 후 실행하면, 학생 점수에 따른 학점을 각 과목별로 테이블 형식의 텍스트로 출력한다.

CSV 파일형식에 맞게 과목이 추가되더라도 이상없이 작동함\
(다만 "이름", "학번", "필수과목" 항목은 필수로 존재해야 한다)

학점 정책 데이터에 추가 정책을 넣더라도 이상없이 작동함\
(만약 모든 학점 정책에 해당되지 않으면 런타임에러 발생)

## 클래스 설명

Aplication: 프로그램 전체의 실행역할\
Input: 입력처리 클래스\
Output: 출력처리 클래스\
JudgeGrade: 학점 판단

GradeInfo: 학점에 대한 점수조건의 데이터\
GradeTable: 학점 조건 테이블

StudentInfo: 한 학생에 대한 데이터\
StudentTable: 학생 데이터 테이블
