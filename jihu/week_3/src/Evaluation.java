public interface Evaluation { // 학점 부여 정책을 인터페이스로 구현했다 (확장성)
    public abstract String getValue (int score); // 점수를 받아 학점을 부여하는 추상 메소드
}
