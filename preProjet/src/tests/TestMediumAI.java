package tests;

import java.awt.Point;

import AI.*;
import static org.junit.Assert.*;

import org.junit.*;

import engine.Engine;
import engine.Gaufre;

public class TestMediumAI {
	MediumAI ia;
	Engine engine;
	Gaufre gaufre;
	
	@Before
	public void init(){
		engine = new Engine();
		engine.nouvellePartie(ia, ia, 2, 2);
		gaufre = engine.partieCourante.map;
		ia = new MediumAI(engine, true, "CP1");
	}
	
	@Test
	public void testAutreCaseLibre() {
		Point res = ia.play();
		assertTrue(res.x == 1 && res.y == 1);		
	}
	
	@Test
	public void testPasAutreCaseLibre() {
		gaufre.grille[1][1] = Gaufre.MANGEE;
		Point res = ia.play();
		assertTrue(((res.x == 1 && res.y == 0) || (res.x == 0 && res.y == 1)) && gaufre.grille[res.x][res.y] == Gaufre.LIBRE);
	}
}
