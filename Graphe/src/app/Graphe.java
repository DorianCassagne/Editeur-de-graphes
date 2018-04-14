package app;

import java.util.ArrayList;

public class Graphe {

	private ArrayList<Sommet> listeSommets;
	private ArrayList<Arete> listeAretes;
	
	public Graphe() {
		this.listeSommets=new ArrayList<Sommet>();
		this.listeAretes=new ArrayList<Arete>();
	}

	public ArrayList<Sommet> getListeSommets() {
		return listeSommets;
	}

	public int nbreSommets() {
		return this.listeSommets.size();
	}
	
	public ArrayList<Arete> getListeAretes() {
		return listeAretes;
	}
	
	public void ajouterSommet(Sommet s) {
		this.listeSommets.add(s);
	}
	
	public void ajouterArete(Arete a) {
		this.listeAretes.add(a);
	}
}
