package recursion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


public class RecursionTest {

    Recursion recursion;

    @BeforeEach
    void setUp() {
        recursion = new Recursion();
    }

    @Test
    @DisplayName("WHEN sum(10) THEN 55 will be returned")
    void sumOfFirstNTest() {
        //GIVEN
        //WHEN
        int received = recursion.sumOfFirstN(10);
        //THEN
        assertThat(received).isEqualTo(55);
    }

    @Test
    @DisplayName("WHEN sum(0) THEN 0 will be returned")
    void sumOfFirstNTest2() {
        //GIVEN
        //WHEN
        int received = recursion.sumOfFirstN(0);
        //THEN
        assertThat(received).isEqualTo(0);
    }

    @Test
    @DisplayName("WHEN sum(negative number) THEN IllegalArgEx will be returned")
    void sumOfFirstNTest3() {
        //GIVEN
        //WHEN
        //THEN
        assertThrows(IllegalArgumentException.class, () -> recursion.sumOfFirstN(-5));
    }

    @Test
    @DisplayName("WHEN sum(10) evens THEN 30 will be returned")
    void somOfFirstNEvenTest() {
        //GIVEN
        //WHEN
        int received = recursion.sumOfFirstNEven(10);
        //THEN
        assertThat(received).isEqualTo(30);
    }

    @Test
    @DisplayName("WHEN sumOfFirstNEven(negative number) THEN IllegalArgEx will be returned")
    void sumOfFirstNEvenTest2() {
        //GIVEN
        //WHEN
        //THEN
        assertThrows(IllegalArgumentException.class, () -> recursion.sumOfFirstNEven(-5));
    }

    @Test
    @DisplayName("WHEN sumOfFirstNEven(0) THEN 0 will be returned")
    void sumOfFirstNEvenTest3() {
        //GIVEN
        //WHEN
        int received = recursion.sumOfFirstNEven(0);
        //THEN
        assertThat(received).isEqualTo(0);
    }

    @Test
    @DisplayName("WHEN level is given THEN check if it's palindrome")
    void palindromeReverse() {
        //GIVEN
        //WHEN
        boolean received = recursion.isPalindrome("level");
        //THEN
        assertThat(received).isTrue();
    }

    @Test
    @DisplayName("WHEN null is given THEN IllegalArgEx is returned")
    void palindromeReverse2() {
        //GIVEN
        //WHEN
        //THEN
        assertThrows(IllegalArgumentException.class, () -> recursion.palindromeReverse(null));
    }

    @Test
    @DisplayName("WHEN level is given THEN true is returned")
    void palindromeCheckLetters() {
        //GIVEN
        //WHEN
        boolean received = recursion.palindromeCheckLetters("level");
        //THEN
        assertThat(received).isTrue();
    }

    @Test
    @DisplayName("WHEN null is given THEN IllegalArgEx is returned")
    void palindromeCheckLetters2() {
        //GIVEN
        //WHEN
        //THEN
        assertThrows(IllegalArgumentException.class, () -> recursion.palindromeCheckLetters(null));
    }

    @Test
    @DisplayName("WHEN 123456 is received THEN 21 is returned")
    void sumOfDigitsTest() {
        //GIVEN
        //WHEN
        int received = recursion.sumOfDigits(123456);
        //THEN
        assertThat(received).isEqualTo(21);
    }

    @Test
    @DisplayName("WHEN one digit number is received THEN the same number is returned")
    void sumOfDigitsTest2() {
        //GIVEN
        //WHEN
        int received = recursion.sumOfDigits(6);
        //THEN
        assertThat(received).isEqualTo(6);
    }

}
