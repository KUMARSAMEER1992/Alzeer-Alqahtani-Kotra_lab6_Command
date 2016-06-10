package ui.command;

import environment.Environment;
import lifeform.LifeForm;

public class TurnEast implements Command 
{
	LifeForm lifeForm;
	public TurnEast(LifeForm lifeForm)
	{
		this.lifeForm=lifeForm;
	}
	@Override
	public void execute() 
	{
		Environment env=Environment.getWorldInstance();
		lifeForm.setDirection(1);
		env.informDisplay();
	}

}
