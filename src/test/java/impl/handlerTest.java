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

    @Before
    public void setUp() {
        hi = new HandlerImpl();
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
        System.out.println(sjoveTing);
        for (PersonImpl p : sjoveTing) {
            System.out.println(p.getAge() + p.getGender() + p.getName());
        }
        
    }
}
