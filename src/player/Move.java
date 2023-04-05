package player;

import board.*;
/** This is class is to know which way the piece is moving to. 
 * */
public class Move {
	private Tile currentPos;
	private Tile finalPos;
	/**This is the getter for currentPos
	 * @return This returns currentPos of the tile*/
	public Tile getCurrentPos() {
		return currentPos;
	}
	/** This is the setter for the currentPos
	 * @param This is the first piece that is clicked by the player
	 * */
	public void setCurrentPos(Tile currentPos) {
		this.currentPos = currentPos;
	}
	/**The getter for the finalPos
	 * @return This returns the finalPos of the piece*/
	public Tile getFinalPos() {
		return finalPos;
	}
	/** This is the setter for the finalPos
	 * @param This is the tile that is last clicked by the player
	 * */
	public void setFinalPos(Tile finalPos) {
		this.finalPos = finalPos;
	}
	
	@Override
	public String toString()
	{
		return currentPos.getLocation() + ", " + finalPos.getLocation();
	}
}
