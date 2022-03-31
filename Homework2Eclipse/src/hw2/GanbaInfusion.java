package hw2;

import java.util.Random;


public class GanbaInfusion {
	
	// TODO: Define your fields
	DoubleLink prof; 
	private int gold = 5;
	private static final int S = 50;
	
	GanbaInfusion(){
		// TODO: Implement a default constructor
		 prof = new DoubleLink();
		
	}
	
	GanbaInfusion(Professor[] prebuilt){
		// TODO: Implement a constructor from an array
		prof = new DoubleLink();
		for(Professor professor : prebuilt) {
			prof.append(professor);
		}	
	}
	
		
	

	
	
	/** Returns a reference to a professor in the list with the name "name" and the rarity level "r". 
	 * If there is none that exists, return Null
	 * 
	 * @return the Professor found, or null if not found
	 */
	public Professor getProf(String name, int r) {
		// TODO: Implement the function
		//throw new UnsupportedOperationException();
		return prof.search(name, r);
	}
	
	
	/**
	 * Returns the n'th professor in your list. If you were to iterate for the size of your list and use this function, you should get back each professor in the list exactly once.
	 * @param n The "index" or number of which professor you need to return.
	 * @return The n'th professor
	 */
	public Professor getNthProf(int n) {
		//throw new UnsupportedOperationException();
		return prof.getAt(n);
	}
	
	
	
	/**Returns the size of the list containing all the professors. This should be a total count of professors.
	 * 
	 * @return The count of professors
	 */
	public int getSize() {
		// TODO: Implement the function
		//throw new UnsupportedOperationException();
		return prof.length();
	}
	
	
	
	/**Returns the amount of gold, our currency.
	 * 
	 * @return the amount of gold
	 */
	public int getGold() {
		//throw new UnsupportedOperationException();
		return gold;
	}
	
	
	
	
	/**
	 * Sells a professor and gives you gold equal to the rarity. This function should check if this function is in our list, 
	 * and if they are then remove the professor from our list and sell. 
	 * If the professor is not in our list, do nothing. 
	 * @param toSell
	 * @return The money received for selling.
	 */
	public int sell(Professor toSell) {
		//TODO: Implement the function.
		//throw new UnsupportedOperationException();
		int startgold = 0;
		if(toSell == null) {
			throw new UnsupportedOperationException();
		}
		if(toSell != null) {
			startgold  = toSell.getRarity();
			gold += startgold;
			prof.delete(toSell);
		}
		return startgold;
	}
	

	
	
	
	/** Returns our Professor list. 
	 * 	Items printed out should be formatted:
	 *  Name, Rarity; Name, Rarity; with commas separating the Name from the Rarity, and semicolons separating different entities
	 * 
	 */
	public String toString() {
		// TODO: Build our string to return
		//throw new UnsupportedOperationException();
		String listofprofessors = "";
		for(int i=0; i < prof.length(); i++) {
			Professor professors = prof.getAt(i);
			listofprofessors +=professors.getName() + "" + professors.getRarity();
		}
		return listofprofessors;
	}
	
	
	
	
	/** Adds a new professor to our list. Costs 5 gold. The rarity breakdown is as follows:
	 * 
	 * 65% to pull a rarity 3 Edmiston
	 * 34% to pull a rarity 4 Freitas
	 * 1% to pull a rarity 5 Toal
	 * 
	 * You can use the helper "randomProf()" to get a String equal to a professor randomly
	 * 
	 * @return a reference to the Professor that was pulled and added to the list
	 */
	public Professor pull() {		
		// TODO: Need to check if there is enough gold, and subtract 5 from our count
		// TODO: Need to update our list with the new professor
		if (gold < 5) {
			return null;
		}
			Random ran = new Random();
			int num = ran.nextInt(100);
			
			String pulled = "";
			
			if(num <= 65 ) {
				pulled = "Edmiston";
			
			} else if(num <= 99) {
				pulled = "Freitas";
			} else {
				pulled = "Toal";
			}
			Professor professor = new Professor(pulled);
			prof.append(professor);
			gold -= 5;
			return professor;
	}
		
		//throw new UnsupportedOperationException();

	
	

	
	
	/** If both professors are of the same type, fuse them to "increase rarity". If they are different types, do nothing.
	 * 
	 *  The base professor's rarity increases by 1 stage if successful.
	 * 
	 * @param base The professor that we are "ranking up".
	 * @param fodder The professor instance we are deleting rank another card up.
	 * @return The base professor after changes are made.
	 */
	public Professor fusion(Professor base, Professor fodder) {
		// TODO: Implement this function
		if(base.toString() == fodder.toString()) {
			int fodderIndex = prof.index(base.getName(), fodder.getRarity());
			if(fodderIndex == -1) {
				return base;
			}
			prof.empty(fodder);
			int baseIndex = prof.index(base.getName(), base.getRarity());
			if(baseIndex == -1) {
				return base;
			}
			base.rarity += 1;
		}
		return base;
		//throw new UnsupportedOperationException();
	}
	

	/**
	 * Two "GanbaInfusion" users duel using their list of Professors. The duel works the following way:
	 * 
	 * The first professor from each "GanbaInfusion" debate eachother. One professor will win the debate, and one will lose. The losing professor
	 * retires from the debate (is not deleted or removed, just is no longer used for this instance of the function call). The winning professor continues. 
	 * 
	 * The winning professor then debates the next professor from the side that lost. This continues until one side has no professors left to debate with. 
	 * 
	 * If "this" instance wins, return true. If "other" wins, return false. Increment the winners gold by 10 with the helper function "increaseGold".
	 * 
	 * The probability of winning a debate is as follows:
	 * 
	 * 50% chance + 10% times the difference in the professors rarity. Below are two examples:
	 * 
	 * Two rarity 3 professors debate. Its a 50% chance for either of them to win.
	 * A rarity 3 and rarity 5 professor debate. The rarity 3 professor has a 30% chance to win, and the rarity 5 professor has a 70% chance to win.
	 * 
	 * @param other The object that holds the other list that "this" object will debate with
	 * @return
	 */
	public boolean debate(GanbaInfusion other) {
		//throw new UnsupportedOperationException();
		Random rand = new Random ();
		int roll;
		for(int i=0; i < prof.length(); i++) {
			
			roll = rand.nextInt(100);
			Professor professor = prof.getAt(i);
			int higherRarity = professor.getRarity();
			int chanceOfPicking = S + (higherRarity * 10);
			if (roll <= chanceOfPicking) {
				increaseGold();
				return true;
			} else {
				return false;
			}
			
		}
		return false;
	}
	
	
	// HELPER FUNCITONS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	
	/**
	 * Generates a random number between 1 and 100, and returns true if that number is less than probability. This means we return true with chance "probability" 
	 * @return
	 */
	private boolean probabilityBetween(int probability) {
		Random rand = new Random();
		int num = rand.nextInt(100); // Generates a random number between 0-99
		return num <= probability;
	}
	
	/**
	 * Returns a String of a random professor
	 */
	private String randomProf() {
		Random rand = new Random();
		int val = rand.nextInt(101); // Generates random value bewteen 0 and 99
		
		// Determines whom got pulled
		if (val <= 65) {
			return "Edmiston";		
		} else if (val <= 99) { // This is between 60-90
			return "Freitas";
		} else {
			return "Toal";
		}
		
	}
	
	private void increaseGold() {
		gold+=10;
	}
	
	
}
