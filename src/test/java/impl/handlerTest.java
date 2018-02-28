package impl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.util.ArrayList;
import org.junit.After;
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
    public void hello() throws IOException {

        ArrayList<PersonImpl> sjoveTing;
        sjoveTing = hi.readFile("persons.csv");
        System.out.println("Vi har " + sjoveTing.size() + " personer");
    }

    @Test
    public void youngestTest() {
        System.out.println(hi.getLowestAge(testp).getName() + " is the youngest");
    }
    
    @Test
    public void oldestTest() {
        System.out.println(hi.getHighestAge(testp).getName() + " is the oldest");
    }
    
    @Test
    public void insertTest(){
        PersonImpl testPerson = new PersonImpl("\nTest", 15, "Test");
        hi.insertPerson(testPerson);
        
    }
    
    @Test
    public void letterTest(){
        ArrayList<PersonImpl> testData = hi.getNameStartingWithLetter(testp , "U");
        System.out.println("letter with name consists of: " + testData.size());
        for (PersonImpl personImpl : testData) {
            System.out.println(personImpl.getName());
        }
    }
    
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
