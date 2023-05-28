public class PersonBuilder {
    private String name;
    private String surname;
    private int age = -1;
    private String city;

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        if (age > 150 || age < 0) throw new IllegalArgumentException("Возраст некорректен");
        this.age = age;
    }

    public void setAdress(String city) {
        this.city = city;
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
