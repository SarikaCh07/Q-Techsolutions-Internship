import java.util.*;

public class MazeSolver {
    private static final int[] rowDir = {-1, 1, 0, 0};
    private static final int[] colDir = {0, 0, -1, 1};
    static class Node {
        int row, col;
        List<String> path; 
        Node(int row, int col, List<String> path) {
            this.row = row;
            this.col = col;
            this.path = new ArrayList<>(path); 
        }
    }
    public static void bfs(int[][] maze, int startRow, int startCol, int endRow, int endCol) {
        int n = maze.length;
        int m = maze[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<Node> queue = new LinkedList<>();
        List<String> startPath = new ArrayList<>();
        startPath.add("(" + startRow + "," + startCol + ")");
        queue.add(new Node(startRow, startCol, startPath));
        visited[startRow][startCol] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.row == endRow && current.col == endCol) {
                System.out.println("Path from start to end:");
                for (String step : current.path) {
                    System.out.print(step + " ");
                }
                System.out.println();
                return;
            }
            for (int i = 0; i < 4; i++) {
                int newRow = current.row + rowDir[i];
                int newCol = current.col + colDir[i];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m &&
                    maze[newRow][newCol] == 0 && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    List<String> newPath = new ArrayList<>(current.path);
                    newPath.add("(" + newRow + "," + newCol + ")");
                    queue.add(new Node(newRow, newCol, newPath));
                }
            }
        }
        System.out.println("No path exists from start to end.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows in the maze: ");
        int n = sc.nextInt();
        System.out.print("Enter the number of columns in the maze: ");
        int m = sc.nextInt();
        int[][] maze = new int[n][m];
        System.out.println("Enter the maze (0 for open space, 1 for wall):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        System.out.print("Enter the start row: ");
        int startRow = sc.nextInt();
        System.out.print("Enter the start column: ");
        int startCol = sc.nextInt();

        System.out.print("Enter the end row: ");
        int endRow = sc.nextInt();
        System.out.print("Enter the end column: ");
        int endCol = sc.nextInt();
        bfs(maze, startRow, startCol, endRow, endCol);

        sc.close(); 
    }
}
