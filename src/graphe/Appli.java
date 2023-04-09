package graphe;

import java.util.ArrayList;
import java.util.HashMap;

public class Appli {

	public static void main(String[] args) {
		/*GrapheLArcs g1 = new GrapheLArcs("A-C(2), A-D(1), C-B(3), E-F(3), Q-L(1), Z-J(3), D-G(2), M-P(8), D-R(7), A-X(4), Q-G(9), S-T(2)");
		ArrayList<String> get1 = new ArrayList<String>( g1.getSommets());
		boolean test = g1.contientArc("A", "C");
		ArrayList<String> get2 = new ArrayList<String>( g1.getSucc("A"));
		String to = g1.toString();
		//g1.oterSommet("C");
		g1.oterArc("Q", "L");
		String todoum = g1.toString();*/
		
		/*GrapheLAdj g1 = new GrapheLAdj("A-C(2), A-D(1), C-B(3), E-F(3), B-D(5), Q-L(1), Z-J(3), D-G(2), M-P(8), D-R(7), A-X(4), Q-G(9), S-T(2)");
		ArrayList<String> get1 = new ArrayList<String>( g1.getSommets());
		boolean test = g1.contientArc("A", "C");
		ArrayList<String> get2 = new ArrayList<String>( g1.getSucc("A"));
		String to = g1.toString();
		g1.oterSommet("D");*/
		
		/*HashMap<String,HashMap<String,Integer>> m = new HashMap<>();
		HashMap<String,Integer> x = new HashMap<>();
		x.put("B", 5);
		m.put("A", x);
		HashMap<String,Integer> a = m.get("A");
		int b = a.get("B");*/
		
		GrapheHHAdj g1 = new GrapheHHAdj("A-C(2), A-D(1), C-B(3), E-F(3), B-D(5), Q-L(1), Z-J(3), D-G(2), M-P(8), D-R(7), A-X(4), Q-G(9), S-T(2)");
		ArrayList<String> get1 = new ArrayList<String>( g1.getSommets());
		boolean test = g1.contientArc("A", "C");
		ArrayList<String> get2 = new ArrayList<String>( g1.getSucc("A"));
		String to = g1.toString();
		g1.oterArc("A","D");
		
	}
		
}
