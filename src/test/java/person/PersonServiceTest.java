package person;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PersonServiceTest {

    PersonService personService;

    @BeforeEach
    void setUp() {
        personService = new PersonService(List.of());
    }

    @Test
    @DisplayName("WHEN added a person THEN the size of the list will be 1")
    void addPerson() {
        //GIVEN
        //WHEN
        personService.addPerson(new Person("Bela", 15));
        //THEN
        assertThat(personService.getAllPersons().size()).isEqualTo(1);
        assertThat(personService.getAllPersons().get(0).getId()).isEqualTo(1);
    }

    @Test
    @DisplayName("WHEN addPerson with invalid name THEN IllegalArgEx is returned")
    void addPerson2() {
        //GIVEN
        //WHEN
        //THEN
        assertThrows(IllegalArgumentException.class, () -> personService.addPerson(new Person("",64)));
    }

    @Test
    @DisplayName("WHEN addPerson with null name THEN IllegalArgEx is returned")
    void addPerson3() {
        //GIVEN
        //WHEN
        //THEN
        assertThrows(IllegalArgumentException.class, () -> personService.addPerson(new Person(null,64)));
    }

    @Test
    @DisplayName("WHEN addPerson with invalid age THEN IllegalArgEx is returned")
    void addPerson4() {
        //GIVEN
        //WHEN
        //THEN
        assertThrows(IllegalArgumentException.class, () -> personService.addPerson(new Person("Ana", 254)));
    }

    @Test
    @DisplayName("WHEN remove a person THEN the size of the list will be decreased and the person removed will be returned")
    void removePerson() {
        //GIVEN
        personService.addPerson(new Person("Bela", 60));
        personService.addPerson(new Person("Marius", 6));
        personService.addPerson(new Person("Ana", 45));
        //WHEN
        Person removedPerson = personService.removePerson(1);
        //THEN
        assertThat(personService.getAllPersons().size()).isEqualTo(2);
        assertThat(removedPerson.getId()).isEqualTo(1);
        assertThat(removedPerson.getName()).isEqualTo("Bela");
    }

    @Test
    @DisplayName("WHEN try to remove a person with invalid ID THEN MyException returned")
    void removePerson2() {
        //GIVEN
        personService.addPerson(new Person("Bela", 60));
        personService.addPerson(new Person("Marius", 6));
        personService.addPerson(new Person("Ana", 45));
        //WHEN
        //THEN
        assertThrows(MyException.class, () -> personService.removePerson(5));
    }

    @Test
    @DisplayName("WHEN getAllPersons is called THEN every person in the list is returned")
    void getAllPersons() {
        //GIVEN
        personService.addPerson(new Person("Bela", 60));
        personService.addPerson(new Person("Marius", 6));
        personService.addPerson(new Person("Ana", 45));
        //WHEN
        List<Person> personList = personService.getAllPersons();
        //THEN
        assertThat(personList.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("WHEN getAllPersons is called on empty list THEN an empty list is returned")
    void getAllPersons2() {
        //GIVEN
        //WHEN
        List<Person> personList = personService.getAllPersons();
        //THEN
        assertThat(personList).isEmpty();
    }

    @Test
    @DisplayName("WHEN getPersonsOlderThan THEN all the persons who are older are returned")
    void getPersonsOlderThan() {
        //GIVEN
        personService.addPerson(new Person("Bela", 60));
        personService.addPerson(new Person("Marius", 6));
        personService.addPerson(new Person("Ana", 45));
        //WHEN
        List<Person> personList = personService.getPersonsOlderThan(10);
        //THEN
        assertThat(personList.size()).isEqualTo(2);
        assertThat(personList.get(0).getId()).isEqualTo(1);
        assertThat(personList.get(1).getId()).isEqualTo(3);
    }

    @Test
    @DisplayName("WHEN getAllPersonNames is called THEN all the names are returned in a list")
    void getAllPersonNames() {
        //GIVEN
        personService.addPerson(new Person("Bela", 60));
        personService.addPerson(new Person("Marius", 6));
        personService.addPerson(new Person("Ana", 45));
        //WHEN
        List<String> nameList = personService.getAllPersonNames();
        //THEN
        assertThat(nameList.size()).isEqualTo(3);
        assertThat(nameList.get(0)).isEqualTo("Bela");
        assertThat(nameList.get(1)).isEqualTo("Marius");
        assertThat(nameList.get(2)).isEqualTo("Ana");
    }

    @Test
    @DisplayName("WHEN getPerson is called THEN all the Persons with that name are returned")
    void getPerson() {
        //GIVEN
        personService.addPerson(new Person("Bela", 60));
        personService.addPerson(new Person("Marius", 6));
        personService.addPerson(new Person("Ana", 45));
        personService.addPerson(new Person("Ana", 77));
        //WHEN
        Person person = personService.getPerson("Ana");
        //THEN
        assertThat(person.getId()).isEqualTo(3);
    }

    @Test
    @DisplayName("WHEN getPerson is called with invalid name THEN MyException returned")
    void getPerson2() {
        //GIVEN
        personService.addPerson(new Person("Bela", 60));
        personService.addPerson(new Person("Marius", 6));
        personService.addPerson(new Person("Ana", 45));
        personService.addPerson(new Person("Ana", 77));
        //WHEN
        //THEN
        assertThrows(MyException.class, () -> personService.getPerson("Ioan"));
    }

    @Test
    @DisplayName("WHEN getPersonById is called THEN the person with that id is returned")
    void getPersonById() {
        //GIVEN
        personService.addPerson(new Person("Bela", 60));
        personService.addPerson(new Person("Marius", 6));
        personService.addPerson(new Person("Ana", 45));
        personService.addPerson(new Person("Ana", 77));
        //WHEN
        Person person = personService.getPersonById(2);
        //THEN
        assertThat(person.getName()).isEqualTo("Marius");
    }

    @Test
    @DisplayName("WHEN getPersonById is called with invalid Id THEN MyException is returned")
    void getPersonById2() {
        //GIVEN
        personService.addPerson(new Person("Bela", 60));
        personService.addPerson(new Person("Marius", 6));
        personService.addPerson(new Person("Ana", 45));
        personService.addPerson(new Person("Ana", 77));
        //WHEN
        //THEN
        assertThrows(MyException.class, () -> personService.getPersonById(8));
    }
}