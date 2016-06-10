package ui.command;

import environment.Environment;
import lifeform.LifeForm;

public class Turn implements Command
{
	LifeForm lifeForm;
	public Turn(LifeForm lifeForm)
	{
		this.lifeForm=lifeForm;
	}
	@Override
	public void execute() 
	{
		
		
	}

}
