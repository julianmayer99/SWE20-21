package rummy.logic.match;

import java.util.List;

import rummy.logic.match.impl.MatchImpl;
import rummy.logic.match.port.Match;
import rummy.logic.state.impl.StatemachineFactoryImpl;
import rummy.logic.state.port.Statemachine;
import rummy.logic.state.port.StatemachineFactory;
import rummy.logic.state.port.StatemachinePort;

public class Matchfactory {
	static int nextId = 1;
	static List<Match> matches;
	
	MatchImpl mkMatch() {
		//Statemachine
		StatemachineFactory statemachineFactory = StatemachineFactory.FACTORY;
		//StatemachinePort statemachinePort = statemachineFactory.statemachinePort();
		//Statemachine statemachine = statemachinePort.statemachine();
		
		MatchImpl m = new MatchImpl(Matchfactory.nextId, statemachineFactory);
		matches.add(m);
		Matchfactory.nextId ++;
		return m;
	}
}
