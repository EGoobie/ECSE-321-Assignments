package Assignment1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**This class runs the graphics for the map. It redraws the map tile by tile*/
public class Display extends JPanel implements Runnable{

	private int posX, posY;
	private int tileWidth= 75;
	private Map map;

	public Display(Map map) {
	    this.map = map;
	    setBackground(Color.BLACK);
	    setDoubleBuffered(true);
	}

	public void paint(Graphics g){
	    super.paint(g);

	    Graphics2D g2d = (Graphics2D)g;

	    posX = 0;
	    posY = 0;
	      
	    for(int i=0; i<map.getHeight(); i++){
	    	for(int j=0; j<map.getWidth(); j++){
	           g2d.drawImage(map.getTile(j,i).getTileImage(), posX, posY, this);
	           posX += tileWidth;
	        } 
	        posX = 0;
	        posY += tileWidth;
	    }
	           
	    Toolkit.getDefaultToolkit().sync();
	    g.dispose();
	}

	public void run() {
		while(true){
			repaint();
	    }    
	}
	
}
