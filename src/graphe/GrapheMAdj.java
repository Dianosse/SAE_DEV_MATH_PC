package graphe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrapheMAdj implements IGraphe{
	private int nbSommets;
    private int[][] matrice;
    private Map<String, Integer> indices;
	private static final int ERROR = -1;

	
    public GrapheMAdj() {
        nbSommets = 0;
        matrice = new int[nbSommets][nbSommets];
        indices = new HashMap<>();
    }
    
    public GrapheMAdj(String graphe) {
    	this();
    	this.peupler(graphe);
    }
	
	@Override
	public List<String> getSommets() {
		return new ArrayList<>(indices.keySet());
	}

	@Override
	public List<String> getSucc(String sommet) {
		List<String> successeurs = new ArrayList<>();
		HashMap<Integer,String> inverse = new HashMap<>();
		for(String s : indices.keySet()) {
			inverse.put(indices.get(s), s);
		}
        int indexSommet = indices.get(sommet);
        for (int i = 0; i < matrice.length; i++) {
            if (matrice[indexSommet][i] >= 0) {
                successeurs.add(inverse.get(i));
            }
        }
        return successeurs;
	}

	@Override
	public int getValuation(String src, String dest) {
		if(contientArc(src, dest)) {
			return matrice[indices.get(src)][indices.get(dest)];
		}
		return ERROR;
	}

	@Override
	public boolean contientSommet(String sommet) {
		for(String s : indices.keySet()) {
			if(s.equals(sommet)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean contientArc(String src, String dest) {
		if(!contientSommet(src)) { return false; }
		if(!contientSommet(dest)) { return false; }
		if(matrice[indices.get(src)][indices.get(dest)] >= 0) {
			return true;
		}
		return false;
	}

	@Override
	public void ajouterSommet(String noeud) {
		if (!contientSommet(noeud)) {
			indices.put(noeud, nbSommets++);
	        int[][] nouvelleMatrice = new int[nbSommets][nbSommets];
	        for (int i = 0; i < nouvelleMatrice.length; i++) {
	            for (int j = 0; j < nouvelleMatrice[i].length; j++) {
	                nouvelleMatrice[i][j] = -1;
	            }
	        }
	        for (int i = 0; i < nbSommets - 1; i++) {
	            for (int j = 0; j < nbSommets - 1; j++) {
	                nouvelleMatrice[i][j] = matrice[i][j];
	            }
	        }
	        matrice = nouvelleMatrice;
        }		
	}

	@Override
	public void ajouterArc(String source, String destination, Integer valeur) {
		if(!contientSommet(source)) {	 ajouterSommet(source);	 }
		if(!contientSommet(destination)) {		ajouterSommet(destination); 	}
		
				
		if(contientArc(source, destination) || valeur < 0) {	
			throw new IllegalArgumentException();	
		}
		else {
	        matrice[indices.get(source)][indices.get(destination)] = valeur;
		}
	}

	@Override
	public void oterSommet(String noeud) {
		if (contientSommet(noeud)) {
			ArrayList<String> succ = new ArrayList<>(getSucc(noeud));
	        for(String s : succ) {
	        	matrice[indices.get(noeud)][indices.get(s)] = -1;
	        }
	        for(String s: indices.keySet()) {
	        	if(contientArc(s, noeud)) {
	        		oterArc(s, noeud);
	        	}
	        }

	        indices.remove(noeud);
	        nbSommets--;
        }        
        
	}

	@Override
	public void oterArc(String source, String destination) {
		if (contientArc(source, destination)) {
            matrice[indices.get(source)][indices.get(destination)] = -1;
        }
		else {
			throw new IllegalArgumentException();
		}
	}
	
	
	@Override
	public String toString() {
		return this.toAString();
	}
}
