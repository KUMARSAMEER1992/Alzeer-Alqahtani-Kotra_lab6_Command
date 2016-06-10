package ui.command;

import environment.Environment;
import lifeform.LifeForm;

public class TurnSouth implements Command 
{
	LifeForm lifeForm;
	public TurnSouth(LifeForm lifeForm)
	{
		this.lifeForm=lifeForm;
	}
	@Override
	public void execute() 
	{
		Environment env=Environment.getWorldInstance();

		lifeForm.setDirection(2);
		env.informDisplay();

	}

}
