import java.util.*;
class tiktak{
	static char board[][] = new char[3][3];
	static char winnerPlayer = 'k';
	static Scanner input = new Scanner(System.in);
	static int count= 0;
	static ArrayList<Integer>  list = new ArrayList<Integer>(); 
	public static void arrayListInitial(){
		for(int i=1;i<=9;i++){
			list.add(i);
		}
	}

	static void moveOfComputer(char n){
		Random r = new Random();
		int temp = list.get(r.nextInt(list.size()));
		list.remove(new Integer(temp));
		int row=0, column=0;
			if(temp%3 !=0){
				row = (temp-1)/3;
				column = temp%3 -1;
			}else{
				switch(temp){
					case 3: row = 0;
							column = 2;
							break;
					case 6: row = 1;
							column = 2;
							break;	
					case 9: row = 2;
							column =2;
							break;
				}
			}
			board[row][column] = n;
				count++;
			System.out.println("Computer moved at position "+temp);
	}

	//display the current status of game
	static void statusOfGame(){
		int i,j;
		System.out.println();
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				if(board[i][j] == 'n')
						System.out.print(" "+".");
				else{
					System.out.print(" "+board[i][j]);
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	//move of player
	static void moveOfPlayer(char n){
		int move=0;
		do{
		System.out.print("which position? =");
		int position = input.nextInt();
		int row=0, column=0;
			if(position%3 !=0){
				row = (position-1)/3;
				column = position%3 -1;
			}else{
				switch(position){
					case 3: row = 0;
							column = 2;
							break;
					case 6: row = 1;
							column = 2;
							break;	
					case 9: row = 2;
							column =2;
							break;
				}
			}
			if(position>=1&&position<=9&&board[row][column]=='n'){
				board[row][column] = n;
				list.remove(new Integer(position));
				count++;
				move =1;
			}else{
				System.out.print("....You cannot move on this place....");
			}
		}while(move==0);
	}

	static int gameover(){
		if(count<9&&winner()==1){
			return 1;
		}else if(count==9&&winner()==1){
			return 1;
		}else if(count==9&&winner() == 0){
			return 1;
		}else
			return 0;

	}

	//checks winner
	static int winner(){

			if(board[1][0]!='n' && board[1][0] == board[1][1] && board[1][1] == board[1][2]){
				winnerPlayer =  board[1][0];
				return 1;
			}else if(board[0][0]!='n' && board[0][0] == board[0][1] && board[0][1] == board[0][2]){
				winnerPlayer = board[0][0];
				return 1;
			}else if(board[2][0]!='n' && board[2][0] == board[2][1] && board[2][1] == board[2][2]){
				winnerPlayer = board[2][0];
				return 1;
			}else if(board[0][0]!='n' && board[0][0] == board[1][0] && board[1][0] == board[2][0]){
				winnerPlayer = board[0][0];
				return 1;
			}else if(board[0][1]!='n' && board[0][1] == board[1][1] && board[1][1] == board[2][1]){
				winnerPlayer = board[0][1];
				return 1;
			}else if(board[0][2]!='n' && board[0][2] == board[1][2] && board[1][2] == board[2][2]){
				winnerPlayer = board[0][2];
				return 1;
			}else if(board[0][0]!='n' && board[0][0] == board[1][1] && board[1][1] == board[2][2]){
				winnerPlayer = board[0][0];
				return 1;
			}else if(board[0][2] !='n' &&board[0][2] == board[1][1] && board[1][1] == board[2][0]){
				winnerPlayer = board[0][2];
				return 1;
			}
			return 0;
	}

	public static void main(String args[]){
		int i,j;
		int chance = 0;
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				board[i][j] = 'n';
			}
		}
		arrayListInitial();
		while(gameover()==0){
			if(chance==0){
				System.out.println("Player 1st chance");
				System.out.println(".....Your move..... ");
				moveOfPlayer('x');
				chance = 1;
				
			}else{
				
				moveOfComputer('o');
				chance = 0;
				
			}
			statusOfGame();	
		}
		if(winnerPlayer!='k'){
			if(winnerPlayer=='x')
				System.out.print("winner is Player1 ....congratulations");
			if(winnerPlayer=='o')
				System.out.print("winner is Computer ....congratulations");
		}else{
			System.out.print("Match Drawn");
		}
	}
}