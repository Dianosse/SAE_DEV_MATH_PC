package graphe.core;



import java.util.ArrayList;


import graphe.implems.*;

public class Appli {

	public static void main(String[] args) {
		GrapheLArcs g1 = new GrapheLArcs("A-C(2), A-D(1), C-B(3), E-F(3), Q-L(1), Z-J(3), D-G(2), M-P(8), D-R(7), A-X(4), Q-G(9), S-T(2)");
		ArrayList<String> get1 = new ArrayList<String>( g1.getSommets());
		boolean test = g1.contientArc("A", "C");
		ArrayList<String> get2 = new ArrayList<String>( g1.getSucc("A"));
		String to = g1.toString();
		g1.oterSommet("C");
		g1.oterArc("Z", "J");
		String todoum = g1.toString();
		
		/*GrapheLAdj g1 = new GrapheLAdj("A-C(2), A-D(1), C-B(3), E-F(3), B-D(5), Q-L(1), Z-J(3), D-G(2), M-P(8), D-R(7), A-X(4), Q-G(9), S-T(2)");
		ArrayList<String> get3 = new ArrayList<String>( g1.getSommets());
		boolean tost = g1.contientArc("A", "C");
		ArrayList<String> get4 = new ArrayList<String>( g1.getSucc("A"));
		String todo = g1.toString();
		g1.oterSommet("D");
		g1.ajouterArc("T", "F", 5);
		String tob = g1.toString();
		
		HashMap<String,HashMap<String,Integer>> m = new HashMap<>();
		HashMap<String,Integer> x = new HashMap<>();
		x.put("B", 5);
		m.put("A", x);
		HashMap<String,Integer> a = m.get("A");
		int b = a.get("B");*/
		
		/*GrapheHHAdj g1 = new GrapheHHAdj("A-C(2), A-D(1), C-B(3), E-F(3), B-D(5), Q-L(1), Z-J(3), D-G(2), M-P(8), D-R(7), A-X(4), Q-G(9), S-T(2)");
		ArrayList<String> get5 = new ArrayList<String>( g1.getSommets());
		boolean tetsii = g1.contientArc("A", "C");
		ArrayList<String> get6 = new ArrayList<String>( g1.getSucc("A"));
		String todoj = g1.toString();
		g1.ajouterArc("T", "F", 5);
		String tododo = g1.toString();
		g1.oterSommet("D");
		String todododo = g1.toString();
		g1.oterArc("Z", "J");
		String todoto = g1.toString();
		
		GrapheHHAdj g = new GrapheHHAdj("Z-J(3)");
		g.oterArc("Z", "J");
		String s = g.toString();*/
		
		/*GrapheHHAdj g1 = new GrapheHHAdj("A-C(2), A-D(1), C-B(3), E-F(3), B-D(5), Q-L(1), Z-J(3), D-G(2), M-P(8), D-R(7), A-X(4), Q-G(9), S-T(2)");
		ArrayList<String> get7 = new ArrayList<String>( g1.getSommets());
		boolean txst = g1.contientArc("A", "C");
		ArrayList<String> get8 = new ArrayList<String>( g1.getSucc("A"));
		String fz = g1.toString();
		g1.ajouterArc("T", "F", 5);
		String klsdnv = g1.toString();
		g1.oterSommet("D");
		String djkvn = g1.toString();
		g1.oterArc("Z", "J");
		String psdjvdi = g1.toString();*/
		
		/*GrapheMAdj g1 = new GrapheMAdj("A-C(2), A-D(1), C-B(3), E-F(3), B-D(5), Q-L(1), Z-J(3), D-G(2), M-P(8), D-R(7), A-X(4), Q-G(9), S-T(2)");
		ArrayList<String> get9 = new ArrayList<String>( g1.getSommets());
		boolean tist = g1.contientArc("A", "C");
		ArrayList<String> get10 = new ArrayList<String>( g1.getSucc("A"));
		String fz = g1.toString();
		g1.ajouterArc("T", "F", 5);
		String klsdnv = g1.toString();
		g1.oterSommet("D");
		String djkvn = g1.toString();
		g1.oterArc("Z", "J");
		String psdjvdi = g1.toString();*/
	}
	
	
}
