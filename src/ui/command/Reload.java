package ui.command;

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
		lifeForm.reload();
	}

}
