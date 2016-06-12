/**
 *  Name:Norah Alqahtani
 *  Course:CSC 561
 *  Instructor: Dr. Girard
 */
package ui.command;

import static org.junit.Assert.*;
import lifeform.Human;
import lifeform.LifeForm;

import org.junit.Test;

import weapon.Pistol;
import weapon.Weapon;
/**
 * The test cases for the Reload class.
 */
public class TestReload 
{
	/**
	 * Test empties then reloads a player's weapon
	 */
	@Test
	public void testReload() 
	{
		LifeForm entity1= new Human("Bob",40,5);
		Weapon weapon= new Pistol();
		entity1.pickUp(weapon);
		Command reload= new Reload(entity1);
		weapon.fire(10);
		weapon.fire(10);
		weapon.fire(10);
		weapon.fire(10);
		weapon.fire(10);
		weapon.fire(10);
		weapon.fire(10);
		weapon.fire(10);
		weapon.fire(10);
		weapon.fire(10);
		weapon.fire(10);
		// empty
		assertEquals(0,weapon.getActualAmmo());
		//reload
		reload.execute();
		assertEquals(10,weapon.getActualAmmo());
			
	}
	
}
