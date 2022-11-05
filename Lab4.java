package lab4;

import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

public class Lab4 {
    
    public static void main(String[] args) {
        /* Row Objects */
        ArrayList <String> keys;
        ArrayList <String> values;
        HashMap <String, String> row;
        String line, header;
        
        /* Container for File Data */
        ArrayList data = new ArrayList <> ();

        try {
            /*Attempt to open input file */
            Scanner in = new Scanner(Paths.get("lab4_input.csv"), "UTF-8");
            
            /* Get list of keys from header row; split into an ArrayList */
            header = in.nextLine();
            keys = new ArrayList(Arrays.asList(header.split(",")));
            
            /* Read and process every subsequent row (record) in CSV file */
            while (in.hasNextLine()) {
                /* Get next line */
                line = in.nextLine();
                
                /* Create new map for current row */
                row = new HashMap <> ();
                
                /* Split comma-separated values into ArrayList */
                values = new ArrayList(Arrays.asList(line.split(",")));
                
                /* Populate map, using key names from the header row */
                for (int i = 0; i < keys.size(); i++) {
                    row.put(keys.get(i), values.get(i));
                }
                
                /* Add map to data container */
                data.add(row);
            }
            
            /* Print number of records read from file (should be 500, not including header) */
            System.out.println("Number of records read: " + data.size());
            
            /* Close input file */
            in.close();
            
            /* Parse data from records; print as formatted address blocks */
            
            /* INSERT YOUR CODE HERE */
            
            final int dataLimit = 5;
            
            HashMap <String, String> currentRowData = null;
            
            for (int index = 0; index < data.size(); index++) {
                if (index == dataLimit) {
                    break;
                }
                
                System.out.println();
                
                currentRowData = (HashMap<String, String>) data.get(index);
                
                String firstName = currentRowData.get("FirstName");
                String midInit = currentRowData.get("MiddleInitial");
                String lastName = currentRowData.get("LastName");
                String streetAddr = currentRowData.get("StreetAddress");
                String city = currentRowData.get("City");
                String state = currentRowData.get("State");
                String zipCode = currentRowData.get("ZipCode");
                
                System.out.println(firstName + " " + midInit + " " + lastName);
                System.out.println(streetAddr);
                System.out.println(city + ", " + state + " " + zipCode);
            }
        }
        catch (Exception e) {
            System.err.println(e.toString());
        }
    }
    
}
