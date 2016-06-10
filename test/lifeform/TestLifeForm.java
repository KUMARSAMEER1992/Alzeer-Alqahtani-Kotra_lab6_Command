package lifeform;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import environment.Environment;
import environment.TestEnvironment;
import gameplay.TimeObserver;
import weapon.GenericWeapon;
import weapon.MockGenericWeapon;
import weapon.Pistol;
import weapon.Weapon;

/**
 * The test cases for the LifeForm class.
 * @author : Sameer Kumar Kotra
 */
public class TestLifeForm
{
	/**
	 * Test direction is LifeForm.
	 */
	@Test
	public void testDirection()
	{
		LifeForm entity = new MockLifeForm("Bob", 40, 10);
		// Initial Direction is North 0.
		assertEquals(0, entity.getDirection());
		entity.setDirection(2);
		// Modified to 2.
		assertEquals(2, entity.getDirection());

		// Sets 0 as it is invalid Direction.
		entity.setDirection(-2);
		assertEquals(0, entity.getDirection());

		// Sets 0 as it is invalid Direction.
		entity.setDirection(6);
		assertEquals(0, entity.getDirection());
	}

	/**
	 * Test Max Speed of LifeForm
	 */
	@Test
	public void testmaxSpeed()
	{
		LifeForm entity = new MockLifeForm("Bob", 40, 10);
		// Default 0;
		assertEquals(0, entity.getMaxSpeed());
		// Max speed is set to 2.
		entity.setMaxSpeed(2);
		assertEquals(2, entity.getMaxSpeed());

		// MAx speed can not be negative.
		entity.setMaxSpeed(-2);
		assertEquals(0, entity.getMaxSpeed());
	}

	/**
	 * Old tests
	 * Test to track location of LifeForm in environment.
	 */
	@Test
	public void trackLocation()
	{
		LifeForm entity = new MockLifeForm("Bob", 40, 10);
		assertEquals(-1, entity.getX());
		assertEquals(-1, entity.getY());

		entity.setLocationXY(2, 2);

		assertEquals(2, entity.getX());
		assertEquals(2, entity.getY());

		entity.removeLocationXY();

		assertEquals(-1, entity.getX());
		assertEquals(-1, entity.getY());
	}

	/**
	 * OldTests Decorator pattern.
	 * Tests the lifeForm can pickup only one Weapon.
	 */
	@Test
	public void TestCanPickupWeapon()
	{
		LifeForm entity = new MockLifeForm("Bob", 40, 10);
		Weapon weapon = new Pistol();
		entity.pickUp(weapon);

		assertEquals(weapon, entity.getWeapon());

		Weapon weapon1 = new Pistol();
		entity.pickUp(weapon1);
		// Can not pick weapon1 as weapon is already there.
		assertEquals(weapon, entity.getWeapon());

		entity.dropWeapon();
		// Null as it dropped the weapon.
		assertNull(entity.getWeapon());
	}

	/**
	 * Use weapon as it has Ammo.
	 */
	@Test
	public void TestUseWeapon()
	{
		Environment environment = Environment.getWorldInstance();
		LifeForm lifeForm1 = new MockLifeForm("Bob", 40, 10);
		LifeForm lifeForm2 = new MockLifeForm("Alice", 30, 10);

		Pistol pistol = new Pistol();
		lifeForm1.pickUp(pistol);

		environment.addLifeForm(0, 0, lifeForm1);
		environment.addLifeForm(0, 1, lifeForm2);

		lifeForm1.attack(lifeForm2);
		assertEquals(20, lifeForm2.getCurrentLifePoints());

		TestEnvironment.resetEnvironment();

	}

	/**
	 * Test when weapon has 0 Ammo.
	 */
	@Test
	public void TestDamage()
	{
		Environment environment = Environment.getWorldInstance();
		// Weapon with 0 Ammo.
		GenericWeapon weapon = new MockGenericWeapon(10, 25, 2, 0);
		LifeForm lifeForm1 = new MockLifeForm("Bob", 40, 10);
		LifeForm lifeForm2 = new MockLifeForm("Alice", 30, 10);

		lifeForm1.pickUp(weapon);

		environment.addLifeForm(0, 0, lifeForm1);
		environment.addLifeForm(0, 1, lifeForm2);

		lifeForm1.attack(lifeForm2);
		// Use strength to attack as it has 0 Ammo.
		assertEquals(20, lifeForm2.getCurrentLifePoints());

		weapon = new MockGenericWeapon(10, 15, 2, 2);
		environment.removeLifeForm(0, 1);
		environment.addLifeForm(0, 4, lifeForm2);

		lifeForm1.attack(lifeForm2);
		// No damage as the Target is out of range.
		assertEquals(20, lifeForm2.getCurrentLifePoints());
		TestEnvironment.resetEnvironment();
	}

	/**
	 * Test weather the Weapon can reload.
	 */
	@Test
	public void TestReload()
	{
		GenericWeapon weapon = new MockGenericWeapon(10, 25, 2, 2);
		LifeForm lifeForm1 = new MockLifeForm("Bob", 40, 10);
		LifeForm lifeForm2 = new MockLifeForm("Alice", 30, 10);

		lifeForm1.pickUp(weapon);

		lifeForm1.attack(lifeForm2);
		lifeForm1.attack(lifeForm2);

		assertEquals(0, lifeForm1.getWeapon().getActualAmmo());
		lifeForm1.reload();
		assertEquals(2, lifeForm1.getWeapon().getActualAmmo());
	}

	/**
	 * Old tests Observer pattern.
	 * Test the Strength of the LifeForm.
	 */
	@Test
	public void testLifeStrength()
	{
		LifeForm entity = new MockLifeForm("Bob", 40, 10);
		// Test getAttachStrength
		assertEquals(10, entity.getAttachStrength());
		entity = new MockLifeForm("Bob", 40, -10);
		assertEquals(0, entity.getAttachStrength());
	}

	/**
	 * Test the attack method of the LifeForm.
	 */
	@Test
	public void testAttack()
	{
		LifeForm lifeForm1 = new MockLifeForm("Bob", 40, 10);
		LifeForm lifeForm2 = new MockLifeForm("Alice", 30, 10);

		lifeForm1.attack(lifeForm2);
		// lifeForm2 decreases from 30 to 20.
		assertEquals(20, lifeForm2.getCurrentLifePoints());

		lifeForm1.currentLifePoints = 0;

		lifeForm1.attack(lifeForm2);
		// lifeForm2 remains 20 as lifeForm1 id dead.
		assertEquals(20, lifeForm2.getCurrentLifePoints());
	}

	/**
	 * Test weather lifeForm can track time..
	 */
	@Test
	public void testTrackTime()
	{
		LifeForm lifeForm1 = new MockLifeForm("Bob", 40, 10);
		assertTrue(lifeForm1 instanceof TimeObserver);
	}

	/**
	 * Old tests for Strategy pattern.
	 * Test the initialization of the LifeForm.
	 */
	@Test
	public void testInitialization()
	{
		LifeForm entity = new MockLifeForm("Bob", 40);
		assertEquals("Bob", entity.getName());
		assertEquals(40, entity.getCurrentLifePoints());

		entity = new MockLifeForm("Bob", -40);
		assertEquals("Bob", entity.getName());
		// LifeForm can not have negative life points so it should have 0.
		assertEquals(0, entity.getCurrentLifePoints());
	}

	/**
	 * Test the takeHit cases of the LifeForm.
	 */
	@Test
	public void testTakeHit()
	{
		LifeForm entity = new MockLifeForm("Bob", 50);

		// Take first hit.
		entity.takeHit(20);
		assertEquals(30, entity.getCurrentLifePoints());

		// Take hit when 0<current life points.
		entity.takeHit(30);
		assertEquals(0, entity.getCurrentLifePoints());

		// Take hit when life points is 0.
		entity.takeHit(10);
		assertEquals(0, entity.getCurrentLifePoints());

		// Can not take hit with negative damage points.
		entity.takeHit(-20);
		assertEquals(0, entity.getCurrentLifePoints());
	}

}