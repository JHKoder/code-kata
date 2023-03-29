package code.kata.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Computer")
public class ComputerTest {

    @Test
    @DisplayName("1~3 외 랜덤한 숫자는 나오지 않습니다.")
    void randomOrder1And3(){
        //given
        Computer computer = new Computer();
        int[] arr = new int[100];

        //when
        for(int i=0;i<100;i++){
            arr[i] = computer.randomInt();
        }

        //then
        assertThat(Arrays.stream(arr).allMatch(num -> num>0 && num <4)).isTrue();
    }

    @Test
    @DisplayName("랜덤으로 나오는 숫자의 확률은 비슷합니다.")
    void random_numbers_have_similar_probabilities(){
        //given
        Computer computer = new Computer();
        int[] arr = new int[4];

        //when
        for(int i=0;i<3300;i++){
            arr[computer.randomInt()]++;
        }

        //then
        assertThat(arr[1] > 1000).isTrue();
        assertThat(arr[2] > 1000).isTrue();
        assertThat(arr[3] > 1000).isTrue();
    }
}
