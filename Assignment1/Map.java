package Assignment1;

/**This class contains all parameters and methods associated with a generated map instance*/
public class Map {
	private String name; /**name of the map*/
	private int width;	/**width in number of tiles of the map*/
	private int height; /**height in number of tiles of the map*/
	private Tile[][] tiles; /**2D array of tiles which comprise the total map*/
	private Tile start; /**the start tile*/
	private Tile end; /**the end tile*/
	
	/**Map constructor which sets the width, height, name and initialises a blank map with only scenery tiles*/
	public Map(String name, int width, int height) {
		this.width=width;
		this.height=height;
		this.name=name;
		
		initializeBlankMap();
		
	}
	
	/**Initialises a blank map comprised of only scenery tiles*/
	public void initializeBlankMap(){
		this.tiles=new Tile[width][height];
		for(int i=0; i<width; i++){
			for(int j=0; j<height; j++){
				this.tiles[i][j]= new Tile(1, i, j);
			}
		}
	}
	
	/**Returns the map width in tiles*/
	public int getWidth(){
		return this.width;
	}
	
	/**Returns the map height in tiles*/
	public int getHeight(){
		return this.height;
	}
	
	/**Returns the tile at specified coordinates of the map*/
	public Tile getTile(int x, int y){
		return this.tiles[x][y];
	}
	
	/**Sets the tile at specified coordinates of the map to a new tile*/
	public void setTile(Tile add, int x, int y){
		this.tiles[x][y]=add;
	}
	
	/**Returns the map's path starting tile*/
	public Tile getStart(){
		return this.start;
	}
	
	/**Sets the starting tile of the map's path to a specified tile*/
	public void setStart(Tile start){
		this.start=start;
	}
	
	/**Sets the end tile of the map's path to a specified tile*/
	public void setEnd(Tile end){
		this.end=end;
	}
	
	/**Returns true if the tile located at the specified coordinates is a path, false otherwise*/
	public boolean isPath(int x, int y){
		if(this.tiles[x][y].tileType()==2){
			return true;
		}
		else return false;
	}
	
	/**Returns true if the path contained by the map has a connected path from the starting tile to the end tile*/
	public boolean validPath(){
		int max=this.width*this.height;
		int count=0;
		Tile current= start;
		while(count<max){
			if(current.getNext().getEnd()){
				return true;
			}
			else current=current.getNext();
		}
		
		return false;
	}
}
