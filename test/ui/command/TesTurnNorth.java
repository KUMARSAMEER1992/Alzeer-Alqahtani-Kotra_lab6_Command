package ui.command;

import static org.junit.Assert.*;
import lifeform.Human;
import lifeform.LifeForm;

import org.junit.Test;

import environment.Environment;

public class TesTurnNorth 
{
/**
 * Test changes selected player's dieriction to north
 */
	@Test
	public void test() 
	{
		LifeForm entity1= new Human("Bob",40,5);
		Environment env= Environment.getWorldInstance();
		Command turnNorth=new TurnNorth(entity1);
		// lifeform turen to south
		entity1.setDirection(2);
		turnNorth.execute();
		assertEquals(0,entity1.getDirection());
		
	}
}
