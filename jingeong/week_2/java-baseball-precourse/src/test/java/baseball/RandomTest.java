package baseball;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomTest {
    Computer computer = new Computer();

    @Test
    void pickRandomNuber() {
        assertThat(computer.makeRandomNumber()).containsAnyElementsOf(Arrays.asList(1,2,3,4,5,6,7,8,9));
        System.out.println(computer.makeRandomNumber());
    }
}

/*
test bulid 오류
settings -> Gradle -> Build랑 test를 Gradle이 아니라 IntelliJ로 변경하니까 해결됨
 */