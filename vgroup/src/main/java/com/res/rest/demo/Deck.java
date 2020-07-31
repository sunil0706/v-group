package com.res.rest.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	List<Card> deckList = new ArrayList<Card>();
	Deck(){
		for(int i = 0; i < 4;i++) {
			for(int j = 1; j < 14; j++) {
				Card card = new Card(j, Suit.values()[i]);
				deckList.add(card);
			}
		}
	}
	
	public List<Card> getDeck(){
		return this.deckList;
	}
	
	public void shuffleDeck() {
		System.out.println(deckList);
		Collections.shuffle(deckList);
		System.out.println(deckList);
	}

	public List<Hand> distributeCard(int numOfPlayers) {
		int cardsInEachHand = 1;
		List<Hand> handList = new ArrayList<>();
		for(int j = 0; j < numOfPlayers; j++) {
			Hand hand = new Hand(cardsInEachHand);
			for(int i=0; i< cardsInEachHand; i++) {
				Card c = deckList.remove(0);
				hand.handList.add(c);
			}
			handList.add(hand);
		}
		
		return handList;
	}
	
	public Card getCardFromDeck() {
		if(deckList.size() > 0) {
			Card c = deckList.remove(0);
			return c;
		}else {
			System.out.println("No Card left in Deck");
			return null;
		}
		
	}
	
	public void printDeck() {
		System.out.println(deckList);
	}
	
	public void returnCardToDeck(Card c) {
		deckList.add(c);
	}

	@Override
	public String toString() {
		return "Deck [deckList=" + deckList + "]";
	}
	
	
	
}
