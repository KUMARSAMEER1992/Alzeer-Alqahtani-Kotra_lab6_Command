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
 * This class to allow LifeForm to pickup a weapon 
 * that in the cell
 */
public class Acquire implements Command
{
	/**
	 * LifeForm acquire the weapon.
	 */
	LifeForm lifeForm;
	/**
	 * Create an instance of Acquire with given LifeForm.
	 * @param lifeForm
	 */
	public Acquire(LifeForm lifeForm)
	{
		this.lifeForm=lifeForm;
	}
	/**
	 * LifeForm picks up a weapon, but only if one exists in the Cell.
	 * If the LifeForm is already holding a weapon, it will swap the old 
	 * weapon for the new weapon. This will keep the LifeForm from having 
	 * to move to a different cell, drop a weapon, then return to this cell 
	 * to get a new one when there are two weapons available. 
	 */
	@Override
	public void execute() 
	{
		Environment env=Environment.getWorldInstance();
		int row=lifeForm.getX();
		int col=lifeForm.getY();
		if(lifeForm.getWeapon()==null)
		{
		if(env.getWeapon(row, col, 1)!=null)
		{
			Weapon temp=env.removeWeapon(row, col, 1);
			lifeForm.pickUp(temp);
		}
		else if( env.getWeapon(row, col, 2)!=null)
		{
			Weapon temp=env.removeWeapon(row, col, 2);
			lifeForm.pickUp(temp);
		}
		}
		else
		{
			Weapon temp=lifeForm.dropWeapon();
			if(env.getWeapon(row, col, 1)!=null)
			{
				Weapon temp1=env.removeWeapon(row, col, 1);
				lifeForm.pickUp(temp1);
				env.addWeapon(row, col, temp);
			}
			else if( env.getWeapon(row, col, 2)!=null)
			{
				Weapon temp1=env.removeWeapon(row, col, 2);
				lifeForm.pickUp(temp1);
				env.addWeapon(row, col, temp);
			}
		}
		env.informDisplay();
 }

}
