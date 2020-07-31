package com.res.rest.demo;

import java.util.Random;

public enum Suit {
	
	Club(1), Diamond(0), Heart(2), Spade(3);
	private int suitValue;
	
	Suit(int suitValue){
		this.suitValue = suitValue;
	}
	
	public int getSuitValue() {
		return this.suitValue;
	}
	
	public static <T extends Enum<?>> T randomEnum(Class<T> clazz){
		Random random = new Random();
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }
}
