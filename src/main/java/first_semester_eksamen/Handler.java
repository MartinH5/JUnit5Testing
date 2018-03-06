package first_semester_eksamen;

import impl.PersonImpl;
import java.io.IOException;
import java.util.ArrayList;

public interface Handler {
    
    public ArrayList<PersonImpl> readFile(String filename) throws IOException;
    
    public PersonImpl getHighestAge(ArrayList<PersonImpl> persons);
    
    public PersonImpl getLowestAge(ArrayList<PersonImpl> persons);
    
    public ArrayList<PersonImpl> getNameStartingWithLetter(ArrayList<PersonImpl> p, String letter);
    
    public ArrayList<PersonImpl> getByName(ArrayList<PersonImpl> persons, String name);
    
    public boolean isMale (PersonImpl person);
    
    public ArrayList<PersonImpl> sortByAge(ArrayList<PersonImpl> persons);
    
    public ArrayList<PersonImpl> sortByName(ArrayList<PersonImpl> persons);
    
    public ArrayList<PersonImpl> getPeopleYoungerThan(ArrayList<PersonImpl> persons, int age); 
    
    public void insertPerson(ArrayList<PersonImpl> persons ,PersonImpl p);
    
    public void deletePersonByName(ArrayList<PersonImpl> persons, String name);
    
    public boolean safeState(ArrayList<PersonImpl> persons, String fileName);
}
