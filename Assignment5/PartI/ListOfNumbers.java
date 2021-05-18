import java.io.*;
import java.util.List;
import java.util.ArrayList;
 
public class ListOfNumbers {
	
    private List<Integer> list;
    private String inFile;
 
    public ListOfNumbers () {
        list = new ArrayList<Integer>();
    }
    

    public ListOfNumbers (String inFile) {
    	this();
    	this.inFile = inFile;	
    }
    
    public void readList() {
    	FileReader f = null;
        try {
            f = new FileReader(inFile);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
            System.exit(1);
        }
        BufferedReader in = new BufferedReader(f);
        String line = null;
        try {
            line = in.readLine();
            while (line != null) {
                try {
                    list.add(Integer.parseInt(line));
                    System.out.println(line);
                }
                catch (NumberFormatException nfe) {
                    System.err.println("Problem Parsing data: " + nfe.getMessage());
                }
                line = in.readLine();
            }
        } catch (IOException ioe) {
            System.err.println("IO error reading file: " + ioe.getMessage());
            System.exit(1);
        } finally {
            try {
                f.close();
            } catch (IOException ioe) {
                System.err.println("IO error closing file: " + ioe.getMessage());
            }
        }
    }
    
    public void writeList() {
        PrintWriter out = null;
        try {
            System.out.println("Entering try statement");
            out = new PrintWriter(new FileWriter("outFile.txt"));
            for (int i = 0; i < list.size(); i++)
                out.println("Value at: " + i + " = " + list.get(i));
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Caught IndexOutOfBoundsException: " +
                                 e.getMessage());
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        } finally {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            } else {
                System.out.println("PrintWriter not open");
            }
        }
    }
    
    public static void cat(String fileName) {
        RandomAccessFile input = null;
        String line = null;
        File file = new File(fileName);
        try {
            input = new RandomAccessFile(file, "r");
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            return;
        }
        catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
            System.exit(1);
        } catch (IOException ioe) {
            System.err.println("IO error reading file: " + ioe.getMessage());
            System.exit(1);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException ioe) {
                    System.err.println("IO error closing file: " + ioe.getMessage());
                }
            }
        }
    }
    
    public static void main(String[] args) {
    	ListOfNumbers listOfNumbers = new ListOfNumbers("numberfile.txt");
    	ListOfNumbers.cat("numberfile.txt");
    	listOfNumbers.readList();
    	listOfNumbers.writeList();
    }

}
