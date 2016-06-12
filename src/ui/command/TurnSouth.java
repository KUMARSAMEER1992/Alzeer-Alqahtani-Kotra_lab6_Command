/**
 *  Name:Norah Alqahtani
 *  Course:CSC 561
 *  Instructor: Dr. Girard
 */
package ui.command;

import environment.Environment;
import lifeform.LifeForm;
/**
 * This class to turn the LifForm to South.
 */
public class TurnSouth implements Command 
{
	/**
	 * LifeForm that want to turn South.
	 */
	LifeForm lifeForm;
	/**
	 * Create an instance of TurnSouth with given LifeForm.
	 * @param lifeForm
	 */
	public TurnSouth(LifeForm lifeForm)
	{
		this.lifeForm=lifeForm;
	}
	/**
	 * To change direction of LifeForm to South.
	 */
	@Override
	public void execute() 
	{
		Environment env=Environment.getWorldInstance();

		lifeForm.setDirection(2);
		env.informDisplay();
	}
}
