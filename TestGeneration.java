import java.util.ArrayList;
import java.util.Scanner;

public class TestGeneration {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter data file name: ");
        String fileName = in.nextLine().trim();

        int size = 500;
        int maxDepth = 4;

        Generation gen = new Generation(size, maxDepth, fileName);

        gen.evalAll();

        System.out.println("Best Tree:");
        gen.printBestTree();
        gen.printBestFitness();
        System.out.println();

        ArrayList<GPTree> topTen = gen.getTopTen();

        System.out.println("Top Ten Fitness Values:");
        for (int i = 0; i < topTen.size(); i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.printf("%.2f", topTen.get(i).getFitness());
        }
        System.out.println();

        in.close();
    }
}
