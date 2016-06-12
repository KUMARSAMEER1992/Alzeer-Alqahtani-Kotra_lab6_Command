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
 * The test cases for the TurnSouth class.
 */
public class TestTurnSouth 
{
	/**
	 * Test changes selected player's direction to South
	 */
		@Test
		public void test() 
		{
			LifeForm entity1= new Human("Bob",40,5);
			Environment env= Environment.getWorldInstance();
			Command turnSouth=new TurnSouth(entity1);
			turnSouth.execute();
			assertEquals(2,entity1.getDirection());
			
		}
}
