package ui.command;

import org.junit.Test;

import environment.Environment;
import environment.TestEnvironment;
import lifeform.Human;
import lifeform.LifeForm;
import ui.GameDisplay;
import junit.framework.TestCase;
import lifeform.Human;
import lifeform.LifeForm;


public class TestInvokerBuilder extends TestCase
{
	
	public void test() 
	{  

		LifeForm entity1 = new Human("bob", 40, 10);

		// test buttons function correctly
		TestEnvironment.resetEnvironment();
		Invoker in=InvokerBuilder.bulidInvoker(entity1);
		//test buttons function correctly
		assertTrue(in.turnNorth instanceof TurnNorth);
		assertTrue(in.turnSouth instanceof TurnSouth);
		assertTrue(in.turnEast instanceof TurnEast);
		assertTrue(in.turnWest instanceof TurnWest);
		assertTrue(in.move instanceof Move);
		assertTrue(in.reload instanceof Reload);
		assertTrue(in.attack instanceof Attack);
		assertTrue(in.drop instanceof Drop);
		assertTrue(in.acquire instanceof Acquire);
		
		
	}

	
}
