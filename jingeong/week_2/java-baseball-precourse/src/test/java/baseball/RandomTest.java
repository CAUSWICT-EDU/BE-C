package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomTest {

    @Test
    void bound() {
        assertThat(Computer.getInstance().makeRandomNumber()).containsAnyElementsOf(Arrays.asList(1,2,3,4,5,6,7,8,9));
        System.out.println(Computer.getInstance().makeRandomNumber());
    }

    @Test
    void duplicated() {
        List<Integer> random = new ArrayList<>(Computer.getInstance().makeRandomNumber());
        System.out.println(random);
        Set<Integer> duple = new LinkedHashSet<>(random);
        assertThat(duple.size()).isEqualTo(random.size());
    }
}

/*
test bulid 오류
settings -> Gradle -> Build랑 test를 Gradle이 아니라 IntelliJ로 변경하니까 해결됨
 */