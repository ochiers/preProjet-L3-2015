package tests;

import java.awt.Point;

import AI.*;
import static org.junit.Assert.*;

import org.junit.*;

import engine.Engine;
import engine.Gaufre;

public class TestMediumAI {

	MediumAI ia;
	
	@Test
	public void test() {
		Engine engine = new Engine();
		engine.nouvellePartie(null, ia, ia, 2, 2);
		Gaufre gaufre = engine.partieCourante.map;
		ia = new MediumAI(engine, true, "CP1");
		Point res = ia.play();
		assertTrue(res.x == 1 && res.y == 1);
		
		gaufre.grille[1][1] = Gaufre.MANGEE;
		res = ia.play();
		assertTrue(gaufre.grille[res.x][res.y] == Gaufre.LIBRE);
		assertTrue((res.x == 1 && res.y == 0) || (res.x == 0 && res.y == 1));
		
	}
}
