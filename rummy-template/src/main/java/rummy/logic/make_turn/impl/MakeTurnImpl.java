package rummy.logic.make_turn.impl;

import rummy.logic.make_turn.port.MakeTurn;
import rummy.logic.domainmodel.Field;
import rummy.logic.gameManager.GameManager;

public class MakeTurnImpl implements MakeTurn {


	private GameManager lnkGameManager;

	@Override
	public void drawFromPile(boolean isOpen) {
		int playerAtTurn = GameManager.playerAtTurn;
		lnkGameManager.getField().drawFromPile(playerAtTurn, isOpen);
	}

	@Override
	public void endTurn(int discardIndex) {
		int playerAtTurn = GameManager.playerAtTurn;
		lnkGameManager.getField().endTurn(playerAtTurn, discardIndex);
		lnkGameManager.nextPlayerAtTurn();
	}
	
	
}
