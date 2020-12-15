package rummy.logic.state.port;
public interface Subject {

	public void attach(Observer obs);
	public void detach(Observer obs);
}
