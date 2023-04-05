package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import location.Location;
/** This represents the whole GUI.
 * */
public class GUI
{
	private JFrame gui;
	private JButton[][] chessSquares;
	private JPanel chessBoard;
	private JLabel status;
	private JLabel teamWon;
	private JLabel error;
	private JButton start;
	private JButton done;
	private JButton[] numbers;
	private JFrame startpanel;
	private JLabel startlabel;
	/** This initializes some attributes of the GUI. 
	 * @param This is the rows of the board
	 * @param This is the columns of the board*/
	public GUI(int x, int y)
	{
		startlabel = new JLabel();
		gui = new JFrame("Animal Chess");
		gui.setSize(800, 500);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setLayout(new BorderLayout());
		setup(x, y);
		
		gui.setVisible(true);
		
	}
	/** This is the setup of the GUI where we setup the button, frames, toolbar, etc. 
	 * @param This is the rows of the board
	 * @param This is the columns of the board */
	public void setup(int x, int y)
	{
		
		status = new JLabel("Start Game");
		teamWon = new JLabel();
		error = new JLabel();
		
		
		chessSquares = new JButton[x][y];
		chessBoard = new JPanel(new GridLayout(0, y + 1));
		start = new JButton ("New");
		done = new JButton ("Done");
		int i, j;
		
		JToolBar tool = new JToolBar();
		
		for(i = 0; i < x; i++)
		{
			for(j = 0; j < y; j++) 
			{
				JButton b = new JButton();
				b.setBackground(Color.white);
				b.setEnabled(true);
				chessSquares[i][j] = b;
			}
		}
		
		chessBoard.add(new JLabel(""));
		
		for(i = 0; i < y; i++)
			chessBoard.add(new JLabel("" + (i + 1), SwingConstants.CENTER));
		
		for(i = 0; i < x; i++)
		{
			for(j = 0; j < y; j++)
			{
				switch(j)
				{
					case 0:
						chessBoard.add(new JLabel("" + (i + 1), SwingConstants.CENTER));
					default:
						chessBoard.add(chessSquares[i][j]);
					
				}
			}
		}
		numbers = new JButton [8];
		numbers[0] = new JButton ("Mouse");
		numbers[1] = new JButton ("Cat");
		numbers[2] = new JButton ("Wolf");
		numbers[3] = new JButton ("Dog");
		numbers[4] = new JButton ("Leopard");
		numbers[5] = new JButton ("Tiger");
		numbers[6] = new JButton ("Lion");
		numbers[7] = new JButton ("Elephant");
		tool. add (start);
		tool.addSeparator();
		tool.add(new JLabel("Error:"));
		tool.add(error);
		tool.addSeparator(new Dimension(250, 0));
		tool.add(status);
		tool.add(teamWon);
		
		gui.add(tool, BorderLayout.PAGE_START);
		gui.add(chessBoard);
		
		
		
	}
	/** This is the setter for the error and displays it in the GUI if there is an error
	 * @param The string containing the error. */
	public void setError(String error)
	{
		this.error.setText(error);
	}
	/** This is the setter of the status in the game. 
	 * @param The string containing the status of the game*/
	public void setStatus(String status)
	{
		this.status.setText(status);
	}
	/** This is the setter of which team won the game
	 * @param This is the string on which team won the game*/
	public void setTeamWon(String team)
	{
		teamWon.setText(team);
	}
	
	/** This is to set the buttons to true or false 
	 * @param This it the boolean to which to set the buttons to. */
	public void setButtonsEnable(boolean enabled)
	{
		int i, j;
		for(i = 0; i < 7; i++)
			for(j = 0; j < 9; j++)
			{
				chessSquares[i][j].setEnabled(enabled);
			}
	}
	
	/** This returns the location of the button that is pressed
	 * @param This is the button that is pressed by the player*/
	public Location getLocation(JButton e)
	{
		int row, col;
		
		for(row = 0; row < chessSquares.length; row++)
			for(col = 0; col < chessSquares[row].length; col++)
				if(chessSquares[row][col] == e)
					return new Location(row, col);
		return null;
	}
	/**This is to setup each and every chess squares in the board (e.g the icons and the color of the button) 
	 * @param This is the x coordinate
	 * @param This is the y coordinate 
	 * @param This is the string containing the name of the piece
	 * @param This is the color of the background of the button*/
	public void setChessSquare(int i, int j, String piece, String color)
	{
		if(piece != null)
		{
			if(color.equals("cyan"))
				chessSquares[i][j].setBackground(Color.cyan);
			else if(color.equals("lightGray"))
				chessSquares[i][j].setBackground(Color.lightGray);
			else if(color.equals("blue"))
				chessSquares[i][j].setBackground(Color.blue);
			else if(color.equals("red"))
				chessSquares[i][j].setBackground(Color.red);
			
			if (piece.equals("W")||piece.equals("T")||piece.equals("Den"))
			{
				chessSquares[i][j].setText(piece);
				chessSquares[i][j].setIcon(null);
			}
				
				if (piece.equals("rD")||piece.equals("bD")) {
					ImageIcon icon = new ImageIcon (getClass().getResource("Dog.png"));
					Image img = icon.getImage();  
					Image newimg = img.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
					icon = new ImageIcon(newimg);
					chessSquares[i][j].setIcon(icon);
				}
				else if (piece.equals("rT")||piece.equals("bT")){
					ImageIcon icon = new ImageIcon (getClass().getResource("Tiger.png"));
					Image img = icon.getImage();  
					Image newimg = img.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
					icon = new ImageIcon(newimg);
					chessSquares[i][j].setIcon(icon);
				}else if (piece.equals("rW")||piece.equals("bW")) {
					ImageIcon icon = new ImageIcon (getClass().getResource("Wolf.png"));
					Image img = icon.getImage();  
					Image newimg = img.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
					icon = new ImageIcon(newimg);
					chessSquares[i][j].setIcon(icon);
				}else if (piece.equals("rM")||piece.equals("bM")) {
					ImageIcon icon = new ImageIcon (getClass().getResource("Mouse.png"));
					Image img = icon.getImage();  
					Image newimg = img.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
					icon = new ImageIcon(newimg);
					chessSquares[i][j].setIcon(icon);
				}else if (piece.equals("rE")) {
					ImageIcon icon = new ImageIcon (getClass().getResource("Elephant.png"));
					Image img = icon.getImage();  
					Image newimg = img.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
					icon = new ImageIcon(newimg);
					chessSquares[i][j].setIcon(icon);
				}else if (piece.equals("bE")) {
					ImageIcon icon1 = new ImageIcon (getClass().getResource("Elephant_mirrored.png"));
					Image img1 = icon1.getImage();  
					Image newimg1 = img1.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
					icon1 = new ImageIcon(newimg1);
					chessSquares[i][j].setIcon(icon1);
				}else if (piece.equals("rL")) {
					ImageIcon icon = new ImageIcon (getClass().getResource("lion.png"));
					Image img = icon.getImage();  
					Image newimg = img.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
					icon = new ImageIcon(newimg);
					chessSquares[i][j].setIcon(icon);
				}else if (piece.equals("bL")) {
					ImageIcon icon = new ImageIcon (getClass().getResource("lion_mirrored.png"));
					Image img = icon.getImage();  
					Image newimg = img.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
					icon = new ImageIcon(newimg);
					chessSquares[i][j].setIcon(icon);
				}else if (piece.equals("bLeo")||piece.equals("rLeo")) {
					ImageIcon icon = new ImageIcon (getClass().getResource("Leopard.png"));
					Image img = icon.getImage();  
					Image newimg = img.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
					icon = new ImageIcon(newimg);
					chessSquares[i][j].setIcon(icon);
				}else if (piece.equals("bC")||piece.equals("rC")) {
					ImageIcon icon = new ImageIcon (getClass().getResource("cat.png"));
					Image img = icon.getImage();  
					Image newimg = img.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
					icon = new ImageIcon(newimg);
					chessSquares[i][j].setIcon(icon);
				}
		}
		else
		{
			chessSquares[i][j].setBackground(null);
			chessSquares[i][j].setText(piece);
			chessSquares[i][j].setIcon(null);
		}
			
		
	}
	/**This is the panel for the new in the toolbar 
	 */
	public void startGame () {
		startpanel = new JFrame();
		JPanel panel = new JPanel (new GridLayout(1, 8));
		JToolBar tools1 = new JToolBar();
		startpanel.setSize(1000,500);
		startpanel.setVisible(true);
		startpanel.setLayout(new BorderLayout());
		startpanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		for(int i = 0; i < 8; i++) {
			panel.add(numbers[i]);
		}
		tools1.add(done);
		tools1.addSeparator(new Dimension(100, 0));
		tools1.add(startlabel);
		startpanel.add(tools1, BorderLayout.PAGE_START);
		startpanel.add(panel);
	}
	/** This is the getter for the startpanel
	 * @return It returns the startpanel variable*/
	public JFrame getStartPanel() {
		return startpanel; 
	}
	/** This is the setter for the startLable 
	 * @param This string contains the string to set the label.
	*/
	public void setStartLabel(String label)
	{
		startlabel.setText(label);
	}
	/** This sets the visibility for the startpanel to false
	 * */
	public void setVisibilityFalse () {
		startpanel.setVisible(false);
	}
	/** This is to set the visibility for main GUI
	 * @param This is the boolean to set the visibility to*/
	public void setVisibility (boolean i) {
		if (i == true)
		gui.setVisible(true);
		else 
		gui.setVisible(false);
	}
	/** This is to set every button to have action listener.
	 * @param The actionListener*/
	public void setActionListener (ActionListener Listener) {
		for (int i = 0; i < 7; i ++) {
			for (int j = 0; j < 9; j++) {
				chessSquares[i][j].addActionListener(Listener);
			}
		}
		start.addActionListener(Listener);
		done.addActionListener(Listener);
		for (int i = 0 ; i < 8; i++) {
			numbers[i].addActionListener(Listener);
		}
	}	
	
}
