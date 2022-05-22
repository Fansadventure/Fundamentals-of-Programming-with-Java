package pgdp.maze;

import static pgdp.MiniJava.*;
import static pgdp.maze.Maze.*;

public class RightHandRule {
	static int[][] maze;
	// Constants, the number is the corresponding index in the array, giving the
	// x- and y-offset
	static int UP = 0;
	static int RIGHT = 1;
	static int DOWN = 2;
	static int LEFT = 3;
	static int[][] OFFSETS = new int[][] { { 0, -1 }, { 1, 0 }, { 0, 1 },
			{ -1, 0 } };

	public static void main(String[] args) {
		int width = readInt("Breite des Labyrinths?");
		int height = readInt("Höhe des Labyrinths?");
		if (width < 3 || height < 3) {
			write("Fehlerhafte Eingabe!");
			return;
		}
		// Generates the same maze (for the same size)
		maze = generateStandardMaze(width, height);
		draw(maze);
		// Generates a random maze
		// maze = generateMaze(width, height);
		int steps = walk(1, 0, DOWN);
		System.out.println("Benötigte Schritte: " + steps);
	}

	public static int walk(int x, int y, int direction) {
		maze[x][y] = PLAYER;
		draw(maze);
		maze[x][y] = OLD_PATH_DONE;
		if (x == maze.length - 1 && y == maze[0].length - 2) {
			write("Ausgang gefunden!");
			return 0;
		}
		if (x == 1 && y == 0 && direction != DOWN) {
			write("Kein Ausgang!");
			return 0;
		}
        // check coordinate on the right-hand side then exact ahead
		int [] CoordsAhead = new int [] {x+OFFSETS[direction][0], y+OFFSETS[direction][1]};
		int [] CoordsRight = new int [] {x+OFFSETS[(direction+1)%4][0], y+OFFSETS[(direction+1)%4][1]};
		int right2 = (direction+2)%4;
		if(maze[CoordsRight[0]][CoordsRight[1]]==WALL){
			if(maze[CoordsAhead[0]][CoordsAhead[1]]==WALL){
				return walk(x,y,right2);
			}else{
				return 1+walk(CoordsAhead[0],CoordsAhead[1],direction);
			}
		}else{
			return 1+walk(CoordsRight[0],CoordsRight[1],(direction+1)%4);
		}
	}
}
