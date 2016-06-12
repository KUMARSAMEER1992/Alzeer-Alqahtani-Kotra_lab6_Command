/**
 *  Name:Norah Alqahtani
 *  Course:CSC 561
 *  Instructor: Dr. Girard
 */
package ui.command;

import environment.Environment;
import lifeform.LifeForm;
/**
 * This class to move the LifeForm in the direction it is facing  
 */
public class Move implements Command
{
	/**
	 * LifeForm that want to move.
	 */
	LifeForm lifeForm;
	/**
	 * Create an instance of Move with given LifeForm.
	 * @param lifeForm
	 */
	public Move(LifeForm lifeForm)
	{
		this.lifeForm=lifeForm;
	}
	/**
	 * Move the LifeForm based on maxSpeed spaces in the direction 
	 * it is facing using the movement rules of the Environment. 
	 */
	@Override
	public void execute() 
	{
		Environment env=Environment.getWorldInstance();
		env.move(lifeForm);
		env.informDisplay();	
	}

}
