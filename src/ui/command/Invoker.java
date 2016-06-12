package ui.command;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class Invoker extends Frame implements ActionListener 
{
	private Button btnNorth, btnSouth, btnEast, btnWest,btnMove,btnReload,btnAttack,btnAcquire,btnDrop;
	Command turnNorth,turnSouth,turnEast,turnWest;
	Command move,reload,attack,drop,acquire;
	
	public Invoker()
	{
		createGui();
	}

	private void createGui() 
	{
		setLayout(new BorderLayout());
		   
	     JPanel panal=new JPanel();
	     panal.setLayout(new BorderLayout(3,3));
	     btnNorth = new Button("NORTH");
	     btnNorth.addActionListener(this);
	     panal.add(btnNorth, BorderLayout.NORTH);
	     btnSouth = new Button("SOUTH");
	     btnSouth.addActionListener(this);
	     panal.add(btnSouth, BorderLayout.CENTER);
	     btnEast = new Button("EAST");
	     btnEast.addActionListener(this);
	     panal.add(btnEast, BorderLayout.EAST);
	     btnWest = new Button("WEST");
	     btnWest.addActionListener(this);
	     panal.add(btnWest, BorderLayout.WEST);
	     add("North",panal);
	     //comand
	     JPanel panal1=new JPanel();
		 panal1.setLayout(new GridLayout(3,3));
	     btnMove=new Button("Move");
	     btnMove.addActionListener(this);
	     panal1.add(btnMove, BorderLayout.WEST);
	     btnReload=new Button("Reload");
	     btnReload.addActionListener(this);
	     panal1.add(btnReload, BorderLayout.NORTH);
	     btnAttack=new Button("Attack");
	     btnAttack.addActionListener(this);
	     panal1.add(btnAttack, BorderLayout.CENTER);
	     btnAcquire=new Button("Acquire");
	     btnAcquire.addActionListener(this);
	     panal1.add(btnAcquire, BorderLayout.EAST);
	     btnDrop=new Button("Drop"); 
	     btnDrop.addActionListener(this);
	     panal1.add(btnDrop, BorderLayout.EAST);
	     add("Center",panal1);
	     setTitle("Remote"); 
	     setSize(280, 150);            
	     pack();
	     setVisible(true);
	}
	
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

	public void setTurnNorth(Command turnNorth)
	{
		this.turnNorth = turnNorth;
	}

	public void setTurnSouth(Command turnSouth)
	{
		this.turnSouth = turnSouth;
	}

	public void setTurnEast(Command turnEast) 
	{
		this.turnEast = turnEast;
	}

	public void setTurnWest(Command turnWest) 
	{
		this.turnWest = turnWest;
	}

	public void setMove(Command move) 
	{
		this.move = move;
	}

	public void setReload(Command reload)
	{
		this.reload = reload;
	}

	public void setAttack(Command attack)
	{
		this.attack = attack;
	}

	public void setDrop(Command drop) 
	{
		this.drop = drop;
	}

	public void setAcquire(Command acquire) 
	{
		this.acquire = acquire;
	}	 
}
