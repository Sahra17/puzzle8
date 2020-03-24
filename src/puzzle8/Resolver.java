/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/**
 *
 * @author Sahra Flor
 */
public class Resolver {
    
	ArrayList<Puzzle8> boardsVisited = new ArrayList<Puzzle8>();
	ArrayList<Puzzle8> goalBoard;
	Puzzle8 finalBoard;
	BoardProirityQueue boardProirityQueue;
	ArrayList<Puzzle8> solutionPath;
	public Resolver(Puzzle8 initial) {

		boardProirityQueue = new BoardProirityQueue();
		boardProirityQueue.add(initial);
		populateGoalBoard();
		solve();

	}
	private void solve () {
		Iterator<Puzzle8> boardIterator = boardProirityQueue.getIterator();
		while(boardIterator.hasNext()) {
			Puzzle8 currentBoard = boardIterator.next();
			boardIterator.remove();
			if(isFinalBoard(currentBoard))
			{
				finalBoard= currentBoard;
				populateFinalSolution();
				return;
			}
			if(isAlreadyVisited(currentBoard)) {
				continue;
			}
			Iterator<Puzzle8> neighbors =currentBoard.neighbors();  
			while(neighbors.hasNext())
			{
				boardProirityQueue.add(neighbors.next());
			}
			addToAlreadyVisitedNodes(currentBoard);
			boardIterator = boardProirityQueue.getIterator();
		}
	}
	// retornar número mínimo de movimentos para resolver o quadro inicial; -1 se não houver solução
	public int moves()   {
		return solutionPath.size() -1;
	}
	// devolver um Iterável de posições no conselho
	public Iterator<Puzzle8> solution() {
		return solutionPath.iterator();
	}

	private boolean isAlreadyVisited (Puzzle8 currentBoard) {
		for (Puzzle8 board : boardsVisited) {
			if(board.equals(currentBoard)) {
				return true;
			}
		}
		return false;
	}

	private void addToAlreadyVisitedNodes(Puzzle8 currentBoard) {
		boardsVisited.add(currentBoard);
	}

	// o quadro inicial é solucionável?
	public boolean isSolvable()   {
		return true;
	}

	private void populateGoalBoard () 
	{
		int[][]finalBoard1Tiles = {{1,2,3} ,{4,5,6}, {7,8,0}};
		goalBoard = new ArrayList<Puzzle8>();
		goalBoard.add(new Puzzle8(finalBoard1Tiles));

	}

	private void populateFinalSolution() {
		Stack<Puzzle8> finalSolutionStack = new Stack<Puzzle8>();
		solutionPath = new ArrayList<Puzzle8>();
		Puzzle8 finalBoardPath = finalBoard;
		while(finalBoardPath != null) {
			finalSolutionStack.push(finalBoardPath);
			finalBoardPath = finalBoardPath.getParentBoard();
		}
		while(!finalSolutionStack.isEmpty()) {
			solutionPath.add(finalSolutionStack.pop());
		}
	}


	public boolean isFinalBoard(Puzzle8 b) {
		for(Puzzle8 solBoard : goalBoard) {
			if (solBoard.equals(b)) {
				return true;
			}
		}
		return false;
	}
}