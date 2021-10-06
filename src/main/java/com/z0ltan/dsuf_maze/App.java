package com.z0ltan.dsuf_maze;

public class App {
  public static void main(String[] args) {
    if (args.length != 2) {
      usage();
    }

    int rows = Integer.parseInt(args[0]);
    int cols = Integer.parseInt(args[1]);

    Maze maze = new Maze(rows, cols);
    maze.generate();
  }

  private static void usage() {
    System.out.println("Usage: maze <rows><columns>");
    System.exit(1);
  }
}
