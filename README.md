# Maze Generation using Disjoint Sets

This is a simple experiment in generating a maze using the [Disjoint Set Union Find](https://en.wikipedia.org/wiki/Disjoint-set_data_structure) data structure.

This implementation connects random "cells" of the maze with one of its neighbours, randomly chosen, till such time as the starting (top-left) and 
ending (bottom-right) cells are connected.

The output should work with any Unix-like system terminal. The implementation specifically uses [ANSI Escape Codes](https://en.wikipedia.org/wiki/ANSI_escape_code) 
for rendering the maze onto the screen.

## Demo


```
$ mvn clean && mvn compile

$ mvn exec:java -Dexec.mainClass=com.z0ltan.dsuf_maze.App -Dexec.args="27 19"


     +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+
     |           |   |                                       |                   |
     +   +---+   +   +   +   +   +---+---+   +   +   +   +   +   +---+---+   +   +
     |   |   |       |                       |                                   |
     +   +   +   +   +   +---+---+   +---+   +   +   +   +   +   +   +   +   +   +
     |       |                       |               |                       |   |
     +   +   +   +   +   +   +   +   +   +   +---+   +---+   +   +---+   +---+   +
     |           |   |                                           |   |   |       |
     +   +   +   +   +   +   +   +   +   +   +   +   +   +   +---+   +---+---+---+
     |                           |   |                                   |   |   |
     +   +   +   +---+   +   +   +   +   +   +   +   +   +   +   +   +   +   +   +
     |       |                   |                       |       |               |
     +   +   +   +   +   +   +   +---+   +   +---+   +   +   +   +---+---+   +   +
     |   |                               |   |               |   |               |
     +   +   +   +---+---+   +---+   +   +   +   +   +   +   +   +   +   +   +   +
     |                           |                                               |
     +---+---+   +   +   +   +---+   +   +   +   +   +   +---+   +   +   +   +   +
     |       |                           |           |   |                       |
     +   +   +   +   +---+   +---+---+   +   +   +   +   +   +   +---+   +   +   +
     |   |               |           |                           |           |   |
     +   +---+   +   +   +---+   +---+   +---+---+   +---+   +   +   +   +   +   +
     |               |                                                   |   |   |
     +   +---+   +   +   +   +   +   +   +   +   +   +---+   +   +   +   +   +   +
     |           |   |       |   |   |       |       |           |       |   |   |
     +   +---+   +   +   +   +---+   +   +   +   +   +   +---+   +   +---+---+   +
     |                   |   |   |   |       |   |                               |
     +   +   +   +   +   +---+   +   +   +   +---+   +   +   +   +---+   +   +   +
     |               |                   |   |   |   |       |                   |
     +   +   +   +   +   +---+   +   +   +---+   +   +---+   +   +   +   +   +   +
     |               |       |   |   |               |                           |
     +   +   +   +   +---+   +   +   +---+   +---+   +   +   +   +---+   +   +   +
     |                                   |       |   |                           |
     +   +   +---+   +   +---+---+   +   +   +---+   +   +   +   +   +   +   +   +
     |   |                           |       |   |   |   |               |       |
     +---+---+   +   +   +   +---+   +   +---+   +   +   +   +   +   +   +---+   +
     |                               |               |       |               |   |
     +---+   +---+   +   +   +   +   +   +   +   +---+   +   +---+---+---+   +   +
     |       |   |   |   |       |   |   |                           |           |
     +   +---+   +   +   +   +   +   +   +   +   +---+   +   +   +   +   +   +   +
     |               |   |       |                           |               |   |
     +---+   +   +   +   +---+   +   +   +   +   +   +---+   +   +   +   +   +   +
     |                                   |   |                                   |
     +   +   +   +   +   +   +   +---+   +   +   +   +   +   +   +   +   +---+   +
     |       |   |                                                       |   |   |
     +   +   +---+   +   +   +   +---+   +   +   +---+---+   +   +---+   +   +   +
     |               |   |   |       |                   |                       |
     +   +   +   +   +   +   +   +   +   +---+---+   +   +---+   +---+---+   +   +
     |                           |   |                                           |
     +   +---+   +---+   +   +---+   +   +   +   +   +   +   +   +   +---+   +   +
     |                                                                           |
     +   +   +   +   +   +   +   +---+   +   +   +   +   +   +   +   +   +   +   +
     |   |       |       |   |                               |   |       |       |
     +   +   +   +---+   +   +   +---+   +   +   +   +---+   +---+   +---+   +   +
     |       |           |                                                       |
     +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+

```
## LICENCE

See [LICENCE](LICENSE).
