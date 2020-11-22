package person;

import java.util.Objects;

public class Person {
    private final int id;
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this(0, name, age);
    }

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = setName(name);
        this.age = setAge(age);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    private String setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid name!");
        } else {
            return name;
        }
    }

    private int setAge(int age) {
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Invalid age!");
        } else {
            return age;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
