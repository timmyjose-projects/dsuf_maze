package com.z0ltan.dsuf_maze;

public class Graphics {
  private static final int LINE_OFFSET = 5;
  private static final int COL_OFFSET = 5;

  private static final int CELL_WIDTH = 4;
  private static final String HORIZONTAL_WALL = "+---+";
  private static final String MISSING_HORIZONTAL_WALL = "+   +";
  private static final String VERTICAL_WALL = "|";

  public static void printMaze(final Maze maze) {
    cls();
    gotoCoord(LINE_OFFSET, COL_OFFSET);

    for (int i = 0; i < maze.getNumRows(); i++) {
      for (int j = 0; j < maze.getNumCols(); j++) {
        if (maze.getCells()[i][j].hasNorthWall) {
          printWall(i, j, Direction.North, false);
        } else {
          printWall(i,j, Direction.North, true);
        }

        if (maze.getCells()[i][j].hasEastWall) {
          printWall(i, j, Direction.East, false);
        }

        if (maze.getCells()[i][j].hasSouthWall) {
          printWall(i, j, Direction.South, false);
        } else {
          printWall(i, j, Direction.South, true);
        }

        if (maze.getCells()[i][j].hasWestWall) {
          printWall(i, j, Direction.West, false);
        }
      }
    }

    gotoCoord(LINE_OFFSET + maze.getNumRows() * 2 + 4, 0);
  }

  private static void printWall(int r, int c, Direction direction, boolean missing) {
    int line = getLineForWall(r, direction);
    int col = getColForWall(c, direction);

    gotoCoord(line, col);

    switch (direction) {
      case North:
      case South:
        if (missing) {
          System.out.print(MISSING_HORIZONTAL_WALL);
        } else {
          System.out.print(HORIZONTAL_WALL);
        }
        break;

      default:
        System.out.print(VERTICAL_WALL);
    }
  }

  private static int getLineForWall(int row, Direction direction) {
    int line  = switch (direction) {
      case North -> row * 2 + 1;
      case East  -> (row + 1) * 2;
      case South -> (row + 1) * 2 + 1;
      default -> (row + 1) * 2;
    };

    return LINE_OFFSET + line;
  }

  private static int getColForWall(int col, Direction direction) {
    int column = switch (direction) {
      case North -> col * CELL_WIDTH + 1;
      case East -> (col + 1) * CELL_WIDTH + 1;
      case South -> col * CELL_WIDTH + 1;
      default -> col * CELL_WIDTH + 1;
    };

    return COL_OFFSET + column;
  }
  private static void cls() {
    System.out.print("\033[2J");
  }

  private static void gotoCoord(int line, int col) {
    System.out.print("\033[" + line + ";" + col + "H");
  }
}
