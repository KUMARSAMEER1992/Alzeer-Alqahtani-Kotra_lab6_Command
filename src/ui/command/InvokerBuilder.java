package ui.command;

import lifeform.LifeForm;

public class InvokerBuilder 
{
	
	public static Invoker bulidInvoker(LifeForm lifeForm)
	{
		Invoker invoker =new Invoker();
		Command temp=new Move(lifeForm);
		invoker.setMove(temp);
		Command temp2=new Reload(lifeForm);
		invoker.setReload(temp2);
		Command temp3=new TurnNorth(lifeForm);
		invoker.setTurnNorth(temp3);
		Command temp4=new TurnSouth(lifeForm);
		invoker.setTurnSouth(temp4);
		Command temp5=new TurnEast(lifeForm);
		invoker.setTurnEast(temp5);
		Command temp6=new TurnWest(lifeForm);
		invoker.setTurnWest(temp6);
		Command temp7=new Acquire(lifeForm);
		invoker.setAcquire(temp7);
		Command temp8=new Attack(lifeForm);
		invoker.setAttack(temp8);
		Command temp9=new Drop(lifeForm);
		invoker.setDrop(temp9);
		return invoker;
	}
	 
}
