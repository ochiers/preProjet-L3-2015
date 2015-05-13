package IHM;

import java.awt.*;

import javax.swing.*;

class AireDeDessin extends JComponent {
    int x,y;
    FenetreV2 fenetre;

    
    public AireDeDessin(FenetreV2 f,int largeur,int hauteur) {
        x=largeur;
        y=hauteur;
        fenetre=f;
       setPreferredSize(new Dimension(500,500));     
    }

    public void paintComponent(Graphics g) {
    	Graphics2D drawable = (Graphics2D) g;

        int width = getSize().width;
        int height = getSize().height;

        drawable.setPaint(Color.white);
        drawable.fillRect(0, 0, width, height);
        drawable.setPaint(Color.black);
        if(fenetre.e.partieCourante.winner == null)
        	afficherJoueur(drawable);
        else{
        	afficherGagnant(drawable);
        }
        dessinGrilleCouleur(drawable);
        dessinGrille(drawable);

    }
    
    public void afficherJoueur(Graphics2D drawable){
    	String message="C'est au tour de "+fenetre.e.partieCourante.joueurCourant.name+" de jouer";
    	drawable.drawString(message, 10, 20);
    	
    }
    
    public void afficherGagnant(Graphics2D drawable){
    	String message=fenetre.e.partieCourante.joueurCourant.name+" a gagné";
    	drawable.drawString(message, 10, 20);
    }

    public void dessinGrilleCouleur(Graphics2D drawable){
    	int width = getSize().width;
        int height = getSize().height;
        drawable.setPaint(Color.magenta);
        int x2=x+2;
        int y2=y+2;
        int max= (x2<y2?y2:x2);
        Point p1=new Point();
        Point p=new Point();
        for(int i=0;i<x;i++){
        	for(int j=0;j<y;j++){
	        	p1.x=(width/max)*((max-x)/2)+(width/max)*i;
	        	p1.y=(height/max)*((max-y)/2)+(height/max)*j;
	        	p=conversionGrille(p1.x,p1.y);
	        	if(p.x!=-1 && p.y!=-1){
		        	if(fenetre.e.partieCourante.map.grille[p.x][p.y]==0){
		        		drawable.setPaint(Color.magenta);
		        		drawable.fillRect(p1.x, p1.y, (width/max), (height/max));
		        	}
		        	else{
		        		if(fenetre.e.partieCourante.map.grille[p.x][p.y]==2){
		        			drawable.setPaint(Color.white);
		        			drawable.fillRect(p1.x, p1.y, (width/max), (height/max));
		        		}
		        		else{
		        			drawable.setPaint(Color.orange);
		        			drawable.fillRect(p1.x, p1.y, (width/max), (height/max));
		        		}
		        	}
	        	}
        	}
        }
    }
    
    public void dessinGrille(Graphics2D drawable){
    	int width = getSize().width;
        int height = getSize().height;
        drawable.setPaint(Color.black);
        int x2=x+2;
        int y2=y+2;
        int max= (x2<y2?y2:x2);
        Point p1=new Point();
        Point p2=new Point();
        for(int i=0;i<(x+1);i++){
        	p1.x=(width/max)*((max-x)/2)+(width/max)*i;
        	p1.y=(height/max)*((max-y)/2);
        	p2.x=(width/max)*((max-x)/2)+(width/max)*i;
        	p2.y=(height/max)*((max-y)/2)+(height/max)*y;
        	drawable.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
        for(int i=0;i<(y+1);i++){
        	p1.x=(width/max)*((max-x)/2);
        	p1.y=(height/max)*((max-y)/2)+(height/max)*i;
        	p2.x=(width/max)*((max-x)/2)+(width/max)*x;
        	p2.y=(height/max)*((max-y)/2)+(height/max)*i;
        	drawable.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    
    }
    
    public Point conversionGrille(int px,int py){
		Point p=new Point();
		int width = getSize().width;
        int height = getSize().height;
        int x2=x+2;
        int y2=y+2;
        int max= (x2<y2?y2:x2);
        int tailleCaseX=width/max;
        int xmin=(max-x)/2 * tailleCaseX;
        int xmax=width-((max-x)/2 * tailleCaseX);
        int tailleCaseY=height/max;
        int ymin=(max-y)/2 * tailleCaseY;
        int ymax=height-((max-y)/2 * tailleCaseY);
        if(px>=xmin && px<=xmax && py>=ymin && py<=ymax ){
        	p.x=(px/tailleCaseX)-((max-x)/2);
        	p.y=(py/tailleCaseY)-((max-y)/2);
        }
        else{
        	p=new Point(-1,-1);
        }
        return p;
	}
    
}
