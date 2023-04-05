package terrain;
/** This class represents the animal den in the board
 * */
public class AnimalDen extends Terrain{

	private String strColor;
	private boolean bIsCaptured;
/** This initializes the animal den on the board
 *  @param This contains the name of the den
 *  @param This contains the color of the den*/	
	public AnimalDen(String name, String color) {
		super(name);
		strColor = color;
		bIsCaptured = false;
	}
	/**Both are getters for the attribute of the class
	 * */
	public String getTeamColor() {
		return strColor;
	}
	
	public boolean getIsCaptured() {
		return bIsCaptured;
	}
	/** This is the setter for the IsCaptured 
	 * @param The boolean to set isCaptured to.
	 * */
	public void setIsCaptured(boolean bIsCaptured) {
		this.bIsCaptured = bIsCaptured;
	}
	
	@Override
	public String toString()
	{
		return getName();
	}
	

}
