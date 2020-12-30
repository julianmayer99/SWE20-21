
package rummy.logic.gameManager;

import rummy.logic.domainmodel.Field;

public class GameManager {

	public int playerAtTurn;
	
	private Field field;
	private int players;
	

	public GameManager(int playerAmount) {
		players = playerAmount;
		field = new Field(players);
		playerAtTurn = 0;
	}
	
	public Field getField() {
		return field;
	}
	
	public void nextPlayerAtTurn() {
		playerAtTurn++;
		playerAtTurn = playerAtTurn % players;
	}
}