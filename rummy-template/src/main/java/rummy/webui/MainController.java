package rummy.webui;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.annotation.SessionScope;

import rummy.logic.LogicFactory;
import rummy.logic.DummyObserver;
import rummy.socketmanagement.RummySocketController;
import rummy.webui.views.View;
import rummy.logic.domainmodel.*;
import rummy.logic.state.impl.StatemachineImpl;
import rummy.logic.state.port.Observer;
import rummy.logic.state.port.State;

@SessionScope
@Controller
@RequestMapping("/rummy")
public class MainController implements Observer {

	@Autowired
	private rummy.logic.Dummy dummy;

	@Autowired
	private RummySocketController socket;

	//private int val;
	//private State state;
	private StatemachineImpl statemachine;




	public void endTurn(int discardIndex) {
		return;
	}

	public void updateField(Field updatedField) {
		return;
	}

	public void drawFromPile(boolean openPile) {
		return;
	}

	public void createStructure(Card[] cards) {
		return;
	}

	@PostConstruct
	private void attach() {
		this.dummy.attach(this);
	}

	@PreDestroy
	private void detach() {
		this.dummy.detach(this);
	}

	//@Override
	//public synchronized void update(int val) {
	//	this.value = val;
	//	this.socket.update("");
	//}

	@RequestMapping(value = "/doIt", method = { RequestMethod.POST, RequestMethod.GET })
	public synchronized String doIt(//
			String matchId, HttpServletRequest request, Model model) {

		if (request.getMethod().equals("POST"))  // Unterscheidung zwischen aktivem VerÃƒÂ¤ndern (POST)
			this.dummy.incValue();               // und dem durch die VerÃƒÂ¤nderung angestoÃƒÅ¸enen GET
		return new View(this.value).update(model);
	}

	@Override
	public void update(State s, StatemachineImpl statemachine) {
		statemachine.setState(s);
		this.socket.update("");
	}

}
