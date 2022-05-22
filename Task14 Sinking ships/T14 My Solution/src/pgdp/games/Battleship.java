package pgdp.games;

import static pgdp.MiniJava.*;

public class Battleship {
	public static void main(String[] args) {
		int [][] board = generateBoard();
		write("Willkommen bei Schiffe-Versenken!");
		printBoard(board);
		int x,y;
		while(shipsLeft(board)==1){
      		 x = readNumber(1,8)-1;
      		 y = readCharacter('a',(char)('a'+ board.length-1));
      		 if(board[x][y]>1) write("Feld bereits beschossen!");
      		 else{
      		 	board[x][y] +=2;
      		 	printBoard(board);
			 }
		}
		write("Glückwunsch! Sie haben gewonnen!");
	}
	// Input:
	static int readNumber(int min, int max){
		int n = readInt("Zahl-Koordinate eingeben:");
		while(n<min || n>max){
			n = readInt("Zahl-Koordinate eingeben:");
		}
		return n;
	}
	public static int readCharacter(char min, char max){
		char n = readChar("Buchstaben-Koordinate eingeben:");
		while(n<min || n>max){
			n = readChar("Buchstaben-Koordinate eingeben:");
		}
		return n-'a'; // easy to make mistake here
	}
	// Output:
	public static void printBoard(int[][] board){
		for(int i=-1;i<board.length;i++){
			if(i==-1){
				writeConsole("+");
				for(char n ='a';n<'a'+board[i+1].length;n++) writeConsole(n);
			}else{
				writeConsole(i+1);
				for(int j=0;j<board[i].length;j++){
					if(board[i][j]==3) writeConsole("x");
					else if(board[i][j]==2) writeConsole("o");
					else writeConsole(" ");
				}
			}
			write("");
		}
	}
	// check if boats left
	public static int shipsLeft(int[][] board){
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[i].length;j++){
				if(board[i][j]==1) return 1;
			}
		}
		return 0;
	}
}
