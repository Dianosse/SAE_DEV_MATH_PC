package test_unitaires;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import graphe.algos.Dijkstra;
import graphe.core.IGraphe;
import graphe.implems.*;

import org.junit.jupiter.api.Test;


public class Test_dijkstra {
	private final IGraphe g = new GrapheHHAdj();
	private Map<String, Integer> dist = new HashMap<>();
    private Map<String, String> prev = new HashMap<>();
    String depart = "A";

	
	private final String test = "A-B(1), A-C(1), B-D(1), B-F(3), C-D(0), C-I(1), D-E(10), F-E(5), E-J(2), Y:, G-H(5)";

	
	@Test
	void test_dijkstra() {
		g.peupler(test);
		Dijkstra.dijkstra(g, depart, dist, prev);
		Map<String, Integer> dist_test = new HashMap<>();
		Map<String, String> prev_test = new HashMap<>();
		dist_test.put(depart, 0); dist_test.put("B", 1); dist_test.put("C", 1); dist_test.put("D", 1); dist_test.put("E", 9); dist_test.put("F", 4); dist_test.put("I", 2); dist_test.put("J", 11);
		prev_test.put(depart, ""); prev_test.put("B", "A"); prev_test.put("C", "A"); prev_test.put("D", "C"); prev_test.put("E", "F"); prev_test.put("F", "B"); prev_test.put("I", "C"); prev_test.put("J", "E"); 
		assertEquals(dist, dist_test);
		assertEquals(prev, prev_test);
	}
	
	
	
}
