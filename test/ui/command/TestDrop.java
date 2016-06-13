/**
 *  Name:Norah Alqahtani
 *  Course:CSC 561
 *  Instructor: Dr. Girard
 */
package ui.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import environment.Environment;
import environment.TestEnvironment;
import lifeform.Human;
import lifeform.LifeForm;
import weapon.Pistol;
import weapon.Weapon;

/**
 * The test cases for the Attack class.
 */
public class TestDrop
{
	/**
	 * Test Drop weapon with space available
	 */
	@Test
	public void testDropWithSpace()
	{
		LifeForm entity1 = new Human("Bob", 40, 5);
		Environment env = Environment.getWorldInstance();
		Command drop = new Drop(entity1);
		Weapon pistol = new Pistol();
		env.addLifeForm(5, 5, entity1);
		entity1.pickUp(pistol);
		assertNull(env.getWeapon(5, 5, 1));
		assertNull(env.getWeapon(5, 5, 2));
		drop.execute();
		assertNull(entity1.getWeapon());
		assertEquals(pistol, env.getWeapon(5, 5, 1));
		TestEnvironment.resetEnvironment();
	}

	/**
	 * Test Drop weapon with no space available
	 */
	@Test
	public void testDropWithNoSpace()
	{
		LifeForm entity1 = new Human("Bob", 40, 5);
		Environment env = Environment.getWorldInstance();
		Command drop = new Drop(entity1);
		Weapon pistol1 = new Pistol();
		Weapon pistol2 = new Pistol();
		Weapon pistol3 = new Pistol();
		env.addWeapon(5, 5, pistol1);
		env.addWeapon(5, 5, pistol2);
		env.addLifeForm(5, 5, entity1);
		entity1.pickUp(pistol3);
		drop.execute();
		assertEquals(pistol3, entity1.getWeapon());
		TestEnvironment.resetEnvironment();
	}

}
