import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import tabular

public class Generation {

    private GPTree[] trees;
    private DataSet dataSet;
    private Random rand;

    rand = new Random();
    trees = new GPTree[size];
        for (int i = 0; i < size; i++) {
        trees[i] = new GPTree(maxDepth, rand);
    }
}
public void evalAll() {
    for (GPTree tree : trees) {
        tree.evalFitness(dataSet);
    }
    Arrays.sort(trees);
}
public GPTree getBest() {
    return trees[0];
}
public ArrayList<GPTree> getTopTen() {
    ArrayList<GPTree> top = new ArrayList<>();
    int limit = Math.min(10, trees.length);
    for (int i = 0; i < limit; i++) {
        top.add(trees[i]);
    }
    return top;
}
public void printBestFitness() {
    System.out.println("Best fitness: " + trees[0].getFitness());
}
public void printBestTree() {
    System.out.println("Best tree: " + trees[0]);
}
public void evolve() {
    GPTree[] nextGen = new GPTree[trees.length];
    int eliteCount = Math.max(1, trees.length / 10); // top 10%
    for (int i = 0; i < eliteCount; i++) {
        nextGen[i] = (GPTree) trees[i].clone();
    }
    for (int i = eliteCount; i < trees.length; i += 2) {
        GPTree parent1 = selectParent();
        GPTree parent2 = selectParent();

        GPTree child1 = (GPTree) parent1.clone();
        GPTree child2 = (GPTree) parent2.clone();

        nextGen[i] = child1;
        if (i + 1 < trees.length) {
            nextGen[i + 1] = child2;
        }
    }

    trees = nextGen;
}
private GPTree selectParent() {
    int bound = Math.max(1, trees.length / 2);
    int index = rand.nextInt(bound);
    return trees[index];
}
}
