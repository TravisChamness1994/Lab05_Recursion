/**
 * Maze Game - finds the path using recursive implementation
 *
 * @author Travis Chamness
 * @version 6/17/2019
 */
public class MazeSolverSolveWithRecursion extends MazeSolver
{
    public MazeSolverSolveWithRecursion(int[][] maze)
    {
        super(maze);
    } // end constructor


    public boolean solveMaze(int r, int c)
    {
        // TODO Project #5B - Solver with Recursion -Done, perform further testing to ensure
        if(!isLegal(r,c)) return false;
        else if(isGoal(r,c)) return true;
        else if(!isOpen(r,c)) return false;
        //at point of processing
        squares[r][c] = VISITED; //mark
        if(solveMaze(r-1,c)) return true; //north recursive call
        if(solveMaze(r,c+1)) return true; //east recursive call
        if(solveMaze(r+1,c)) return true; //south recursive call
        if(solveMaze(r,c-1)) return true; //west recursive call

        return false;
    }
} // end MazeSolverSolveWithRecursion