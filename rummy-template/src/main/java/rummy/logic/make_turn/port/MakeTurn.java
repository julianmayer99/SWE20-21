package rummy.logic.make_turn.port;
public interface MakeTurn {


	void drawFromPile(boolean isOpen);
	
	void endTurn(int discardIndex);
	
}
