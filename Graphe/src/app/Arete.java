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
		this.afficheStartXProperty=new DoubleBinding() {
			{
			bind(s.centerXProperty(),s.radiusProperty(),s.centerYProperty(),
					t.centerXProperty(),t.centerYProperty(),t.radiusProperty());
			}
			@Override
			protected double computeValue() {
				double sx=s.centerXProperty().getValue();
				double sy=s.centerYProperty().getValue();
				double sr=s.radiusProperty().getValue();
				double tx=t.centerXProperty().getValue();
				double ty=t.centerYProperty().getValue();
				double norme=Math.sqrt(Math.pow(sx-tx,2)+Math.pow(sy-ty, 2));
				return sx+sr*(tx-sx)/norme+sr;
			}
			
		};
		this.afficheStartYProperty=new DoubleBinding() {

			{
				bind(s.centerXProperty(),s.radiusProperty(),s.centerYProperty(),
						t.centerXProperty(),t.centerYProperty(),t.radiusProperty());
				}
			@Override
			protected double computeValue() {
			
				double sx=s.centerXProperty().getValue();
				double sy=s.centerYProperty().getValue();
				double sr=s.radiusProperty().getValue();
				double tx=t.centerXProperty().getValue();
				double ty=t.centerYProperty().getValue();
				double norme=Math.sqrt(Math.pow(sx-tx,2)+Math.pow(sy-ty, 2));
				return sy+sr*(ty-sy)/norme+sr;
			}
			
		};
		
		this.afficheEndXProperty=new DoubleBinding() {
			{
			bind(s.centerXProperty(),s.radiusProperty(),s.centerYProperty(),
					t.centerXProperty(),t.centerYProperty(),t.radiusProperty());
			}
			@Override
			protected double computeValue() {
				double sx=s.centerXProperty().getValue();
				double sy=s.centerYProperty().getValue();
				double sr=s.radiusProperty().getValue();
				double tx=t.centerXProperty().getValue();
				double ty=t.centerYProperty().getValue();
				double norme=Math.sqrt(Math.pow(sx-tx,2)+Math.pow(sy-ty, 2));
				return tx-sr*(tx-sx)/norme+sr;
			}
			
		};
		this.afficheEndYProperty=new DoubleBinding() {

			{
				bind(s.centerXProperty(),s.radiusProperty(),s.centerYProperty(),
						t.centerXProperty(),t.centerYProperty(),t.radiusProperty());
				}
			@Override
			protected double computeValue() {
			
				double sx=s.centerXProperty().getValue();
				double sy=s.centerYProperty().getValue();
				double sr=s.radiusProperty().getValue();
				double tx=t.centerXProperty().getValue();
				double ty=t.centerYProperty().getValue();
				double norme=Math.sqrt(Math.pow(sx-tx,2)+Math.pow(sy-ty, 2));
				return ty-sr*(ty-sy)/norme+sr;
			}
			
		};
	}
	
	
	public void dessiner(Pane p) {
		
			/*this.startXProperty().bind(this.A.centerXProperty().add(this.A.radiusProperty()));
			
			this.startYProperty().bind(this.A.centerYProperty().add(this.A.radiusProperty()));
					
			this.endXProperty().bind(this.B.centerXProperty().add(this.A.radiusProperty()));
					
			this.endYProperty().bind(this.B.centerYProperty().add(this.A.radiusProperty()));*/
			
			//pour essayer de ne pas dessiner la partie de l'arête qui intersecte le sommet
			//ça ne marche pas
			this.startXProperty().bind(afficheStartXProperty);
			this.startYProperty().bind(afficheStartYProperty);
			this.endXProperty().bind(afficheEndXProperty);
			this.endYProperty().bind(afficheEndYProperty);
			p.getChildren().add(this);
			
	}
}
