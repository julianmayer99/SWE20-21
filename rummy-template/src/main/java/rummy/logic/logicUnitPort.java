package rummy.logic;

import rummy.logic.make_turn.port.MakeTurn;
import rummy.logic.meldingCards.port.MeldingCards;

public interface logicUnitPort {
	
	MakeTurn makeTurn();
	
	MeldingCards meldingCards();
}
