package Assignment1;

import java.awt.Image;
import javax.swing.ImageIcon;

/**This class contains all parameters and methods asociated with a specific tile, of which there are many in a single map instance*/
public class Tile {
	private int type; /**Indicates the whether the tile is 1:scenery, 2:path, 3:tower*/ 
	private int[] coordinates; /**Holds the coordinates of the tile*/
	private Image tileImage; /**Holds the image corresponding to the tile type*/
	private Tile next; /**Holds the next tile which this current tile is connected to*/
	private boolean isStart=false; /**Is true if the tile is assigned as the starting tile*/
	private boolean isEnd=false; /**Is true if the tile is assigned as the end tile*/
	
	
	/**Sets the tile type, the coordinates of the tile and the corresponding tile image*/
	public Tile(int type, int x, int y) {
		this.type=type;
		this.coordinates= new int[2];
		this.coordinates[0]=x;
		this.coordinates[1]=y;
		if(type==1){
			tileImage= new ImageIcon(this.getClass().getResource("scenery.png")).getImage();
		}
		else if(type==2){
			tileImage= new ImageIcon(this.getClass().getResource("path.png")).getImage();
		}
		else if(type==3){
			tileImage= new ImageIcon(this.getClass().getResource("tower.png")).getImage();
		}
	}
	
	/**Returns the x coordinate of the tile*/
	public int getXcoord(){
		return this.coordinates[0];
	}
	
	/**Returns the y coordinate of the tile*/
	public int getYcoord(){
		return this.coordinates[1];
	}
	
	/**Returns the tile type*/
	public int tileType(){
		return this.type;
	}
	
	/**Returns the tile image*/
	public Image getTileImage(){
		return tileImage;
	}
	
	/**Returns the next tile in the path, relevant only if tile is of type path*/
	public Tile getNext(){
		return this.next;
	}
	
	/**Sets the next tile in the path to the provided tile, relevant only if tile is of type path*/
	public void setNext(Tile next){
		this.next=next;
	}
	
	/**Assigns this tile as the starting tile of the map*/
	public void setStart(){
		this.isStart=true;
	}
	
	/**Assigns this tile as the end tile of the map*/
	public void setEnd(){
		this.isEnd=true;
	}
	
	/**Returns true if the tile is a start tile*/
	public boolean getStart(){
		return this.isStart;
	}
	
	/**Return true if the tile is an end tile*/
	public boolean getEnd(){
		return this.isEnd;
	}

}
