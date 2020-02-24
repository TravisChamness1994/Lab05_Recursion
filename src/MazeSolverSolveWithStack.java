import java.util.Stack;
/**
 * Maze Game - finds the path using stack
 *
 * @author Travis Chamness
 * @version 6/17/2019
 */
public class MazeSolverSolveWithStack extends MazeSolver
{
    public MazeSolverSolveWithStack(int[][] maze)
    {
        super(maze);
    } // end constructor


    public boolean solveMaze(int r, int c)
    {
        // TODO Project #5C - Solver with Stack - Done

        boolean result = false;
        Stack<MazeCoordinates> stack = new Stack<>();
        stack.push(new MazeCoordinates(startRow, startCol));

        MazeCoordinates current = null;
        while(!stack.isEmpty() && !result) {

            current = stack.pop();
            if (isGoal(current.row, current.col)) {
                result = true;
            } else {
                //north
                if (isLegal(current.row - 1,current.col) && isOpen(current.row - 1,current.col)){
                    stack.push(new MazeCoordinates(current.row - 1, current.col));
                }
                //east
                if (isLegal(current.row ,current.col +1) && isOpen(current.row,current.col+1)){
                    stack.push(new MazeCoordinates(current.row, current.col+1));
                }
                //south
                if (isLegal(current.row + 1,current.col) && isOpen(current.row+1,current.col)){
                    stack.push(new MazeCoordinates(current.row + 1, current.col));
                }
                //west
                if (isLegal(current.row ,current.col -1) && isOpen(current.row,current.col-1)){
                    stack.push(new MazeCoordinates(current.row, current.col-1));
                }
                squares[current.row][current.col] = VISITED;
            }
        }


        // when you pop from the stack check for the goal first

        // if not the goal:
        //   try moving up (NORTH), next try moving right (EAST),
        //   next try moving down (SOUTH), and finally try moving left (WEST)
        //   !! push only valid moves on the stack !!


        return result;
    }
    private class MazeCoordinates
    {
        private int row;
        private int col;

        public MazeCoordinates(int r, int c)
        {
            this.row = r;
            this.col = c;
        }

        public String toString()
        {
            return "[" + row + "," + col + "]";
        }
    }
} // end MazeSolverSolveWithStack
