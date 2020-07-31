package com.res.rest.demo;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	List<Card> handList;

	Hand(int numOfCard) {
		handList = new ArrayList<>(numOfCard);
	}

	public Card getCard() {
		Card card = handList.get(0);
		return card;
	}

	@Override
	public String toString() {
		return handList + " \n";
	}

}
