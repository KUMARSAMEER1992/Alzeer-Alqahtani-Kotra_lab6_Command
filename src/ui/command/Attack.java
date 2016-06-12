/**
 *  Name:Norah Alqahtani
 *  Course:CSC 561
 *  Instructor: Dr. Girard
 */
package ui.command;

import environment.Environment;
import lifeform.LifeForm;
/**
 * LifeForm attack another LifeForm in the direction it.
 */
public class Attack implements Command

{
	/**
	 * LifeForm want to attack another LifeForm.
	 */
	LifeForm lifeForm;
	/**
	 * Create an instance of Attack with given LifeForm.
	 * @param lifeForm
	 */
	public Attack(LifeForm lifeForm)
	{
	  this.lifeForm=lifeForm;

	}
    /**
     * A LifeForm will only attack targets in a direct 
     * line in front of the LifeForm. 
     */
	@Override
	public void execute() 
	{
	 int row=lifeForm.getX();
	 int col=lifeForm.getY();
	 int temp;
	 Environment env=Environment.getWorldInstance();
		switch(lifeForm.getDirection())
		{
		case 0:
			temp=row-1;
			while(temp>=0)
			{
				if(env.getLifeForm(temp, col)!=null)
				{
					lifeForm.attack(env.getLifeForm(temp, col));
					break;
				}
				else
				{
					temp--;
				}
			}
			break;
		case 1:
			temp=col+1;
			while(temp<Environment.COLS)
			{
				if(env.getLifeForm(row, temp)!=null)
				{
					lifeForm.attack(env.getLifeForm(row, temp));
					break;
				}
				else
				{
					temp++;
				}
			}
			break;
		case 2:
			temp=row+1;
			while(temp<Environment.ROWS)
			{
				if(env.getLifeForm(temp, col)!=null)
				{
					lifeForm.attack(env.getLifeForm(temp, col));
					break;
				}
				else
				{
					temp++;
				}
			}
			break;
		case 3:
			temp=col-1;
			while(temp>=0)
			{
				if(env.getLifeForm(row, temp)!=null)
				{
					lifeForm.attack(env.getLifeForm(row, temp));
					break;
				}
				else
				{
					temp--;
				}
			}
			break;
		}
		env.informDisplay();
	}

}
