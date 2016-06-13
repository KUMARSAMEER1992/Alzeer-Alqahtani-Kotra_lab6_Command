package environment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Test;

import lifeform.Alien;
import lifeform.Human;
import lifeform.LifeForm;
import lifeform.MockLifeForm;
import weapon.ChainGun;
import weapon.Pistol;
import weapon.Weapon;

/**
 * The test cases for the Environment class.
 * @author : Sameer Kumar Kotra
 */
public class TestEnvironment
{
	/**
	 * Test movement of Human to North Direction.
	 */
	@Test
	public void testMovementHumanNorth()
	{
		LifeForm lifeForm = new Human("Bob", 50, 10);
		LifeForm lifeForm1 = new Human("Bob", 50, 10);
		Environment environment = Environment.getWorldInstance();

		// with out Obstacle.
		environment.addLifeForm(8, 5, lifeForm);
		environment.addLifeForm(2, 5, lifeForm1);
		environment.move(lifeForm);
		// Moves from 8,5 to 5,5.
		assertEquals(lifeForm, environment.getLifeForm(5, 5));
		assertNull(environment.getLifeForm(8, 5));

		// With Obstacle.
		environment.move(lifeForm);
		// Can not move to 2,5 as LifeForm is there so moves to 3,5.
		assertEquals(lifeForm, environment.getLifeForm(3, 5));
		assertNull(environment.getLifeForm(5, 5));
		reset();
	}

	/**
	 * Test movement of Human to South Direction.
	 */
	@Test
	public void testMovementHumanSouth()
	{
		LifeForm lifeForm = new Human("Bob", 50, 10);
		// Setting to South.
		lifeForm.setDirection(2);
		LifeForm lifeForm1 = new Human("Bob", 50, 10);
		Environment environment = Environment.getWorldInstance();

		// with out Obstacle.
		environment.addLifeForm(2, 5, lifeForm);
		environment.addLifeForm(8, 5, lifeForm1);
		environment.move(lifeForm);
		// Moves from 2,5 to 5,5.
		assertEquals(lifeForm, environment.getLifeForm(5, 5));
		assertNull(environment.getLifeForm(2, 5));

		// With Obstacle.
		environment.move(lifeForm);
		// Can not move to 8,5 as LifeForm is there so moves to 7,5.
		assertEquals(lifeForm, environment.getLifeForm(7, 5));
		assertNull(environment.getLifeForm(5, 5));
		reset();
	}

	/**
	 * Test movement of Alien to East.
	 */
	@Test
	public void testMovementAlienEast()
	{
		LifeForm lifeForm = new Alien("Bob", 50);
		// Setting to East.
		lifeForm.setDirection(1);
		LifeForm lifeForm1 = new Alien("Bob", 50);
		Environment environment = Environment.getWorldInstance();

		// with out Obstacle.
		environment.addLifeForm(2, 2, lifeForm);
		environment.addLifeForm(2, 6, lifeForm1);
		environment.move(lifeForm);
		// Moves from 2,2 to 2,4.
		assertEquals(lifeForm, environment.getLifeForm(2, 4));
		assertNull(environment.getLifeForm(2, 2));

		// With Obstacle.
		environment.move(lifeForm);
		// Can not move to 2,6 as LifeForm is there so moves to 2,5.
		assertEquals(lifeForm, environment.getLifeForm(2, 5));
		assertNull(environment.getLifeForm(2, 4));
		reset();
	}

	/**
	 * Test movement of Alien to West.
	 */
	@Test
	public void testMovementAlienWest()
	{
		LifeForm lifeForm = new Alien("Bob", 50);
		// Setting to West.
		lifeForm.setDirection(3);
		LifeForm lifeForm1 = new Alien("Bob", 50);
		Environment environment = Environment.getWorldInstance();

		// with out Obstacle.
		environment.addLifeForm(2, 6, lifeForm);
		environment.addLifeForm(2, 2, lifeForm1);
		environment.move(lifeForm);
		// Moves from 2,6 to 2,4.
		assertEquals(lifeForm, environment.getLifeForm(2, 4));
		assertNull(environment.getLifeForm(2, 6));

		// With Obstacle.
		environment.move(lifeForm);
		// Can not move to 2,2 as LifeForm is there so moves to 2,3.
		assertEquals(lifeForm, environment.getLifeForm(2, 3));
		assertNull(environment.getLifeForm(2, 4));
		reset();
	}

	/**
	 * Old Tests.
	 * Test the initialization of the Environment.
	 */
	@Test
	public void testInitialization()
	{
		Environment environment1 = Environment.getWorldInstance();

		assertNull(environment1.getLifeForm(0, 0));
		assertNull(environment1.getLifeForm(4, 3));

		Environment environment2 = Environment.getWorldInstance();

		assertEquals(environment1, environment2);
	}

	/**
	 * Reset the instance after each Test.
	 */
	@After
	public void reset()
	{
		Environment.resetInstance();
	}

	/**
	 * Reset environment method to use for other tests.
	 */
	public static void resetEnvironment()
	{
		Environment.resetInstance();
	}

	/**
	 * Test Add and remove weapon from a specific location.
	 */
	@Test
	public void testAddRemoveWeapon()
	{
		Environment environment = Environment.getWorldInstance();
		Weapon weapon1 = new Pistol();
		Weapon weapon2 = new ChainGun();

		assertTrue(environment.addWeapon(1, 1, weapon1));

		assertTrue(environment.addWeapon(1, 1, weapon2));

		assertFalse(environment.addWeapon(12, 12, weapon1));
		assertFalse(environment.addWeapon(12, 1, weapon1));
		assertFalse(environment.addWeapon(1, 12, weapon1));

		assertEquals(weapon1, environment.removeWeapon(1, 1, 1));
		assertEquals(weapon2, environment.removeWeapon(1, 1, 1));

		assertNull(environment.removeWeapon(12, 1, 1));
		assertNull(environment.removeWeapon(1, 12, 1));
		assertNull(environment.removeWeapon(12, 12, 1));
		reset();
	}

	/**
	 * Find distance between the LifeForms.
	 */
	@Test
	public void testRange()
	{
		Environment environment = Environment.getWorldInstance();
		LifeForm lifeForm1 = new MockLifeForm("Bob", 40);
		LifeForm lifeForm2 = new MockLifeForm("Alice", 30);
		LifeForm lifeForm3 = new MockLifeForm("Tom", 40);

		environment.addLifeForm(0, 0, lifeForm1);
		environment.addLifeForm(0, 2, lifeForm2);
		environment.addLifeForm(4, 2, lifeForm3);

		// Same Row.
		assertEquals(10, environment.getDistance(lifeForm1, lifeForm2));
		// Same Column.
		assertEquals(20, environment.getDistance(lifeForm2, lifeForm3));
		// Different row and different column.
		assertEquals(22, environment.getDistance(lifeForm1, lifeForm3));

		environment.removeLifeForm(0, 2);
		assertEquals(-1, environment.getDistance(lifeForm1, lifeForm2));
		assertEquals(-1, environment.getDistance(lifeForm2, lifeForm3));
		reset();
	}

	/**
	 * Old tests.
	 * Test the setting of LifeFrom in the Environment.
	 */
	@Test
	public void testSetLifeForm()
	{
		Environment environment = Environment.getWorldInstance();
		LifeForm bob = new MockLifeForm("Bob", 40);

		// The cell is empty so this should work.
		boolean success = environment.addLifeForm(1, 2, bob);
		assertTrue(success);
		assertEquals(bob, environment.getLifeForm(1, 2));

		// The cell is not empty so this should fail.
		success = environment.addLifeForm(1, 2, bob);
		assertFalse(success);

		// The cell in empty we should get null
		assertNull(environment.getLifeForm(0, 0));

		// The cell location is invalid we should get null
		assertNull(environment.getLifeForm(0, 15));

		// The cell location is invalid we should get null
		assertNull(environment.getLifeForm(12, 15));
		reset();
	}

	/**
	 * Test the border conditions while adding the LifeFrom to Environment.
	 */
	@Test
	public void testBorderConditions()
	{
		Environment environment = Environment.getWorldInstance();
		LifeForm bob = new MockLifeForm("Bob", 40);

		// Can not add at location 12,0 as rows exceed size
		boolean success = environment.addLifeForm(12, 0, bob);
		assertFalse(success);

		// Can not add at location 0,12 as column exceed size
		success = environment.addLifeForm(0, 12, bob);
		assertFalse(success);
		reset();
	}

	/**
	 * Test the removing of LifeFrom from the Environment.
	 */
	@Test
	public void testRemoveLifeForm()
	{
		Environment environment = Environment.getWorldInstance();
		LifeForm bob = new MockLifeForm("Bob", 40);

		// The cell is empty so this should work.
		boolean success = environment.addLifeForm(1, 2, bob);
		assertTrue(success);

		// Life form is added do it should work.
		assertEquals(bob, environment.removeLifeForm(1, 2));

		// Life form is not added at location 1, so it should fail.
		assertNull(environment.removeLifeForm(1, 1));

		// Location out of range so it should return null
		assertNull(environment.removeLifeForm(4, 13));

		// Location out of range so it should return null
		assertNull(environment.removeLifeForm(11, 3));

		// Location out of range so it should return null
		assertNull(environment.removeLifeForm(12, 11));
	}
}
