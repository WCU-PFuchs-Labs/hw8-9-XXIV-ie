/**
 * Author: Francine Lohose
 * Date:
 * Purpose:
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataSet {

    // add fields here
    private ArrayList<DataRow> data;
    private int numIndepVariables;


    public DataSet(String fileName) {
        data = new ArrayList<DataRow>();

        try {
            Scanner fileScanner = new Scanner(new File(fileName));

            // Read the first line to get variable names
            String headerLine = fileScanner.nextLine();
            String[] variableNames = headerLine.split(",");

            // Initialize the number of independent variables
            numIndepVariables = variableNames.length - 1;

            // Read the data rows
            while (fileScanner.hasNextLine()) {
                String dataLine = fileScanner.nextLine();
                String[] values = dataLine.split(",");

                // Check if the data row has the correct number of columns
                if (values.length == variableNames.length) {

                    double y = Double.parseDouble(values[0]);
                    double[] x = new double[numIndepVariables];

                    for (int i = 1; i < values.length; i++) {
                        x[i - 1] = Double.parseDouble(values[i]);
                    }


                    DataRow dataRow = new DataRow(y,x);
                    data.add(dataRow);

                }
            }

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
        }
    }

    /**
     * @return the list of rows
     */
    public ArrayList<DataRow> getRows() {
        // FIXME: return the right thing here

        return data;
    }

    /**
     * @return the number of independent variables in each row of the data set
     */
    public int getNumIndependentVariables() {
        // FIXME: return the right thing here
        return numIndepVariables;

    }
}
