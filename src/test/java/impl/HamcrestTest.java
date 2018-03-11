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
    PersonImpl testPerson;

    @Before
    public void setUpClass() throws IOException {
        hi = new HandlerImpl();
        testp = hi.readFile("persons.csv");
        testPerson = new PersonImpl("Anders", 12, "male");
    }

    @Test
    public void testReadFile() throws IOException {
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

    @Test
    public void testGender() {
        assertThat(hi.isMale(testPerson), is(true));
    }

}
