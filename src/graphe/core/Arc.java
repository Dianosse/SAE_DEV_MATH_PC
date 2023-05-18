package graphe.core;

public class Arc {
	private String noeud_source;
	private String noeud_dest;
	private int valu;
	
	
	public Arc(String n) {
		this(n,"",0);
	}

	public Arc(String n_s, String n_d, int v) {
		assert(v>=0);
		noeud_source = n_s;
		noeud_dest = n_d;
		valu = v;
	}

	public String getSource() {
		return noeud_source;
	}

	public String getDestination() {
		return noeud_dest;
	}

	public int getValuation() {
		return valu;
	}

	public String toString() {
		return noeud_source + "-" + noeud_dest + "(" + valu + ")";
	}

	public boolean equals(String src, String dest) {
		if (this.noeud_source.equals(src) && this.noeud_dest.equals(dest)) {
			return true;
		}
		return false;
	}



}
