package week7;

import java.util.ArrayDeque;
import java.util.Queue;

public class AdjGraph {
    private int matrix[][];
    private boolean directed = false;
    private int[] visited;

    public AdjGraph(int num) {
        matrix = new int[num][num];
    }

    public boolean isDirected() {
        return false;
    }

    public void setDirected() {

    }

    public String toString() {
        String result = "";
        //implement
        return result;
    }

    public void addEdge(int x, int y) {
        //implement
    }

    public int degree(int x) {
        int degree = 0;

        //implement

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
}
