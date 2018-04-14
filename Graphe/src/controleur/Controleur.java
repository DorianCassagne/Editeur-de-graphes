package controleur;

import java.net.URL;
import java.util.ResourceBundle;

import app.Arete;
import app.Graphe;
import app.Sommet;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.input.MouseEvent;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;


public class Controleur implements Initializable {

	@FXML
	private Pane feuilleDessin;
	
    private Graphe graphe;
  
    boolean creaSommet,creaArete;
	
    private StackPane[] select;
    
	@FXML
	private void creationSommet(ActionEvent event) {
		this.creaSommet=true;
		this.creaArete=false;
	}
	
	@FXML
	private void dessinSommet(MouseEvent me) {
		if(this.creaSommet) {
			
			int n=this.graphe.nbreSommets();
			Sommet s=new Sommet(String.valueOf(n));
			s.setCoord(me.getX()-s.getRadius(),me.getY()-s.getRadius());
			this.graphe.ajouterSommet(s);
			StackPane stack=s.getStack();
			
			stack.setOnMouseDragged(event->{
				this.creaSommet=false;
				double nouveauX=event.getX()+stack.getTranslateX()-s.getRadius();
				double nouveauY=event.getY()+stack.getTranslateY()-s.getRadius();
				s.setCoord(nouveauX, nouveauY);
			});
			
			stack.setOnMouseClicked(event->{
				dessinArete(event);
			});
			
			this.feuilleDessin.getChildren().add(stack);
		}
	}
	
	@FXML
	private void creationArete(ActionEvent event) {
		this.creaArete=true;
		this.creaSommet=false;
	}
	

	private void dessinArete(MouseEvent event) {
		if(this.creaArete) {
			select[0]=(StackPane) event.getSource();
			creaArete=false;
		}
		else select[1]=(StackPane) event.getSource();
		if(select[0]!=null && select[1]!=null) {
			Sommet s1=(Sommet) select[0].getChildren().get(0);
			Sommet s2=(Sommet) select[1].getChildren().get(0);
				Arete a=new Arete(s1,s2);
				this.graphe.ajouterArete(a);
				a.dessiner(this.feuilleDessin);
				creaArete=true;
				select[0]=null;
				select[1]=null;
			}
		
	}
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		this.graphe=new Graphe();
		this.select=new StackPane[2];
		
	}
	
}
