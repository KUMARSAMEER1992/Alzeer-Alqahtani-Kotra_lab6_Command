package ui.command;

import org.junit.Test;

import environment.Environment;
import environment.TestEnvironment;
import lifeform.Human;
import lifeform.LifeForm;
import ui.GameDisplay;

public class TestInvokerBuilder
{

	@Test
	public void test()
	{
		GameDisplay display = new GameDisplay();
		Environment env = Environment.getWorldInstance();
		env.setDisplay(display);

		LifeForm entity1 = new Human("bob", 40, 10);
		env.addLifeForm(0, 0, entity1);
		Invoker in = InvokerBuilder.bulidInvoker(entity1);

		// test buttons function correctly
		TestEnvironment.resetEnvironment();
	}

}
