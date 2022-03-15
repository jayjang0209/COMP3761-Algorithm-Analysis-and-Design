package week7;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Represents a Graph.
 *
 * @author Jonghoon Jang
 * @version March, 2022
 */
public class AdjGraph {
    private final int[][] matrix;
    private boolean directed = false;
    private int[] visited;

    /**
     * Constructs an adjacency Matrix.
     *
     * @param num an int representing number of vertices
     */
    public AdjGraph(final int num) {
        matrix = new int[num][num];
    }

    /**
     * Returns true if this Graph is directed, else false.
     *
     * @return true if this Graph is directed, else false as a boolean
     */
    public boolean isDirected() {
        return directed;
    }

    public void setDirected() {
        directed = true;
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
        if (!directed) {
            this.matrix[x][y] = 1;
            this.matrix[y][x] = 1;
        } else {
            this.matrix[x][y] = 1;
        }

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
        for (int row = 0; row < this.matrix[vert].length; row++) {
            if (this.matrix[row][vert] == 1) {
                in++;
            }
        }
        return in;
    }

    public int outDegree(int vert) {
        int out = 0;
        for (int col = 0; col < this.matrix[vert].length; col++) {
            if (this.matrix[vert][col] == 1) {
                out++;
            }
        }
        return out;
    }

    public void DFS() {
        visited = new int[matrix.length];
        for (int vertex = 0; vertex < matrix.length; vertex++) {
            if (visited[vertex] == 0) {
                dfs(vertex);
            }
        }
    }

    public void dfs(int y) {
        visited[y] = 1;
        System.out.println("Visiting vertex: " + y);
        for (int vert = 0; vert < matrix.length; vert++) {
            if (matrix[y][vert] == 1 && visited[vert] == 0) {
                dfs(vert);
            }
        }
    }

    public void BFS() {
        visited = new int[matrix.length];
        for (int vertex = 0; vertex < matrix.length; vertex++) {
            if (visited[vertex] == 0) {
                bfs(vertex);
            }
        }
    }

    public void bfs(int y) {
        visited[y] = 1;
        System.out.println("Visiting vertex: " + y);
        Queue<Integer> q = new ArrayDeque<Integer>();
        q.add(y);
        while (q.size() != 0) {
            int headOfQueue = q.peek();
//            System.out.println("Q:" + q + "head: " + headOfQueue );
            for (int vert = 0; vert < matrix.length; vert++) {
                if (matrix[headOfQueue][vert] == 1 && visited[vert] == 0) {
//                    System.out.println("unvisted adjacent" + vert);
                    this.visited[vert] = 1;
                    System.out.println("Visiting vertex: " + vert);
                    q.add(vert);
                }
            }
            q.poll();
        }
    }

    public static void main(String[] args) {
        AdjGraph test = new AdjGraph(3);
        test.setDirected();
        test.addEdge(0, 1);
        test.addEdge(0, 2);
        System.out.println(test.outDegree(0));
        System.out.println(test.inDegree(1));
        System.out.println(test.inDegree(0));

        System.out.println(test); // or test.toString?
    }
}
