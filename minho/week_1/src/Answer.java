import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Answer {
    // 랜덤 숫자 생성 메서드
    public int randomMake(){
        Random random = new Random(); // Random 클래스의 인스턴스 생성
        return random.nextInt(9) + 1; // 1부터 9까지의 랜덤한 정수 반환
    }

    // 컴퓨터가 선택한 숫자 리스트 생성 메서드
    public List<Integer> create(){
        List<Integer> computerNumber = new ArrayList<>(); // 정수를 저장할 ArrayList 생성
        while (computerNumber.size() < 3){ // 리스트의 크기가 3보다 작은 동안 반복
            int randomNumber = randomMake(); // 랜덤 숫자 생성
            if(computerNumber.contains(randomNumber)){ // 이미 리스트에 같은 숫자가 있다면
                continue; // 다음 반복으로 건너뜀
            }else { // 리스트에 같은 숫자가 없다면
                computerNumber.add(randomNumber); // 생성된 랜덤 숫자를 리스트에 추가
            }
        }
        return computerNumber; // 최종 생성된 숫자 리스트 반환
    }
}

