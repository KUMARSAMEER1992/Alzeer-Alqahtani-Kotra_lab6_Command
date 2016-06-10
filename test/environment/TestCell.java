package environment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import lifeform.LifeForm;
import lifeform.MockLifeForm;
import weapon.ChainGun;
import weapon.Pistol;
import weapon.PlasmaCannon;
import weapon.Weapon;

/**
 * The test cases for the Cell class
 * @author : Sameer Kumar Kotra
 */
public class TestCell
{

	/**
	 * Test the initialization of the Cell.
	 */
	@Test
	public void testInitialization()
	{
		Cell cell = new Cell();
		// LifeForm will be null when new Cell is created.
		assertNull(cell.getLifeForm());
		assertNull(cell.getWeapon(1));
		assertNull(cell.getWeapon(2));
	}

	/**
	 * Test add and remove weapons to the cell.
	 */
	@Test
	public void testAddReamoveWeapons()
	{
		Cell cell = new Cell();
		Weapon weapon1 = new Pistol();
		Weapon weapon2 = new ChainGun();
		Weapon weapon3 = new PlasmaCannon();

		// Adds as there is no weapon.
		assertTrue(cell.addWeapon(weapon1));
		// Adds there is only one weapon.
		assertTrue(cell.addWeapon(weapon2));
		// Can not add as there are 2 weapons.
		assertFalse(cell.addWeapon(weapon3));

		assertEquals(weapon1, cell.getWeapon(1));
		assertEquals(weapon2, cell.getWeapon(2));

		assertEquals(weapon1, cell.removeWeapon(1));
		// Returns null as weapon at position 1 is removed weapon at 2 is moved
		// to position 1.
		assertNull(cell.getWeapon(2));
		// Returns Null as there is no Weapon.
		assertNull(cell.removeWeapon(2));

		assertEquals(weapon2, cell.getWeapon(1));
		// Returns weapon2
		assertEquals(weapon2, cell.removeWeapon(1));

		assertNull(cell.getWeapon(1));

		// Position is wrong
		assertNull(cell.getWeapon(3));
		assertNull(cell.getWeapon(-3));
		assertNull(cell.removeWeapon(-3));
		assertNull(cell.removeWeapon(3));
	}

	/**
	 * Old Tests.
	 * Test the setting of LifeFrom in the Cell.
	 */
	@Test
	public void testSetLifeForm()
	{
		LifeForm bob = new MockLifeForm("Bob", 40);
		LifeForm fred = new MockLifeForm("Fred", 40);
		Cell cell = new Cell();

		// The cell is empty so this should work.
		boolean success = cell.addLifeForm(bob);
		assertTrue(success);
		assertEquals(bob, cell.getLifeForm());

		// The cell is not empty so this should fail.
		success = cell.addLifeForm(fred);
		assertFalse(success);
		assertEquals(bob, cell.getLifeForm());
	}

	/**
	 * Test the removing of LifeFrom from the Cell.
	 */
	@Test
	public void testRemoveLifeForm()
	{
		LifeForm bob = new MockLifeForm("Bob", 40);
		Cell cell = new Cell();

		// The cell is empty so this should work.
		boolean success = cell.addLifeForm(bob);
		assertTrue(success);

		// LifeForm is present so it should return the LifeForm
		assertEquals(bob, cell.removeLifeForm());

		// LifeForm is removed so it should return null
		assertNull(cell.removeLifeForm());
	}

}