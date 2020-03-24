/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle8;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 *
 * @author Sahra Flor
 */
public class BoardProirityQueue {

	Queue<Puzzle8> boardPriorityQueue ;
	//Implementação de classe anônima do comparador
	public static Comparator<Puzzle8> boardComparator = new Comparator<Puzzle8>(){

		@Override
		public int compare(Puzzle8 b1, Puzzle8 b2) {
			return (int) (b1.hamming() - b2.hamming());
		}
	};

	BoardProirityQueue() {
		boardPriorityQueue = new PriorityBlockingQueue<Puzzle8>(100, boardComparator);
	}
	void add(Puzzle8 board) {
		boardPriorityQueue.add(board);
	}
	Puzzle8 getNextPriorityBoard() 
	{
		return boardPriorityQueue.poll();
	}
	Iterator<Puzzle8> getIterator() 
	{
		return boardPriorityQueue.iterator();
	}

}