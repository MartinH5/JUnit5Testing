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

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void readTest() throws IOException {

        ArrayList<PersonImpl> people;
        people = hi.readFile("persons.csv");
        System.out.println("After a read we have " + people.size() + " people");
        assert(people.size() > 1);
    }

    @Test
    public void youngestTest() {
        int youngest = 10;
        PersonImpl actualYoungest = hi.getLowestAge(testp);     
        System.out.println(actualYoungest.getName() + " is the yoiungest\n");
        assertEquals(actualYoungest.getAge(),youngest);
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
    
    
    // Here we check if each person's name starts with U
    @Test
    public void letterTest(){
        ArrayList<PersonImpl> testData = hi.getNameStartingWithLetter(testp , "U");
        System.out.println("letter with name consists of: " + testData.size());
        for (PersonImpl personImpl : testData) {
            System.out.println(personImpl.getName());
        }
        
    }
    //Here We check if we got a person by the right name. 
    @Test
    public void nameTest(){
        ArrayList<PersonImpl> testData = hi.getByName("Ulla", testp);
        System.out.println("We have : " + testData.size() + " with the same name");
        for (PersonImpl personImpl : testData) {
            System.out.println(personImpl.getName());
        }
    }
    
    
    @Test
    public void maleTest(){
        PersonImpl testPerson = new PersonImpl("Hans", 15, "male");
        System.out.println("Is it true, that Hans is a male? " + hi.isMale(testPerson));
    }
    
    
    
    @Test
    public void deletionTest(){
    //    hi.deletePersonByName("Ulla");
    
    }
}
