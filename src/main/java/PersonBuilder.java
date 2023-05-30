public class PersonBuilder {
    private String name;
    private String surname;
    private int age = -1;
    private String city;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age > 150 || age < 0) throw new IllegalArgumentException("Возраст некорректен");
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String city) {
        this.city = city;
        return this;
    }

    public Person build() {
        if (name == null || surname == null) {
            throw new IllegalArgumentException("Имя и возраст - обязательные параметры для создания объекта. Пожалуйста, заполните их");
        } else if (age != -1 && city == null) {
            return new Person(name, surname, age);
        } else if (age == -1 && city != null) {
            return new Person(name, surname, city);
        } else if (age != -1 && city != null) {
            return new Person(name, surname, age, city);
        } else {
            return new Person(name, surname);
        }
    }
}
