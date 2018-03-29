import java.io.*;
import java.util.*;
/* # Is ship
   X is hit
   O is miss
   
   Row Same && Column Increased || Row Increased && Column Same
 */
public class BattleShip {
	private char arr[][] = new char[12][12];
	private char p1Board[][] = new char[12][12];
	private char p2Board[][] = new char[12][12];
	
	public BattleShip(){
		
	}
	
	public void makeBoard(){			//Done
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
	
	public void printEmptyBoard(){		//Done
		for(int k = 0; k < 10; k++){
			for(int l = 0; l < 10; l++){
				System.out.print(arr[k][l]);
				if(l == 9){
					System.out.println("");
				}
			}
		}
	}
	
	public void printP1Board(){			//Done
		for(int k = 0; k < 10; k++){
			for(int l = 0; l < 10; l++){
				System.out.print(p1Board[k][l]);
				if(l == 9){
					System.out.println("");
				}
			}
		}
	}
	
	public void printP2Board(){			//Done
		for(int k = 0; k < 10; k++){
			for(int l = 0; l < 10; l++){
				System.out.print(p2Board[k][l]);
				if(l == 9){
					System.out.println("");
				}
			}
		}
	}

	public void placeTwoSpotShip(){		//Done
		Scanner kbReader = new Scanner(System.in);
		
		p1Board = arr;
		
		String place[] = new String[2];
		char charPlace[] = new char[3];
		
		char test[] = new char[3];
		
		System.out.println("Please type a row letter and column number for each ship's spot. (ex. A2)");
		
		for(int i = 0; i < 2; i++){
			if(i == 0){		//First Spot
				System.out.println("What is the first place you would like your 2 long ship to be placed at?");
				place[0] = kbReader.next().toUpperCase();
				charPlace = place[0].toCharArray();
				
				if(charPlace[0] > 73 || charPlace[0] < 65|| charPlace.length > 2){	//On Board
					System.out.println("Error:");
					System.out.println("Row or Column not on board");
					i = -1;
				}
				else{
					test = place[0].toCharArray();
					p1Board[charPlace[0] - 64][charPlace[1] - 48] = '2';
				}
			}
			else{			//Second Spot
				System.out.println("What is the second place you would like your 2 long ship to be placed at?");
				place[1] = kbReader.next().toUpperCase();
				charPlace = place[1].toCharArray();
				
				if(charPlace[0] > 73 || charPlace[0] < 65 || charPlace.length > 2){	//On Board
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
							p1Board[charPlace[0] - 64][charPlace[1] - 48] = '2';
						}						
					}
				}
			}
		}
		printP1Board();
	}

	public void placeThreeSpotShip(){
		Scanner kbReader = new Scanner(System.in);
		
		String place[] = new String[2];
		char charPlace[] = new char[3];
		
		char test[] = new char[3];
		
		for(int i = 0; i < 2; i++){
			if(i == 0){		//First Spot
				System.out.println("What is the first place you would like your 3 long ship to be placed at?");
				place[0] = kbReader.next().toUpperCase();
				charPlace = place[0].toCharArray();
				
				if(charPlace[0] > 73 || charPlace[0] < 65 || charPlace.length > 2){	//On Board
					System.out.println("Error:");
					System.out.println("Row or Column not on board");
					i = -1;
				}
				else if(p1Board[charPlace[0] - 64][charPlace[1] - 48] != ' '){
					System.out.println("Error:");
					System.out.println("Spot already taken");
					i = -1;
				}
				else{
					test = place[0].toCharArray();
					p1Board[charPlace[0] - 64][charPlace[1] - 48] = '3';
				}
			}
			else{			//Last Spot
				System.out.println("What is the LAST place you would like your 3 long ship to be placed at?");
				place[1] = kbReader.next().toUpperCase();
				charPlace = place[1].toCharArray();
				
				if(charPlace[0] > 73 || charPlace[0] < 65 || charPlace.length > 2){	//On Board
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
						/*if(charPlace[0] == test[0] && charPlace[1] == test[1] + 2 || 
								charPlace[0] == test[0] && charPlace[1] == test[1] - 2){	//Row
							
						}
						else if(charPlace[1] == test[1]){	//Column
							
						}*/
						if(charPlace[0] > test[0] + 2 || charPlace[0] < test[0] - 2){	//Adjacent Row
							System.out.println("Error:");
							System.out.println("Row or Column input wrongly\n");
							i = 0;
						}
						else if(charPlace[1] > test[1] + 2 || charPlace[1] < test[1] - 2){	//Adjacent Column
							System.out.println("Error:");
							System.out.println("Row or Column input wrongly\n");
							i = 0;
						}
						else{
							p1Board[charPlace[0] - 64][charPlace[1] - 48] = '3';
						}						
					}
				}
			}
		}
		printP1Board();
	}
	
	public void placeFourSpotShip(){
		
	}
	
	public void placeFiveSpotShip(){
		
	}
}
