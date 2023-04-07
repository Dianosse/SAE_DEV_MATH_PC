package graphe;

import java.util.ArrayList;

public class Appli {

	public static void main(String[] args) {
		GrapheLArcs g1 = new GrapheLArcs("A-C(2), A-D(1)");
		ArrayList<String> get1 = new ArrayList<String>( g1.getSommets());
		boolean test = g1.contientArc("A", "C");
		ArrayList<String> get2 = new ArrayList<String>( g1.getSucc("A"));
		String to = g1.toString();
	}
		
}
