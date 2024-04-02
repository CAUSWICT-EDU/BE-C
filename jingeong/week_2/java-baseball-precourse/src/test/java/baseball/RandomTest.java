package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomTest {
    Computer computer = new Computer();

    @Test
    void bound() {
        assertThat(computer.getRandomNumber()).containsAnyElementsOf(Arrays.asList(1,2,3,4,5,6,7,8,9));
        System.out.println(computer.getRandomNumber());
    }

    @Test
    void duplicated() {
        ArrayList<Integer> random = new ArrayList<>(computer.getRandomNumber());
        System.out.println(random);
        Set<Integer> duple = new LinkedHashSet<>(random);
        assertThat(duple.size()).isEqualTo(random.size());
    }
}

/*
test bulid 오류
settings -> Gradle -> Build랑 test를 Gradle이 아니라 IntelliJ로 변경하니까 해결됨
 */