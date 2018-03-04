package impl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.util.ArrayList;
import org.junit.After;
import static org.junit.Assert.assertEquals;
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
    public void readTest() throws IOException {
        ArrayList<PersonImpl> people;
        people = hi.readFile("persons.csv");
        System.out.println("After a read we have " + people.size() + " people");
        assert(people.size() > 1);
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
        int youngest = 10;
        PersonImpl actualYoungest = hi.getLowestAge(testp);     
        System.out.println(actualYoungest.getName() + " is the yoiungest\n");
        assertEquals(actualYoungest.getAge(),youngest);
        System.out.println("\n" + "Youngest person:");
        System.out.println(hi.getLowestAge(testp).getName() + " is the youngest");
    }

    @Test
    public void oldestTest() {
        int oldest = 160;
        PersonImpl actualOldest = hi.getHighestAge(testp);     
        System.out.println(actualOldest.getName() + " is the oldest\n");
        assertEquals(actualOldest.getAge(),oldest);
    }
    
    @Test
    public void insertTest(){
        PersonImpl testPerson = new PersonImpl("\nTest", 15, "Test");
        hi.insertPerson(testPerson);
        
    
    
    
    }

//    @Test
//    public void insertTest(){
//        PersonImpl testPerson = new PersonImpl("\nTest", 15, "Test");
//        hi.insertPerson(testPerson);
//        
//    }
    // Here we check if each person's name starts with U

    @Test
    public void letterTest() {
        ArrayList<PersonImpl> testData = hi.getNameStartingWithLetter(testp, "U");
        System.out.println("\n" + "letter with U in their name consists of: " + testData.size() + " persons");
        System.out.println("and they are:");
        for (PersonImpl personImpl : testData) {
            System.out.println(personImpl.getName());
        }
        
    }
    //Here We check if we got a person by the right name. 
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
    public void sortByNameTest() {
        System.out.println("\n" + "Sorting the CSV by name:");
        ArrayList<PersonImpl> SortName = hi.sortByName(testp);
        for (PersonImpl line : SortName) {
            System.out.println(line);
        }
    }

    @Test
    public void deletionTest() {
        //    hi.deletePersonByName("Ulla");

    }
}
