package location;

/**
 * Object serves as the x and y coordinates of the tiles, the pieces,
 * and the terrains
 * 
 */
public class Location {
	private int xCoordinate;
	private int yCoordinate;
	/**This is the constructor to initialize the location
	 * @param This is the x coordinate
	 * @param This is the y coordinate
	 * */
	public Location(int x, int y) {
		this.xCoordinate = x;
		this.yCoordinate = y;
	}
	/**This is the getter for the x coordinate
	 *@return This returns the x coordinate */
	public int getXCoordinate() {
		return this.xCoordinate;
	}
	/**This is the getter for the y coordinate
	 *@return This returns the y coordinate */
	public int getYCoordinate() {
		return this.yCoordinate;
	}
	
	/**
	 * Checking if 2 objects has the same x and y coordinates
	 */
	@Override
	public boolean equals(Object obj)
	{
		if(obj != null)
		{
			Location otherObj = (Location) obj;
			return otherObj.getXCoordinate() == this.xCoordinate 
					&& otherObj.getYCoordinate() == this.yCoordinate;
		}
		return false;
	}
	
	@Override
	public String toString()
	{
		return "( " + this.xCoordinate +", " + this.yCoordinate + " )";
	}
	
}
