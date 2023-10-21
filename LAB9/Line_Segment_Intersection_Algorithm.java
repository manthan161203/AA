package LAB9;

import java.util.Scanner;

public class Line_Segment_Intersection_Algorithm {
    public static int direction(Pair p1, Pair p2, Pair p3) {
        int res = (p3.first - p1.first) * (p2.second - p1.second) - (p3.second - p1.second) * (p2.first - p1.first);
        return res;
    }

    public static boolean onSegment(Pair p1, Pair p2, Pair p3) {
        return (Math.min(p1.first, p2.first) <= p3.first && p3.first <= Math.max(p1.first, p2.first) &&
                Math.min(p1.second, p2.second) <= p3.second && p3.second <= Math.max(p1.second, p2.second));
    }

    public static boolean segmentIntersect(Pair p1, Pair p2, Pair q1, Pair q2) {
        int d1 = direction(p1, p2, q1);
        int d2 = direction(p1, p2, q2);
        int d3 = direction(q1, q2, p1);
        int d4 = direction(q1, q2, p2);

        if ((d1 * d2 < 0) || (d3 * d4 < 0)) {
            return true;
        } else if ((d1 == 0) && onSegment(p1, p2, q1)) {
            return true;
        } else if ((d2 == 0) && onSegment(p1, p2, q2)) {
            return true;
        } else if ((d3 == 0) && onSegment(q1, q2, p1)) {
            return true;
        } else if ((d4 == 0) && onSegment(q1, q2, p2)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("Line Segment Intersection Algorithm");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the values of 4 points coordinates x and y:");

        Pair p1 = new Pair();
        Pair p2 = new Pair();
        Pair q1 = new Pair();
        Pair q2 = new Pair();

        System.out.println("Enter the values of first points:");
        p1.first = scanner.nextInt();
        p1.second = scanner.nextInt();

        System.out.println("Enter the values of second points:");
        p2.first = scanner.nextInt();
        p2.second = scanner.nextInt();

        System.out.println("Enter the values of third points:");
        q1.first = scanner.nextInt();
        q1.second = scanner.nextInt();

        System.out.println("Enter the values of fourth points:");
        q2.first = scanner.nextInt();
        q2.second = scanner.nextInt();

        if (segmentIntersect(p1, p2, q1, q2)) {
            System.out.println("These two segments are intersecting.");
        } else {
            System.out.println("These two segments are not intersecting.");
        }
    }

    static class Pair {
        int first;
        int second;
    }
}
