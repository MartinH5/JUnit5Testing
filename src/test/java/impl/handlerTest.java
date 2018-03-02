package impl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author OpieOP
 */
public class handlerTest {

    HandlerImpl hi;
    ArrayList<PersonImpl> testp;

    @Before
    public void setUp() throws IOException {
        hi = new HandlerImpl();
        testp = hi.readFile("persons.csv");
    }

    @Test
    public void readFileTest() throws IOException {
        System.out.println("\n" + "Read File test:");
        ArrayList<PersonImpl> personArr;
        personArr = hi.readFile("persons.csv");
        System.out.println("We have " + personArr.size() + " persons");
    }

    @Test
    public void youngestTest() {
        System.out.println("\n" + "Youngest person:");
        System.out.println(hi.getLowestAge(testp).getName() + " is the youngest");
    }

    @Test
    public void oldestTest() {
        System.out.println("\n" + "Oldest person:");
        System.out.println(hi.getHighestAge(testp).getName() + " is the oldest");
    }

//    @Test
//    public void insertTest(){
//        PersonImpl testPerson = new PersonImpl("\nTest", 15, "Test");
//        hi.insertPerson(testPerson);
//        
//    }
    @Test
    public void letterTest() {
        ArrayList<PersonImpl> testData = hi.getNameStartingWithLetter(testp, "U");
        System.out.println("\n" + "letter with U in their name consists of: " + testData.size() + " persons");
        System.out.println("and they are:");
        for (PersonImpl personImpl : testData) {
            System.out.println(personImpl.getName());
        }
    }

    @Test
    public void nameTest() {
        ArrayList<PersonImpl> testData = hi.getByName("Ulla", testp);
        System.out.println("\n" + "We have : " + testData.size() + " with the same name");
        System.out.println("Who are/is:");
        for (PersonImpl personImpl : testData) {
            System.out.println(personImpl.getName());
        }
    }

    @Test
    public void maleTest() {
        System.out.println("\n" + "Gender test:");
        PersonImpl testPerson = new PersonImpl("Hans", 15, "male");
        System.out.println("Is it true, that Hans is a male? " + "\nAnswer: " + hi.isMale(testPerson));
    }

    @Test
    public void sortByAgeTest() {
        System.out.println("\nSorting the CSV by age:");
        ArrayList<PersonImpl> SortAge = hi.sortByAge(testp);
        for (PersonImpl line : SortAge) {
            System.out.println(line);
        }
    }

    @Test
    public void deletionTest() {
        //    hi.deletePersonByName("Ulla");

    }
}
