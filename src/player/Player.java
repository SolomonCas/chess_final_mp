package player;

import piece.*;
import java.util.*;
import board.*;
/**This is the class for representing the players and its pieces
 * */
public class Player {
	private int num;
	private String strColor;
	private Mouse mouse;
	private Cat cat;
	private Wolf wolf;
	private Dog dog;
	private Leopard leopard;
	private Tiger tiger;
	private Lion lion;
	private Elephant elephant;
	
	/** This is to initialize the color for each player
	 * @param The color of the player*/
	public Player(String color)
	{
		num = 8;
		strColor = color;
		mouse = new Mouse (color);
		cat = new Cat (color);
		wolf = new Wolf (color);
		dog = new Dog (color);
		leopard = new Leopard (color);
		tiger = new Tiger (color);
		lion = new Lion (color);
		elephant = new Elephant (color);
	}
	
	/**This is the arraylist of piece that the player has.
	 * @return This returns the pieces of the player*/
	public ArrayList<Piece> getPieces()
	{
		ArrayList<Piece> pieces = new ArrayList<> ();
		pieces.add(mouse);
		pieces.add(cat);
		pieces.add(wolf);
		pieces.add(dog);
		pieces.add(leopard);
		pieces.add(tiger);
		pieces.add(lion);
		pieces.add(elephant);
		
		return pieces;
	}
	/** This is to set the piece to the tile after checking if it is valid
	 * @param This is the piece that is going to move
	 * @param This is the tile the piece that is moving to*/
	public void setTile(Piece piece, Tile tile)
	{
		if(piece.equals(mouse))
			mouse.setCurrentTile(tile);
		else if(piece.equals(cat))
			cat.setCurrentTile(tile);
		else if(piece.equals(wolf))
			wolf.setCurrentTile(tile);
		else if(piece.equals(dog))
			dog.setCurrentTile(tile);
		else if(piece.equals(leopard))
			leopard.setCurrentTile(tile);
		else if(piece.equals(tiger))
			tiger.setCurrentTile(tile);
		else if(piece.equals(lion))
			lion.setCurrentTile(tile);
		else if(piece.equals(elephant))
			elephant.setCurrentTile(tile);
	}
	/**The getters for the attributes.
	 * */
	public String getColor()
	{
		return strColor;
	}
	
	public Mouse getMouse()
	{
		return mouse;
	}
	
	public Cat getCat()
	{
		return cat;
	}
	
	public Wolf getWolf()
	{
		return wolf;
	}
	
	public Dog getDog()
	{
		return dog;
	}
	
	public Leopard getLeopard()
	{
		return leopard;
	}
	
	public Tiger getTiger()
	{
		return tiger;
	}
	
	public Lion getLion()
	{
		return lion;
	}
	
	public Elephant getElephant()
	{
		return elephant;
	}
	
	public int getNum()
	{
		return num;
	}
	
	@Override
	public String toString()
	{
		return strColor + " Team";
	}
	
	
	
}
