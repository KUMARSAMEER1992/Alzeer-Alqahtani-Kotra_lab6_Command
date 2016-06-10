package ui.command;

import static org.junit.Assert.*;
import lifeform.Alien;
import lifeform.Human;
import lifeform.LifeForm;

import org.junit.Test;

import environment.Environment;

public class TestAttack {

	@Test
	public void testAttack() 
	{
		
		LifeForm entity1= new Human("Bob",20,5);
		LifeForm entity2= new Alien("fred",40);
		Environment env= Environment.getWorldInstance();
		Command attack=new Attack(entity1);
		env.addLifeForm(8, 8, entity1);
		env.addLifeForm(7, 8, entity2);
		attack.execute();
		assertEquals(35,entity2.getCurrentLifePoints());
		
	}

}
