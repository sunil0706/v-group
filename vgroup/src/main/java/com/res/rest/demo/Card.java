package com.res.rest.demo;

public class Card {
	private int value;
	private Suit suit;
	
	public Card(int _value, Suit _suit) {
		value = _value;
		suit = _suit;
	}

	public int getValue() {
		return value;
	}

	public Suit getSuit() {
		return suit;
	}

	@Override
	public String toString() {
		return "Card [value=" + value + ", suit=" + suit + "]";
	}
	
	
	
	
}
