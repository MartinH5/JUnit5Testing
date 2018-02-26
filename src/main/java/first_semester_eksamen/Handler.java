package first_semester_eksamen;

import impl.Time;
import java.io.IOException;
import java.util.ArrayList;

public interface Handler {
    /**
     * Convert a file to a String
     * @param filename The name of the file to be read
     * @return The file content as a String
     * @throws IOException if file is missing or locked
     */
    public String[] readFile(String filename) throws IOException;
    
    /**
     * Converts file content to proper objects
     * @param persons The list of Samples based on file content
     * @return a list of Sample objects
     */
    public Person getHighestAge(ArrayList<Person> persons);
    
    /**
     * Identifies the Sample with the highest amplitude. Peaks are ignored.
     * @param persons The list of Samples based on file content
     * @return the identified Sample object
     */
    public Person getLowestAge(ArrayList<Person> persons);
    
    /**
     * Identifies the sample which have increased the most in amplitude 
     * compared to its predecessor. 
     * The compared values are signed - It is NOT the numerical difference 
     * that counts.
     * @param data 
     * 2 values are required
     * @return the identified Sample object
     */
    public ArrayList<Person> getNameStartingWithLetter(String data);
    
    /**
     * Determines whether or not any sample surpasses the set limit. 
     * Peaks matter
     * @param gender
     * @param persons The list of Samples based on file content
     * @return true if any amplitude or peak is greater than the limit,
     * false in any other case.
     */
    public boolean isMaleOrFemale(String gender, ArrayList<Person> persons);
    
    /**
     * Sorts samples by time
     * @param persons The list that will be sorted
     */
    public void sortByAge(ArrayList<Person> persons);
    
    /**
     * sorts samples by amplitude (ignore peak)
     * @param persons The list that will be sorted
     */
    public void sortByName(ArrayList<Person> persons);
    
    /**
     * Retrieves a subset containing only the samples that have an amplitude 
     * higher than or equal to the limit.
     * @param name The maximum allowed amplitude
     * @return a new list containing the subset
     */
    public ArrayList<Person> getByName(String name);
    
    /**
     * Retrieves a subset containing only the samples that have a timestamp 
     * earlier than the limit. (NOT equal to the limit!)
     * @param persons The list from which to get the subset
     * @return a new list containing the subset
     */
    public Person getYoungPeople(ArrayList<Person> persons);    
}
