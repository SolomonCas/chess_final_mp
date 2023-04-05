package piece;

import board.*;
import terrain.*;

public class Mouse extends Piece{

	public Mouse(String color) {
		super("Mouse", color, 1);
		
	}
	
	@Override
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
			return false;
		}
		else if((nXDiff >= 0) && nYDiff > 1)
		{
			return false;
		}
		
		if(tile.getTerrain() != null)
		{
			Terrain terrain = tile.getTerrain();
			if(terrain instanceof AnimalDen && 
					((AnimalDen) terrain).getTeamColor().equals(getColor()))
			{
				
				return false;
			}
			else if(currentTile.getTerrain() == null && 
					terrain.getName().equals("Water") && tile.getIsOccupied())
			{
				return false;
			}
		}
		
		
		if(tile.getIsOccupied())
		{
			Piece piece = tile.getCurrentPiece();
			if(piece.getColor().equals(getColor()) || 
					(piece.getRank() > nRank && !(piece.getName().equals("Elephant"))))
			{
				return false;
			}
			if(currentTile.getTerrain() != null && 
					currentTile.getTerrain().getName().equals("Water") && !piece.getName().equals("Mouse"))
			{
				return false;
			}
		}
		
		return true;
	}
	
	
	public void setCurrentTile(Tile currentLocation)
	{
		currentTile = currentLocation;
		if(currentLocation.getTerrain() != null && 
				currentLocation.getTerrain().getName().equals("Trap"))
			nRank = 0;
		else
			nRank = 1;
		
	}
}
