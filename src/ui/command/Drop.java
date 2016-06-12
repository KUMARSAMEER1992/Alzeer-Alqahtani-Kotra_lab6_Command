/**
 *  Name:Norah Alqahtani
 *  Course:CSC 561
 *  Instructor: Dr. Girard
 */
package ui.command;

import weapon.Weapon;
import environment.Environment;
import lifeform.LifeForm;
/**
 * This class to drop the weapon the LifeForm is holding. 
 */
public class Drop implements Command
{
	/**
	 * LifeForm drops its current weapon.
	 */
	LifeForm lifeForm;
	/**
	 * Create an instance of Drop with given LifeForm.
	 * @param lifeForm
	 */
	public Drop(LifeForm lifeForm)
	{
		this.lifeForm=lifeForm;
	}
	/**
	 *  LifeForm drops its current weapon.
	 *  Should not allow the LifeForm to drop a Weapon 
	 *  if no space for the weapon in the Cell. 
	 */
	@Override
	public void execute() 
	{
		Environment env=Environment.getWorldInstance();
		int row=lifeForm.getX();
		int col=lifeForm.getY();
		if(env.getWeapon(row, col, 1)==null || env.getWeapon(row, col, 2)==null)
		{
			Weapon temp=lifeForm.dropWeapon();
			env.addWeapon(row, col, temp);
		
		}
		env.informDisplay();
	 }
}
