
//-------------------------------------------------------------------------
import static java.lang.System.*;  // these lines are required
import static java.lang.Math.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.Icon;
import javax.sound.midi.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.image.BufferStrategy;
import java.awt.Font;
import java.io.*;

public class mp7
{
	public static void main(String args[])
	{
		new Toe();
	}
}

class Toe implements ActionListener
{
	//*JFRAME* 
	
	private JFrame frame = new JFrame("Tic - Tac - Toe");
	private JFrame frame1 = new JFrame("Players");
	
	//*JBUTTON* 
	
	//player buttons 
	private JButton yes = new JButton("Keep Names",null);
	private JButton no = new JButton("Change Names",null);
	//buttons for tic tac toe
	private JButton b1 = new JButton("",null);
	private JButton b2 = new JButton("",null);
	private JButton b3 = new JButton("",null);
	private JButton b4 = new JButton("",null);
	private JButton b5 = new JButton("",null);
	private JButton b6 = new JButton("",null);
	private JButton b7 = new JButton("",null);
	private JButton b8 = new JButton("",null);
	private JButton b9 = new JButton("",null);
	
	//button String
	private String b11 = "";
	private String b22 = "";
	private String b33 = "";
	private String b44 = "";
	private String b55 = "";
	private String b66 = "";
	private String b77 = "";
	private String b88 = "";
	private String b99 = "";
	
	//Other Variables
	private String text = "";
	private int count = 0;
	static String p1 = "";
	static String p2 = "";
	private String title = "Tic - Tac - Toe";


	public Toe()
	{   
	   //*****SETTING UP JFRAME*******
	   
	   //Setting defaults for JFrame 
	   frame.setSize(700,700);
	   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   frame.setLayout(new GridLayout(3, 3));
	   frame.setTitle(title);
	   frame.setLocationRelativeTo(null);
	   //Adding buttons to JFrame
	   frame.add(b1);
	   frame.add(b2);
	   frame.add(b3);
	   frame.add(b4);
	   frame.add(b5);
	   frame.add(b6);
	   frame.add(b7);
	   frame.add(b8);
	   frame.add(b9);
	   //Adding action listener to Jbuttons
	   b1.addActionListener(this);
	   b2.addActionListener(this);
	   b3.addActionListener(this);
	   b4.addActionListener(this);
	   b5.addActionListener(this);
	   b6.addActionListener(this);
	   b7.addActionListener(this);
	   b8.addActionListener(this);
	   b9.addActionListener(this);
	   //Changing the Color of buttons
	   b1.setBackground(Color.white);
	   b2.setBackground(Color.white);
	   b3.setBackground(Color.white);
	   b4.setBackground(Color.white);
	   b5.setBackground(Color.white);
	   b6.setBackground(Color.white);
	   b7.setBackground(Color.white);
	   b8.setBackground(Color.white);
	   b9.setBackground(Color.white);
	   //Setting it visible
	   frame.setVisible(true);
	   
       //****END OF JFRAME*****
	   
	   if (p1.equalsIgnoreCase(""))
	   {
		   players();
		   JOptionPane.showMessageDialog(null,p1+" - X\n"+p2+" - O\n",title,JOptionPane.INFORMATION_MESSAGE);
	   }
	   else 
	   {
	   	   //Setting up jpanel
	   	   JPanel panel = new JPanel();
	   	   JLabel label = new JLabel("Continue with same player names?");
	   	   panel.add(label);
	   	   //Setting up frame defaults 
	       frame1.setSize(325,125);
	       frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       frame1.setLayout(new FlowLayout());
	       frame1.setTitle(title);
	       frame1.setLocationRelativeTo(null);
	       //Adding content to frame
	       frame1.add(panel);
	       frame1.add(yes);
	       frame1.add(no);
	       //adding action listener to content
	       yes.addActionListener(this);
	       no.addActionListener(this);
	       frame1.setVisible(true);
	    }
	}
	public void players()
	{
		p1 = JOptionPane.showInputDialog(null,"Player 1 Enter Your Name:",title,JOptionPane.QUESTION_MESSAGE);
		p2 = JOptionPane.showInputDialog(null,"Player 2 Enter Your Name:",title,JOptionPane.QUESTION_MESSAGE);
	}
	public void actionPerformed(ActionEvent a)
	{
		playSound2();  //button click sound
		
		//PLAYER BUTTON
		if (a.getSource() == yes)
		{
			frame1.dispose();
		}
		if (a.getSource() == no)
		{
			players();					
			frame1.dispose();
			JOptionPane.showMessageDialog(null,p1+" - X\n"+p2+" - O\n",title,JOptionPane.INFORMATION_MESSAGE);
		}
		//GAME BUTTONS
	    if (a.getSource() == b1 || a.getSource() == b2 || a.getSource() == b3 || a.getSource() == b4 || a.getSource() == b5 || a.getSource() == b6 || a.getSource() == b7 || a.getSource() == b8 || a.getSource() == b9)
	    {
		 		count++;
				String t = "";
				//odds are x
				//evens are o
				if (count == 1 || count == 3 || count == 5 || count == 7 || count == 9)
				{
					text = "XTicTacToe.png";
					t = "X";
				}
				if (count == 2 || count == 4 || count == 6 || count == 8 || count == 10)
				{
					text = "OTicTacToe.png";
					t = "O";
				}
		
				
				//***BTN Clicked ***
		
				
				if (a.getSource() == b1)
				{
					b11 = t;
					b1.setIcon(new ImageIcon(text));
					b1.removeActionListener(this);
				}
				if (a.getSource() == b2)
				{
					b22 = t;
					b2.setIcon(new ImageIcon(text));
					b2.removeActionListener(this);
				}
				if (a.getSource() == b3)
				{
					b33 = t;
					b3.setIcon(new ImageIcon(text));
					b3.removeActionListener(this);
				}
				if (a.getSource() == b4)
				{
					b44 = t;
					b4.setIcon(new ImageIcon(text));
					b4.removeActionListener(this);
				}
				if (a.getSource() == b5)
				{
					b55 = t;
					b5.setIcon(new ImageIcon(text));
					b5.removeActionListener(this);
				}
				if (a.getSource() == b6)
				{
					b66 = t;
					b6.setIcon(new ImageIcon(text));
					b6.removeActionListener(this);
				}
				if (a.getSource() == b7)
				{
					b77 = t;
					b7.setIcon(new ImageIcon(text));
					b7.removeActionListener(this);
				}
				if (a.getSource() == b8)
				{
					b88 = t;
					b8.setIcon(new ImageIcon(text));
					b8.removeActionListener(this);
				}
				if (a.getSource() == b9)
				{
					b99 = t;
					b9.setIcon(new ImageIcon(text));
					b9.removeActionListener(this);
				}
				
				
				//******LOGIC*******
				
		        logic();
        }
	}
	//*********LOGIC****
	
	public void logic()
	{
		//Booleans
		boolean horizontal1 = false;
		boolean horizontal2 = false;
		boolean horizontal3 = false;
		boolean diagonal1 = false;
		boolean diagonal2 = false;
		boolean vertical1 = false;
		boolean vertical2 = false;
		boolean vertical3 = false;
		
		
        //Diagonal
        
        // : | |
        // | : |
        // | | :
		if (b11.equalsIgnoreCase(b55) && b55.equalsIgnoreCase(b99) && check(b11) == false)
	    {
		       if (b11.equalsIgnoreCase("O"))
		       {
		       	      playSound();
			          JOptionPane.showMessageDialog(null,p2 +" Wins!",title,JOptionPane.INFORMATION_MESSAGE);
			          b1.removeActionListener(this);
			          b2.removeActionListener(this);
			          b3.removeActionListener(this);
			          b4.removeActionListener(this);
			          b5.removeActionListener(this);
			          b6.removeActionListener(this);
			          b7.removeActionListener(this);
			          b8.removeActionListener(this);
			          b9.removeActionListener(this);
			          diagonal1 = true;
		       }
		       else
		       {
		       	      playSound();
			          JOptionPane.showMessageDialog(null,p1 +" Wins!",title,JOptionPane.INFORMATION_MESSAGE);
			          b1.removeActionListener(this);
			          b2.removeActionListener(this);
			          b3.removeActionListener(this);
			          b4.removeActionListener(this);
			          b5.removeActionListener(this);
			          b6.removeActionListener(this);
			          b7.removeActionListener(this);
			          b8.removeActionListener(this);
			          b9.removeActionListener(this);
			          diagonal1 = true;
		       }
		       frame.dispose();
			   new Toe();
	    }
	    
	    // | | :
	    // | : |
	    // : | |
	    
	    if (b33.equalsIgnoreCase(b55) && b55.equalsIgnoreCase(b77) && check(b33) == false)
	    {
		       if (b33.equalsIgnoreCase("O"))
		       {
		       	      playSound();
			          JOptionPane.showMessageDialog(null,p2 +" Wins!",title,JOptionPane.INFORMATION_MESSAGE);
			          b1.removeActionListener(this);
			          b2.removeActionListener(this);
			          b3.removeActionListener(this);
			          b4.removeActionListener(this);
			          b5.removeActionListener(this);
			          b6.removeActionListener(this);
			          b7.removeActionListener(this);
			          b8.removeActionListener(this);
			          b9.removeActionListener(this);
			          diagonal2 = true;
		       }
		       else
		       {
		       	      playSound();
			          JOptionPane.showMessageDialog(null,p1 +" Wins!",title,JOptionPane.INFORMATION_MESSAGE);
			          b1.removeActionListener(this);
			          b2.removeActionListener(this);
			          b3.removeActionListener(this);
			          b4.removeActionListener(this);
			          b5.removeActionListener(this);
			          b6.removeActionListener(this);
			          b7.removeActionListener(this);
			          b8.removeActionListener(this);
			          b9.removeActionListener(this);
			          diagonal2 = true;
		       }
		       frame.dispose();
			   new Toe();
	    }
	    
	    //**HORIZONTAL**
	    
	    // : : :
	    // | | |
	    // | | |
	    
        if (b11.equalsIgnoreCase(b22) && b22.equalsIgnoreCase(b33) && check(b11) == false)
	    {
		       if (b11.equalsIgnoreCase("O"))
		       {
		       	      playSound();
			          JOptionPane.showMessageDialog(null,p2 +" Wins!",title,JOptionPane.INFORMATION_MESSAGE);
			          b1.removeActionListener(this);
			          b2.removeActionListener(this);
			          b3.removeActionListener(this);
			          b4.removeActionListener(this);
			          b5.removeActionListener(this);
			          b6.removeActionListener(this);
			          b7.removeActionListener(this);
			          b8.removeActionListener(this);
			          b9.removeActionListener(this);
			          horizontal1 = true;
		       }
		       else
		       {
		       	      playSound();
			          JOptionPane.showMessageDialog(null,p1 +" Wins!",title,JOptionPane.INFORMATION_MESSAGE);
			          b1.removeActionListener(this);
			          b2.removeActionListener(this);
			          b3.removeActionListener(this);
			          b4.removeActionListener(this);
			          b5.removeActionListener(this);
			          b6.removeActionListener(this);
			          b7.removeActionListener(this);
			          b8.removeActionListener(this);
			          b9.removeActionListener(this);
			          horizontal1 = true;
		       }
		       frame.dispose();
			   new Toe();
	    }
	    
	    // | | |
	    // : : :
	    // | | |
	    
	    if (b44.equalsIgnoreCase(b55) && b55.equalsIgnoreCase(b66) && check(b44) == false)
	    {
		       if (b44.equalsIgnoreCase("O"))
		       {
		       	      playSound();
			          JOptionPane.showMessageDialog(null,p2 +" Wins!",title,JOptionPane.INFORMATION_MESSAGE);
			          b1.removeActionListener(this);
			          b2.removeActionListener(this);
			          b3.removeActionListener(this);
			          b4.removeActionListener(this);
			          b5.removeActionListener(this);
			          b6.removeActionListener(this);
			          b7.removeActionListener(this);
			          b8.removeActionListener(this);
			          b9.removeActionListener(this);
			          horizontal2 = true;
		       }
		       else
		       {
		       	      playSound();
			          JOptionPane.showMessageDialog(null,p1 +" Wins!",title,JOptionPane.INFORMATION_MESSAGE);
			          b1.removeActionListener(this);
			          b2.removeActionListener(this);
			          b3.removeActionListener(this);
			          b4.removeActionListener(this);
			          b5.removeActionListener(this);
			          b6.removeActionListener(this);
			          b7.removeActionListener(this);
			          b8.removeActionListener(this);
			          b9.removeActionListener(this);
			          horizontal2 = true;
		       }
		       frame.dispose();
			   new Toe();
	    }  
	    
	    // | | |
	    // | | |
	    // : : :
	    
	    if (b77.equalsIgnoreCase(b88) && b88.equalsIgnoreCase(b99) && check(b99) == false)
	    {
		       if (b77.equalsIgnoreCase("O"))
		       {
		       	      playSound();
		              JOptionPane.showMessageDialog(null,p2 +" Wins!",title,JOptionPane.INFORMATION_MESSAGE);
		              b1.removeActionListener(this);
			          b2.removeActionListener(this);
			          b3.removeActionListener(this);
			          b4.removeActionListener(this);
			          b5.removeActionListener(this);
			          b6.removeActionListener(this);
			          b7.removeActionListener(this);
			          b8.removeActionListener(this);
			          b9.removeActionListener(this);
			          horizontal3 = true;
		       }
		       else
		       {
		       	      playSound();
			          JOptionPane.showMessageDialog(null,p1 +" Wins!",title,JOptionPane.INFORMATION_MESSAGE);
			          b1.removeActionListener(this);
			          b2.removeActionListener(this);
			          b3.removeActionListener(this);
			          b4.removeActionListener(this);
			          b5.removeActionListener(this);
			          b6.removeActionListener(this);
			          b7.removeActionListener(this);
			          b8.removeActionListener(this);
			          b9.removeActionListener(this);
			          horizontal3 = true;
		       }
		       frame.dispose();
			   new Toe();
	    }
	    
	   //**VERTICAL**
	   
	   // : | |
	   // : | |
	   // : | |
	   
	   if (b11.equalsIgnoreCase(b44) && b44.equalsIgnoreCase(b77) && check(b11) == false)
	   {
		      if (b11.equalsIgnoreCase("O"))
		      {
		      	     playSound();
			         JOptionPane.showMessageDialog(null,p2 +" Wins!",title,JOptionPane.INFORMATION_MESSAGE);
			         b1.removeActionListener(this);
			         b2.removeActionListener(this);
			         b3.removeActionListener(this);
			         b4.removeActionListener(this);
			         b5.removeActionListener(this);
			         b6.removeActionListener(this);
			         b7.removeActionListener(this);
			         b8.removeActionListener(this);
			         b9.removeActionListener(this);
			         vertical1 = true;
		      }
		      else
		      {
		             playSound();
			         JOptionPane.showMessageDialog(null,p1 +" Wins!",title,JOptionPane.INFORMATION_MESSAGE);
			         b1.removeActionListener(this);
			         b2.removeActionListener(this);
			         b3.removeActionListener(this);
			         b4.removeActionListener(this);
			         b5.removeActionListener(this);
			         b6.removeActionListener(this);
			         b7.removeActionListener(this);
			         b8.removeActionListener(this);
			         b9.removeActionListener(this);
			         vertical1 = true;
		      }
		      frame.dispose();
			  new Toe();
	   }  
	   
	   // | : |
	   // | : |
	   // | : |
	   
	   if (b22.equalsIgnoreCase(b55) && b55.equalsIgnoreCase(b88) && check(b22) == false)
	   {
		      if (b22.equalsIgnoreCase("O"))
	          {
	          	     playSound();
			  	     JOptionPane.showMessageDialog(null,p2 +" Wins!",title,JOptionPane.INFORMATION_MESSAGE);
			  	     b1.removeActionListener(this);
			         b2.removeActionListener(this);
			         b3.removeActionListener(this);
			         b4.removeActionListener(this);
			         b5.removeActionListener(this);
			         b6.removeActionListener(this);
			         b7.removeActionListener(this);
			         b8.removeActionListener(this);
			         b9.removeActionListener(this);
			         vertical2 = true;
		      }
		      else
		      {
		             playSound();
			         JOptionPane.showMessageDialog(null,p1 +" Wins!",title,JOptionPane.INFORMATION_MESSAGE);
			         b1.removeActionListener(this);
			         b2.removeActionListener(this);
			         b3.removeActionListener(this);
			         b4.removeActionListener(this);
			         b5.removeActionListener(this);
			         b6.removeActionListener(this);
			         b7.removeActionListener(this);
			         b8.removeActionListener(this);
			         b9.removeActionListener(this);
			         vertical2 = true;
		      }
		      frame.dispose();
			  new Toe();
	   }
	   
	   // | | :
	   // | | :
	   // | | :
	   
	   if (b33.equalsIgnoreCase(b66) && b66.equalsIgnoreCase(b99) && check(b33) == false)
	   {
		      if (b33.equalsIgnoreCase("O"))
		      {
		      	     playSound();
			         JOptionPane.showMessageDialog(null,p2 +" Wins!",title,JOptionPane.INFORMATION_MESSAGE);
			         b1.removeActionListener(this);
			         b2.removeActionListener(this);
			         b3.removeActionListener(this);
			         b4.removeActionListener(this);
			         b5.removeActionListener(this);
			         b6.removeActionListener(this);
			         b7.removeActionListener(this);
			         b8.removeActionListener(this);
			         b9.removeActionListener(this);
			         vertical3 = true;
		      }
		      else
	          {
	          	     playSound();
			   	     JOptionPane.showMessageDialog(null,p1 +" Wins!",title,JOptionPane.INFORMATION_MESSAGE);
			   	     b1.removeActionListener(this);
			         b2.removeActionListener(this);
			         b3.removeActionListener(this);
			         b4.removeActionListener(this);
			         b5.removeActionListener(this);
			         b6.removeActionListener(this);
			         b7.removeActionListener(this);
			         b8.removeActionListener(this);
			         b9.removeActionListener(this);
			         vertical3 = true;
		   	     
		      }
		      frame.dispose();
			  new Toe();
       }
       
       //**TIE**
       
       else
       if (count == 9 && horizontal1 == false && horizontal2 == false && horizontal3 == false && vertical1 == false && vertical2 == false && vertical3 == false && diagonal1 == false && diagonal2 == false)
       {
              playSound();
	          JOptionPane.showMessageDialog(null,"Tie!",title,JOptionPane.INFORMATION_MESSAGE);
	          b1.removeActionListener(this);
		      b2.removeActionListener(this);
		      b3.removeActionListener(this);
		      b4.removeActionListener(this);
		      b5.removeActionListener(this);
		      b6.removeActionListener(this);
		      b7.removeActionListener(this);
		      b8.removeActionListener(this);
		      b9.removeActionListener(this);
			  frame.dispose();
			  new Toe();
       }
     }
     public boolean check(String c)
     {
     	boolean a = false;
     	if (c.equalsIgnoreCase(""))
     	{
     		a = true;
     	}
     	return a;
     }
     public void playSound2() //***CLICK**
	 {
		    try 
		    {
			        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("BLOOP.wav").getAbsoluteFile());
			        Clip clip = AudioSystem.getClip();
			        clip.open(audioInputStream);
			        clip.start();
		    } 
		    catch(Exception ex) 
		    {
			        System.out.println("Error with playing sound.");
			        ex.printStackTrace();
		    }
     }
     public void playSound() //***WIN**
     {
		    try 
		    {
			        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("CLAPPING.wav").getAbsoluteFile());
			        Clip clip = AudioSystem.getClip();
			        clip.open(audioInputStream);
			        clip.start();
		    } 
		    catch(Exception ex) 
		    {
			        System.out.println("Error with playing sound.");
			        ex.printStackTrace();
		    }
     }
}