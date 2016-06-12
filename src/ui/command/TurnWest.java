/**
 *  Name:Norah Alqahtani
 *  Course:CSC 561
 *  Instructor: Dr. Girard
 */
package ui.command;

import environment.Environment;
import lifeform.LifeForm;
/**
 * This class to turn the LifForm to West.
 */
public class TurnWest implements Command 
{
	/**
	 * LifeForm that want to turn West.
	 */
	LifeForm lifeForm;
	/**
	 * Create an instance of TurnWest with given LifeForm.
	 * @param lifeForm
	 */
	public TurnWest(LifeForm lifeForm)
	{
		this.lifeForm=lifeForm;
	}
	/**
	 * To change direction of LifeForm to West.
	 */
	@Override
	public void execute() 
	{
		Environment env=Environment.getWorldInstance();

		lifeForm.setDirection(3);
		env.informDisplay();
	}
}


