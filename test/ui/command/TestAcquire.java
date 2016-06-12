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
import environment.Environment;
import environment.TestEnvironment;
/**
 * The test cases for the Acquire class.
 */
public class TestAcquire 
{
	/**
	 * Test Acquire weapon with one available
	 */
	@Test
	public void testAcquireAvailableWeapon() 
	{
		LifeForm entity1= new Human("Bob",40,5);
		Environment env= Environment.getWorldInstance();
		Command acquire=new Acquire(entity1);
		Weapon pistol= new Pistol();
		env.addWeapon(7, 7, pistol);
		env.addLifeForm(7, 7, entity1);
		acquire.execute();
		assertEquals(pistol, entity1.getWeapon());
		TestEnvironment.resetEnvironment();
	}
	/**
	 * Test Acquire with no weapon available
	 */
	@Test
	public void testAcquireNoAvailableWeapon() 
	{
		LifeForm entity1= new Human("Bob",40,5);
		Environment env= Environment.getWorldInstance();
		Command acquire=new Acquire(entity1);
		env.addLifeForm(7, 7, entity1);
		acquire.execute();
		assertNull(entity1.getWeapon());
		TestEnvironment.resetEnvironment();

	}
	/**
	 * Test Acquire weapon with weapon available, but already have weapon equipped 
	 */
	@Test
	public void testAcquireAvailableWeaponWithWeaponEquipped() 
	{
		LifeForm entity1= new Human("Bob",40,5);
		Environment env= Environment.getWorldInstance();
		Command acquire=new Acquire(entity1);
		Weapon pistol1= new Pistol();
		Weapon pistol2= new Pistol();
		Weapon pistol3= new Pistol();
		env.addWeapon(7, 7, pistol1);
		env.addWeapon(7, 7, pistol2);
		env.addLifeForm(7, 7, entity1);
		entity1.pickUp(pistol3);
		acquire.execute();
		assertEquals(pistol1, entity1.getWeapon());
		TestEnvironment.resetEnvironment();
	}
}
