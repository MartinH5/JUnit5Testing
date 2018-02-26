package impl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

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

        String[] sjoveTing;
        sjoveTing = hi.readFile("persons.csv");
        System.out.println(System.getProperty("user.dir"));
        System.out.println(sjoveTing);
        for (String str : sjoveTing) {
            System.out.println(str);
        }

    }
}
