package week7;

import java.util.ArrayDeque;
import java.util.Queue;

public class AdjGraph {
    private int matrix[][];
    private boolean directed = false;
    private int[] visited;

    public AdjGraph(final int num) {
        matrix = new int[num][num];
    }

    public boolean isDirected() {
        return directed;
    }

    public void setDirected() {

    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < this.matrix[0].length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
//                System.out.print(this.matrix[i][j]);
//                System.out.print((j == this.matrix[0].length - 1) ? '\n' : ' ');
                result.append(this.matrix[i][j]);
                result.append((j == this.matrix[0].length - 1) ? '\n' : ' ');
            }
        }
        return result.toString();
    }

    public void addEdge(int x, int y) {
        this.matrix[x][y] = 1;
        this.matrix[y][x] = 1;
    }

    public int degree(int x) {
        int degree = 0;

        for (int col = 0; col < this.matrix[x].length; col++) {
            if (this.matrix[x][col] == 1) {
                degree++;
            }
        }
        return degree;
    }

    public int inDegree(int vert) {
        int in = 0;

        //implement
        return in;
    }

    public int outDegree(int vert) {
        int in = 0;

        //implement

        return in;
    }

    public void DFS() {
        visited = new int[matrix.length];

        //implement
    }

    public void dfs(int y) {
        System.out.println("Visiting vertex: " + y);

        //implement
    }

    public void BFS() {
        visited = new int[matrix.length];

        //implement
    }

    public void bfs(int y) {
        Queue<Integer> q = new ArrayDeque<Integer>();
        visited[y] = 1;

        //implement
    }

    public static void main(String[] args) {
        AdjGraph test = new AdjGraph(3);
        test.addEdge(0, 1);
        test.addEdge(0, 2);
        System.out.println(test); // or test.toString?
    }
}
