package ui.command;

import lifeform.LifeForm;

public class MockCammand implements Command {

	int testValue;
	
	public MockCammand(LifeForm lifeForm)
	{
		testValue=0;
	}

	@Override
	public void execute() 
	{
		testValue=1;
	}
	

}
