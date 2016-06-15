/**
 *  Name:Dalal Alzeer
 *  Course:CSC 561
 *  Instructor: Dr. Girard
 */
package ui.command;
import lifeform.LifeForm;
/**
 *  Invoker Builder class
 */
public class InvokerBuilder 
{
	/**
	 * Attach command to each buttons
	 * @param lifeForm
	 * @return Invoker
	 */
	public static Invoker bulidInvoker(LifeForm lifeForm)
	{	
		Invoker invoker =new Invoker();
		//Move
		Command temp1=new Move(lifeForm);
		invoker.setMove(temp1);
		//Reload
		Command temp2=new Reload(lifeForm);
		invoker.setReload(temp2);
		//Acquire
		Command temp3=new Acquire(lifeForm);
		invoker.setAcquire(temp3);
		//Attack
		Command temp4=new Attack(lifeForm);
		invoker.setAttack(temp4);
		//Drop
		Command temp5=new Drop(lifeForm);
		invoker.setDrop(temp5);
		//TurnNorth
		Command temp6=new TurnNorth(lifeForm);
		invoker.setTurnNorth(temp6);
		//TurnSouth
		Command temp7=new TurnSouth(lifeForm);
		invoker.setTurnSouth(temp7);
		//TurnEast
		Command temp8=new TurnEast(lifeForm);
		invoker.setTurnEast(temp8);
		//TurnWest
		Command temp9=new TurnWest(lifeForm);
		invoker.setTurnWest(temp9);
		
		return invoker;
	}
	 
}
