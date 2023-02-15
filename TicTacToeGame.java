package tic.tac.toe.game;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {
    
    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
    
    public static void main(String[] args) {
        //creating the game board using 2-D array with 3 rows and 5 columns
        char [] [] gameBoard = {{' ','|',' ','|',' '},
                                {'-','+','-','+','-'},
                                {' ','|',' ','|',' '},
                                {'-','+','-','+','-'},
                                {' ','|',' ','|',' '}};
        printGameBoard(gameBoard);
        
        //to get the user to put in the board
        //were gonna be asking the user for a number 1 to 9 
        Scanner input = new Scanner(System.in);
        
        while(true){ //to maintaine the conuntiuaty of the game 
            System.out.println("Enter ur placment 1...9 :");
            int Pposition = input.nextInt();
            while(playerPositions.contains(Pposition) || cpuPositions.contains(Pposition)){
                System.out.println("Position is taken Enter a correct position : ");
                Pposition = input.nextInt();
            }
             placePiece(gameBoard,Pposition,"player");
//             
//            String result = checkWinner();
//            if(result.length() > 0){
//                System.out.println(result);
//                break;
//            }           
        //the computer turn u can do it in two ways:  1- using the random number generation.  2- using AI Libraries 
        // here we did random
            Random rand = new Random();
            int cpuPos = rand.nextInt(9) + 1;
            //computers turn    
            while(playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)){
                cpuPos = rand.nextInt(9) + 1;
            }
            placePiece(gameBoard,cpuPos,"cpu");
            printGameBoard(gameBoard);
            
           String result = checkWinner();
           System.out.println(result); 
        }
    
    }
    
    //now to print out the board we need to use 2 for loops (here we used for each loops)
    public static void printGameBoard (char[][] gameBoard){
        for(char[] row : gameBoard){
            for(char c : row){
                System.out.print(c);
            }
            System.out.println();
        }
    }
    public static void placePiece(char[][] gameBoard,int position ,String user){
        char symbol = ' ';
        if(user.equals("player")){
            symbol = 'X';
            playerPositions.add(position);
        }else if(user.equals("cpu")){
            symbol = 'O';
            cpuPositions.add(position);
        }
        switch(position){
            case 1 : gameBoard[0][0] = symbol; break;
            case 2 : gameBoard[0][2] = symbol; break;
            case 3 : gameBoard[0][4] = symbol; break;
            case 4 : gameBoard[2][0] = symbol; break;
            case 5 : gameBoard[2][2] = symbol; break;
            case 6 : gameBoard[2][4] = symbol; break;
            case 7 : gameBoard[4][0] = symbol; break;
            case 8 : gameBoard[4][2] = symbol; break;
            case 9 : gameBoard[4][4] = symbol; break; 
            default:
                break;
        }}
        
        //check the winner 
        public static String checkWinner(){
            
            List topRow =  Arrays.asList(1, 2, 3);
            List midRow =  Arrays.asList(4, 5, 6);
            List botRow =  Arrays.asList(7, 8, 9);
            List leftCol =  Arrays.asList(1, 4, 7);
            List midCol =  Arrays.asList(2, 5, 8);
            List rightCol =  Arrays.asList(3, 6, 9);  
            List cross1 =  Arrays.asList(1, 5, 9);
            List cross2 =  Arrays.asList(7, 5, 3);
            
            List<List> winning = new ArrayList<List>();
            winning.add(topRow);
            winning.add(midRow);
            winning.add(botRow);
            winning.add(leftCol);
            winning.add(midCol);
            winning.add(rightCol);
            winning.add(cross1);
            winning.add(cross2);
            
            for(List l : winning){
                if(playerPositions.containsAll(l))
                    return "congratulations";
                else if(cpuPositions.containsAll(l))
                    return "CPU Wins :(";
                else if (playerPositions.size() + cpuPositions.size() == 9) //in pther words the board is full
                    return "its a Tie";
            }
            
            return " ";
            
        }
        
    
    
}
