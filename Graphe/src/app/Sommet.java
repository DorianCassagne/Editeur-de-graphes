package app;

import java.util.ArrayList;


import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class Sommet extends Circle{

	private StackPane stack;
	private String libelle;
	private int degre;
	private ArrayList<Arete> listeAretes;
	
	public Sommet(String nom) {
		super(10);
		this.libelle=nom;
		this.degre=0;
		this.listeAretes=new ArrayList<Arete>();
		this.setFill(Color.ANTIQUEWHITE);
		this.setStroke(Color.BLACK);
		this.stack=new StackPane();
		Text t=new Text(this.libelle);
		stack.getChildren().addAll(this,t);
		this.setOpacity(1);
	}
	
	public void setCoord(double x,double y) {
		this.setCenterX(x);
		this.setCenterY(y);
		stack.setTranslateX(x);
		stack.setTranslateY(y);
		this.centerXProperty().setValue(x);
		this.centerYProperty().setValue(y);
	}
	
	public void dessiner (Pane p) {
		
	}
	
	public void incrementerDegre() {
		this.degre++;
	}
	
	public StackPane getStack() {
		return this.stack;
	}
	
	public void ajouterArete(Arete a) {
		this.listeAretes.add(a);
	}
	
	public String toString() {
		return this.libelle;
	}
	
	
}
