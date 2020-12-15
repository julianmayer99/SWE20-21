package rummy.logic.state.port;

import rummy.logic.state.impl.StatemachineImpl;

public interface Observer {
	
	void update(State s, StatemachineImpl statemachine);
	
}
