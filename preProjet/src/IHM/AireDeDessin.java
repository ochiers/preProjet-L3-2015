package IHM;

import java.awt.*;
import javax.swing.*;

class AireDeDessin extends JComponent {
    String message;
    Point center = null;
    int x,y;

    public AireDeDessin() {
        message = new String("Gaufre Empoisonnée");
        x=7;
        y=5;
    }

    public void paintComponent(Graphics g) {
    	Graphics2D drawable = (Graphics2D) g;

        int width = getSize().width;
        int height = getSize().height;

        if (center == null) {
            center = new Point(width/2, height/2);
        }
        int ray = 50;

        drawable.setPaint(Color.white);
        drawable.fillRect(0, 0, width, height);
        drawable.setPaint(Color.black);

        drawable.drawString(message, 00, 10);
        dessinGrille(drawable);
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
}