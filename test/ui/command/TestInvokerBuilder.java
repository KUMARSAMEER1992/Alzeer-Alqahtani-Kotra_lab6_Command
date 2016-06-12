package ui.command;

import static org.junit.Assert.*;
import lifeform.Human;
import lifeform.LifeForm;

import org.junit.Test;

import environment.Environment;

import ui.GameDisplay;

public class TestInvokerBuilder 
{

	@Test
	public void test() 
	{
		GameDisplay display=new GameDisplay();
		Environment env=Environment.getWorldInstance();
		env.setDiaplay(display);
		
		LifeForm entity1=new Human("bob",40,10);
		env.addLifeForm(0, 0, entity1);
		Invoker in=InvokerBuilder.bulidInvoker(entity1);
		
		//test buttons function correctly
		
	}
	

}
