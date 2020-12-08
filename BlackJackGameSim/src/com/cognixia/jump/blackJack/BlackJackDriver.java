package com.cognixia.jump.blackJack;

import java.util.*;

public class BlackJackDriver {

	public static void main(String[] args) {
		// starting game printout
		System.out.println("Let's play Oompa Loompa BlackJack!");
		//call deck shuffle
		Deck.getInstance().shuffle();
		
		//decks for player and dealer
		 ArrayList<Card> playerDeck = new ArrayList<Card>();
		 ArrayList<Card> wonkaDeck = new ArrayList<Card>();
		
		//create player money
		double playerMoney = 300;
		
		//Scanner so that we can play with inputs
		Scanner userInput = new Scanner(System.in);
		
		//Betting loop accounting for if they try to bet more than they have or if they bet 0
		while(playerMoney > 0) {
				System.out.println("You've got " + playerMoney + " Everlasting Gobstoppers, how many you wanna bet?");
				double playerBet = userInput.nextDouble();
				//boolean so we can end round or play
				boolean endRound = false;
					if(playerBet > playerMoney) {
						System.out.println("You're a rotten egg, you've been tossed!");
						break;
					}
					else if(playerBet == 0) {
						System.out.println("Good Day!");
						break;
					}
			//deal player 2 cards
				playerDeck.add(Deck.getInstance().draw());
				playerDeck.add(Deck.getInstance().draw());
			//same for dealer
				wonkaDeck.add(Deck.getInstance().draw());
				wonkaDeck.add(Deck.getInstance().draw());
				
					while(!endRound) { //display player/ dealer hands 
						System.out.println("You have: " + Deck.getInstance().toString(playerDeck));
						System.out.println("You're at " + Deck.getInstance().cardsRank(playerDeck));
						System.out.println("Mr. Wonka has " +  wonkaDeck.get(0).toString() + " and an upside down card.");
						// ask what they'd like to do and get their answer
						System.out.println("Would you like to (1)Hit or (2)Stand?");
						int answer = userInput.nextInt();
						//Hit
						if(answer == 1) {
							playerDeck.add(Deck.getInstance().draw());
							System.out.println("You were dealt " + playerDeck.get(playerDeck.size()-1).toString());
						//Bust
						if(Deck.getInstance().cardsRank(playerDeck)>21) {
						System.out.println("You now have " + Deck.getInstance().cardsRank(playerDeck) + " \nBusted! You're a giant Blueberry!");
						playerMoney-=playerBet;
						endRound = true;
						break;
					}
				}		//stand
						if(answer == 2) {
							endRound = true;
								break;
				}
			}
			
				//Reveal Dealer cards 
				System.out.println("Mr. Wonka has" + wonkaDeck.toString() + "\n");
				//and see if he has won
				if((Deck.getInstance().cardsRank(playerDeck)<22) && (Deck.getInstance().cardsRank(wonkaDeck)>Deck.getInstance().cardsRank(playerDeck))) {
					System.out.println("You Get Nothing! You Lose! Good Day, Sir!\n");
						playerMoney -= playerBet;
						endRound = true;
				}
				//dealer setup for when they hit
				if((Deck.getInstance().cardsRank(wonkaDeck)<17)) {
					wonkaDeck.add(Deck.getInstance().draw());
					System.out.println("Mr. Wonka drew " + wonkaDeck.get(wonkaDeck.size()-1).toString());
				}
					System.out.println("Mr. Wonka's hand is: " + Deck.getInstance().cardsRank(wonkaDeck));
				//dealer bust
				if((Deck.getInstance().cardsRank(playerDeck)<22) && (Deck.getInstance().cardsRank(wonkaDeck)>21)) {
					System.out.println("You Won! You did it, You did it! I knew you would!");
						playerMoney += playerBet;
						endRound = true;
				}//tie
				if((Deck.getInstance().cardsRank(playerDeck)<22) && Deck.getInstance().cardsRank(playerDeck)== Deck.getInstance().cardsRank(wonkaDeck)) {
					System.out.println("Tie!");
						endRound = true;
				}
				//see if player wins or not
				if((Deck.getInstance().cardsRank(playerDeck)<22) && (Deck.getInstance().cardsRank(playerDeck) > Deck.getInstance().cardsRank(wonkaDeck))){
					System.out.println("You Won! You did it, You did it! I knew you would!");
						playerMoney += playerBet;
						endRound = true;
				} 
				if((Deck.getInstance().cardsRank(playerDeck)<22) && (Deck.getInstance().cardsRank(playerDeck) == 21) && (Deck.getInstance().cardsRank(playerDeck) > Deck.getInstance().cardsRank(wonkaDeck))){
					System.out.println("You Won! You did it, You did it! I knew you would!");
						playerMoney += playerBet;
						endRound = true;
				}
				else if(endRound == false) {
					System.out.println("You Get Nothing! You Lose! Good Day, Sir");
						playerMoney -= playerBet;
				}
			// return all cards back to the deck
				playerDeck.clear();
				wonkaDeck.clear();
				System.out.println("\nOompa Loompa, Doompa De Do \n I've got another riddle for you!\n");
				System.out.println("------------------------------------------------------------------\n");
		}
		
		// end of game
		System.out.println("\nI SAID, GOOD DAY!");
		//close scanner
		userInput.close();
	}
	
}


