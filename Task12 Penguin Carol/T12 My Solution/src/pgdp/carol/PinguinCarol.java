package pgdp.carol;

import static pgdp.MiniJava.*;

public class PinguinCarol {

	public static void main(String[] args) {
		// create the 2D array and print the playground:
		int x = readInt("Spielfeldbreite eingeben:");
		int y = readInt("Spielfeldhöhe eingeben:");
		if(x<=0 || y<=0) write("Spielfeldbreite und -höhe müssen größer als null sein.");
		else{
			int [][] playground = new int [x][y];
			for(int i =0;i<x;i++){
				for(int j=0;j<y;j++){
					playground[i][j] = randomInt(-1,9);
				}
			}
			printPlayground(playground);
			// Input of the desired initial situation:
			int position_x = readInt("Startposition x:");
			int position_y = readInt("Startposition y:");
			int direction = readInt("Blickrichtung zu Beginn:");
			int iceblock = readInt("Eisblöcke zu Beginn:");
			if((position_x<0 || position_x>=x) ||(position_y<0 || position_y>=y) ||
					(iceblock <0 || iceblock >10)|| (direction !=0 && direction != 1 && direction !=2 && direction !=3)) {
				write("Ungültige Startwerte.");
			}
			// if valid input, start the simulation:
			else{
				boolean end = false;
				char instruction = readChar("Instruktion eingeben:");
				while(!end){
					switch(instruction){
						case 'e': end =true; break;
						case 'a': {
							printPlayground(playground,position_x,position_y,direction,iceblock);
							break;
						}
						case 'r': {
							switch(direction){
								case 0: direction =3; break;
								case 1: direction =0; break;
								case 2: direction =1; break;
								case 3: direction =2; break;
							}
							break;
						}
						case 'l': {
							switch(direction) {
								case 0: direction = 1;break;
								case 1: direction = 2;break;
								case 2: direction = 3;break;
								case 3: direction = 0;break;
							}
							break;
						}
						case 's':{
							switch(direction){
								case 0: {
									if(position_x+1>=x) write("Carol kann das Spielfeld nicht verlassen.");
									else{
										int diff = playground[position_x+1][position_y] - playground[position_x][position_y];
										if(diff>1 || diff <-1) {
											write("Carol kann nicht auf das nächste Feld gehen da der Höhenunterschied zu groß ist.");
										}
										else position_x +=1;
									}
									break;
								}
								case 1: {
									if(position_y+1>=y) {
										write("Carol kann das Spielfeld nicht verlassen.");
									}
									else{
										int diff = playground[position_x][position_y+1]-playground[position_x][position_y];
										if(diff>1 || diff<-1) {
											write("Carol kann nicht auf das nächste Feld gehen da der Höhenunterschied zu groß ist.");
										}
										else position_y +=1;
									}
									break;
								}
								case 2: {
									if(position_x-1<0) {
										write("Carol kann das Spielfeld nicht verlassen.");
									}
									else{
										int diff = playground[position_x-1][position_y]-playground[position_x][position_y];
									    if(diff >1 || diff<-1) {
									    	write("Carol kann nicht auf das nächste Feld gehen da der Höhenunterschied zu groß ist.");
										}
										else position_x -=1;
									}
									break;
								}
								case 3: {
									if(position_y-1<0) {
										write("Carol kann das Spielfeld nicht verlassen.");
									}
									else{
										int diff = playground[position_x][position_y-1] - playground[position_x][position_y];
										if(diff>1 || diff <-1) {
											write("Carol kann nicht auf das nächste Feld gehen da der Höhenunterschied zu groß ist.");
										}
										else position_y -=1;
									}
									break;
								}
							}
							break;
						}
						case 'n': {
							if(iceblock==10) write("Carol kann keinen Eisblock nehmen, sie trägt schon zehn.");
							else if(playground[position_x][position_y]==-1) write("Carol kann im Wasser keine Eisblöcke nehmen.");
							// out of range:
							else if((direction==0 && position_x==x-1) || (direction==1 && position_y==y-1) ||
									(direction==2 && position_x==0) || (direction==3 && position_y==0))
								write("Carol kann keine Eisblöcke außerhalb des Spielfelds nehmen.");
							// no ice block on that filed:
							else if((direction==0 && playground[position_x+1][position_y]==-1) || (direction==1 && playground[position_x][position_y+1]==-1) ||
									(direction==2 && playground[position_x-1][position_y]==-1) || (direction==3 && playground[position_x][position_y-1]==-1))
								write("Carol kann keinen Eisblock nehmen, es sind keine mehr vorhanden.");
							else {
								switch(direction){
									case 0: {playground[position_x+1][position_y] -=1; break;}
									case 1: {playground[position_x][position_y+1] -=1; break;}
									case 2: {playground[position_x-1][position_y] -=1; break;}
									case 3: {playground[position_x][position_y-1] -=1; break;}
								}
								iceblock+=1;
							}
							break;
						}
						case 'p':{
							if(iceblock==0) write("Carol kann keinen Eisblock legen, weil sie keine trägt.");
							else if(playground[position_x][position_y]==-1) write("Carol kann im Wasser keine Eisblöcke legen.");
							// out of range:
							else if((direction==0 && position_x==x-1) || (direction==1 && position_y==y-1) ||
									(direction==2 && position_x==0) || (direction==3 && position_y==0))
								write("Carol kann keine Eisblöcke außerhalb des Spielfelds legen.");
							// already max 9 blocks on that field:
							else if((direction ==0 && playground[position_x+1][position_y]==9) ||
									(direction ==1 && playground[position_x][position_y+1]==9) ||
									(direction ==2 && playground[position_x-1][position_y]==9) ||
									(direction ==3 && playground[position_x][position_y-1]==9))
								write("Carol kann keinen Eisblock legen, es liegen schon zehn Eisblöcke auf dem Feld.");

							else {
								switch(direction){
									case 0: {playground[position_x+1][position_y] +=1; break;}
									case 1: {playground[position_x][position_y+1] +=1; break;}
									case 2: {playground[position_x-1][position_y] +=1; break;}
									case 3: {playground[position_x][position_y-1] +=1; break;}
								}
								iceblock-=1;
							}
							break;}
						default: {
							write("Unbekannte Anweisung!");
						}
						break;
					}
					if(instruction!='e') instruction = readChar("Instruktion eingeben:");
				}
			}
		}
	}
}
