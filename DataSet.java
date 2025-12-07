import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataSet {

    private ArrayList<DataRow> data;
    private int numIndepVariables;


    public DataSet(String fileName) {
        data = new ArrayList<DataRow>();

        try {
            Scanner fileScanner = new Scanner(new File(fileName));

            String headerLine = fileScanner.nextLine();
            String[] variableNames = headerLine.split(",");

            numIndepVariables = variableNames.length - 1;

            while (fileScanner.hasNextLine()) {
                String dataLine = fileScanner.nextLine();
                String[] values = dataLine.split(",");

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

  
    public ArrayList<DataRow> getRows() {

        return data;
    }


    public int getNumIndependentVariables() {
        return numIndepVariables;

    }
}
