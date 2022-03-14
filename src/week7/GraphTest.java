package week7;

public class GraphTest {

    public static void main(String[] args) {
        // Part1 - Q2
        System.out.println("Part1 - Q2");
        // first test - size 5 x 5 matrix
        AdjGraph firstTestWithSizeFive = new AdjGraph(5);

        firstTestWithSizeFive.addEdge(0, 1);
        firstTestWithSizeFive.addEdge(0, 3);
        firstTestWithSizeFive.addEdge(0, 4);
        firstTestWithSizeFive.addEdge(1, 2);
        firstTestWithSizeFive.addEdge(1, 4);
        firstTestWithSizeFive.addEdge(2, 3);
        firstTestWithSizeFive.addEdge(3, 4);

        System.out.println("First test");
        System.out.println(firstTestWithSizeFive);

        // second test - size 4 x 4 matrix
        AdjGraph secondTestWithSizeFour = new AdjGraph(4);
        secondTestWithSizeFour.addEdge(0, 1);
        secondTestWithSizeFour.addEdge(1, 2);
        secondTestWithSizeFour.addEdge(2, 3);

        System.out.println("Second test");
        System.out.println(secondTestWithSizeFour);

        // Part1 - Q3
        System.out.println("Part1 - Q3");
        int d1 = firstTestWithSizeFive.degree(0);
        System.out.println("degree[0] = " + d1);
        int d2 = secondTestWithSizeFour.degree(0);
        System.out.println("degree[0] = " + d2);


    }
}
