package LAB8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Closest_Pair_of_Points_Using_Brute_Force {
    public static double calculateDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of points: ");
        int n = scanner.nextInt();

        List<Pair> pts = new ArrayList<Pair>();

        System.out.println("Enter the data of all points:");
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            pts.add(new Pair(a, b));
        }

        double minDistance = Double.MAX_VALUE;
        Pair pt1 = null, pt2 = null;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                double dist = calculateDistance(pts.get(i).x, pts.get(i).y, pts.get(j).x, pts.get(j).y);

                if (minDistance > dist) {
                    minDistance = dist;
                    pt1 = pts.get(i);
                    pt2 = pts.get(j);
                }
            }
        }

        System.out.println("Minimum distance is: " + minDistance);
        System.out.println("First point is: (" + pt1.x + ", " + pt1.y + ")");
        System.out.println("Second point is: (" + pt2.x + ", " + pt2.y + ")");
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
