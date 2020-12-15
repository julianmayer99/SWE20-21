package rummy.logic.state.impl;

import rummy.logic.state.port.State;
import rummy.logic.state.port.Statemachine;
import rummy.logic.state.port.Subject;
import rummy.logic.state.port.Observer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class StatemachineImpl implements Statemachine, Subject{

	private List<Observer> observers = new ArrayList<>( );
	private State currentState;

	public StatemachineImpl(){this.currentState = State.S.PileSelect;}
	
	@Override
	public State getState() {
		return currentState;
	}

	@Override
	public void setState(State newState) {
		currentState = newState;
		observers.forEach(obs -> obs.update(newState, this));
	}
	
	@Override
	public void attach(Observer obs) {
		this.observers.add(obs); 
		obs.update(currentState, this);
	}
	
	public void detach(Observer obs) {
		this.observers.remove(obs);
	}
}
