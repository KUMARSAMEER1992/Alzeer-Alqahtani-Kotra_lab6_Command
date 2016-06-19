/**
 *  Name:Dalal Alzeer
 *  Course:CSC 561
 *  Instructor: Dr. Girard
 */
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

/**
 * test cases for InvokerBuilder class
 */
public class TestInvokerBuilder extends TestCase
{
	/**
	 *test attache correct command to each button/receiver
	 */
	public void test() 
	{  
		LifeForm entity1 = new Human("bob", 40, 10);
		TestEnvironment.resetEnvironment();
		Invoker in=InvokerBuilder.bulidInvoker(entity1);
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
