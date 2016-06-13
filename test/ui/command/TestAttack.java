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
import lifeform.Alien;
import lifeform.Human;
import lifeform.LifeForm;

/**
 * The test cases for the Attack class.
 */
public class TestAttack
{
	/**
	 * Test attacked another LifForm.
	 */
	@Test
	public void testAttack()
	{
		LifeForm entity1 = new Human("Bob", 20, 5);
		LifeForm entity2 = new Alien("fred", 40);
		Environment env = Environment.getWorldInstance();
		Command attack = new Attack(entity1);
		env.addLifeForm(8, 8, entity1);
		env.addLifeForm(7, 8, entity2);
		attack.execute();
		assertEquals(35, entity2.getCurrentLifePoints());
		TestEnvironment.resetEnvironment();
	}
}
