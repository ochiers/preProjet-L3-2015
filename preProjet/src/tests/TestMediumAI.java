package tests;

import java.awt.Point;

import AI.*;
import static org.junit.Assert.*;

import org.junit.*;

import engine.Gaufre;

public class TestMediumAI {

	MediumAI ia;
	
	@Test
	public void test() {
		Gaufre gaufre = new Gaufre(2,2);
		gaufre.initialisation();
		gaufre.grille[1][1] = Gaufre.MANGEE;
		
		ia = new MediumAI(gaufre, true, "CP1");
		Point res = ia.play();
		assertTrue(gaufre.grille[res.x][res.y] == Gaufre.LIBRE);
		//assertTrue((res.x == 1 && res.y == 0) || (res.x == 0 && res.y == 1));
	}
}
