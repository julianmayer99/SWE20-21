package rummy.logic.meldingCards;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rummy.logic.domainmodel.Card;
import rummy.logic.meldingCards.impl.MeldingCardsImpl;
import rummy.logic.state.impl.StatemachineImpl;
import rummy.logic.state.port.State;

@Component
public class MeldingCardsFactory {

	@Autowired
	private StatemachineImpl stateMachine; 
	private MeldingCardsImpl meldingCardsImpl;
	
	public void testForStructureConditions(Card[] cards) {
		if(!stateMachine.getState().isSubStateOf(State.S.CardSelect))
			return;
		
		meldingCardsImpl.testForStructureConditions(cards);
		}
}
