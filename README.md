# Homework 2
Early deadline: 2/25/22 11:59PM
Regular deadline: 3/8/22 11:59pm

Recently, many games have seen wild success with usage of loot boxes, or other reward system that is dependent on pure randomness. Some countries are starting to crack down on these games, calling them "gambling". Before it is completely outlawed, we need to take advantage of this genre of game. We are going to be developing "GambaInfusion".

In this game, you have a collection of "Professors" whom can debate other "Professors". Winning a debate earns you money, and you can use this to recruit more professors. You may also fuse together two of the same professor, to increase their rarity. You are provided with a complete Professor class, and need to implement the GanbaInfusion class. The GanbaInfusion class will need to include:
 
 1. A way to store a list of Professors of your own choosing (may not use the Java Collections Framework). You must implement your data structure from first principles. You may use an array if you implement an ArrayList, but you may not use an array on its own.
 2. How much gold you have. By default, when creating a new instance of a GanbaInfusion class, you should have 5 gold.
 3. Two constructors: A default constructor (with no arguments), and a constructor that takes an array of Professors and converts it into a GanbaInfusion.
 4. Several class specific functions. These include:
	 1. **public Professor getProf(String name, int r)**: Finds a professor with the given name and rarity, and returns them.
	 2. **public Professor getNthProf(int n)** Returns the nth professor in your ordered collection.
	 3. **public int getSize()** : Returns the size of the list that contains all the professors 
	 4. **public int getGold()**: Returns the amount of gold you currently have. 
	 5. **public int sell(Professor toSell):** Sells the Professor toSell. The Professor toSell must be in our collection. If not, then nothing happens. If the professor is in our collection, remove that instance of the professor from our collection, and gain gold equal to their rarity.
	 6. **public String toString()**: Prints out our collection of Professors. Our output should be formatted "Name, Rarity; Name, Rarity; ..." where commas separate the Name from the Rarity of one Professor, and semicolons separate different entities.
	 7. **public Professor pull()**: Adds a new professor to our list, at a cost of 5 gold. There is a weighted chance to pull different professors.  There is a 65% to pull a rarity 3 Edmiston,  34% to pull a rarity 4 Freitas, and 1% to pull a rarity 5 Toal. After pulling the Professor, add the to our collection and subtract 5 gold. Return the newly added Professor.
	 8. **public Professor fusion(Professor base, Professor fodder)**: If both Professor base and fodder have the same name and rarity, then "fuse" them to increase the rarity of base by 1. If they are different, do nothing. Return the base professor.
	 9. **public boolean debate(GanbaInfusion other)** Two "GanbaInfusion" users duel using their list of Professors. The winner will receive 10 gold. See the javadocs in the GanbaInfusion.java for more details.

You may **NOT** add any additional public fields or methods. You may, however, add private helper methods or fields. If you are unsure, please don't hesitate to ask about if something is allowed or not.

A small testing-suite is provided for you. Please use it to test that you're developing your GanbaInfusion class correctly.

This assignment is to be completed alone. 

The grade distribution of this homework will be:

- 90% unit tests 
- 10% style

HINTS:

- The unit tests are pretty sparse. There are many edge cases you likely want to test, as they may or may not be graded on.
- Think about your design before starting coding. What do you want to accomplish? How do you want to do it? What type of data structure will work best?
- Start early, as this project takes a while to get into. Starting the day it's due does not leave you time to ask questions!

Deadlines:
- If you finish your assignment and get it turned in by the early deadline, you will earn a bonus 10% credit (multiplicative). Meaning if you earned a 90%, you would earn a 99% (90 * 1.1). Maximum 110%. There will be no extensions on the early deadline for any circumstances.
- You can still earn full credit by turning it in by the regular deadline.
- If you do not get it in by the regular deadline, the normal late policy applies. If you turn it in late without prior arrangements, your maximum score is a 70%.

If there are any questions, please email me as soon as you have them.
