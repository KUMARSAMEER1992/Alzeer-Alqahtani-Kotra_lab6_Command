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

/**
 * The test cases for the TurnEast class.
 */
public class TestTurnEast
{
	/**
	 * Test changes selected player's direction to east
	 */
	@Test
	public void test()
	{
		LifeForm entity1 = new Human("Bob", 40, 5);
		Environment env = Environment.getWorldInstance();
		Command turnEast = new TurnEast(entity1);
		turnEast.execute();
		assertEquals(1, entity1.getDirection());
		TestEnvironment.resetEnvironment();
	}
}
