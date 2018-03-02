package impl;

public class PersonImpl implements Comparable<PersonImpl>{

    private String name;
    private int age;
    private String gender;

    public PersonImpl(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }


    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    public String getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;

    }

    @Override
    public int compareTo(PersonImpl p) {
        if (this.age == p.age){
            return this.name.compareTo(p.name);
        } else {
            return (p.age - this.age) > 0 ? 1 : -1;
        }
    }
    
    @Override
    public String toString() {
        return "Persons: " + "Name: " + name + " Age: " + age + " Gender: " + gender;
    }
}
