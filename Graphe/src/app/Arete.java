package app;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;

public class Arete extends Line {

	private Sommet A,B;
	private DoubleBinding afficheStartXProperty,afficheStartYProperty;
	private DoubleBinding afficheEndXProperty,afficheEndYProperty;
	public Arete(Sommet s,Sommet t) {
		this.A=s;
		this.B=t;
		this.A.incrementerDegre();
		this.B.incrementerDegre();
		this.A.ajouterArete(this);
		this.B.ajouterArete(this);
		
		this.afficheStartXProperty=new AreteBinding(s,t,'X');
		this.afficheStartYProperty=new AreteBinding(s,t,'Y');
		this.afficheEndXProperty=new AreteBinding(t,s,'X');
		this.afficheEndYProperty=new AreteBinding(t,s,'Y');
		
		
		
	}
	
	
	public void dessiner(Pane p) {
		
			this.startXProperty().bind(afficheStartXProperty);
			this.startYProperty().bind(afficheStartYProperty);
			this.endXProperty().bind(afficheEndXProperty);
			this.endYProperty().bind(afficheEndYProperty);
			p.getChildren().add(this);
			
	}
}
