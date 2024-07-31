package src;
/**Malith Ranasinghe 20221458**/
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.ArrayList;

public class SlidingMazePuzzle {
    private Vertex start;
    private Vertex finish;
    private String fileName;

    public SlidingMazePuzzle(String fileName) {
        this.fileName = fileName;
    }

    public void solvePuzzleGetShortestDistance() {
        try {
            char[][] maze = Helper.readMaze(fileName);
            Helper.printMaze(maze);
            implementGraph(maze);
            solveGetPathToShortestDistance();
        } catch (FileNotFoundException error) {
            System.out.println("File not found.");
        }
    }

    public void implementGraph(char[][] maze) { //create the graph with a starting node a finishing node
        LinkedList<Vertex> queue = new LinkedList<Vertex>();
        ArrayList<Vertex> visited = new ArrayList<Vertex>();

        start = new Vertex(Helper.start);
        finish = new Vertex(Helper.end);
        queue.addFirst(start);
        while (queue.size() > 0) {
            Vertex current = queue.removeFirst();
            //System.out.println("Current Vertex " + current);
            visited.add(current);
            // find top node
            Vertex topNode = Helper.findVertex(maze, current, "up", finish);
            current.setUpVertex(topNode);
            if (topNode != null && !topNode.equals(finish) && !visited.contains(topNode)) {
                //System.out.println("Added Node(top) " + topNode);
                queue.addLast(topNode);
            }
            // find bottom node
            Vertex bottomNode = Helper.findVertex(maze, current, "down", finish);
            current.setDownVertex(bottomNode);
            if (bottomNode != null && !bottomNode.equals(finish) && !visited.contains(bottomNode)) {
                //System.out.println("Added Node(bottom) " + bottomNode);
                queue.addLast(bottomNode);
            }
            // find left node
            Vertex leftNode = Helper.findVertex(maze, current, "left", finish);
            current.setLeftVertex(leftNode);
            if (leftNode != null && !leftNode.equals(finish) && !visited.contains(leftNode)) {
                //System.out.println("Added Node(left) " + leftNode);
                queue.addLast(leftNode);
            }
            // find right node
            Vertex rightNode = Helper.findVertex(maze, current, "right", finish);
            current.setRightVertex(rightNode);
            if (rightNode != null && !rightNode.equals(finish) && !visited.contains(rightNode)) {
                //System.out.println("Added Node(right) " + rightNode);
                queue.addLast(rightNode);
            }
        }
    }

    public void solveGetPathToShortestDistance() {
        LinkedList<Vertex> queue = new LinkedList<Vertex>();
        start.setVisited();
        queue.addFirst(start);
        while (queue.size() > 0) {

            Vertex current = queue.removeFirst();

            if (current.equals(finish)) {

                while (current.getParent() != null) {
                    current.setPathVertex();
                    current = current.getParent();
                }
                break;
            }
            Vertex top = current.getUpVertex();
            Vertex down = current.getDownVertex();
            Vertex left = current.getLeftVertex();
            Vertex right = current.getRightVertex();

            if (top != null && !top.isVisited()) {
                top.setParent(current);
                top.setVisited();
                queue.addLast(top);
            }

            if (down != null && !down.isVisited()) {
                down.setParent(current);
                down.setVisited();
                queue.addLast(down);
            }

            if (left != null && !left.isVisited()) {
                left.setParent(current);
                left.setVisited();
                queue.addLast(left);
            }

            if (right != null && !right.isVisited()) {
                right.setParent(current);
                right.setVisited();
                queue.addLast(right);
            }
        }
        printSolution();
    }

    public void printSolution() {
        Vertex current = start;
        System.out.println("Start at " + start);
        while (!current.equals(finish)) {
            Vertex up = current.getUpVertex();
            Vertex down = current.getDownVertex();
            Vertex left = current.getLeftVertex();
            Vertex right = current.getRightVertex();
            if (up != null && up.isPathVertex()) {
                System.out.println("Move up to " + up);
                current = up;
            } else if (down != null && down.isPathVertex()) {
                System.out.println("Move down to " + down);
                current = down;
            } else if (left != null && left.isPathVertex()) {
                System.out.println("Move left to" + left);
                current = left;
            } else if (right != null && right.isPathVertex()) {
                System.out.println("Move right to" + right);
                current = right;
            } else {
                System.out.println("No path found");
                break;
            }
        }
        if (current.equals(finish)) {
            System.out.println("Done!");
        }
    }
}
