package rummy.logic.state.impl;

import rummy.logic.state.port.State;
import rummy.logic.state.port.Statemachine;
import org.springframework.stereotype.Component;

@Component
public class StatemachineImpl implements Statemachine, Subject{

	private State currentState = State.S.PileSelect;
	
	@Override
	public State getState() {
		return currentState;
	}

	@Override
	public void setState(State newState) {
		currentState = newState;		
	}
	
}
