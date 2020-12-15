package rummy.logic.state.port;

import rummy.logic.state.impl.StatemachineFactoryImpl;

public interface StatemachineFactory {
	StatemachineFactory FACTORY = new StatemachineFactoryImpl();
	
	SubjectPort subjectPort();
	StatemachinePort statemachinePort();
}
