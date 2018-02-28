package impl;

import com.opencsv.CSVReader;
import first_semester_eksamen.Handler;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class HandlerImpl implements Handler {

    public static final String FILENAME = "persons.csv";
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
        PersonImpl p = new PersonImpl("", 0, "");
        for (PersonImpl person : persons) {
            if (person.getAge() > p.getAge()) {
                p = person;
            }
        }
        return p;
    }

    @Override
    public PersonImpl getLowestAge(ArrayList<PersonImpl> persons) {
        PersonImpl p = new PersonImpl("", 200, "");
        for (PersonImpl person : persons) {
            if (person.getAge() < p.getAge()) {
                p = person;
            }
        }
        return p;
    }

    @Override
    public ArrayList<PersonImpl> getNameStartingWithLetter(ArrayList<PersonImpl> persons, String letter) {

        ArrayList<PersonImpl> withLetter = new ArrayList<>();

        for (PersonImpl p : persons) {
            if (p.getName().substring(0, 1).equals(letter)) {
                withLetter.add(p);
            }

        }
        return withLetter;

    }

    @Override
    public boolean isMale(PersonImpl person) {
        if (person.getGender().equals("male")) {
            return true;
        }
        return false;
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
    public ArrayList<PersonImpl> getByName(String name, ArrayList<PersonImpl> people) {
        ArrayList<PersonImpl> peopleWithName = new ArrayList<>();

        for (PersonImpl p : people) {
            if (p.getName().equals(name)) {
                peopleWithName.add(p);
            }

        }
        return peopleWithName;

    }

    @Override
    public PersonImpl getYoungPeople(ArrayList<PersonImpl> persons) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertPerson(PersonImpl p) {
        try (BufferedWriter output = new BufferedWriter(new FileWriter(FILENAME, true))) { //clears file every time
            //clears file every time
            output.append(p.getName() + "," + p.getAge() + "," + p.getGender());
            output.close();
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    @Override
    public boolean deletePersonByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        ArrayList<PersonImpl> people;
//        ArrayList<PersonImpl> toRemove = new ArrayList<>();
//        try (BufferedWriter output = new BufferedWriter(new FileWriter(FILENAME))) {
//            people = readFile(FILENAME);
//            System.out.println(people.size() + " min størrelse");
//            for (PersonImpl p : people) {
//                if (p.getName().equals(name)) {
//                    toRemove.add(p);
//                }
//            }
//            people.removeAll(toRemove);
//            output.write("Name,Age,Gender");
//            output.close();
//            for (PersonImpl p : people) {
//                insertPerson(p);
//            }
//            return true;
//        } catch (IOException ex) {
//            return false;
//        }
//    }

    }
