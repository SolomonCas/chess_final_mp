package piece;

import board.Tile;

public class Wolf extends Piece{
	/**Initializing the color and the name of the piece with the rank
	 * @param the color of the piece
	 * */
	public Wolf(String color) {
		super("Wolf", color, 3);
		
	}
	/** This is to check if the location of the piece is in the tile with a name trap and setting the piece to the current tile
	 * @param The location of the current location of piece
	 * */
	public void setCurrentTile(Tile currentLocation)
	{
		currentTile = currentLocation;
		if(currentLocation.getTerrain() != null && 
				currentLocation.getTerrain().getName().equals("Trap"))
			nRank = 0;
		else
			nRank = 3;
		
	}

}
