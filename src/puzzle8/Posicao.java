/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle8;

/**
 *
 * @author Sahra Flor
 */
public class Posicao {
    
	public Posicao(int row, int column) {
		this.row = row;
		this.column = column;
	}
	int row;
	int column;
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	
}