package person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PersonService {
        private final List<Person> persons;

        public PersonService(Collection<Person> persons) {
            this.persons = new ArrayList<>();
            this.persons.addAll(persons);
        }

        public Person addPerson(Person person) {
            Person newPerson = new Person(persons.size() + 1, person.getName(), person.getAge());
            persons.add(newPerson);
            return newPerson;
        }

        public Person removePerson(int id) throws MyException {
            for (Person person : persons) {
                if (person.getId() == id) {
                    persons.remove(person);
                    return person;
                }
            }
            throw new MyException("There is no person with this ID: " + id);
        }

        public List<Person> getAllPersons() {
            return new ArrayList<>(persons);
        }

        public List<Person> getPersonsOlderThan(int age) {
            List<Person> personList = new ArrayList<>();
            for (Person person : persons) {
                if (person.getAge() > age) {
                    personList.add(person);
                }
            }
            return personList;
        }

        public List<String> getAllPersonNames() {
            List<String> nameList = new ArrayList<>();
            for (Person person : persons) {
                nameList.add(person.getName());
            }
            return nameList;
        }

        public Person getPerson(String name) throws MyException {
            for (Person person : persons) {
                if (person.getName().equalsIgnoreCase(name)) {
                    return person;
                }
            }
            throw new MyException("There is no Person with this name: " + name);
        }

        public Person getPersonById(int id) throws MyException {
            for (Person person : persons) {
                if (person.getId() == id) {
                    return person;
                }
            }
            throw new MyException("There is no Person with this ID: " + id);
        }
}
