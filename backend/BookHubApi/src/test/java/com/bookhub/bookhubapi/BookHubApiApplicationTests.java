package com.bookhub.bookhubapi;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class BookHubApiApplicationTests {
    Calculator calculatorTest = new Calculator();
    @Test
    void itShouldAddTwoNumbers() {
        //given
        int numberOne = 10;
        int numberTwo = 20;
        //when
        int result = calculatorTest.add(numberOne,numberTwo);

        // then
        int expected = 30;

        assertThat(result).isEqualTo(expected);
    }

    class Calculator{
        int add(int a , int b){
            return a+b;
        }
    }

}
