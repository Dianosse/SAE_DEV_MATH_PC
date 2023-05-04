package graphe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GrapheLArcs implements IGraphe{
	private List<Arc> arcs;
	
	private static final int ERROR = -1;
	private static final int VALU_MIN = 0;
	
	public GrapheLArcs() {
		arcs = new ArrayList<>();
	}
	
	public GrapheLArcs(String grapheStr) {
		this();
		this.peupler(grapheStr);
	}
	@Override
	public ArrayList<String> getSommets() {
		ArrayList<String> sommets = new ArrayList<>();
		for (int i=0; i< arcs.size();++i) {
			if(!dans_liste(arcs.get(i).getSource(), sommets))
				sommets.add(arcs.get(i).getSource());
		}
		return sommets;
	}

	@Override
	public ArrayList<String> getSucc(String sommet) {
		ArrayList<String> successeurs = new ArrayList<>();
		for(Arc a : arcs) {
			if (sommet.equals(a.getSource()) && !dans_liste(sommet, successeurs) && !a.getDestination().equals(""))
				successeurs.add(a.getDestination());
		}
		return successeurs;
	}

	@Override
	public int getValuation(String src, String dest){
		for(int i=0; i<arcs.size();++i) {
			if(arcs.get(i).equals(src,dest)) 
				return this.arcs.get(i).getValuation();
		}
		return ERROR;
	}

	@Override
	public boolean contientSommet(String sommet) {
		for(Arc a : arcs) {
			if(a.getSource().equals(sommet) || a.getDestination().equals(sommet)) 
				return true;
		}
		return false;
	}

	@Override
	public boolean contientArc(String src, String dest) {
		for(Arc a : arcs) {
			if(a.equals(src,dest))
				return true;
		}
		return false;
	}

	@Override
	public void ajouterSommet(String noeud) {
		if(!contientSommet(noeud))
			arcs.add(new Arc(noeud));
	}

	@Override
	public void ajouterArc(String source, String destination, Integer valeur) {
		if(!contientSommet(source)) {	 ajouterSommet(source);	 }
		else if(!contientSommet(destination)) {		ajouterSommet(destination); 	}
		
				
		if(contientArc(source, destination) || valeur < VALU_MIN) {	
			throw new IllegalArgumentException();	
		}
		else {
			arcs.add(new Arc(source,destination,valeur));
		}
		
		if(contientArc(source,"")) {	oterArc(source, "");	}

	}

	@Override
	public void oterSommet(String noeud) {
		if(contientSommet(noeud)) {
			for(int i = 0; i< arcs.size();++i) {
				if (arcs.get(i).getSource().equals(noeud)) {
					arcs.remove(i);
				}
			}
			for (int i = 0; i< arcs.size(); ++i) {
				if (arcs.get(i).getDestination().equals(noeud)) {
					String src = arcs.get(i).getSource();
					arcs.remove(i);
					ajouterSommet(src);
				}
			}
		}
		
		
	}

	@Override
	public void oterArc(String source, String destination) {
		if (!contientArc(source, destination)) {
			throw new IllegalArgumentException();
		}
		for(int i =0; i<arcs.size();++i) {
			if(arcs.get(i).equals(source,destination)) {
				arcs.remove(i);
				if(!contientSommet(source))					//Pour garder quand même un sommet contenant la source dans graphe car ce n'est pas parce qu'on supprime l'Arc que la source disparait du graphe
					ajouterSommet(source);
				break;
			}
		}
	}
	
	
	private boolean dans_liste(String s, ArrayList<String> a) {
		for(int i=0;i<a.size();++i) {
			if(s.equals(a.get(i))) {
				return true;
			}
		}
		return false;
	}
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		boolean premier = true;
		Comparator<Arc> comparator = Comparator.comparing(Arc::toString);
        Collections.sort(arcs, comparator);
		for (Arc a : arcs) {
			if(!premier) {
				sb.append(", ");
			}
			else {
				premier = false;
			}
			if(a.getDestination().equals("")) {
				sb.append(a.getSource() + ":");
			}
			else {
				sb.append(a.toString());	
			}
		}
		return sb.toString();
	}
	
	
}
