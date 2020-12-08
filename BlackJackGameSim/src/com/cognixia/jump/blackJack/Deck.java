 package com.cognixia.jump.blackJack;

import java.util.*;

public class Deck {
		//Singleton setup
		private ArrayList<Card> cards = new ArrayList<Card>();
		
		private static Deck instance = null;
		
		//make 52 card Singleton deck method looping through Suit and Rank
		private Deck() {
			for(Suit cardSuit : Suit.values()) {
				for(Rank cardRank : Rank.values()) {
					this.cards.add(new Card(cardSuit,cardRank));
				}
			}
		}
		public static Deck getInstance() {
			if(instance == null) {
				instance = new Deck();
			}
			return Deck.instance;	
		}
		
		//method and loop to shuffle(randomize) the deck 
		public void shuffle() {
			Collections.shuffle(cards, new Random());
		}

		//looped toString to make string with all cards with values
		public String toString(ArrayList<Card>PlayersHand) {
			String cardList = " ";
			for(Card aCard : PlayersHand) {
				cardList += "\n" + aCard.toString(); 
			}
			return cardList;
		}
		//remove cards method 
		public void removeCard(int i) {
			this.cards.remove(i);
			}
		//get cards method 
		public Card getCard(int i) {
			return this.cards.get(i);
		}
		//add card 
		public void addCard(Card addCard) {
			this.cards.add(addCard);
		}
		//method to take from beginning of ArrayList 
		public Card draw() {
			if(cards.isEmpty()) {
				resetDeck(this);
			}
				Card cardStorage = cards.get(0);
				cards.remove(0);
				return cardStorage;
		}
		//method to return cards
		public void resetDeck(Deck moveTo) {
			int thisDeckSize = this.cards.size();
			for(int i=0; i< thisDeckSize; i ++) {
			moveTo.addCard(this.getCard(i));
			}
			for(int i=0; i< thisDeckSize; i ++) {
				this.removeCard(0);
			}
		}
		
		//method to give deck actual value
		public int cardsRank(ArrayList<Card>PlayersHand){
			int totalValue = 0;
			int aces = 0;
			for (Card aCard : PlayersHand) {
				switch(aCard.getRank()) {
				case TWO: totalValue += 2; break;
				case THREE: totalValue += 3; break;
				case FOUR: totalValue += 4; break;
				case FIVE: totalValue += 5; break;
				case SIX: totalValue += 6; break;
				case SEVEN: totalValue += 7; break;
				case EIGHT: totalValue += 8; break;
				case NINE: totalValue += 9; break;
				case TEN: totalValue += 10; break;
				case JACK: totalValue += 10; break;
				case QUEEN: totalValue += 10; break;
				case KING: totalValue += 10; break;
				case ACE: aces += 1; break;
				}
			}
			//account for the double value of aces. 11 or 1 depending on the hand you have
			for(int i = 0; i < aces; i++) {
				if(totalValue > 10) {
					totalValue +=1;
				} else {
					totalValue += 11;
				}
			} return totalValue;
			
		}


}


