package ui.command;

import weapon.Weapon;
import environment.Environment;
import lifeform.LifeForm;

public class Drop implements Command
{
	LifeForm lifeForm;
	public Drop(LifeForm lifeForm)
	{
		this.lifeForm=lifeForm;

	}
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
