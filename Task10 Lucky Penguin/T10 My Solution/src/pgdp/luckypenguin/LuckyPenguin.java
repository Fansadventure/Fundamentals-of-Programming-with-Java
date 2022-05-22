package pgdp.luckypenguin;

import static pgdp.MiniJava.*; //Diesen Import nicht löschen! Do not delete this import!

public class LuckyPenguin {
    public static void main(String[] args) {
        // ask for input:
        int n = readInt("Anzahl Pinguine:");
        while(n<=1){n = readInt("Anzahl Pinguine soll >1 sein:");}
        int m = readInt("Anfangsfische pro Pinguin:");
        while(m<=0){m = readInt("Anfangsfische soll >0 sein:");}
        // store the input in array:
        int [] player = new int [n];
        int [] fish = new int [n];
        for(int i =0; i<player.length;i++){
            player[i] =i;
            fish[i] = m;
        }
        //play the game:
        boolean lastplayer = false;
        int activeplayer = -1;
        int [] board = new int [9];

        while(!lastplayer){
            // check if last player:
            int count =0;
            for(int i=0;i<player.length;i++){
                if(player[i] == -1) count++;
                if(count == player.length - 1) lastplayer=true;
            }
            // change the active player to another:
            boolean findActivePlayer = false;
            while(!findActivePlayer){
                int j= (activeplayer+1)%n;
                while(j<player.length){
                    if(player[j] != -1){
                        activeplayer = j;
                        findActivePlayer=true;
                        break;
                    }
                    j++;
                }
                if(!findActivePlayer) activeplayer =-1;
            }
            // writeBoard:
            writeBoard(board[0],board[1],board[2],board[3],board[4],board[5],board[6],board[7],board[8]);
            write("Pinguin "+activeplayer +" ist dran:");
            if(lastplayer){
                write("Sie sind der letzte mitspielende Pinguin! Sie gewinnen alle Fische auf dem Brett!");
                int sum =0;
                for (int i=0;i<board.length;i++){
                    sum += board[i];
                }
                fish[activeplayer]=fish[activeplayer]+sum;
                break;
            }
            int d1 = dice();
            int d2 = dice();
            int sum = d1 + d2;
            write(d1+" + "+d2+" = "+sum+" wurde gewürfelt.");
            // check whether there is fish in that field:
            if(sum ==2){
                int take = 0;
                write("Glückspinguin! Sie gewinnen alle Fische auf dem Brett außer von F7!");
                for(int i =0;i<board.length;i++){
                    if(i!=4) {
                        take += board[i];
                        board[i] =0;
                    }
                }
                fish[activeplayer] = fish[activeplayer] + take;
            }else if(sum == 7){
                write("Hochzeit! Sie schenken einen Fisch und legen ihn auf F7.");
                board[4] = board[4]+1;
                fish[activeplayer] = fish[activeplayer] -1;
            }else if(sum ==12){
                int take = 0;
                write("Königspinguin! Sie gewinnen alle Fische auf dem Brett!");
                for(int i = 0; i<board.length;i++){
                    take += board[i];
                    board[i]=0;
                }
                fish[activeplayer] =fish[activeplayer] + take;
            }else{
                if(board[sum-3]==1) {
                    write("Sie nehmen den Fisch von F"+sum+".");
                    fish[activeplayer] = fish[activeplayer] + 1;
                    board[sum -3] =0;
                }else if(board[sum -3] ==0){
                    write("Sie legen einen Fisch auf F"+sum+".");
                    fish[activeplayer] = fish[activeplayer] - 1;
                    board[sum -3] =board[sum -3]+1;
                }

            }
            // print current active player's fish
            if(fish[activeplayer]==1) write("Sie haben jetzt 1 Fisch!");
            else write("Sie haben jetzt "+fish[activeplayer]+" Fische!");
            // whether continue to play the game?
            if(fish[activeplayer]==0) {
                write("Sie haben alle Fische verloren, daher können Sie nicht mehr spielen!");
                player[activeplayer] = -1;
            }else{
                int k = readInt("Geben Sie 1 ein, um jetzt das Spiel zu verlassen:");
                if(k==1) player[activeplayer] =-1;
            }

            }
        // calculate the max number of fishes and find the winner:
        int max =0;
        for (int i=0;i<fish.length;i++){
            if(max<fish[i]) max = fish[i];
        }
        write("Die Gewinnerpinguine mit "+max+" Fischen:");
        for(int i=0;i<fish.length;i++){
            if(fish[i]==max) write("Pinguin "+i);
        }
        }
    }
