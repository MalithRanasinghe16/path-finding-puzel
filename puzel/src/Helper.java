package src;

/**Malith Ranasinghe 20221458**/
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;

public class Helper {
    public static String start;
    public static String end;

    public static char[][] readMaze(String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fileName));
        ArrayList<String> input = new ArrayList<String>();
        int row = 1;
        while (sc.hasNextLine()) {
            String stringLine = "X" + sc.nextLine() + "X";
            char[] line = stringLine.toCharArray();
            for (int i = 1; i < line.length - 1; i++) {
                if (line[i] == 'S') {
                    Helper.start = row + "," + i;
                } else if (line[i] == 'F') {
                    Helper.end = row + "," + i;
                }
            }
            input.add(String.valueOf(line));
            row++;
        }
        int col = input.get(0).length();
        String wall = createWall(col);
        input.add(0, wall);
        input.add(wall);
        return createCharArray(input);
    }

    public static void printMaze(char[][] maze) {
        for (int i = 1; i < maze.length - 1; i++) {
            System.out.println(String.valueOf(maze[i]).substring(1, maze[0].length - 1));
        }
    }

    public static char[][] createCharArray(ArrayList<String> list) {
        int row = list.size();
        int col = list.get(0).length();
        char[][] arr = new char[row][col];
        for (int i = 0; i < row; i++) {
            arr[i] = list.get(i).toCharArray();
        }
        return arr;
    }

    public static String createWall(int size) {
        char[] wall = new char[size];
        for (int i = 0; i < size; i++) {
            wall[i] = 'X';
        }
        return String.valueOf(wall);
    }

    public static Vertex findVertex(char[][] maze, Vertex start, String direction, Vertex goal) {
        int x = start.getX();
        int y = start.getY();
        int row = 0;
        int col = 0;
        boolean isFinish = false;
        switch (direction) {
            case "up":
                col = y;
                for (int i = x - 1; i > 0; i--) {
                    if (maze[i][y] == '0') {
                        break;
                    }
                    if (maze[i][y] == 'F') {
                        isFinish = true;
                        break;
                    }
                    if (maze[i][y] == '.' && (maze[i - 1][y] == '0' || maze[i - 1][y] == 'X')) {
                        row = i;
                        break;
                    }
                }
                break;
            case "down":
                col = y;
                for (int i = x + 1; i < maze.length - 1; i++) {
                    if (maze[i][y] == '0') {
                        break;
                    }
                    if (maze[i][y] == 'F') {
                        isFinish = true;
                        break;
                    }
                    if (maze[i][y] == '.' && (maze[i + 1][y] == '0' || maze[i + 1][y] == 'X')) {
                        row = i;
                        break;
                    }
                }
                break;
            case "left":
                row = x;
                for (int i = y - 1; i > 0; i--) {
                    if (maze[x][i] == '0') {
                        break;
                    }
                    if (maze[x][i] == 'F') {
                        isFinish = true;
                        break;
                    }
                    if (maze[x][i] == '.' && (maze[x][i - 1] == '0' || maze[x][i - 1] == 'X')) {
                        col = i;
                        break;
                    }
                }
                break;
            case "right":
                row = x;
                for (int i = y + 1; i < maze[x].length - 1; i++) {
                    if (maze[x][i] == '0') {
                        break;
                    }
                    if (maze[x][i] == 'F') {
                        isFinish = true;
                        break;
                    }
                    if (maze[x][i] == '.' && (maze[x][i + 1] == '0' || maze[x][i + 1] == 'X')) {
                        col = i;
                        break;
                    }
                }

        }
        if (isFinish) {
            return goal;
        }
        if (row == 0 || col == 0) {
            return null;
        }
        return new Vertex(row, col);
    }
}
