package rummy.logic.make_turn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rummy.logic.make_turn.impl.MakeTurnImpl;
import rummy.logic.state.impl.StatemachineImpl;
import rummy.logic.state.port.State;
import rummy.logic.state.port.Statemachine;

@Component
public class MakeTurnFactory{
	
	@Autowired
	private StatemachineImpl stateMachine; 
	private MakeTurnImpl makeTurnImpl;
	
	public void drawFromPile(boolean isOpen) 
		{
			if(!stateMachine.getState().isSubStateOf(State.S.PileSelect))
				return;
			
			this.makeTurnImpl.drawFromPile(isOpen);
		}
	
	public void endTurn(int discardIndex) 
		{
			if(!stateMachine.getState().isSubStateOf(State.S.TurnActions)) 
				return;
			
			this.makeTurnImpl.endTurn(discardIndex);
		}
}
