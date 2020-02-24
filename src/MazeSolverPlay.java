import java.util.Scanner;
/**
 * Maze Game - lets user find the path interactively
 *
 * @author Travis Chamness
 * @version 6/17/2019
 */
public class MazeSolverPlay extends MazeSolver
{
    private int currentRow; // currentRow and currentCol are coordinates of the current position of the player
    private int currentCol;

    public MazeSolverPlay(int[][] maze)
    {
        super(maze);
    } // end constructor

    /**
     * Makes the user-specified move. The selected square must be within the maze and must not be a wall
     *
     * @param selection The move: u, d, l, or r.
     */
    public void makeMove(char selection)
    {
        // TODO Project #5A - makeMove - Does not handle leaving bounds, why?
        //    The requested square must be within the maze and must not be a wall for the move to take place
//        Scanner input = new Scanner(System.in);
//        selection = input.next().charAt(0);

        switch (selection) {
            case 'U':
                if ((this.currentRow - 1) >= 0 && squares[this.currentRow -1][this.currentCol] != WALL) {
                    squares[this.currentRow][this.currentCol] = VISITED;
                    this.currentRow = this.currentRow - 1;
                    squares[this.currentRow][this.currentCol] = PLAYER;

                }
                break;
            case 'L':
                System.out.println((this.currentCol - 1));
                if( (this.currentCol - 1) >= 0 && squares[this.currentRow][this.currentCol - 1] != WALL){
                    squares[this.currentRow][this.currentCol] = VISITED;
                    this.currentCol = this.currentCol -1;
                    squares[this.currentRow][this.currentCol] = PLAYER;

                }
                break;
            case 'D':
                if(squares[this.currentRow + 1][this.currentCol] != WALL && (this.currentRow + 1) <= 6){
                    squares[this.currentRow][this.currentCol] = VISITED;
                    this.currentRow = this.currentRow + 1;
                    squares[this.currentRow][this.currentCol] = PLAYER;

                }
                break;
            case 'R':
                if(squares[this.currentRow][this.currentCol+1] != WALL && (this.currentCol+1) <= 12) {
                    squares[this.currentRow][this.currentCol] = VISITED;
                    this.currentCol = this.currentCol + 1;
                    squares[this.currentRow][this.currentCol] = PLAYER;

                }
            default:
                break;
        }

        // utilize a switch
    } // end makeMove


    /**
     * Enables a user to solve this maze.
     */
    public boolean solveMaze(int r, int c)
    {
        this.currentRow = r;
        this.currentCol = c;
        char choice = ' ';

        while (choice != 'q' && !isGoal(this.currentRow, this.currentCol))
        {
            choice = menu();
            if (choice != 'q')
                makeMove(choice);

            display();
        } // end while

        return choice != 'q';
    } // end play

    /**
     * Displays a menu of movement choices to the user.
     * Gets the next move from the user ("u", "d", "l", "r", or "q").
     */
    public char menu()
    {
        System.out.println("U: up");
        System.out.println("D: down");
        System.out.println("L: left");
        System.out.println("R: right");
        System.out.println("Q: quit");
        Scanner keyboard = new Scanner(System.in);
        String selection;
        do
        {
            selection = keyboard.nextLine();
        } while (!selection.toLowerCase().matches("[udlrq]"));

        return selection.charAt(0);
    } // end menu
}// end MazeSolverPlay