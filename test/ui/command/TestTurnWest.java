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

import environment.Environment;
/**
 * The test cases for the TurnWest class.
 */
public class TestTurnWest 
{
	/**
	 * Test changes selected player's direction to West
	 */
	@Test
	public void test() 
	{
		LifeForm entity1= new Human("Bob",40,5);
		Environment env= Environment.getWorldInstance();
		Command turnWest=new TurnWest(entity1);
		turnWest.execute();
		assertEquals(3,entity1.getDirection());
	}

}
