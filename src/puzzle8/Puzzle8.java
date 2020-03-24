/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle8;
//package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


/**
 *
 * @author Sahra Flor
 */

public class Puzzle8 {
	int tiles[][];
	Puzzle8 parentBoard = null;

	ArrayList<Puzzle8> neighbours;

	// Construir uma placa a partir de uma matriz N-por-N de blocos	
	public Puzzle8(int[][] tiles)  {
		this.tiles = tiles;
	}

	//Retornar o número de blocos fora do lugar
	public int hamming()    {
		int hammingDistance = 0;
		int columnLength  = tiles[0].length;
		for(int i =0; i < tiles.length; i ++)
		{
			for(int j =0; j < tiles[i].length; j++) 
			{
				int expectedNumber = columnLength*i + 1;
				if((tiles[i][j] != expectedNumber) && (tiles[i][j] != 0) ) {
					hammingDistance += 1;
				}
			}
		}
		return hammingDistance;

	}
	//soma de retorno das distâncias de Manhattan entre os blocos e a meta
	public int manhattan() {
		int manhattanDistance =0;
		int columnLength  = tiles[0].length;
		for(int i =0; i < tiles.length; i ++)
		{
			for(int j =0; j < tiles[i].length; j++) {
				if(tiles[i][j] != 0) {
					int displacement =  columnLength*i  + j + 1 - tiles[i][j];
					int rowDistance = displacement/columnLength;
					int columnDistance = displacement%columnLength;
					manhattanDistance = rowDistance + columnDistance;  
				}
			}
		}
		return manhattanDistance;
	}

	//esta posição da placa é igual a y
	public boolean equals(Puzzle8 newPuzzle8) 
	{
		int[][] tilesToBeCompared = newPuzzle8.getTiles();
		for(int i =0; i < tiles.length; i ++)
		{
			for(int j =0; j < tiles[i].length; j++) {
				if (tiles[i][j] != tilesToBeCompared[i][j] ) {
					return false;
				}
			}
		}

		return true;
	}

	//retornar um iterador de todas as posições vizinhas da placa	   
	public Iterator<Puzzle8> neighbors() {
		neighbours = new ArrayList<Puzzle8>();
		Posicao blankPosition = getBlankPosition();
		int rowLength = tiles.length;
		int columnsLength = tiles[0].length;
		if(blankPosition.getColumn() < columnsLength - 1) {
			int[][] newTiles = copy();
			newTiles[blankPosition.getRow()][blankPosition.getColumn()]=  tiles[blankPosition.getRow()][blankPosition.getColumn() + 1];
			newTiles[blankPosition.getRow()][blankPosition.getColumn() + 1] = 0;
			Puzzle8 newBoard = new Puzzle8(newTiles);
			newBoard.setParentBoard(this);
			neighbours.add(newBoard);
		}

		if(blankPosition.getColumn() > 0) {
			int[][] newTiles = copy();
			newTiles[blankPosition.getRow()][blankPosition.getColumn()]=  tiles[blankPosition.getRow()][blankPosition.getColumn() - 1];
			newTiles[blankPosition.getRow()][blankPosition.getColumn() - 1] = 0;

			Puzzle8 newBoard = new Puzzle8(newTiles);
			newBoard.setParentBoard(this);
			neighbours.add(newBoard);
		}

		if(blankPosition.getRow() > 0) {
			int[][] newTiles = copy();
			newTiles[blankPosition.getRow()][blankPosition.getColumn()]=  tiles[blankPosition.getRow() -1][blankPosition.getColumn()];
			newTiles[blankPosition.getRow() -1][blankPosition.getColumn()] = 0;
			Puzzle8 newBoard = new Puzzle8(newTiles);
			newBoard.setParentBoard(this);
			neighbours.add(newBoard);
		}


		if(blankPosition.getRow() < rowLength - 1) {
			int[][] newTiles = copy();
			newTiles[blankPosition.getRow()][blankPosition.getColumn()]=  tiles[blankPosition.getRow() + 1][blankPosition.getColumn()];
			newTiles[blankPosition.getRow() + 1][blankPosition.getColumn()] = 0;
			Puzzle8 newBoard = new Puzzle8(newTiles);
			newBoard.setParentBoard(this);
			neighbours.add(newBoard);
		}
		return neighbours.iterator();
	}


	// retornar uma representação de string do quadro
	public String toString() {
		String stringRepresentation  = "\n";
		for(int i =0; i < tiles.length; i ++)
		{
			for(int j =0; j < tiles[i].length; j++) {
				if(tiles[i][j] != 0) {
					stringRepresentation  += tiles[i][j] + "\t";
				}
				else
					stringRepresentation  +=  "\t";
			}
			stringRepresentation   += "\n";
		}
		return stringRepresentation  ;
	}



	public int[][] getTiles() {
		return tiles;
	}

	public void setTiles(int[][] tiles) {
		this.tiles = tiles;
	}

	private Posicao getBlankPosition () {
		for(int i =0; i < tiles.length; i ++)
		{
			for(int j =0; j < tiles[i].length; j++) {

				if( tiles[i][j]== 0) {
					Posicao posicao = new Posicao(i,j);
					return posicao;
				}
			}

		}
		return null;
	}


	int[][] copy() {
		int newTiles[][] = new int[tiles.length][tiles[0].length]; 
		for (int i = 0; i< tiles.length; i ++) {
			newTiles[i]= Arrays.copyOf(tiles[i], tiles[i].length);
		}
		return newTiles;
	}

	public Puzzle8 getParentBoard() {
		return parentBoard;
	}

	public void setParentBoard(Puzzle8 parentBoard) {
		this.parentBoard = parentBoard;
	}

}