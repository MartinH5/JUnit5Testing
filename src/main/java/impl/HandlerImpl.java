package impl;

import first_semester_eksamen.Handler;
import first_semester_eksamen.TimeFormatException;
import java.io.IOException;
import java.util.ArrayList;
import first_semester_eksamen.Person;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class HandlerImpl implements Handler {

    public static final String FILENAME = "Samples.csv";
    String[] people;

    @Override
    public String[] readFile(String FILENAME) throws IOException {
        String csvFile = "/Users/mkyong/csv/country.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] people = line.split(cvsSplitBy);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return people;
    }

    @Override
    public Person getHighestAge(ArrayList<Person> persons) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Person getLowestAge(ArrayList<Person> persons) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Person> getNameStartingWithLetter(String data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isMaleOrFemale(String gender, ArrayList<Person> persons) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sortByAge(ArrayList<Person> persons) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sortByName(ArrayList<Person> persons) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Person> getByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Person getYoungPeople(ArrayList<Person> persons) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
