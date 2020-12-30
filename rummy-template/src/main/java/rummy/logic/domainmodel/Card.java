
package rummy.logic.domainmodel;

public class Card {
	public enum Value {
		JOKER, ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
	}

	public enum Colour {
		CLUB, //♣
		SPADE, //♠
		DIAMOND, //♦
		HEART //♥
	}

	private Value value;
	private Colour colour;

	public Card(Value val, Colour col) {
		this.value = val;
		this.colour = col;
	}
}
