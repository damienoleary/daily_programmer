import java.util.*;

public class Inter315 {

    private static final double CHANCE_OF_BEING_ALIVE = 0.45;
    private static final double CHANCE_OF_BEING_RED = 0.5;
    private static final char RED_CELL = '#';
    private static final char BLUE_CELL = '*';
    private static final char EMPTY_CELL = '.';

    public static void main(String[] args) {
        int w = 32;
        int h = 17;
        int n = 10;

        char[][] grid = generateGrid(w, h);

        printGrid(simulate(grid, n));
    }

    private static char[][] generateGrid(int width, int height) {
        Random random = new Random();
        char[][] grid = new char[height][];

        for (int row = 0; row < height; row++) {
            char[] cells = new char[width];
            for (int col = 0; col < width; col++) {
                if (random.nextDouble() < CHANCE_OF_BEING_ALIVE) {
                    cells[col] = (random.nextDouble() < CHANCE_OF_BEING_RED) ? RED_CELL : BLUE_CELL;
                }
                else {
                    cells[col] = EMPTY_CELL;
                }
            }
            grid[row] = cells;
        }

        return grid;
    }

    private static char[][] simulate(char[][] grid, int times) {
        char[][] result = grid;
        for (int i = 0; i < times; i++) {
            result = simulate(result);
        }
        return result;
    }

    private static char[][] simulate(char[][] grid) {
        int w = grid[0].length;
        int h = grid.length;
        List<CellUpdate> updates = new ArrayList<>();

        for (int row = 0; row < h; row++) {
            for (int col = 0; col < w; col++) {
                simulateCell(grid, row, col).ifPresent(update -> updates.add(update));
            }
        }

        for (CellUpdate update : updates) {
            grid[update.row][update.col] = update.newColor;
        }

        return grid;
    }

    private static Map<Character, Integer> getNeighboursColors(char[][] grid, int row, int col) {
        Map<Character, Integer> neighbours = new HashMap<>();
        int w = grid[0].length;
        int h = grid.length;

        int neighbourRow = (row + h - 1) % h;
        for (int i = 0; i < 3; i++, neighbourRow = (neighbourRow + 1) % h) {
            int neighbourCol = (col + w - 1) % w;
            for (int j = 0; j < 3; j++, neighbourCol = (neighbourCol + 1) % w) {
                if (neighbourRow == row && neighbourCol == col) { continue; }
                char neighbourCellColor = grid[neighbourRow][neighbourCol];
                int oldVal = neighbours.getOrDefault(neighbourCellColor, 0);
                neighbours.put(neighbourCellColor, oldVal + 1);
            }
        }
        return neighbours;
    }

    private static Optional<CellUpdate> simulateCell(char[][] grid, int row, int col) {
        Map<Character, Integer> neighboursColors = getNeighboursColors(grid, row, col);
        char thisCellColor = grid[row][col];
        int redCells = neighboursColors.getOrDefault(RED_CELL, 0);
        int blueCells = neighboursColors.getOrDefault(BLUE_CELL, 0);
        int totalCells = redCells + blueCells;
        char mostPopularColor = (redCells > blueCells) ? RED_CELL : BLUE_CELL;
        CellUpdate result = null;

        if (thisCellColor == EMPTY_CELL) {
            if (totalCells == 3) {
                result = new CellUpdate(col, row, mostPopularColor);
            }
        }
        else {
            if (totalCells == 2 || totalCells == 3) {
                if (redCells != blueCells) {
                    result = new CellUpdate(col, row, mostPopularColor);
                }
            }
            else {
                result = new CellUpdate(col, row, EMPTY_CELL);
            }
        }
        return Optional.ofNullable(result);
    }

    private static class CellUpdate {
        final int col, row;
        final char newColor;

        CellUpdate(int col, int row, char newColor) {
            this.col = col;
            this.row = row;
            this.newColor = newColor;
        }
    }

    private static void printGrid(char[][] grid) {
        for (char[] row : grid) {
            System.out.println(row);
        }
    }
}