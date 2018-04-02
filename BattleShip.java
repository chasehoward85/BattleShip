import java.io.*;
import java.util.*;
/* # Is ship
   X is hit
   O is miss
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
	
	public void printPlayBoard(){		//Done
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
							if(charPlace[0] == test[0] && charPlace[1] == test[1] + 1){			//Row Same Column Increased
								p1Board[charPlace[0] - 64][charPlace[1] - 48] = '2';
							}
							else if(charPlace[0] == test[0] && charPlace[1] == test[1] - 1){	//Row Same Column Decreased
								p1Board[charPlace[0] - 64][charPlace[1] - 48] = '2';
							}
							else if(charPlace[1] == test[1] && charPlace[0] == test[0] + 1){	//Column Same Row Increased
								p1Board[charPlace[0] - 64][charPlace[1] - 48] = '2';
							}
							else if(charPlace[1] == test[1] && charPlace[0] == test[0] - 1){	//Column Same Row Decreased
								p1Board[charPlace[0] - 64][charPlace[1] - 48] = '2';
							}
							else{
								System.out.println("Error:");
								System.out.println("Row or Column input wrongly\n");
								i = 0;
							}
						}						
					}
				}
			}
		}
		printP1Board();
	}

	public void placeThreeSpotShip(){	//Done
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
							if(charPlace[0] == test[0] && charPlace[1] == test[1] + 2){			//Row Same Column Increased
								p1Board[charPlace[0] - 64][charPlace[1] - 48] = '3';
								p1Board[charPlace[0] - 64][charPlace[1] - 49] = '3';
							}
							else if(charPlace[0] == test[0] && charPlace[1] == test[1] - 2){	//Row Same Column Decreased
								p1Board[charPlace[0] - 64][charPlace[1] - 48] = '3';
								p1Board[charPlace[0] - 64][charPlace[1] - 47] = '3';
							}
							else if(charPlace[1] == test[1] && charPlace[0] == test[0] + 2){	//Column Same Row Increased
								p1Board[charPlace[0] - 64][charPlace[1] - 48] = '3';
								p1Board[charPlace[0] - 65][charPlace[1] - 48] = '3';
							}
							else if(charPlace[1] == test[1] && charPlace[0] == test[0] - 2){	//Column Same Row Decreased
								p1Board[charPlace[0] - 64][charPlace[1] - 48] = '3';
								p1Board[charPlace[0] - 63][charPlace[1] - 48] = '3';
							}
							else{
								System.out.println("Error:");
								System.out.println("Row or Column input wrongly\n");
								i = 0;
							}
						}						
					}
				}
			}
		}
		printP1Board();
	}
	
	public void placeFourSpotShip(){	//Done
		Scanner kbReader = new Scanner(System.in);
		
		String place[] = new String[2];
		char charPlace[] = new char[3];
		
		char test[] = new char[3];
		
		for(int i = 0; i < 2; i++){
			if(i == 0){		//First Spot
				System.out.println("What is the first place you would like your 4 long ship to be placed at?");
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
					p1Board[charPlace[0] - 64][charPlace[1] - 48] = '4';
				}
			}
			else{			//Last Spot
				System.out.println("What is the LAST place you would like your 4 long ship to be placed at?");
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
						if(charPlace[0] > test[0] + 3 || charPlace[0] < test[0] - 3){	//Adjacent Row
							System.out.println("Error:");
							System.out.println("Row or Column input wrongly\n");
							i = 0;
						}
						else if(charPlace[1] > test[1] + 3 || charPlace[1] < test[1] - 3){	//Adjacent Column
							System.out.println("Error:");
							System.out.println("Row or Column input wrongly\n");
							i = 0;
						}
						else{
							if(charPlace[0] == test[0] && charPlace[1] == test[1] + 3){			//Row Same Column Increased
								p1Board[charPlace[0] - 64][charPlace[1] - 48] = '4';
								p1Board[charPlace[0] - 64][charPlace[1] - 49] = '4';
								p1Board[charPlace[0] - 64][charPlace[1] - 50] = '4';
							}
							else if(charPlace[0] == test[0] && charPlace[1] == test[1] - 3){	//Row Same Column Decreased
								p1Board[charPlace[0] - 64][charPlace[1] - 48] = '4';
								p1Board[charPlace[0] - 64][charPlace[1] - 47] = '4';
								p1Board[charPlace[0] - 64][charPlace[1] - 46] = '4';
							}
							else if(charPlace[1] == test[1] && charPlace[0] == test[0] + 3){	//Column Same Row Increased
								p1Board[charPlace[0] - 64][charPlace[1] - 48] = '4';
								p1Board[charPlace[0] - 65][charPlace[1] - 48] = '4';
								p1Board[charPlace[0] - 66][charPlace[1] - 48] = '4';
							}
							else if(charPlace[1] == test[1] && charPlace[0] == test[0] - 3){	//Column Same Row Decreased
								p1Board[charPlace[0] - 64][charPlace[1] - 48] = '4';
								p1Board[charPlace[0] - 63][charPlace[1] - 48] = '4';
								p1Board[charPlace[0] - 62][charPlace[1] - 48] = '4';
							}
							else{
								System.out.println("Error:");
								System.out.println("Row or Column input wrongly\n");
								i = 0;
							}
						}						
					}
				}
			}
		}
		printP1Board();
	}
	
	public void placeFiveSpotShip(){	//Done
		Scanner kbReader = new Scanner(System.in);
		
		String place[] = new String[2];
		char charPlace[] = new char[3];
		
		char test[] = new char[3];
		
		for(int i = 0; i < 2; i++){
			if(i == 0){		//First Spot
				System.out.println("What is the first place you would like your 5 long ship to be placed at?");
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
					p1Board[charPlace[0] - 64][charPlace[1] - 48] = '5';
				}
			}
			else{			//Last Spot
				System.out.println("What is the LAST place you would like your 5 long ship to be placed at?");
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
						if(charPlace[0] > test[0] + 4 || charPlace[0] < test[0] - 4){	//Adjacent Row
							System.out.println("Error:");
							System.out.println("Row or Column input wrongly\n");
							i = 0;
						}
						else if(charPlace[1] > test[1] + 4 || charPlace[1] < test[1] - 4){	//Adjacent Column
							System.out.println("Error:");
							System.out.println("Row or Column input wrongly\n");
							i = 0;
						}
						else{
							if(charPlace[0] == test[0] && charPlace[1] == test[1] + 4){			//Row Same Column Increased
								p1Board[charPlace[0] - 64][charPlace[1] - 48] = '5';
								p1Board[charPlace[0] - 64][charPlace[1] - 49] = '5';
								p1Board[charPlace[0] - 64][charPlace[1] - 50] = '5';
								p1Board[charPlace[0] - 64][charPlace[1] - 51] = '5';
							}
							else if(charPlace[0] == test[0] && charPlace[1] == test[1] - 4){	//Row Same Column Decreased
								p1Board[charPlace[0] - 64][charPlace[1] - 48] = '5';
								p1Board[charPlace[0] - 64][charPlace[1] - 47] = '5';
								p1Board[charPlace[0] - 64][charPlace[1] - 46] = '5';
								p1Board[charPlace[0] - 64][charPlace[1] - 45] = '5';
							}
							else if(charPlace[1] == test[1] && charPlace[0] == test[0] + 4){	//Column Same Row Increased
								p1Board[charPlace[0] - 64][charPlace[1] - 48] = '5';
								p1Board[charPlace[0] - 65][charPlace[1] - 48] = '5';
								p1Board[charPlace[0] - 66][charPlace[1] - 48] = '5';
								p1Board[charPlace[0] - 66][charPlace[1] - 48] = '5';
							}
							else if(charPlace[1] == test[1] && charPlace[0] == test[0] - 4){	//Column Same Row Decreased
								p1Board[charPlace[0] - 64][charPlace[1] - 48] = '5';
								p1Board[charPlace[0] - 63][charPlace[1] - 48] = '5';
								p1Board[charPlace[0] - 62][charPlace[1] - 48] = '5';
								p1Board[charPlace[0] - 61][charPlace[1] - 48] = '5';
							}
							else{
								System.out.println("Error:");
								System.out.println("Row or Column input wrongly\n");
								i = 0;
							}
						}						
					}
				}
			}
		}
		printP1Board();
	}

	public void computerPlayer(){
		Random rCol = new Random();
		Random rRow = new Random();
		Random endSpot = new Random();
		
		int row;
		int col;
		int end;
		
		p2Board = arr;
		
		row = rRow.nextInt(8) + 1;
		col = rCol.nextInt(8) + 1;

		//Two Spot Ship
		for(int j = 0; j < 20; j++){
			if(p2Board[row][col] != ' '){
				row = rRow.nextInt(8) + 1;
				col = rCol.nextInt(8) + 1;
			}
			else{
				break;
			}
		}
		
		p2Board[row][col] = '2';	//First Spot
		end = endSpot.nextInt(3);
		
		for(int i = 0; i < 20; i++) {		//Testing if first spot at beginning or end
			if(row == 9 && end == 0) {			//Changes end spot from end of row
				end = endSpot.nextInt(3);
			}
			else if(row == 1 && end == 1) {		//Changes end spot from front of row
				end = endSpot.nextInt(3);
			}
			else if(col == 9 && end == 2) {		//Changes end spot from end of row
				end = endSpot.nextInt(3);
			}
			else if(col == 1 && end == 3) {		//Changes end spot from front of row
				end = endSpot.nextInt(3);
			}
			else {
				break;
			}
		}
		
		if(end == 0) {	//Increase Row
			p2Board[row + 1][col] = '2';
		}
		else if(end == 1) {	//Decrease Row
			p2Board[row - 1][col] = '2';
		}
		else if(end == 2) {	//Increase Column
			p2Board[row][col + 1] = '2';
		}
		else if(end == 3) {	//Decrease Column
			p2Board[row][col - 1] = '2';
		}
		//End Two Ship Placement ----------------------------------------------------------
		
		
		row = rRow.nextInt(8) + 1;
		col = rCol.nextInt(8) + 1;
		
		//Three Spot Ship
		for(int j = 0; j < 20; j++){
			if(p2Board[row][col] != ' '){
				row = rRow.nextInt(8) + 1;
				col = rCol.nextInt(8) + 1;
			}
			else{
				break;
			}
		}
		
		p2Board[row][col] = '3';	//First Spot
		end = endSpot.nextInt(3);
		
		for(int i = 0; i < 20; i++) {		//Testing if first spot at beginning or end or if filled
			if(end == 0 && p2Board[row + 1][col] != ' ' && p2Board[row + 2][col] != ' ') {		//Changes end spot from end of row
				end = endSpot.nextInt(3);
			}
			else if(end == 1 && p2Board[row - 1][col] != ' ' && p2Board[row - 2][col] != ' ') {		//Changes end spot from front of row
				end = endSpot.nextInt(3);
			}
			else if(end == 2 && p2Board[row][col + 1] != ' ' && p2Board[row][col + 2] != ' ') {		//Changes end spot from end of row
				end = endSpot.nextInt(3);
			}
			else if(end == 3 && p2Board[row][col - 1] != ' ' && p2Board[row][col - 2] != ' '){		//Changes end spot from front of row
				end = endSpot.nextInt(3);
			}
			else {
				break;
			}
		}
		
		if(end == 0) {	//Increase Row
			p2Board[row + 1][col] = '3';
			p2Board[row + 2][col] = '3';
		}
		else if(end == 1) {	//Decrease Row
			p2Board[row - 1][col] = '3';
			p2Board[row - 2][col] = '3';
		}
		else if(end == 2) {	//Increase Column
			p2Board[row][col + 1] = '3';
			p2Board[row][col + 2] = '3';
		}
		else if(end == 3) {	//Decrease Column
			p2Board[row][col - 1] = '3';
			p2Board[row][col - 2] = '3';
		}
		//End Three Ship Placement	------------------------------------------------
		
		row = rRow.nextInt(8) + 1;
		col = rCol.nextInt(8) + 1;
		
		//Four Spot Ship
		for(int j = 0; j < 20; j++){
			if(p2Board[row][col] != ' '){
				row = rRow.nextInt(8) + 1;
				col = rCol.nextInt(8) + 1;
			}
			else{
				break;
			}
		}
		
		p2Board[row][col] = '4';	//First Spot
		end = endSpot.nextInt(3);
		
		for(int i = 0; i < 20; i++) {		//Testing if first spot at beginning or end or if filled
			if(end == 0 && p2Board[row + 1][col] != ' '  && p2Board[row + 2][col] != ' ' && p2Board[row + 3][col] != ' ') {		//Changes end spot from end of row
				end = endSpot.nextInt(3);
			}
			else if(end == 1 && p2Board[row - 1][col] != ' ' && p2Board[row - 2][col] != ' ' && p2Board[row - 3][col] != ' ') {		//Changes end spot from front of row
				end = endSpot.nextInt(3);
			}
			else if(end == 2 && p2Board[row][col + 1] != ' ' && p2Board[row][col + 2] != ' ' && p2Board[row][col + 3] != ' ') {		//Changes end spot from end of row
				end = endSpot.nextInt(3);
			}
			else if(end == 3 && p2Board[row][col - 1] != ' ' && p2Board[row][col - 2] != ' ' && p2Board[row][col - 3] != ' '){		//Changes end spot from front of row
				end = endSpot.nextInt(3);
			}
			else {
				break;
			}
		}
		
		if(end == 0) {	//Increase Row
			p2Board[row + 1][col] = '4';
			p2Board[row + 2][col] = '4';
			p2Board[row + 3][col] = '4';
		}
		else if(end == 1) {	//Decrease Row
			p2Board[row - 1][col] = '4';
			p2Board[row - 2][col] = '4';
			p2Board[row - 3][col] = '4';
		}
		else if(end == 2) {	//Increase Column
			p2Board[row][col + 1] = '4';
			p2Board[row][col + 2] = '4';
			p2Board[row][col + 3] = '4';
		}
		else if(end == 3) {	//Decrease Column
			p2Board[row][col - 1] = '4';
			p2Board[row][col - 2] = '4';
			p2Board[row][col - 3] = '4';
		}
		//End Four Ship Placement	------------------------------------------------
		
		row = rRow.nextInt(8) + 1;
		col = rCol.nextInt(8) + 1;
		
		//Five Spot Ship
		for(int j = 0; j < 20; j++){
			if(p2Board[row][col] != ' '){
				row = rRow.nextInt(8) + 1;
				col = rCol.nextInt(8) + 1;
			}
			else{
				break;
			}
		}
		
		p2Board[row][col] = '5';	//First Spot
		end = endSpot.nextInt(3);
		
		for(int i = 0; i < 20; i++) {		//Testing if first spot at beginning or end or if filled
			if(end == 0 && p2Board[row + 1][col] != ' ' && p2Board[row + 2][col] != ' ' && p2Board[row + 3][col] != ' '
					&& p2Board[row + 4][col] != ' ') {		//Changes end spot from end of row
				end = endSpot.nextInt(3);
			}
			else if(end == 1 && p2Board[row - 1][col] != ' '&& p2Board[row - 2][col] != ' ' && p2Board[row - 3][col] != ' '
					&& p2Board[row - 4][col] != ' ') {		//Changes end spot from front of row
				end = endSpot.nextInt(3);
			}
			else if(end == 2 && p2Board[row][col + 1] != ' ' && p2Board[row][col + 2] != ' ' && p2Board[row][col + 3] != ' '
						&& p2Board[row][col + 4] != ' ') {		//Changes end spot from end of row
				end = endSpot.nextInt(3);
			}
			else if(end == 3 && p2Board[row][col - 1] != ' ' && p2Board[row][col - 2] != ' ' && p2Board[row][col - 3] != ' '
					 && p2Board[row][col - 4] != ' '){		//Changes end spot from front of row
				end = endSpot.nextInt(3);
			}
			else {
				break;
			}
		}
		
		if(end == 0) {	//Increase Row
			p2Board[row + 1][col] = '5';
			p2Board[row + 2][col] = '5';
			p2Board[row + 3][col] = '5';
			p2Board[row + 4][col] = '5';
		}
		else if(end == 1) {	//Decrease Row
			p2Board[row - 1][col] = '5';
			p2Board[row - 2][col] = '5';
			p2Board[row - 3][col] = '5';
			p2Board[row - 4][col] = '5';
		}
		else if(end == 2) {	//Increase Column
			p2Board[row][col + 1] = '5';
			p2Board[row][col + 2] = '5';
			p2Board[row][col + 3] = '5';
			p2Board[row][col + 4] = '5';
		}
		else if(end == 3) {	//Decrease Column
			p2Board[row][col - 1] = '5';
			p2Board[row][col - 2] = '5';
			p2Board[row][col - 3] = '5';
			p2Board[row][col - 4] = '5';
		}
		//End Five Ship Placement	------------------------------------------------
	}
	
	public void playGame(){
		
	}
}
