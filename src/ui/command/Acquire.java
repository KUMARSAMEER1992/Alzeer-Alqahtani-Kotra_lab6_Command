package ui.command;

import weapon.Weapon;
import environment.Environment;
import lifeform.LifeForm;

public class Acquire implements Command
{
	LifeForm lifeForm;
	public Acquire(LifeForm lifeForm)
	{
		this.lifeForm=lifeForm;
	}

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
	}

}
