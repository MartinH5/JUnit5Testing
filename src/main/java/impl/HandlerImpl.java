package impl;

import com.opencsv.CSVReader;
import first_semester_eksamen.Handler;
import java.io.IOException;
import java.util.ArrayList;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HandlerImpl implements Handler {

    public static final String FILENAME = "Samples.csv";
    String[] people;

    @Override
    public ArrayList<PersonImpl> readFile(String filename) throws IOException {
        ArrayList<PersonImpl> people = new ArrayList<PersonImpl>();
        PersonImpl tmp;
        int count = 0;
        try (
                Reader reader = Files.newBufferedReader(Paths.get(filename));
                CSVReader csvReader = new CSVReader(reader);) {
            // Reading Records One by One in a String array
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                if (count != 0) {
                    tmp = new PersonImpl("", 0, "");
                    tmp.setName(nextRecord[0]);
                    tmp.setAge(Integer.parseInt(nextRecord[1]));
                    tmp.setGender(nextRecord[2]);
                    people.add(tmp);
                }
                count++;
            }
        }
        return people;
    }

    @Override
    public ArrayList<PersonImpl> getPeople() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonImpl getHighestAge(ArrayList<PersonImpl> persons) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonImpl getLowestAge(ArrayList<PersonImpl> persons) {
        PersonImpl p = new PersonImpl("", 200, "");
        for (PersonImpl person : persons) {
            if (person.getAge() < p.getAge()) {
                p = person;
            }
            System.out.println(p.getName() + " is the youngest " + p.getName());
        }
        return p;
    }

    @Override
    public ArrayList<PersonImpl> getNameStartingWithLetter(String data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isMaleOrFemale(String gender, ArrayList<PersonImpl> persons) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sortByAge(ArrayList<PersonImpl> persons) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sortByName(ArrayList<PersonImpl> persons) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<PersonImpl> getByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonImpl getYoungPeople(ArrayList<PersonImpl> persons) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
