package hw2;

import static org.junit.Assert.*;

import org.junit.Test;

public class UnitTests {

	@Test
	public void test_pull1() {
		GanbaInfusion game = new GanbaInfusion();
		Professor pulled = game.pull();
		assertTrue(pulled.getRarity() <= 5 && pulled.getRarity() >= 3);
		
	}
	
	
	@Test
	public void test_getSize1() {
		GanbaInfusion game = new GanbaInfusion();
		game.pull();
		assertTrue(game.getSize() == 1);
	}
	
	
	@Test
	public void test_getSize2() {
		GanbaInfusion game = new GanbaInfusion();
		game.pull();
		game.pull(); // Should not increase size because not enough gold
		assertTrue(game.getSize() == 1);
	}
	
	@Test
	public void test_getGold1() {
		GanbaInfusion game = new GanbaInfusion();
		game.pull();
		assertTrue(game.getGold() == 0);
	}
	
	@Test
	public void test_getGold2() {
		GanbaInfusion game = new GanbaInfusion();
		assertTrue(game.getGold() == 5);
	}
	
	@Test
	public void test_sell() {
		GanbaInfusion game = new GanbaInfusion();
		Professor pulled = game.pull();
		game.sell(pulled);	
		assertTrue(game.getSize() == 0);
		assertTrue(game.getGold() <= 6 && game.getGold() >= 3);
		
	}
	
	@Test
	public void test_getProf() {
		GanbaInfusion game = new GanbaInfusion(new Professor[] {new Professor("Edmiston")});
		assertTrue(game.getSize() == 1);
		assertTrue(game.getProf("Edmiston", 3) != null);
	}
	
	
	@Test
	public void test_getNthProf() {
		GanbaInfusion game = new GanbaInfusion(new Professor[] {new Professor("Edmiston"), new Professor("Freitas")});
		assertTrue(game.getSize() == 2);
		assertTrue(game.getNthProf(1).getName().equals("Freitas"));
	}
	
	
	
	
	@Test
	public void test_fusion() {
		Professor e1 = new Professor("Edmiston");
		Professor e2 = new Professor("Edmiston");
		
		GanbaInfusion game = new GanbaInfusion(new Professor[] {e1, e2});
		
		assertTrue(game.getProf("Edmiston", 3) != null);
		
		game.fusion(e1, e2);
		
		assertTrue(game.getProf("Edmiston", 3) == null);
		assertTrue(game.getProf("Edmiston", 4) == e1);
	}
	
	
	
	@Test
	public void test_debate() {
		GanbaInfusion game1 = new GanbaInfusion(new Professor[] {new Professor("Edmiston")});
		GanbaInfusion game2 = new GanbaInfusion(new Professor[] {new Professor("Edmiston")});
		int game1Win = 0;
		for(int i = 0; i < 1000; i++) {
			game1Win = game1.debate(game2) ? game1Win+1 : game1Win; // Ternary statement. a ? b : c means "if a then b else c"	
		}
		assertTrue(game1Win < 650 && game1Win > 350); // 50% chance to win means you should be in this range quite consistently		
		
	}
	
	
		

}
