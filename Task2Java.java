import java.util.*;

class GuessGame{
	int systemInput;
	int userInput;
	int numGuesses = 0;
	
	GuessGame(){
		Random random = new Random();
		this.systemInput = random.nextInt(100)+1;
	}
	
	public boolean UserInput() {
		if(numGuesses < 10) {
			System.out.println("Guess the number: ");
			this.userInput = Task2Java.takeIntegerInput(100);
			numGuesses++;
			return false;
		}
		else {
			System.out.println("Game Over!! Better Luck next time!!");
			return true;
		}
	}
	
	public boolean isCorrectGuess() {
		if(systemInput == userInput) {
			System.out.println("Congratulations!! You Have Guessed the number "
		+ systemInput +" in "+ numGuesses +" guesses");
			switch(numGuesses) {
				case 1:
					System.out.println("Your Score is 100");
					break;
				case 2:
					System.out.println("Your Score is 90");
					break;
				case 3:
					System.out.println("Your Score is 80");
					break;
				case 4:
					System.out.println("Your Score is 70");
					break;
				case 5:
					System.out.println("Your Score is 60");
					break;
				case 6:
					System.out.println("Your Score is 50");
					break;
				case 7:
					System.out.println("Your Score is 40");
					break;
				case 8:
					System.out.println("Your Score is 30");
					break;
				case 9:
					System.out.println("Your Score is 20");
					break;
				case 10:
					System.out.println("Your Score is 10");
					break;
			}
			System.out.println();
			return true;
		}
		else if(numGuesses <10 && userInput>systemInput) {
			if(userInput-systemInput > 10)
				System.out.println("Too High");
			else
				System.out.println("High");
		}
		else if(numGuesses<10 && userInput<systemInput) {
			if(systemInput-userInput >10)
				System.out.println("Too Low");
			else
				System.out.println("Low");
		}
		return false;
	}
}

public class Task2Java {
	
	public static int takeIntegerInput(int limit) {
		int input=0;
		boolean flag=false;
		while(!flag) {
			try {
				Scanner sc = new Scanner(System.in);
				input = sc.nextInt();
				flag = true;
				
				if(flag && (input>limit || input<1)) {
					System.out.println("choose number between 1 to "+limit);
					flag = false;
				}
			}
			catch(Exception e) {
				System.out.println("Enter the correct value");
				flag = false;
			}
		};
		return input;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to \"Guess the Numbers\" Game");
		System.out.println("Choose an Option:");
		System.out.println("1. Start the Game \n2. Exit");
		int choice = takeIntegerInput(2);
		int nextRound = 1;
		int noOfRound = 0;
		
		if(choice == 1) {
			// check whether there is next round or not
			while(nextRound == 1) {
				// create a Game object
				GuessGame game = new GuessGame();
				boolean isMatched = false;
				boolean isLimitCross = false;
				System.out.println("\nRound "+ ++noOfRound + " starts...");
				
				// to check correct guess and limit cross
				while(!isMatched &&  !isLimitCross) {
					isLimitCross = game.UserInput();
					isMatched = game.isCorrectGuess();
				}
				// input for next round
				System.out.println("1. Next Round \n2. Exit");
				System.out.println("Enter your choice: ");
				nextRound = takeIntegerInput(2);
				if(nextRound != 1) {
					System.out.println("See You Again!  Bye Bye");
					System.exit(0);
				}
			}
		}
		else {
			System.exit(0);
		}	
	}
}
