/**
 * Author: Francine Lohose
 * Date:
 * Purpose:
 */


public class DataRow {

    // add fields here
    private double y; // Dependent variable
    private double[] x; // Independent variable

    /**
     * @param y the dependent variable
     * @param x the array of independent variables
     */
    public DataRow(double y, double[] x)
    {
        // initialize fields here

        this.y = y;
        this.x = x;
    }

    /**
     * @return the dependent variable
     */
    public double getY() {
        // FIXME: return the right thing here
        return y;
    }

    /**
     * @return the array of independent variables
     */
    public double[] getX() {
        // FIXME: return the right thing here

        return x;
    }
}
