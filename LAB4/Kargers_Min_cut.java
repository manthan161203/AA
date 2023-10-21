package LAB4;

public class Kargers_Min_cut {
    static final int N = 4;
    static int G[][] = {{0, 1, 1, 1}, {1, 0, 0, 1}, {1, 0, 0, 1}, {1, 1, 1, 0}};
    static int G1[][] = new int[N][N];

    public static void main(String[] args) {
        int n = N;
        Scanner input = new Scanner(System.in);

        while (n > 2) {
            int u, v;
            System.out.println("Enter Edge:");
            System.out.println("Enter U:");
            u = input.nextInt();
            System.out.println("Enter V:");
            v = input.nextInt();
            int cnt = 0;

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    cnt = 0;

                    if (i == u && j == v) {
                        G1[i][j] = G1[j][i] = 0;
                    } else if (i == u || i == v) {
                        if (G[u][j] > 0) {
                            cnt += G[u][j];
                        }
                        if (G[v][j] > 0) {
                            cnt += G[v][j];
                        }
                        if (u < j) {
                            G1[u][j] = cnt;
                        } else {
                            G1[j][u] = cnt;
                        }
                        if (v < j) {
                            G1[v][j] = cnt;
                        } else {
                            G1[j][v] = cnt;
                        }
                    } else if (j == u || j == v) {
                        if (G[u][i] > 0) {
                            cnt += G[u][i];
                        }
                        if (G[v][i] > 0) {
                            cnt += G[v][i];
                        }
                        if (i < u) {
                            G1[i][u] = cnt;
                        } else {
                            G1[u][i] = cnt;
                        }
                        if (i < v) {
                            G1[i][v] = cnt;
                        } else {
                            G1[v][i] = cnt;
                        }
                    } else {
                        G1[i][j] = G[i][j];
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(G1[i][j] + " ");
                }
                System.out.println();
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i >= j) {
                        G1[i][j] = G1[j][i];
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(G1[i][j] + " ");
                }
                System.out.println();
            }

            int x = n - 1;
            int G2[][] = new int[x][x];
            int a = 0, b = 0;
            for (int i = 0; i < n; i++) {
                if (i == v) continue;
                b = 0;
                for (int j = 0; j < n; j++) {
                    if (j == v) continue;
                    else {
                        G2[a][b] = G1[i][j];
                        b++;
                    }
                }
                a++;
            }

            for (int i = 0; i < x; i++) {
                for (int j = 0; j < x; j++) {
                    System.out.print(G2[i][j] + " ");
                }
                System.out.println();
            }

            for (int i = 0; i < x; i++) {
                for (int j = 0; j < x; j++) {
                    G[i][j] = G2[i][j];
                }
            }
            n = n - 1;
        }

        System.out.println("Min-Cut = " + G[0][1]);
    }
}
