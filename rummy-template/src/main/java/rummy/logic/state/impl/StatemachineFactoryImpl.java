package rummy.logic.state.impl;

import rummy.logic.state.port.Observer;
import rummy.logic.state.port.State;
import rummy.logic.state.port.Statemachine;
import rummy.logic.state.port.StatemachineFactory;
import rummy.logic.state.port.StatemachinePort;
import rummy.logic.state.port.Subject;
import rummy.logic.state.port.SubjectPort;

public class StatemachineFactoryImpl implements StatemachineFactory,SubjectPort,StatemachinePort,Statemachine,Subject{
	private StatemachineImpl statemachine;
	
	private void mkStateMachine(){ 
		if (statemachine == null) statemachine = new StatemachineImpl(); //TODO MatchID 
		}

	@Override
	public SubjectPort subjectPort(){ 
		return this;
		}
	
	@Override
	public StatemachinePort statemachinePort(){ 
		return this;
		}
	
	@Override
	public synchronized Statemachine statemachine() {
		this.mkStateMachine(); return this;
		}
	public synchronized Subject subject() {
		this.mkStateMachine(); return this;
		}

	@Override
	public synchronized void attach(Observer obs) {
		this.statemachine.attach(obs);
		}

	@Override
	public synchronized void detach(Observer obs) {
		this.statemachine.detach(obs);
		}

	@Override
	public synchronized State getState() {
		return this.statemachine.getState();
		}

	@Override
	public synchronized void setState(State state) {
		this.statemachine.setState(state);
		}

}
