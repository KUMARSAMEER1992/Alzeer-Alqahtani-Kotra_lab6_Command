package ui.command;

import environment.Environment;
import lifeform.LifeForm;

public class Move implements Command
{
	LifeForm lifeForm;
	public Move(LifeForm lifeForm)
	{
		this.lifeForm=lifeForm;
	}
	@Override
	public void execute() 
	{
		Environment env=Environment.getWorldInstance();
		env.move(lifeForm);
		
		
	}

}
