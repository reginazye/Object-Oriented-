import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Tetris Controller
 * 
 * @author ReginaYe
 *
 */
public class TetrisGameTextController {
	// create an instance of tetris view
	private TetrisView view;
	// create an instane of tetris game
	private TetrisGame game;

	/**
	 * controller class constructor
	 * create new game, new view, 
	 * include the methods to get input, 
	 * refresh the display after getting input
	 */
	public TetrisGameTextController() {
		game = new TetrisGame();
		view = new TetrisView(game.getTetrisBoard());
		readInput();
		refreshDisplay();
	}

	/**
	 * to get the input to make the game
	 * 
	 */
	public void readInput(){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		try{
			refreshDisplay();
			line = reader.readLine();
			while(!line.toLowerCase().equals("quit")){
				if(line.toLowerCase().equals("r")){
					game.attemptMove(0);
				}
				else if (line.toLowerCase().equals("l")){
					game.attemptMove(1);
				}
				else if (line.toLowerCase().equals("d"))
				{	
					game.attemptMove(2);
				}
				else if (line.toLowerCase().equals("z")){
					game.attemptMove(3);
				}
				else if (line.toLowerCase().equals("x")){
					game.attemptMove(4);
				}
				else System.out.println("Invalid move");
				
				refreshDisplay();
				line = reader.readLine();
			}
		}
		catch (IOException iox){
			System.out.println("Error: IOException");
				
		}
	}

	/**
	 * refresh the display method
	 */
	public void refreshDisplay() {
		System.out.println("Please enter a move(l,r,d,z,x) or type Quit to end.");
		System.out.println("Number of lines cleared: " + game.getNumLines());
		System.out.println("Number of Tetrises cleared: " + game.getNumTetrises());
		System.out.println("---------------------");
		System.out.print(view.getBoardString());
		System.out.println("---------------------");

	}
}

