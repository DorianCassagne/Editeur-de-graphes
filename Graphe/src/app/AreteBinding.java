package app;

import javafx.beans.binding.DoubleBinding;

public class AreteBinding extends DoubleBinding {
	
	Sommet start,end;
	char xy;

	public AreteBinding(Sommet start,Sommet end,char xy) {
		this.start=start;
		this.end=end;
		this.xy=xy;
		bind(start.centerXProperty(),start.radiusProperty(),start.centerYProperty(),
				end.centerXProperty(),end.centerYProperty(),end.radiusProperty());
	}
	@Override
	protected double computeValue() {
		
		double sx=start.centerXProperty().getValue();
		double sy=start.centerYProperty().getValue();
		double sr=start.radiusProperty().getValue();
		double tx=end.centerXProperty().getValue();
		double ty=end.centerYProperty().getValue();
		double norme=Math.sqrt(Math.pow(sx-tx,2)+Math.pow(sy-ty, 2));
		if (this.xy=='X')return sx+sr*(tx-sx)/norme+sr;
		else return sy+sr*(ty-sy)/norme+sr;
		
	}

}
