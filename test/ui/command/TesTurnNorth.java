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
import lifeform.MockLifeForm;

/**
 * The test cases for the TurnNorth class.
 */
public class TesTurnNorth
{
	/**
	 * Test changes selected player's direction to North
	 */
	@Test
	public void test()
	{
		LifeForm entity = new MockLifeForm("Bob", 40, 10);
		Environment env = Environment.getWorldInstance();
		Command turnNorth = new TurnNorth(entity);
		// LifeForm turn to south
		entity.setDirection(2);
		turnNorth.execute();
		assertEquals(0, entity.getDirection());
		TestEnvironment.resetEnvironment();
	}
}
