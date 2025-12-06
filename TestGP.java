import java.util.Scanner;

public class TestGP {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter data file name: ");
        String fileName = in.nextLine().trim();

        int size = 500;
        int maxDepth = 4;    
        int generations = 50; 

        Generation gen = new Generation(size, maxDepth, fileName);

        for (int g = 1; g <= generations; g++) {
            gen.evalAll(); 

            System.out.println("Generation " + g + ":");
            gen.printBestTree();
            gen.printBestFitness();
            System.out.println();

            if (g < generations) {
                gen.evolve();
            }
        }

        in.close();
    }
}
