package rummy.logic.match.impl;

import rummy.logic.match.port.Match;
import rummy.logic.state.impl.StatemachineImpl;
import rummy.logic.state.port.Statemachine;
import rummy.logic.state.port.StatemachineFactory;

public class MatchImpl implements Match {
	
	private int id;
	private StatemachineFactory statemachineFactory;
	
	public MatchImpl(int setId, StatemachineFactory setStatemachineFac) {
		id = setId;
		statemachineFactory = setStatemachineFac;
	}


	@Override
	public int GetId() {
		return id;
	}
}
