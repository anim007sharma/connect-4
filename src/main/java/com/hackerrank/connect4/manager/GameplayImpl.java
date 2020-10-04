package com.hackerrank.connect4.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hackerrank.connect4.domain.Game;

@Component
public class GameplayImpl implements Gameplay {
	
	@Autowired
	Game game;
	
	@Override
	public void createNewBoard() {
		game = new Game();
	}

	@Override
	public boolean play(int col) {
		if(game.getRedChance()==1) {
			game.setRedChance(-1);
			game.setYellowChance(1);
		}
		if(game.getYellowChance()==1) {
			game.setRedChance(1);
			game.setYellowChance(-1);
		}
		game.saveBoard(col);
		return game.isValid(col);
	}
	
	public void printBoard() {
		char temp[][] = game.getBoard();
		for(int i=0; i<6; i++) {
			for(int j=0; j<7; j++) {
				System.out.print(temp[i][j]);
			}
			System.out.println();
		}
	}

}
