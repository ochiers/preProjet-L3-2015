package tests;

import java.awt.Point;
import AI.*;
import static org.junit.Assert.*;
import org.junit.*;
import engine.*;

public class TestEasyAI {

	EasyAI ia;
	
	@Test
	public void test() {
		Engine engine = new Engine();
		engine.nouvellePartie(ia, ia, 5, 5);
		Gaufre gaufre = engine.partieCourante.map;
		gaufre.grille[4][4] = gaufre.grille[4][3] = gaufre.grille[3][4] = Gaufre.MANGEE;	
		ia = new EasyAI(engine, true, "CP1");
		Point res = ia.play();
		assertTrue(gaufre.grille[res.x][res.y] == Gaufre.LIBRE);
	}
}
