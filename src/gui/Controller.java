package gui;

import java.awt.event.*;

import javax.swing.*;

import board.*;
import location.*;
import player.*;
import piece.*;
import terrain.*;
/** This represents the controller of the GUI 
 * */
public class Controller implements ActionListener{
	private Board model;
	private Move move;
	private GUI view;
	private int isTurn;
	private Player p1;
	private Player p2;
	private Player nol;
	private Piece player1; 
	private Piece player2; 
	private boolean enabled;
	private String[] colors;
	/** This initializes the attributes in the class.
	 * */
	public Controller()
	{
		nol = new Player(null);
		colors = new String[2];
		colors[0] = "red";
		colors[1] = "blue";
		enabled = false;
		move = new Move();
		view = new GUI(7, 9);
		isTurn = 0;
		view.setActionListener(this);
		view.setButtonsEnable(enabled);
		updateView();
	}
	/** This updates the view of the gui everytime an action is made and also updates the view for the first time after picking which player goes first.
	 * */
	public void updateView()
	{
		int i, j;
		
		if(enabled)
		{
			view.setStatus(model.whoseTurn());
			for(i = 0; i < model.getMaxXCoords(); i++) 
			{
				for(j = 0; j < model.getMaxYCoords(); j++) 
				{
					if(model.getTile(i, j).getIsOccupied())
					{
						Piece piece = model.getTile(i, j).getCurrentPiece();
						view.setChessSquare(i, j, piece.toString(), piece.getColor());
					}
					else if(model.getTile(i, j).getTerrain() != null)
					{
						Terrain terrain = model.getTile(i, j).getTerrain();
						if(terrain.getName().equals("Water"))
							view.setChessSquare(i, j, terrain.toString(), "cyan");
						else if(terrain instanceof AnimalDen)
							view.setChessSquare(i, j, ((AnimalDen) terrain).toString(), ((AnimalDen) terrain).getTeamColor());
						else
							view.setChessSquare(i, j, terrain.toString(), "lightGray");
						
					}
					else
						view.setChessSquare(i, j, null, null);
				}
			}
			if(model.winningCondition())
			{
				view.setStatus(null);
				view.setTeamWon(model.winner());
				view.setButtonsEnable(false);
			}
		}
		
			
	}
	/** This checks if the button pressed is an animal or terrain or den.
	 *  @param e The action event that happened in the gui.
	 *  @return This returns if the button pressed is W, Den or T
	 *  */
	public boolean isBoard(ActionEvent e)
	{
		if(e.getActionCommand().equals("") || 
				e.getActionCommand().equals("W") || 
				e.getActionCommand().equals("Den") || 
				e.getActionCommand().equals("T"))
			return true;
		return false;	
	}
	/**This is the action performed for every button that is pressed in the GUI 
	 * @param The action event that happened in the gui.
	 *   */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand() != null && 
				!(isBoard(e)))
		{
			JFrame frame = new JFrame("Animal");
			if(isTurn == 0)
				view.setStartLabel("Player 1 : Choose a number");
			else
				view.setStartLabel("Player 2 : Choose a number");
			
			if (e.getActionCommand().equals("New")) 
			{
				view.setVisibility(false);
				view.startGame();
			}
			else if (e.getActionCommand().equals("Mouse")) 
			{
				if (isTurn == 0) {
					player1 = nol.getMouse();
				}else {
					player2 = nol.getMouse();
				}
			}
			else if (e.getActionCommand().equals("Cat")) 
			{
				if (isTurn == 0) {
					player1 = nol.getCat();
				}else {
					player2 = nol.getCat();
				}
			} 
			else if (e.getActionCommand().equals("Wolf")) 
			{
				if (isTurn == 0) {
					player1 = nol.getWolf();
				}else {
					player2 = nol.getWolf();
				}
			} 
			else if (e.getActionCommand().equals("Dog")) 
			{
				if (isTurn == 0) {
					player1 = nol.getDog();
				}
				else 
				{
					player2 = nol.getDog();
				}
			} 
			else if (e.getActionCommand().equals("Leopard")) 
			{
				if (isTurn == 0) 
				{
					player1 = nol.getLeopard();
				}
				else 
				{
					player2 = nol.getLeopard();
				}
			} 
			else if (e.getActionCommand().equals("Tiger")) 
			{
				if (isTurn == 0) 
				{
					player1 = nol.getTiger();
				}
				else 
				{
					player2 = nol.getTiger();
				}
			} 
			else if (e.getActionCommand().equals("Lion")) 
			{
				if (isTurn == 0) 
				{
					player1 = nol.getLion(); 
				}
				else 
				{
					player2 = nol.getLion(); 
				}
			} 
			else if (e.getActionCommand().equals("Elephant")) 
			{
				if (isTurn == 0) 
				{
					player1 = nol.getElephant();
				}
				else 
				{
					player2 = nol.getElephant();
				}
				
			} 
			
			if(isTurn == 0 && player1 != null)
			{
				isTurn++;
				JOptionPane.showMessageDialog(frame, "Animal : " + player1.toString());
			}
			else if(isTurn == 1 && player2 != null)
			{
				isTurn++;
				JOptionPane.showMessageDialog(frame, "Animal : " + player2.toString());
			}
			
			if (isTurn == 2 && e.getActionCommand().equals("Done")) 
			{
			
				String color = null;
				boolean bResult;
				if (player1.getRank() > player2.getRank()) 
				{
					
					do 
					{
						
						color = JOptionPane.showInputDialog(view.getStartPanel(),"Player 1 What color do you want? [Red or Blue]", null);
						
						if(color != null && !color.equalsIgnoreCase(colors[0]) && !color.equalsIgnoreCase(colors[1]))
							bResult = true;
						else
							bResult = false;
					} while(bResult);
					
					if(color != null && color.equalsIgnoreCase(colors[0]))
					{
						p1 = new Player(colors[0]);
						p2 = new Player(colors[1]);
					}
					else if(color != null && color.equalsIgnoreCase(colors[1]))
					{
						p1 = new Player(colors[1]);
						p2 = new Player(colors[0]);
					}
					isTurn = 0;
					player1 = null;
					player2 = null;
					model = new Board(p1, p2);
					enabled = true;
					view.setButtonsEnable(enabled);
					view.setVisibilityFalse();
					view.setVisibility(true);
					updateView();
				}
				else if (player1.getRank() < player2.getRank()) 
				{
					
					do 
					{
						bResult = false;
						color = JOptionPane.showInputDialog(view.getStartPanel(),"Player 2 What color do you want? [Red or Blue]", null);
						
						if(color != null && !color.equalsIgnoreCase(colors[0]) && !color.equalsIgnoreCase(colors[1]))
							bResult = true;
					} while(bResult);
					
					if(color != null && color.equalsIgnoreCase(colors[0]))
					{
						p2 = new Player(colors[0]);
						p1 = new Player(colors[1]);
					}
					else if(color != null && color.equalsIgnoreCase(colors[1]))
					{
						p2 = new Player(colors[1]);
						p1 = new Player(colors[0]);
					}
					isTurn = 0;
					player1 = null;
					player2 = null;
					model = new Board(p2, p1);
					enabled = true;
					view.setButtonsEnable(enabled);
					view.setVisibilityFalse();
					view.setVisibility(true);
					updateView();
				}
				else if (player1 == player2) 
				{
					 JOptionPane.showMessageDialog(view.getStartPanel(), "Please try again the numbers are the equal", "Alert", JOptionPane.WARNING_MESSAGE);	
					 isTurn = 0; 
				}
			}
		}	
		else
		{
			JButton clickbttn = (JButton) e.getSource();
			Player current, other;
			Piece piece, temp;
			Location loc = view.getLocation(clickbttn);
			
			current = model.getTeamTwo();
			other = model.getTeamOne();
			view.setError("");
			if(model.getTurn() % 2 == 1)
			{
				
				current = model.getTeamOne();
				other = model.getTeamTwo();
			}
			
			System.out.println(current.toString());
			System.out.println(other.toString());
			
			Tile clickedTile = model.getTile(loc);
			
			if(move.getCurrentPos() == null && clickedTile.getIsOccupied())
			{
				piece = clickedTile.getCurrentPiece();
				if(piece.getColor().equals(current.getColor())) 
				{
					move.setCurrentPos(clickedTile);
				}
				else
					view.setError("Invalid piece");
			}
			else if(move.getCurrentPos() != null && move.getCurrentPos().equals(clickedTile))
			{
				clickedTile = null;
				move.setCurrentPos(clickedTile);
			}
			else if(move.getCurrentPos() != null)
			{
				move.setFinalPos(clickedTile);
				piece = move.getCurrentPos().getCurrentPiece();
				
				if(piece.canMove(move.getFinalPos(), model))
				{
					model.getTile(move.getCurrentPos().getLocation()).reset();
					
					if(move.getFinalPos().getIsOccupied())
					{
						temp = move.getFinalPos().getCurrentPiece();
						temp.setIsAlive(false);
						
						other.setTile(temp, move.getFinalPos());
						if(model.getTurn() % 2 == 1)
						{
							model.setTeamTwo(other);
						}
						else
						{
							model.setTeamOne(other);
						}
						
						model.getTile(move.getFinalPos().getLocation()).reset();
						
					}
					else if(move.getFinalPos().getTerrain() != null)
					{
						Terrain terrain = move.getFinalPos().getTerrain();
						if(terrain instanceof AnimalDen)
						{
							((AnimalDen) terrain).setIsCaptured(true);
							model.getTile(move.getFinalPos().getLocation()).setTerrain(terrain);
						}
					}
					
					model.getTile(clickedTile.getLocation()).setCurrentPiece(piece);
					current.setTile(piece, clickedTile);
					if(model.getTurn() % 2 == 1)
					{
						model.setTeamOne(current);
					}
					else
					{
						model.setTeamTwo(current);
					}
					clickedTile = null;
					move.setCurrentPos(clickedTile);
					move.setFinalPos(clickedTile);
					model.nextTurn();
					
				}
				else
					view.setError("Invalid move");
			}
			updateView();
		}
		
	}

	
	public static void main (String[] args)
	{
		Controller controller = new Controller();
	}

	

	
}