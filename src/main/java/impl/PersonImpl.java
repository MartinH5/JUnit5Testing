package impl;

import first_semester_eksamen.Person;

public class PersonImpl implements Person {

    private final String name;
    private final int age;
    private final String gender;

    public PersonImpl(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getGender() {
        return gender;
    }
    
}
