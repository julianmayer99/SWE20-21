
package rummy.logic.domainmodel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import rummy.logic.domainmodel.Card.Value;
import rummy.logic.domainmodel.Card.Colour;

public class Field {

	private rummy.logic.domainmodel.Card lnkCard;
	private Stack<Card> openPile;
	private Stack<Card> closedPile;
	
	private List<List<Card>> structures; //subject to change...

	private List<Card>[] hands;

	public Field(int players) {
		List<Card> allCards = new ArrayList<Card>(); //110 = 2 Sets (52 Blatt + 3 Joker)
		//Add Cards
		//Sets
		for (int set = 0; set <= 1; set++) {
			//Values
			for (int val = 1; val <= 13; val++) {
				//Colors
				for (int col = 0; col < 4; col++) {
					Card card = new Card(Value.values()[val], Colour.values()[col]);
	            	allCards.add(card);
				}
			}
			//Jokers
			for (int jok = 0; jok < 3; jok++) {
				Card joker = new Card(Value.values()[0], Colour.values()[0]);
            	allCards.add(joker);
			}
		}
		//Array with all Cards created
		
		//Create Hands
		hands = new ArrayList[players];
		//Deal Cards
		for (int player = 0; player < players; player++) {
			//Initialize List
			hands[player] = new ArrayList<Card>();
			//Fill List
			for(int card = 0; card < 13; card++) {								//Each player gets 13 cards...
				int index = (int) Math.round(Math.random() * allCards.size());	//Choose random index (from all cards)
				Card addCard = allCards.remove(index);							//Remove card at this index
				hands[player].add(addCard);										//Add this Card to the players Hand
			}
		}
		
		//Initialize Piles
		closedPile = new Stack<Card>();
		openPile   = new Stack<Card>();
		
		//Fill Piles
		//1 to openPile
		int i = (int) Math.round(Math.random() * allCards.size());			//Choose random index (from all cards)
		Card addCard = allCards.remove(i);									//Remove card at this index
		openPile.add(addCard);												//Lay this card on the open pile
		
		//The Rest to the closed Pile
		while (allCards.size() > 0) {
			int index = (int) Math.round(Math.random() * allCards.size());	//Choose random index (from all cards)
			Card xXxaddCardxXx = allCards.remove(index);					//Remove card at this index
			closedPile.add(xXxaddCardxXx);									//Lay this card on the closed pile
		}
	}
	
	public void drawFromPile(int player, boolean isOpen) {
		Card cardTransfer;
		if (isOpen) {
			cardTransfer = openPile.pop();		//take upper Card from pile
		}
		else {
			cardTransfer = closedPile.pop();	//take upper Card from pile
		}
		
		hands[player].add(cardTransfer);		//Add this Card to the players Hand
	}

	public void endTurn(int player, int discardIndex) {
		//Remove Card from Hand
		Card cardTransfer = hands[player].remove(discardIndex);
		//Add Card on Top of open Pile
		openPile.push(cardTransfer);
	}

	//Getters
	public Stack<Card> getOpenPile(){
		return openPile;
	}
	public Stack<Card> getClosedPile(){
		return closedPile;
	}
	public List<Card> getHand(int player){
		return hands[player];
	}
}
