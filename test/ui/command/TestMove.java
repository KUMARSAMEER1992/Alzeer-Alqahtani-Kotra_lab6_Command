/**
 *  Name:Norah Alqahtani
 *  Course:CSC 561
 *  Instructor: Dr. Girard
 */
package ui.command;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import environment.Environment;
import environment.TestEnvironment;
import lifeform.Human;
import lifeform.LifeForm;

public class TestMove
{
	/**
	 * Test move selected player
	 */
	@Test
	public void test()
	{
		LifeForm entity1 = new Human("Bob", 40, 5);
		Environment env = Environment.getWorldInstance();
		env.addLifeForm(6, 6, entity1);
		Command move = new Move(entity1);
		move.execute();
		assertEquals(entity1, env.getLifeForm(3, 6));
		TestEnvironment.resetEnvironment();
	}

}
