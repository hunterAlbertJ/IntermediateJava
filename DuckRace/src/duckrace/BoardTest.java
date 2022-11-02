package duckrace;

//import static org.junit.Assert.*;

public class BoardTest {
    public static void main(String[] args) {
        Board board = new Board();
        board.dumpStudentIdMap();
        board.update(3, Reward.PRIZES);
        board.show();
    }

}