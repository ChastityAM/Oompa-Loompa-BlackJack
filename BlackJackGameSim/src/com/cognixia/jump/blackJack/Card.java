package com.cognixia.jump.blackJack;

public class Card {
	//bring in what makes up the card
	private final Suit suit;
	private final Rank rank;
	// card constructor
	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}
	//toString that puts card together
	@Override
	public String toString() {
		return this.rank.toString() + " of " + this.suit.toString();
		
	}
	//get rank method
	public Rank getRank() {
		return this.rank;
		
	}
}
