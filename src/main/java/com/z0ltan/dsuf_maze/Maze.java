package com.z0ltan.dsuf_maze;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Maze {
  private Cell[][] cells;
  private int numRows;
  private int numCols;

  private static final Random random = new Random();

  public Maze(int numRows, int numCols) {
    this.numRows = numRows;
    this.numCols = numCols;
    initialise();
  }

  private void initialise() {
    this.cells = new Cell[this.numRows][this.numCols];

    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < numCols; j++) {
        this.cells[i][j] = new Cell(i, j);
      }
    }
  }

  public int getNumRows() {
    return this.numRows;
  }

  public int getNumCols() {
    return this.numCols;
  }

  public Cell[][] getCells() {
    return this.cells;
  }

  public void generate() {
    DSU dsu = new DSU(numRows * numCols);
    int start = mapCellToDSUSet(cells[0][0]);
    int finish = mapCellToDSUSet(cells[numRows - 1][numCols - 1]);

    int ctr = 0;
    do {
      Cell from = getRandomCell();
      int fromIdx = mapCellToDSUSet(from);

      Cell to = getRandomNeighbour(from);
      int toIdx = mapCellToDSUSet(to);

      if (dsu.find(fromIdx) == dsu.find(toIdx)) {
        continue;
      }

      dsu.union(fromIdx, toIdx);

      switch (findDirection(from, to)) {
        case North:
          from.hasNorthWall = false;
          to.hasSouthWall = false;
          break;

        case East:
          from.hasEastWall = false;
          to.hasWestWall = false;
          break;

        case South:
          from.hasSouthWall = false;
          to.hasNorthWall = false;
          break;

        default:
          from.hasWestWall = false;
          to.hasEastWall = false;
      }

    } while (dsu.find(start) != dsu.find(finish));

    Graphics.printMaze(this);
  }

  private Direction findDirection(final Cell from, final Cell to) {
    if (to.row == from.row - 1) {
      return Direction.North;
    } else if (to.col == from.col + 1) {
      return Direction.East;
    } else if (to.row == from.row + 1) {
      return Direction.South;
    } else {
      return Direction.West;
    }
  }

  private Cell getRandomCell() {
    int randomRow = random.nextInt(numRows);
    int randomCol = random.nextInt(numCols);

    return cells[randomRow][randomCol];
  }

  private Cell getRandomNeighbour(final Cell cell) {
    final List<Pair> neighbours = new ArrayList<>();

    if (cell.row > 0) {
      neighbours.add(new Pair(cell.row - 1, cell.col));
    }

    if (cell.col < numCols - 1) {
      neighbours.add(new Pair(cell.row, cell.col + 1));
    }

    if (cell.row < numRows - 1) {
      neighbours.add(new Pair(cell.row + 1, cell.col));
    }

    if (cell.col > 0) {
      neighbours.add(new Pair(cell.row, cell.col - 1));
    }

    if (neighbours.size() == 0) {
      throw new IllegalStateException("no neighbours found");
    }

    Collections.shuffle(neighbours);

    int row = neighbours.get(0).first;
    int col = neighbours.get(0).second;

    return cells[row][col];
  }

  private int mapCellToDSUSet(Cell cell) {
    return cell.row * numCols + cell.col;
  }
}

class Pair {
  int first;
  int second;

  public Pair(int first, int second) {
    this.first = first;
    this.second = second;
  }
}
