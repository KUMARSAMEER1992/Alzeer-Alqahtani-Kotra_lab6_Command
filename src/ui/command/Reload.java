/**
 *  Name:Norah Alqahtani
 *  Course:CSC 561
 *  Instructor: Dr. Girard
 */
package ui.command;

import environment.Environment;
import lifeform.LifeForm;
/**
 * This class to reloads the weapon the LifeForm is holding.  
 * If the LifeForm is not holding a weapon, then nothing happens. 
 */
public class Reload implements Command
{
	/**
	 * LifeForm reload the weapon that is holding.
	 */
	LifeForm lifeForm;
	/**
	 * Create an instance of Reload with given LifeForm.
	 * @param lifeForm
	 */
	public Reload(LifeForm lifeForm)
	{
		this.lifeForm=lifeForm;
	}
	/**
	 * To reloads the weapon the lifeForm is holding.
	 */
	@Override
	public void execute() 
	{
		Environment env=Environment.getWorldInstance();

		lifeForm.reload();
		env.informDisplay();
	}

}
