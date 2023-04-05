package board;

import location.Location;
import piece.Piece;
import terrain.*;
/**
 * This represents every tile on the board and that piece and terrain that is on the tile.
 * */
public class Tile {
	private Location location;
	private boolean bIsOccupied;
	private Piece currentPiece;
	private Terrain terrain;
	/** This initiates the coordinate for every tile that is not used. 
	 * @param The x coordinate of the tile. 
	 * @param The y coordinate of the tile. */
	public Tile(int x, int y) {
		location = new Location (x, y);
	}
	/** This is to initialize the tile for the different pieces on the board
	 * @param This is the x coordinate of the tile 
	 * @param This is the y coordinate of the tile 
	 * @param This is the piece that is supposed to be in the tile */
	public Tile(int x, int y, Piece piece){
		location = new Location (x, y);
		this.setCurrentPiece(piece);
		bIsOccupied = true;
	}
	/**This is the initialize the terrains (e.g den, trap, water)
	 * @param This is the x coordinate of the tile 
	 * @param This is the y coordinate of the tile 
	 * @param This is the piece of the terrain */
	public Tile(int x, int y, Terrain piece){
		location = new Location (x, y);
		this.setTerrain(piece);
	}
	/** This empties the piece and makes the isOccupied to false
	 */
	public void reset()
	{
		this.bIsOccupied = false;
		this.currentPiece = null;
	}
	/**This is the getter for location.
	 * @return The location of the current piece is returned*/
	public Location getLocation() {
		return location;
	}
	/**This is the setter of the location 
	 *@param The location of the said tile. */
	public void setLocation(Location location) {
		this.location = location;
	}
	/** The getter of IsOccupied
	 *@return This returns if the tile is occupied */
	public boolean getIsOccupied() {
		return bIsOccupied;
	}
	/**The setter for IsOccupied 
	 * @param The value of the occupied tile.*/
	public void setIsOccupied(boolean bIsOccupied) {
		this.bIsOccupied = bIsOccupied;
	}
	/**The getter of the currentPiece
	 * @return The piece that is on the tile*/
	public Piece getCurrentPiece() {
		return currentPiece;
	}
	/**The setter for the currentPiece
	 * @param The piece that is set on the tile.*/
	public void setCurrentPiece(Piece currentPiece) {
		this.currentPiece = currentPiece;
		setIsOccupied(true);
	}
	/**The getter of the current terrain on the tile 
	 * @return The terrain that is on the tile*/
	public Terrain getTerrain() {
		return terrain;
	}
	/** The setter for the terrain 
	 * @param The terrain that is needed to be set on the tile */
	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}
	
	/**Compares if the two tile have the same location.
	 * */
	
	@Override
	public boolean equals(Object obj)
	{
		if(obj != null)
		{
			Tile otherobj = (Tile) obj;
			return otherobj.getLocation().equals(this.getLocation());
		}
		
		return false;
	}
}
