package ui.command;

import environment.Environment;
import lifeform.LifeForm;

public class Reload implements Command
{
	LifeForm lifeForm;
	public Reload(LifeForm lifeForm)
	{
		this.lifeForm=lifeForm;
	}
	@Override
	public void execute() 
	{
		Environment env=Environment.getWorldInstance();

		lifeForm.reload();
		env.informDisplay();

	}

}
