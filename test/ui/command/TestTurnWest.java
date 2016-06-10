package ui.command;

import static org.junit.Assert.*;
import lifeform.Human;
import lifeform.LifeForm;

import org.junit.Test;

import environment.Environment;

public class TestTurnWest {

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
