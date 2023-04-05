package piece;

import board.*;
import terrain.AnimalDen;
import terrain.Terrain;

public class Tiger extends Piece{

	public Tiger(String color) {
		super("Tiger", color, 6);
		
	}
	
	@Override
	/**This is to check if the move is possible 
	 * @param The tile that piece wants to move to
	 * @param The state of the board is in
	 * */
	public boolean canMove(Tile tile, Board board)
	{
		int nXCoord = tile.getLocation().getXCoordinate();
		int nYCoord = tile.getLocation().getYCoordinate();
		
		int nCurrentXCoord = currentTile.getLocation().getXCoordinate();
		int nCurrentYCoord = currentTile.getLocation().getYCoordinate();		
		
		int nXDiff = nXCoord - nCurrentXCoord;
		int nYDiff = nYCoord - nCurrentYCoord;
		int nAbsXDiff = Math.abs(nXDiff);
		int nAbsYDiff = Math.abs(nYDiff);
		

		
		if(nAbsXDiff == nAbsYDiff)
		{
			return false;
		}
		else if((nAbsXDiff == 2 || nAbsXDiff > 3) && (nAbsYDiff >=0))
		{
			return false;
		}
		else if(nAbsXDiff == 3 && nAbsYDiff > 0)
		{
			return false;
		}
		else if((nAbsYDiff == 2 || nAbsYDiff > 4) && (nAbsXDiff >= 0))
		{
			return false;
		}
		else if(nAbsYDiff == 4 && nAbsXDiff > 0)
		{
			return false;
		}
		else if(nAbsXDiff == 3)
		{
			int i = 1;
			Tile piece = null;
			
			do 
			{
				if(nXDiff > 0)
				{
					piece = board.getTile(nCurrentXCoord + i, nCurrentYCoord);
				}
				else if(nXDiff < 0)
				{
					piece = board.getTile(nCurrentXCoord - i, nCurrentYCoord);
				}
				
				if(piece.getTerrain() == null)
				{
					return false;
				}
				else if(piece.getTerrain() != null && 
						piece.getTerrain().getName().equals("Water") && piece.getIsOccupied())
				{
					return false;
				}
				i++;
			} while(i < 3);
						
		}
		else if(nAbsYDiff == 4)
		{
			int i = 1;
			Tile piece = null;
			do 
			{	
				if(nYDiff > 0)
				{
					piece = board.getTile(nCurrentXCoord, nCurrentYCoord + i);
				}
				else if(nYDiff < 0)
				{
					piece = board.getTile(nCurrentXCoord, nCurrentYCoord - i);
				}
				
				if(piece.getTerrain() == null)
				{
					return false;
				}
				else if(piece.getTerrain() != null && 
						piece.getTerrain().getName().equals("Water") && piece.getIsOccupied())
				{
					return false;
				}
				i++;
			} while(i < 4);
				
		}
		else if(nAbsXDiff > 1 && (nAbsYDiff >= 0))
		{
			return false;
		}
		else if((nAbsXDiff >= 0) && nAbsYDiff > 1)
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
		else if(tile.getIsOccupied())
		{
			Piece piece = tile.getCurrentPiece();
			if(piece.getRank() > nRank || piece.getColor().equals(getColor()))
				return false;
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
			nRank = 6;
		
	}

}
