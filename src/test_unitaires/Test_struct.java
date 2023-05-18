package test_unitaires;

import graphe.core.IGraphe;
import graphe.implems.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;


public class Test_struct {
	private final IGraphe g = new GrapheHHAdj();
	
	
	private final String test = "A-C(2), A-D(1), C-B(3), E-F(3), Q-L(1), Z-J(3), D-G(2), M-P(8), D-R(7), A-X(4), Q-G(9), S-T(2)";
	
	@Test
	void test_succ() {
		g.peupler(test);
		ArrayList<String> get = new ArrayList<String>( g.getSucc("A"));
		assertEquals(List.of("C","D","X"), get);
	}
	
	@Test 
	void test_Sommet(){
		g.peupler(test);
		ArrayList<String> get = new ArrayList<String>( g.getSommets());
		assertEquals(get, List.of("A", "B", "C", "D", "E", "F", "G", "J", "L", "M", "P", "Q", "R", "S","T", "X", "Z"));
	}
	
	@Test
	void test_contientArc() {
		g.peupler(test);
		assertTrue(g.contientArc("A", "C"));
		assertFalse(g.contientArc("J", "L"));
		assertFalse(g.contientArc("a", "C"));
	}
	
	@Test
	void test_oterSommet() {
		g.peupler(test);
		g.oterSommet("C");
		assertEquals(g.getSommets(), List.of("A", "B", "D", "E", "F", "G", "J", "L", "M", "P", "Q", "R", "S","T", "X", "Z"));
	}
	
	@Test
	void test_oterArc() {
		g.peupler(test);
		g.oterArc("Z", "J");
		assertFalse(g.contientArc("Z", "J"));
	}
	
	@Test
	void test_toString() {
		g.peupler(test);
		String test_sort = "A-C(2), A-D(1), A-X(4), B:, C-B(3), D-G(2), D-R(7), E-F(3), F:, G:, J:, L:, M-P(8), P:, Q-G(9), Q-L(1), R:, S-T(2), T:, X:, Z-J(3)";
		assertEquals(test_sort, g.toString());
	}
}
