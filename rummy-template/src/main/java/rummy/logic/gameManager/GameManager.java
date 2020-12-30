
package rummy.logic.gameManager;

import rummy.logic.domainmodel.Field;

public class GameManager {

	public static int playerAtTurn;
	
	private Field field;
	private int players;
	

	public GameManager() {
		field = new Field(players);
	}
	
	public Field getField() {
		return field;
	}
	
	public void nextPlayerAtTurn() {
		playerAtTurn++;
		playerAtTurn = playerAtTurn % players;
	}
}