/**
 *  Name:Dalal Alzeer
 *  Course:CSC 561
 *  Instructor: Dr. Girard
 */
package ui.command;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
/**
 * Invoker class contains commands and buttons
 */
public class Invoker extends Frame implements ActionListener 
{
	protected JButton btnNorth, btnSouth, btnEast, btnWest,btnMove,btnReload,btnAttack,btnAcquire,btnDrop;
	Command turnNorth,turnSouth,turnEast,turnWest;
	Command move,reload,attack,drop,acquire;
	/**
	 * constructor to create GUI
	 */
	public Invoker()
	{
		createGui();
	}
	/**
	 * Adding buttons and commands to GUI
	 */
	private void createGui() 
	{
		setLayout(new BorderLayout());
		//buttons
	    JPanel panal=new JPanel();
	    panal.setLayout(new BorderLayout(3,3));
	    btnNorth = new JButton("NORTH");
	    btnNorth.addActionListener(this);
	    panal.add(btnNorth, BorderLayout.NORTH);
	    btnSouth = new JButton("SOUTH");
	    btnSouth.addActionListener(this);
	    panal.add(btnSouth, BorderLayout.CENTER);
	    btnEast = new JButton("EAST");
	    btnEast.addActionListener(this);
	    panal.add(btnEast, BorderLayout.EAST);
	    btnWest = new JButton("WEST");
	    btnWest.addActionListener(this);
	    panal.add(btnWest, BorderLayout.WEST);
	    add("North",panal);
	    //command
	    JPanel panal1=new JPanel();
		panal1.setLayout(new GridLayout(3,3));
	    btnMove=new JButton("Move");
	    btnMove.addActionListener(this);
	    panal1.add(btnMove, BorderLayout.WEST);
	    btnReload=new JButton("Reload");
	    btnReload.addActionListener(this);
	    panal1.add(btnReload, BorderLayout.NORTH);
	    btnAttack=new JButton("Attack");
	    btnAttack.addActionListener(this);
	    panal1.add(btnAttack, BorderLayout.CENTER);
	    btnAcquire=new JButton("Acquire");
	    btnAcquire.addActionListener(this);
	    panal1.add(btnAcquire, BorderLayout.EAST);
	    btnDrop=new JButton("Drop"); 
	    btnDrop.addActionListener(this);
	    panal1.add(btnDrop, BorderLayout.EAST);
	    add("Center",panal1);
	    setTitle("Remote"); 
	    setSize(280, 150);            
	    pack();
	    setVisible(true);
	}
	/**
	 * execute command for each button
	 */
	 @Override
	 public void actionPerformed(ActionEvent evt) 
	 {
		 String temp=evt.getActionCommand();
		 if(temp.equals("Reload"))
		 {
			 reload.execute();
		 }
		 else if(temp.equals("Move"))
		 {
			 move.execute();
		 }
		 else if(temp.equals("NORTH"))
		 {
			 turnNorth.execute();
		 }
		 else if(temp.equals("SOUTH"))
		 {
			 turnSouth.execute();
		 }
		 else if(temp.equals("EAST"))
		 {
			 turnEast.execute();
		 }
		 else if(temp.equals("WEST"))
		 {
			 turnWest.execute();
		 }
		 else if(temp.equals("Acquire"))
		 {
			 acquire.execute();
		 }
		 else if(temp.equals("Attack"))
		 {
			 attack.execute();
		 }
		 else if(temp.equals("Drop"))
		 {
			 drop.execute();
		 }
	 }
	 /**
	  * to set TurnNorth command
	  * @param turnNorth
	  */
	public void setTurnNorth(Command turnNorth)
	{
		this.turnNorth = turnNorth;
	}
	/**
	 * to set turnSouth command
	 * @param turnSouth
	 */
	public void setTurnSouth(Command turnSouth)
	{
		this.turnSouth = turnSouth;
	}
	/**
	 * to set turnEast command
	 * @param turnEast
	 */
	public void setTurnEast(Command turnEast) 
	{
		this.turnEast = turnEast;
	}
	/**
	 * to set turnWest command
	 * @param turnWest
	 */
	public void setTurnWest(Command turnWest) 
	{
		this.turnWest = turnWest;
	}
	/**
	 * to set move command
	 * @param move
	 */
	public void setMove(Command move) 
	{
		this.move = move;
	}
	/**
	 * to set reload command
	 * @param reload
	 */
	public void setReload(Command reload)
	{
		this.reload = reload;
	}
	/**
	 * to set attack command
	 * @param attack
	 */
	public void setAttack(Command attack)
	{
		this.attack = attack;
	}
	/**
	 * to set drop command
	 * @param drop
	 */
	public void setDrop(Command drop) 
	{
		this.drop = drop;
	}
	/**
	 * to set acquire command
	 * @param acquire
	 */
	public void setAcquire(Command acquire) 
	{
		this.acquire = acquire;
	}	 
}
