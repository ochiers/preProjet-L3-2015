package tests;

import java.awt.Point;

import AI.*;
import static org.junit.Assert.*;

import org.junit.*;

import engine.Gaufre;

public class TestEasyAI {

	EasyAI ia;
	
	@Test
	public void test() {
		Gaufre gaufre = new Gaufre(5,5);
		gaufre.initialisation();
		gaufre.grille[4][4] = gaufre.grille[4][3] = gaufre.grille[3][4] = 2;
		
		ia = new EasyAI(gaufre, true, "CP1");
		Point res = ia.play();
		assertTrue(gaufre.grille[res.x][res.y] == Gaufre.LIBRE);
	}
}
