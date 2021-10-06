package com.z0ltan.dsuf_maze;

public class Cell {
  int row;
  int col;
  boolean hasNorthWall;
  boolean hasEastWall;
  boolean hasSouthWall;
  boolean hasWestWall;

  public Cell(int row, int col) {
    this.row = row;
    this.col = col;
    hasNorthWall = hasEastWall = hasSouthWall = hasWestWall = true;
  }

  @Override
  public String toString() {
    return "(" + row + ", " + col + ", " + hasNorthWall + ",  " + hasEastWall + ", " + hasSouthWall + ", " + hasWestWall + ")";
  }
}
