package rummy.logic.state.port;

public interface Statemachine {
	
	State getState();
	void setState(State newState);
	
}
