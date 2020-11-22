package person;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonTest {
    Person person;

    @Test
    @DisplayName("WHEN a Person is initialized with age 20 THEN Person.getAge will return 20")
    void testPerson1() {
        //GIVEN
        Person person = new Person("Bela", 20);
        //WHEN
        int received = person.getAge();
        //THEN
        assertThat(received).isEqualTo(20);
    }

    @Test
    @DisplayName("WHEN a Person is initialized with higher age then 120 THEN IllegalArgEx will be returned")
    void testPerson2() {
        //GIVEN
        //WHEN
        //THEN
        assertThrows(IllegalArgumentException.class, () -> new Person("Bela", 130));
    }

    @Test
    @DisplayName("WHEN a Person is initialized with lower age then 0 THEN IllegalArgEx will be returned")
    void testPerson3() {
        //GIVEN
        //WHEN
        //THEN
        assertThrows(IllegalArgumentException.class, () -> new Person("Bela", -10));
    }

    @Test
    @DisplayName("WHEN a Person is initialized with name Bela THEN Person.getName will return Bela")
    void testPerson4() {
        //GIVEN
        Person person = new Person("Bela", 66);
        //WHEN
        String received = person.getName();
        //THEN
        assertThat(received).isEqualTo("Bela");
    }

    @Test
    @DisplayName("WHEN a Person is initialized with null name THEN IllegalArgEx will be returned")
    void testPerson5() {
        //GIVEN
        //WHEN
        //THEN
        assertThrows(IllegalArgumentException.class, () -> new Person(null, 15));
    }

    @Test
    @DisplayName("WHEN a Person is initialized with empty name THEN IllegalArgEx will be returned")
    void testPerson6() {
        //GIVEN
        //WHEN
        //THEN
        assertThrows(IllegalArgumentException.class, () -> new Person("", 15));
    }

}
