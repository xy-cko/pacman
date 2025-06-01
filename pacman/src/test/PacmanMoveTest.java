import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import model.*;

public class PacmanMoveTest {

    private Map map;
    private Cell startCell;
    private Pacman pacman;

    @Before
    public void setUp() {
        map = new Map(5, 5);

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                map.getCells()[row][col] = new Cell(row, col, map);
            }
        }

        startCell = map.getSingleCell(2, 2);
        pacman = new Pacman(startCell);
    }

    @Test
    public void testMoveUp() {
        pacman.changeDirection(Direction.UP);
        pacman.move();

        assertEquals(1, pacman.getLocation().getRow());
        assertEquals(2, pacman.getLocation().getCol());
    }

    @Test
    public void testMoveDown() {
        pacman.changeDirection(Direction.DOWN);
        pacman.move();

        assertEquals(3, pacman.getLocation().getRow());
        assertEquals(2, pacman.getLocation().getCol());
    }

    @Test
    public void testMoveLeft() {
        pacman.changeDirection(Direction.LEFT);
        pacman.move();

        assertEquals(2, pacman.getLocation().getRow());
        assertEquals(1, pacman.getLocation().getCol());
    }

    @Test
    public void testMoveRight() {
        pacman.changeDirection(Direction.RIGHT);
        pacman.move();

        assertEquals(2, pacman.getLocation().getRow());
        assertEquals(3, pacman.getLocation().getCol());
    }

    @Test
    public void testMoveToNonWalkableCell() {
        startCell.getUpperCell().setWalkable(false);

        pacman.changeDirection(Direction.UP);
        pacman.move();

        assertEquals(2, pacman.getLocation().getRow());
        assertEquals(2, pacman.getLocation().getCol());
    }

    @Test
    public void testMoveOutOfBounds() {
        pacman.changeLocation(map.getSingleCell(0, 2));

        pacman.changeDirection(Direction.UP);
        pacman.move();

        assertEquals(0, pacman.getLocation().getRow());
        assertEquals(2, pacman.getLocation().getCol());
    }
}
