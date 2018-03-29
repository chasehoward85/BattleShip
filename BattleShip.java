import java.io.*;
import java.util.*;
/* # Is your ship
   X is hit
   O is miss
 */
public class BattleShip {
	private char arr[][] = new char[12][12];
	
	public BattleShip(){
		
	}
	
	public void makeBoard(){
		arr[0][0] = ' ';
		
		for(int i = 49; i < 60; i++){	//Column Numbers
			arr[0][i - 48] = (char)(i);
		}
		for(int k = 65; k < 74; k++){	//Row Letters
			arr[k - 64][0] = (char)(k);
		}
		
		for(int j = 1; j < 10; j ++){
			for(int l = 1; l < 10; l++){
				arr[j][l] = ' ';
			}
		}
	}
	
	public void printBoard(){
		for(int k = 0; k < 10; k++){
			for(int l = 0; l < 10; l++){
				System.out.print(arr[k][l]);
				if(l == 9){
					System.out.println("");
				}
			}
		}
	}
	public void placeTwoSpotShip(){
		Scanner kbReader = new Scanner(System.in);
		
		String place[] = new String[2];
		char charPlace[] = new char[3];
		
		char test[] = new char[3];
		
		System.out.println("Please type a row letter and column number for each ship's spot. (ex. A2)");
		
		for(int i = 0; i < 2; i++){
			if(i == 0){		//First Spot
				System.out.println("What is the first place you would like your 2 long ship to be placed at?");
				place[0] = kbReader.next().toUpperCase();
				charPlace = place[0].toCharArray();
				
				if(charPlace[0] > 73 || charPlace.length > 2){	//On Board
					System.out.println("Error:");
					System.out.println("Row or Column not on board");
					i = -1;
				}
				else{
					test = place[0].toCharArray();
					arr[charPlace[0] - 64][charPlace[1] - 48] = '2';
				}
			}
			else{			//Second Spot
				System.out.println("What is the second place you would like your 2 long ship to be placed at?");
				place[1] = kbReader.next().toUpperCase();
				charPlace = place[1].toCharArray();
				
				if(charPlace[0] > 73 || charPlace.length > 2){	//On Board
					System.out.println("Error:");
					System.out.println("Row or Column not on board");
					i = 0;
				}
				else{
					if(charPlace[0] == test[0] && charPlace[1] == test[1]){
						System.out.println("\nError:");
						System.out.println("Row or Column input wrongly\n");
						i = 0;
					}
					else{
						if(charPlace[0] > test[0] + 1 || charPlace[0] < test[0] - 1){	//Adjacent Row
							System.out.println("Error:");
							System.out.println("Row or Column input wrongly\n");
							i = 0;
						}
						else if(charPlace[1] > test[1] + 1 || charPlace[1] < test[1] - 1){	//Adjacent Column
							System.out.println("Error:");
							System.out.println("Row or Column input wrongly\n");
							i = 0;
						}
						else{
							arr[charPlace[0] - 64][charPlace[1] - 48] = '2';
						}						
					}
				}
			}
		}
		printBoard();
	}
}
