package src;
/**Malith Ranasinghe 20221458**/
public class Vertex {
    private int x;
    private int y;
    private boolean visited;
    private Vertex parent;
    private boolean pathVertex;
    private Vertex upVertex;
    private Vertex downVertex;
    private Vertex leftVertex;
    private Vertex rightVertex;

    public Vertex(String coordinates) {
        String[] arrOfStr = coordinates.split(",", 2);
        this.x = Integer.parseInt(arrOfStr[0]);
        this.y = Integer.parseInt(arrOfStr[1]);
    }

    public Vertex(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited() {
        this.visited = true;
    }

    public Vertex getParent() {
        return parent;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    public boolean isPathVertex() {
        return pathVertex;
    }

    public void setPathVertex() {
        pathVertex = true;
    }

    public Vertex getUpVertex() {
        return upVertex;
    }

    public void setUpVertex(Vertex upVertex) {
        this.upVertex = upVertex;
    }

    public Vertex getDownVertex() {
        return downVertex;
    }

    public void setDownVertex(Vertex downVertex) {
        this.downVertex = downVertex;
    }

    public Vertex getLeftVertex() {
        return leftVertex;
    }

    public void setLeftVertex(Vertex leftVertex) {
        this.leftVertex = leftVertex;
    }

    public Vertex getRightVertex() {
        return rightVertex;
    }

    public void setRightVertex(Vertex rightVertex) {
        this.rightVertex = rightVertex;
    }

    public String toString() {
        return "(" + y + "," + x + ")";
    }

    public boolean equals(Object node) {
        if (!(node instanceof Vertex)) {
            return false;
        }
        Vertex vertex = (Vertex) node;
        if (this.x == vertex.getX() && this.y == vertex.getY()) {
            return true;
        }
        return false;
    }
}
