package impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class HandlerTest {

    HandlerImpl hi;
    ArrayList<PersonImpl> testp;
    Map<String, String> testData;

    @Before
    public void setUp() throws IOException {
        hi = new HandlerImpl();
        testp = hi.readFile("persons.csv");
        testData = generateTestData();
    }

    @Test
    public void readFileTest() throws IOException {
        System.out.println("\n" + "Read File test:");
        ArrayList<PersonImpl> people;
        people = hi.readFile("persons.csv");
        System.out.println("After a read we have " + people.size() + " people");
        assertTrue(people.size() > Integer.parseInt(testData.get("Not Empty")));
    }

    @Test
    public void highestAgeTest() {
        System.out.println("\n" + "Oldest test:");
        int oldest = Integer.parseInt(testData.get("Oldest"));
        PersonImpl actualOldest = hi.getHighestAge(testp);
        System.out.println(actualOldest.getName() + " is the oldest\n");
        assertEquals(actualOldest.getAge(), oldest);
    }

    @Test
    public void lowestAgeTest() {
        System.out.println("\n" + "Youngest test:");
        int youngest = Integer.parseInt(testData.get("Youngest"));
        PersonImpl actualYoungest = hi.getLowestAge(testp);
        System.out.println(actualYoungest.getName() + " is the youngest\n");
        assertEquals(actualYoungest.getAge(), youngest);
    }

    // Here we check if each person's name starts with U
    @Test
    public void nameStartingWithLetterTest() {
        ArrayList<PersonImpl> people = hi.getNameStartingWithLetter(testp, testData.get("Starting Letter1"));
        System.out.println("\n" + "letter with starting letter in their name consists of: " + testData.size() + " persons");
        System.out.println("and they are:");
        for (PersonImpl personImpl : people) {
            System.out.println(personImpl.getName());
            if (!personImpl.getName().substring(0, 1).equals("U")) {
                fail("Found a letter that doesn't fit");
            }
        }

    }

    //Here We check if we got a person by the right name. 
    @Test
    public void getByNameTest() {
        ArrayList<PersonImpl> people = hi.getByName(testp, testData.get("Starting Name1"));
        System.out.println("\n" + "We have : " + testData.size() + " with the same name");
        System.out.println("Who are:");
        for (PersonImpl p : people) {
            System.out.println(p.getName() + " " + p.getAge());
            if (!p.getName().equals(testData.get("Starting Name1"))) {
                fail("Found a name that doesn't fit");
            }
        }
    }

    @Test
    public void genderTest() {
        System.out.println("\n" + "Gender test:");
        PersonImpl testPerson = hi.getByName(testp, testData.get("Starting Name1")).get(0);
        assertEquals(false, hi.isMale(testPerson));
        System.out.println("Is it true, that our testperson is a female? " + "\nAnswer: " + hi.isMale(testPerson));
    }

    @Test
    public void sortByAgeTest() {
        System.out.println("\nSorting the CSV by age:");
        ArrayList<PersonImpl> SortAge = hi.sortByAge(testp);
        boolean result = true;
        int tempAge = Integer.parseInt(testData.get("Temp Age"));
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
        String tempName = testData.get("Temp Name");
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
        assertEquals(true, result);
    }

    @Test
    public void peopleYoungerThanTest() {
        System.out.println("\n" + "Get People younger than Test:");
        int youngerThan = Integer.parseInt(testData.get("PeopleYounger1"));
        ArrayList<PersonImpl> youngThan = hi.getPeopleYoungerThan(testp,youngerThan);
        for (PersonImpl line : youngThan) {
            if (line.getAge() >= youngerThan) {
                fail("Found someone who was too old");
            }
            System.out.println(line);
        }
    }

//    @Test
//    public void insertPersonTest() throws IOException{
//        System.out.println("\n" + "Insert person test:");
//        PersonImpl testPerson = new PersonImpl("\nTest", 15, "Test");
//        ArrayList<PersonImpl> people = hi.readFile("persons.csv");
//        hi.insertPerson(testPerson);
//        System.out.println(testPerson + " has been inserted");
//        ArrayList<PersonImpl> peopleIns = hi.readFile("persons.csv");
//        assertTrue(peopleIns.size() > people.size());
//    }
//    
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

    private Map<String, String> generateTestData() {
        Map<String, String> tData = new HashMap<String, String>();
        tData.put("Not Empty", "1");
        tData.put("Oldest", "160");
        tData.put("Youngest", "10");
        tData.put("Starting Letter1", "A");
        tData.put("Starting Letter2", "U");
        tData.put("Starting Letter3", "B");
        tData.put("Starting Name1", "Ulla");
        tData.put("Starting Name2", "Ulrik");
        tData.put("Starting Name3", "Bethoven");
        tData.put("Temp Age", "9999");
        tData.put("Temp Name", "A");
        tData.put("PeopleYounger1", "20");
        tData.put("PeopleYounger2", "40");
        tData.put("PeopleYounger3", "60");
        return tData;
    }
}
