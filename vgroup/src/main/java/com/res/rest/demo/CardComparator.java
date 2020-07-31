package com.res.rest.demo;

import java.util.Comparator;

public class CardComparator implements Comparator<Card>{

	@Override
	public int compare(Card arg0, Card arg1) {
		if(arg0.getValue() < arg1.getValue()) {
			return -1;
		}else if(arg0.getValue() > arg1.getValue()) {
			return 1;
		}else if(arg0.getValue() == arg1.getValue()) {
			if(arg0.getSuit().getSuitValue() < arg1.getSuit().getSuitValue()) {
				return -1;
			}else {
				return 1;
			}
		}
		return 0;
	}

}
