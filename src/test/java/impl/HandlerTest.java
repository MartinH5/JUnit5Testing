package impl;

import java.io.IOException;
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class HandlerTest {

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
        assertTrue(people.size() > 1);
    }

    @Test
    public void highestAgeTest() {
        System.out.println("\n" + "Oldest test:");
        int oldest = 160;
        PersonImpl actualOldest = hi.getHighestAge(testp);
        System.out.println(actualOldest.getName() + " is the oldest\n");
        assertEquals(actualOldest.getAge(), oldest);
    }

    @Test
    public void lowestAgeTest() {
        System.out.println("\n" + "Youngest test:");
        int youngest = 10;
        PersonImpl actualYoungest = hi.getLowestAge(testp);
        System.out.println(actualYoungest.getName() + " is the youngest\n");
        assertEquals(actualYoungest.getAge(), youngest);
    }

    // Here we check if each person's name starts with U
    @Test
    public void nameStartingWithLetterTest() {
        ArrayList<PersonImpl> testData = hi.getNameStartingWithLetter(testp, "U");
        System.out.println("\n" + "letter with U in their name consists of: " + testData.size() + " persons");
        System.out.println("and they are:");
        for (PersonImpl personImpl : testData) {
            System.out.println(personImpl.getName());
            if (!personImpl.getName().substring(0, 1).equals("U")) {
                fail("Found a letter that doesn't fit");
            }
        }

    }

    //Here We check if we got a person by the right name. 
    @Test
    public void getByNameTest() {
        ArrayList<PersonImpl> testData = hi.getByName("Ulla", testp);
        System.out.println("\n" + "We have : " + testData.size() + " with the same name");
        System.out.println("Who are:");
        for (PersonImpl p : testData) {
            System.out.println(p.getName() + " " + p.getAge());
            if (!p.getName().equals("Ulla")) {
                fail("Found a name that doesn't fit");
            }
        }
    }

    @Test
    public void isMaleTest() {
        System.out.println("\n" + "Gender test:");
        PersonImpl testPerson = new PersonImpl("Hans", 15, "male");
        assertEquals("male", testPerson.getGender());
        System.out.println("Is it true, that Hans is a male? " + "\nAnswer: " + hi.isMale(testPerson));
    }

    @Test
    public void sortByAgeTest() {
        System.out.println("\nSorting the CSV by age:");
        ArrayList<PersonImpl> SortAge = hi.sortByAge(testp);
        boolean result = true;
        int tempAge = 9999;
        for (PersonImpl line : SortAge) {
            //System.out.println(line);
            if (line.getAge() > tempAge) {
                result = false;
            } else {
                tempAge = line.getAge();
            }
        }
        assertEquals(true, result);
    }

    @Test
    public void sortByNameTest() {
        System.out.println("\n" + "Sorting the CSV by name:");
        ArrayList<PersonImpl> SortName = hi.sortByName(testp);
        String tempName = "A";
        boolean result = true;
        for (PersonImpl line : SortName) {
//            System.out.println(line);
            if (tempName.charAt(0) == line.getName().charAt(0)) {
                if (!sameLetterHelper(tempName, line.getName())) {
                    result = false;
                }
            }
            if (line.getName().charAt(0) < tempName.charAt(0)) {
                System.out.println("Current name is: " + line.getName().charAt(0) + "  And Temp name is: " + tempName.charAt(0));
                result = false;
            } else {
                tempName = line.getName();
            }
        }
        assertEquals(true,result);
    }

    @Test
    public void peopleYoungerThanTest() {
        System.out.println("\n" + "Get People younger than Test:");
        ArrayList<PersonImpl> youngThan = hi.getPeopleYoungerThan(testp, 20);
        for (PersonImpl line : youngThan) {
            if (line.getAge() > 19) {
                fail("Found someone who was too old");
            }
            System.out.println(line);
        }
    }

    @Test
    public void insertPersonTest() throws IOException{
        System.out.println("\n" + "Insert person test:");
        PersonImpl testPerson = new PersonImpl("\nTest", 15, "Test");
        ArrayList<PersonImpl> people = hi.readFile("persons.csv");
        hi.insertPerson(testPerson);
        System.out.println(testPerson + " has been inserted");
        ArrayList<PersonImpl> peopleIns = hi.readFile("persons.csv");
        assertTrue(peopleIns.size() > people.size());
    }
    
//    @Test
//    public void deletePersonByCredentailsTest() throws IOException {
//        ArrayList<PersonImpl> people = hi.readFile("persons.csv");
//        PersonImpl testPerson = new PersonImpl("\nTest", 15, "Test");
//        hi.insertPerson(testPerson);
//        ArrayList<PersonImpl> peopleIns = hi.readFile("persons.csv");
//        assertTrue(peopleIns.size() > people.size());
//        
//        hi.deletePersonByCredentials("Test");
//        ArrayList<PersonImpl> peopleDel = hi.readFile("persons.csv");
//        
//        System.out.println("//////////People ins: " + peopleIns.size() + " og  people: " + people.size());
//        assertTrue(peopleDel.size() == people.size());
//    }

    private boolean sameLetterHelper(String a, String b) {

        int lengthA = a.length();
        int lengthB = a.length();
        int index;
        if (lengthA >= lengthB) {
            index = lengthA;
        } else {
            index = lengthB;
        }

        for (int i = 1; index > i; i++) {
            if (a.charAt(i) > b.charAt(i)) {
                return false;
            }
            return true;
        }
        return true;
    }

}
