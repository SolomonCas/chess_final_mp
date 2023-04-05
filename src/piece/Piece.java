package piece;

import board.*;
import terrain.*;
/**This class represents the piece on the board
 * */
public abstract class Piece {
	protected Tile currentTile;
	private String strName;
	private String strColor;
	protected int nRank;
	private boolean bIsAlive;
	/** This initialize the every piece on the board
	 * @param This string contains the name of the piece
	 * @param This string contains the color for that piece
	 * @param This has the rank for the piece. 
	 * */
	public Piece(String name, String color, int rank)
	{
		strName = name;
		strColor = color;
		nRank = rank;
		bIsAlive = true;
		currentTile = null;
	}
	/**This checks if the current piece can move to the wanted position
	 * @param The tile from where the piece is going to
	 * @param The board itself
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
			System.out.println("" + 5.1);
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
					((AnimalDen) terrain).getTeamColor().equals(strColor))
			{
				return false;
			}
		}
		if(tile.getIsOccupied())
		{
			Piece piece = tile.getCurrentPiece();
			if(piece.getRank() > nRank || piece.getColor().equals(strColor))
				return false;
		}
		
		return true;
	}
	/**The getters for the attributes
	 * */
	public String getName() {
		return strName;
	}

	public String getColor() {
		return strColor;
	}

	public int getRank() {
		return nRank;
	}

	public boolean getIsAlive() {
		return bIsAlive;
	}

	public Tile getCurrentTile() {
		return currentTile;
	}
	
	/**The setter for the IsAlive
	 * @param The boolean to set isalive to
	 * */
	public void setIsAlive(boolean bIsAlive) {
		this.bIsAlive = bIsAlive;
	}

	/**Abstract method because of the trap specification, this is to check if the current 
	 * @param The current location of the piece
	 * */
	public abstract void setCurrentTile(Tile currentLocation);
	

	
	@Override
	public String toString()
	{
		String animal;
		if(strName.equals("Leopard"))
			animal = "Leo";
		else
			animal = strName.charAt(0) + "";
		
		if(strColor != null)
			return strColor.charAt(0) + animal;
		
		return strName;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(obj != null)
		{
			Piece otherobj = (Piece) obj;
			return otherobj.toString().equals(this.toString());
		}
		
		return false;
	}
}
