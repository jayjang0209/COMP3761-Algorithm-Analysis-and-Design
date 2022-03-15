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

    /**
     * Set this graph directed.
     *
     */
    public void setDirected() {
        directed = true;
    }

    /**
     * Returns a String representation of this Graph.
     *
     * @return toString as a string
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < this.matrix[0].length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                result.append(this.matrix[i][j]);
                result.append((j == this.matrix[0].length - 1) ? '\n' : ' ');
            }
        }
        return result.toString();
    }

    /**
     * Adds edges.
     *
     * @param x an int representing start vertex
     * @param y an int representing end vertex
     */
    public void addEdge(final int x, final int y) {
        if (!directed) {
            this.matrix[x][y] = 1;
            this.matrix[y][x] = 1;
        } else {
            this.matrix[x][y] = 1;
        }

    }

    /**
     * Get the degree of the specified vertex.
     *
     * @param x an int representing a vertex
     * @return degree as an int
     */
    public int degree(final int x) {
        int degree = 0;

        for (int col = 0; col < this.matrix[x].length; col++) {
            if (this.matrix[x][col] == 1) {
                degree++;
            }
        }
        return degree;
    }

    /**
     * Get the in degree of the specified vertex.
     *
     * @param vert an int representing a vertex
     * @return in-degree as an int
     */
    public int inDegree(final int vert) {
        int in = 0;
        for (int row = 0; row < this.matrix[vert].length; row++) {
            if (this.matrix[row][vert] == 1) {
                in++;
            }
        }
        return in;
    }

    /**
     * Get the out degree of the specified vertex.
     *
     * @param vert an int representing a vertex
     * @return out-degree as an int
     */
    public int outDegree(final int vert) {
        int out = 0;
        for (int col = 0; col < this.matrix[vert].length; col++) {
            if (this.matrix[vert][col] == 1) {
                out++;
            }
        }
        return out;
    }

    /**
     * Runs Depth-First Search(DFS).
     *
     */
    public void DFS() {
        visited = new int[matrix.length];
        for (int vertex = 0; vertex < matrix.length; vertex++) {
            if (visited[vertex] == 0) { // vertex has not been visited
                dfs(vertex);
            }
        }
    }

    /**
     * Helper function for Depth-First Search(DFS).
     *
     * @param y an int representing a vertex
     */
    public void dfs(final int y) {
        this.visited[y] = 1; // visit node v
        System.out.println("Visiting vertex: " + y);
        for (int vert = 0; vert < this.matrix.length; vert++) {
            if (matrix[y][vert] == 1 && visited[vert] == 0) { //adjacent vertex & not been visited
                dfs(vert);
            }
        }
    }

    /**
     * Runs Breadth-first search(BFS).
     *
     */
    public void BFS() {
        this.visited = new int[this.matrix.length];
        for (int vertex = 0; vertex < this.matrix.length; vertex++) {
            if (this.visited[vertex] == 0) { // vertex has not been visited
                bfs(vertex);
            }
        }
    }

    /**
     * Helper function for Breadth-first search(BFS).
     *
     * @param y an int representing a vertex
     */
    public void bfs(final int y) {
        this.visited[y] = 1;
        System.out.println("Visiting vertex: " + y);
        Queue<Integer> q = new ArrayDeque<>();
        q.add(y);
        while (q.size() != 0) { // while Q is not empty
            int headOfQueue = q.peek(); // Q.head
            for (int vert = 0; vert < this.matrix.length; vert++) {
                if (matrix[headOfQueue][vert] == 1 && visited[vert] == 0) { //adj vert & not visited
                    this.visited[vert] = 1; // visit adjacent node
                    System.out.println("Visiting vertex: " + vert);
                    q.add(vert); // add adjacent node to Q
                }
            }
            q.poll(); // remove Q.head from Q
        }
    }

    /**
     * Drives the program.
     *
     * @param args unused
     */
    public static void main(final String[] args) {
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
