package impl;

import java.io.IOException;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

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
        ArrayList<PersonImpl> people;
        people = hi.readFile("persons.csv");
        System.out.println("After a read we have " + people.size() + " people");
        assert(people.size() > 1);
    }

    @Test
    public void highestAgeTest() {
        System.out.println("\n" + "Oldest test:");
        int oldest = 160;
        PersonImpl actualOldest = hi.getHighestAge(testp);     
        System.out.println(actualOldest.getName() + " is the oldest\n");
        assertEquals(actualOldest.getAge(),oldest);
    }
    
    @Test
    public void lowestAgeTest() {
        System.out.println("\n" + "Youngest test:");
        int youngest = 10;
        PersonImpl actualYoungest = hi.getLowestAge(testp);     
        System.out.println(actualYoungest.getName() + " is the youngest\n");
        assertEquals(actualYoungest.getAge(),youngest);
        System.out.println("\n" + "Youngest person:");
        System.out.println(hi.getLowestAge(testp).getName() + " is the youngest");
    }
    
    // Here we check if each person's name starts with U
    @Test
    public void nameStartingWithLetterTest() {
        ArrayList<PersonImpl> testData = hi.getNameStartingWithLetter(testp, "U");
        System.out.println("\n" + "letter with U in their name consists of: " + testData.size() + " persons");
        System.out.println("and they are:");
        for (PersonImpl personImpl : testData) {
            System.out.println(personImpl.getName());
        }
        
    }
    //Here We check if we got a person by the right name. 
    @Test
    public void getByNameTest() {
        ArrayList<PersonImpl> testData = hi.getByName("Ulla", testp);
        System.out.println("\n" + "We have : " + testData.size() + " with the same name");
        System.out.println("Who are/is:");
        for (PersonImpl p : testData) {
            if(!p.getName().equals("Ulla")){
                fail("Found a name that doesn't fit");
            }
        }
    }

    @Test
    public void isMaleTest() {
        System.out.println("\n" + "Gender test:");
        PersonImpl testPerson = new PersonImpl("Hans", 15, "male");
        assertEquals("male",testPerson.getGender());
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
    public void peopleYoungerThanTest() {
        System.out.println("\n" + "Get People younger than Test:");
        ArrayList<PersonImpl> youngThan = hi.getPeopleYoungerThan(testp, 20);
        for (PersonImpl line : youngThan){
            if(line.getAge() > 19) fail("Found someone who was too old");
            System.out.println(line);
        }
    }

//    @Test
//    public void insertPersonTest(){
//        System.out.println("\n" + "Insert person test:");
//        PersonImpl testPerson = new PersonImpl("\nTest", 15, "Test");
//        hi.insertPerson(testPerson);
//        System.out.println(testPerson + " has been inserted");
//    }
    
    @Test
    public void DeletePersonByCredentailsTest() {
        hi.deletePersonByCredentials("Test,15,Test");
    }
}
