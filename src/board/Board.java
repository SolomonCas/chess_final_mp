package board;



import location.*;
import piece.Piece;
import player.*;
import terrain.*;
/**This represents that whole board and if there is winner or not. 
 * */


public class Board {
	private int maxXCoords = 7;
	private int maxYCoords = 9;
	private Player teamOne;
	private Player teamTwo;
	private Tile[][] tiles;
	private Terrain animalDen;
	private Terrain animalDen1;
	private int nTurn;
	/**Initializes the board and its pieces and terrains. 
	  @param player1 - This is the player 1.
	  @param player2 - This is the player 2.
	  */
	public Board (Player player1, Player player2)
	{
		nTurn = 1;
		teamOne = player1;
		teamTwo = player2;
		Terrain waters = new Terrain("Water");
		Terrain trap = new Terrain("Trap");
		animalDen = new AnimalDen("Den", teamOne.getColor());
		animalDen1 = new AnimalDen("Den", teamTwo.getColor());
		tiles = new Tile[maxXCoords][maxYCoords];
		
		tiles[0][0] = new Tile(0, 0, teamOne.getTiger());
		teamOne.getTiger().setCurrentTile(new Tile(0,0));
		
		tiles[0][2] = new Tile(0, 2, teamOne.getElephant());
		teamOne.getElephant().setCurrentTile(new Tile(0,2));
		
		tiles[1][1] = new Tile(1, 1, teamOne.getCat());
		teamOne.getCat().setCurrentTile(new Tile(1,1));
		
		tiles[2][2] = new Tile(2, 2, teamOne.getWolf());
		teamOne.getWolf().setCurrentTile(new Tile(2,2));
		
		tiles[4][2] = new Tile(4, 2, teamOne.getLeopard());
		teamOne.getLeopard().setCurrentTile(new Tile(4,2));
		
		tiles[5][1] = new Tile(5, 1, teamOne.getDog());
		teamOne.getDog().setCurrentTile(new Tile(5,1));
		
		tiles[6][0] = new Tile(6, 0, teamOne.getLion());
		teamOne.getLion().setCurrentTile(new Tile(6,0));
		
		tiles[6][2] = new Tile(6, 2, teamOne.getMouse());
		teamOne.getMouse().setCurrentTile(new Tile(6,2));
		
		
		tiles[0][8] = new Tile(0, 8, teamTwo.getLion());
		teamTwo.getLion().setCurrentTile(new Tile(0,8));
		
		tiles[0][6] = new Tile(0, 6, teamTwo.getMouse());
		teamTwo.getMouse().setCurrentTile(new Tile(0,6));
		
		tiles[1][7] = new Tile(1, 7, teamTwo.getDog());
		teamTwo.getDog().setCurrentTile(new Tile(1,7));
		
		tiles[2][6] = new Tile(2, 6, teamTwo.getLeopard());
		teamTwo.getLeopard().setCurrentTile(new Tile(2,6));
		
		tiles[4][6] = new Tile(4, 6, teamTwo.getWolf());
		teamTwo.getWolf().setCurrentTile(new Tile(4,6));
		
		tiles[5][7] = new Tile(5, 7, teamTwo.getCat());
		teamTwo.getCat().setCurrentTile(new Tile(5,7));
		
		tiles[6][6] = new Tile(6, 6, teamTwo.getElephant());
		teamTwo.getElephant().setCurrentTile(new Tile(6,6));
		
		tiles[6][8] = new Tile(6, 8, teamTwo.getTiger());
		teamTwo.getTiger().setCurrentTile(new Tile(6,8));
		
		tiles[1][3] = new Tile (1, 3, waters);
		tiles[1][4] = new Tile (1, 4, waters);
		tiles[1][5] = new Tile (1, 5, waters);
		tiles[2][3] = new Tile (2, 3, waters);
		tiles[2][4] = new Tile (2, 4, waters);
		tiles[2][5] = new Tile (2, 5, waters);
		tiles[4][3] = new Tile (4, 3, waters);
		tiles[4][4] = new Tile (4, 4, waters);
		tiles[4][5] = new Tile (4, 5, waters);
		tiles[5][3] = new Tile (5, 3, waters);
		tiles[5][4] = new Tile (5, 4, waters);
		tiles[5][5] = new Tile (5, 5, waters);
		
		tiles[3][0] = new Tile (3, 0, animalDen);
		tiles[3][8] = new Tile (3, 8, animalDen1);

		tiles[2][0] = new Tile (2, 0, trap);
		tiles[3][1] = new Tile (3, 1, trap);
		tiles[4][0] = new Tile (4, 0, trap);
		
		tiles[2][8] = new Tile (2, 8, trap);
		tiles[3][7] = new Tile (3, 7, trap);
		tiles[4][8] = new Tile (4, 8, trap);

		
		for(int i = 0; i < maxXCoords; i++)
			for(int j = 0; j < maxYCoords; j++)
				if(tiles[i][j] == null)
					tiles[i][j] = new Tile (i, j);		
	}
	/** This is for checking the win condition of both sides. If the den is captured or there are no more animals left.
	 */
	public boolean winningCondition()
	{
		int i, count;
		if((nTurn - 1) % 2 == 0)
		{
			if(((AnimalDen) animalDen).getIsCaptured())
			{
				return true;
			}
			else
			{
				count = 0;
				for(i = 0; i < teamOne.getPieces().size(); i++)
				{
					Piece piece = teamOne.getPieces().get(i);
					if(piece.getIsAlive())
						count++;
				}
				if(count == 0)
				{
					return true;
				}
			}
		}
		else
		{
			if(((AnimalDen) animalDen1).getIsCaptured())
			{
				return true;
			}
			else
			{
				count = 0;
				for(i = 0; i < teamTwo.getPieces().size(); i++)
				{
					Piece piece = teamTwo.getPieces().get(i);
					if(piece.getIsAlive())
						count++;
				}
				if(count == 0)
				{
					System.out.println("" + 4.1);
					return true;
				}
			}
		}
		return false;
	}
	/** This prints the winner of the game.
	 * @return This is returning which team is the winner.
	 */
	public String winner()
	{
		if((nTurn - 1) % 2 == 1)
		{
			return teamOne.toString() + " Wins";
		}
		
		return teamTwo.toString() + " Wins";	
	}
	/**This prints which turn is which for both players.
	 * @return This prints which turns is it for the players.
	 */
	public String whoseTurn()
	{
		if(nTurn % 2 == 1)
		{
			return teamOne.toString() + "'s turn";
		}
		else
			return teamTwo.toString() + "'s turn";
	}
	/** This is used to know which turn is which.
	 * @return This returns how many turns has already passed  for the ongoing game 
	 */
	public int getTurn()
	{
		return nTurn;
	}
	/** This is used to return the max X coordinates
	 *@return An int representing the max X coordinates */
	public int getMaxXCoords()
	{
		return maxXCoords;
	}
	/**This is used to return the max Y coordinates
	 *@return An int representing the max Y coordinates */
	public int getMaxYCoords()
	{
		return maxYCoords;
	}
	/** This is used to return which tile the coordinate is referring to.
	 * @param The x coordinate of the tile
	 * @param The y coordinate of the tile*/
	public Tile getTile(int x, int y)
	{
		return tiles[x][y];
	}
	/** This is used to get the tile by which "Location"
	 * @param The location of the tile. */
	public Tile getTile(Location loc)
	{
		return tiles[loc.getXCoordinate()][loc.getYCoordinate()];
	}
	/** This is used to return whole player.
	 * @return The player "1"*/
	public Player getTeamOne() {
		return teamOne;
	}
	/** This is to setTeamOne.
	 * @param This is for setting the teamOne for every turn. */
	public void setTeamOne(Player player)
	{
		teamOne = player;
	}
	/** This is a getter for TeamTwo
	 * @return The player "2"*/
	public Player getTeamTwo() {
		return teamTwo;
	}
	/** This is a setter to TeamTwo 
	 * @param This is to set player 2 */
	public void setTeamTwo(Player player)
	{
		teamTwo = player;
	}
	/** This increments the turn after each players is finished.  
	  */
	public void nextTurn()
	{
		nTurn++;
	}
		
	
}
