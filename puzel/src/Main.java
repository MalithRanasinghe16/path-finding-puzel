package src;
/**Malith Ranasinghe 20221458**/
public class Main {
    public static void main(String[] args) {
        SlidingMazePuzzle mazePuzzle = new SlidingMazePuzzle("puzzle_40" + ".txt"); //Specify the file name that needs to be solved in order to get the shortest path
        long startTime = System.currentTimeMillis();
        mazePuzzle.solvePuzzleGetShortestDistance();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken " + (endTime - startTime) + " milliseconds");
    }
}
