package LAB11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Minimum_Vertex_Cover {
    public static void shift(char[] edgeList, int index, int ub) {
        for (int i = index; i < ub; i++) {
            edgeList[i] = edgeList[i + 1];
        }
    }

    public static void main(String[] args) {
        ArrayList<Character> vertexCover = new ArrayList<>();
        ArrayList<Integer> edgesCovered = new ArrayList<>();

        char[] edgePart1 = { 'A', 'B', 'B', 'B', 'A', 'E', 'C' };
        char[] edgePart2 = { 'B', 'D', 'C', 'E', 'E', 'D', 'D' };
        int ub = 6;
        int lb = 0;

        boolean flag = false;

        while (edgesCovered.size() != 7) {
            if (edgesCovered.size() == 6) {
                for (Character vertex : vertexCover) {
                    System.out.println("vertexCover: " + vertex);

                    if (vertex == edgePart1[0] || vertex == edgePart2[0]) {
                        System.out.println("heyy:");
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }

            Random rand = new Random();
            int index = rand.nextInt(ub - lb + 1) + lb;
            edgesCovered.add(index);
            vertexCover.add(edgePart1[index]);
            vertexCover.add(edgePart2[index]);
            System.out.println("chosen vertex from A: " + edgePart1[index] + " " + edgePart2[index]);

            shift(edgePart1, index, ub);
            shift(edgePart2, index, ub);
            ub--;

            for (int i = 0; i < ub; i++) {
                if (edgePart1[i] == edgePart1[index] || edgePart1[i] == edgePart2[index]) {
                    edgesCovered.add(i);
                    shift(edgePart1, i, ub);
                    shift(edgePart2, i, ub);
                    ub--;
                }

                if (edgePart2[i] == edgePart2[index] || edgePart2[i] == edgePart1[index]) {
                    edgesCovered.add(i);
                    shift(edgePart1, i, ub);
                    shift(edgePart2, i, ub);
                    ub--;
                }
            }
        }

        Set<Character> s = new HashSet<>(vertexCover);
        ArrayList<Character> vc = new ArrayList<>(s);

        System.out.println("final answer: ");
        for (Character character : vc) {
            System.out.print(character + " ");
        }
    }
}
