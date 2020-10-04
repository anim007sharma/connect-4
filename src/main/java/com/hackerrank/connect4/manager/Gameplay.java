package com.hackerrank.connect4.manager;



public interface Gameplay {
	
	public void createNewBoard();
	public boolean play(int col);
	public void printBoard();
}
