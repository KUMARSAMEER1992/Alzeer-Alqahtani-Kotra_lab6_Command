/**
 *  Name:Norah Alqahtani
 *  Course:CSC 561
 *  Instructor: Dr. Girard
 */
package ui.command;

import environment.Environment;
import lifeform.LifeForm;
/**
 * This class to turn the LifForm to East.
 */
public class TurnEast implements Command 
{
	/**
	 * LifeForm that want to turn East.
	 */
	LifeForm lifeForm;
	/**
	 * Create an instance of TurnEast with given LifeForm.
	 * @param lifeForm
	 */
	public TurnEast(LifeForm lifeForm)
	{
		this.lifeForm=lifeForm;
	}
	/**
	 * To change direction of LifeForm to East.
	 */
	@Override
	public void execute() 
	{
		Environment env=Environment.getWorldInstance();
		lifeForm.setDirection(1);
		env.informDisplay();
	}
}
