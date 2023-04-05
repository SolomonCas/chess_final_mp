package piece;

import board.Board;
import board.Tile;
import terrain.AnimalDen;
import terrain.Terrain;

public class Elephant extends Piece{
	/**Initializing the color and the name of the piece with the rank
	 * @param the color of the piece
	 * */
	public Elephant(String color) {
		super("Elephant", color, 8);
		
	}
	@Override
	/**This is to check if the move is possible 
	 * @param The tile that piece wants to move to
	 * @param The state of the board is in
	 * */
	public boolean canMove (Tile tile, Board board)
	{
		int nXCoord = tile.getLocation().getXCoordinate();
		int nYCoord = tile.getLocation().getYCoordinate();
		
		int nXDiff = Math.abs(currentTile.getLocation().getXCoordinate() - nXCoord);
		int nYDiff = Math.abs(currentTile.getLocation().getYCoordinate() - nYCoord);
		
		
		if(nXDiff == nYDiff)
		{
			return false;
		}
		if(nXDiff > 1 && (nYDiff >= 0))
		{
			System.out.println("" + 5);
			return false;
		}
		else if((nXDiff >= 0) && nYDiff > 1)
		{
			return false;
		}
		
		if(tile.getTerrain() != null)
		{
			Terrain terrain = tile.getTerrain();
			if(terrain.getName().equals("Water"))
			{
				return false;
			}
			if(terrain instanceof AnimalDen && 
					((AnimalDen) terrain).getTeamColor().equals(getColor()))
			{
				return false;
			}
		}
		if(tile.getIsOccupied())
		{
			Piece piece = tile.getCurrentPiece();
			if(piece.getColor().equals(getColor()) || 
					piece.getRank() > nRank || (piece.getName().equals("Mouse") && piece.getRank() != 0))
			{
				return false;
			}
		}
		
		return true;
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
			nRank = 8;
		
	}
}
