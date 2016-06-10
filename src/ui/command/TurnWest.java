package ui.command;

import environment.Environment;
import lifeform.LifeForm;

public class TurnWest implements Command 
{
	LifeForm lifeForm;
	public TurnWest(LifeForm lifeForm)
	{
		this.lifeForm=lifeForm;
	}
	@Override
	public void execute() 
	{
		Environment env=Environment.getWorldInstance();

		lifeForm.setDirection(3);
		env.informDisplay();

	}

}


