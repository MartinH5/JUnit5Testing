package impl;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class HandlerTestJunit5 {

    HandlerImpl hi;
    ArrayList<PersonImpl> testp;

    @BeforeAll
    public void initAll() throws IOException {
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
}
