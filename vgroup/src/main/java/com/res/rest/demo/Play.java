package com.res.rest.demo;

import java.util.List;
import java.util.Scanner;

public class Play {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Deck deck = new Deck();
		System.out.println("Shuffle the deck");
		deck.shuffleDeck();
		System.out.println("Enter number of players::");
		int numOfPlayers = Integer.parseInt(scan.next());
		System.out.println("Start Game..");
		List<Hand> hands = deck.distributeCard(numOfPlayers);
		for(int i = 0; i < hands.size(); i++) {
			System.out.println("Cards in each hand :: "+hands.get(i));
		}
		compareCards(hands);
		scan.close();
	}
	
	private static void compareCards(List<Hand> handList) {
		Hand h1 = handList.get(0);
		CardComparator comp = new CardComparator();
		for(int i = 1;i< handList.size(); i++) {
			Hand h2 = handList.get(i);
			Card c1 = h1.getCard();
			Card c2 = h2.getCard();
			int compValue = comp.compare(c1, c2);
			if(compValue < 1) {
				h1 = h2;
			}
		}
		System.out.println("Winner is :: "+h1);
	}

}
