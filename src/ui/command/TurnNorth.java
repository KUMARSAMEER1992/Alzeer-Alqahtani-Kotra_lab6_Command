package ui.command;

import environment.Environment;
import lifeform.LifeForm;

public class TurnNorth implements Command 
{
	LifeForm lifeForm;
	public TurnNorth(LifeForm lifeForm)
	{
		this.lifeForm=lifeForm;
	}
	@Override
	public void execute() 
	{
		Environment env=Environment.getWorldInstance();

		lifeForm.setDirection(0);
		env.informDisplay();

	}

}
