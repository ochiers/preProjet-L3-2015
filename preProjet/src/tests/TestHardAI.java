package tests;

import java.awt.Point;

import AI.*;
import static org.junit.Assert.*;

import org.junit.*;

import engine.Engine;
import engine.Gaufre;

public class TestHardAI {
	HardAI ia;
	Engine engine;
	Gaufre gaufre;
	
	@Before
	public void init(){
		engine = new Engine();
		engine.nouvellePartie(ia, ia, 2, 2);
		gaufre = engine.partieCourante.map;
		ia = new HardAI(engine, true, "CP1");
	}
	
	@Test
	public void testAutreCaseLibre() {
		Point res = ia.play();
		//System.out.println(res.x + " " + res.y);
		assertTrue(res.x == 1 && res.y == 1);		
	}
	
	@Test
	public void testGrille4x6() {
		engine = new Engine();
		engine.nouvellePartie(ia, ia, 4, 6);
		gaufre = engine.partieCourante.map;
		ia = new HardAI(engine, true, "CP1");
		Point res = ia.play();
		//System.out.println(res.x + " " + res.y);
		assertFalse((res.x == 0 && res.y == 1) && (res.x == 1 && res.y == 0));
	}
}
