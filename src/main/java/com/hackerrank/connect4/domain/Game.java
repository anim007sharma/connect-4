package com.hackerrank.connect4.domain;

import org.springframework.stereotype.Component;

@Component
public class Game {
	private char[][] board = new char[6][7];
	private int redChance = -1;
	private int yellowChance = -1;
	
	public Game() {
		for(int i=0; i<6; i++) 
			for(int j=0; j<7; j++) 
				board[i][j]='0';
		yellowChance = 1;
	}
	public char[][] getBoard() {
		return board;
	}
	public void setBoard(char[][] board) {
		this.board = board;
	}
	public int getRedChance() {
		return redChance;
	}
	public void setRedChance(int redChance) {
		this.redChance = redChance;
	}
	public int getYellowChance() {
		return yellowChance;
	}
	public void setYellowChance(int yellowChance) {
		this.yellowChance = yellowChance;
	}
	public boolean isValid(int col) {
		if(col<=0 && col>=6)
			return false;
		if(board[0][col]=='r' || board[0][col]=='r')
			return false;
		return true; 
	}
	public void saveBoard(int col) {
		for(int i=5; i>=0; i--) {
			if(board[i][col]=='r' || board[i][col]=='y')
				continue;	
			if(getRedChance()==1)
				board[i][col]='r';
			else
				board[i][col]='y';
		}
	}
}
