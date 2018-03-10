package impl;

import java.io.IOException;
import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

public class HamcrestTest {
    
    HandlerImpl hi;
    ArrayList<PersonImpl> testp;
    
    @Before
    public void setUpClass() throws IOException {
        hi = new HandlerImpl();
        testp = hi.readFile("persons.csv");
    }
    
    @Test
    public void testThis() throws IOException {
        ArrayList<PersonImpl> people;
        people = hi.readFile("persons.csv");
        
        //same test but just a bit different
        //Checking if the list is empty or not.
        assertThat(people.isEmpty(), is(false));
        assertThat(people.isEmpty(), equalTo(false));
        assertThat(people, is(not(equalTo(empty()))));
        
        //Checking the size of the csv file.
        assertThat(people.size(), is(20));
    }
}
