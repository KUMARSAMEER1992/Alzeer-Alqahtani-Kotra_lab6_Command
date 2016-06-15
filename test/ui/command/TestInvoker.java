/**
 *  Name:Dalal Alzeer
 *  Course:CSC 561
 *  Instructor: Dr. Girard
 */
package ui.command;
import org.junit.Test;

import junit.framework.TestCase;
import lifeform.Human;
import lifeform.LifeForm;
/**
 * test cases for Invoker class
 */
public class TestInvoker extends TestCase 
{
	/**
	 * test that clicking buttons call correct attached command
	 */
	@Test
	public void testInvoker()
	{
		Invoker invoker=new Invoker();
		LifeForm lifeForm=new Human("bob", 30, 10);
		//test TurnNorth
		MockCammand c1=new MockCammand(lifeForm);
		invoker.setTurnNorth(c1);
		assertEquals(0,c1.testValue);
		invoker.btnNorth.doClick();
		assertEquals(1,c1.testValue);
		//test TurnEast
		MockCammand c2=new MockCammand(lifeForm);
		invoker.setTurnEast(c2);
		assertEquals(0,c2.testValue);
		invoker.btnEast.doClick();
		assertEquals(1,c2.testValue);
		//test TurnSouth
		MockCammand c3=new MockCammand(lifeForm);
		invoker.setTurnSouth(c3);
		assertEquals(0,c3.testValue);
		invoker.btnSouth.doClick();
		assertEquals(1,c3.testValue);
		//test TurnWest
		MockCammand c4=new MockCammand(lifeForm);
		invoker.setTurnWest(c4);
		assertEquals(0,c4.testValue);
		invoker.btnWest.doClick();
		assertEquals(1,c4.testValue);
		//test Acquire
		MockCammand c5=new MockCammand(lifeForm);
		invoker.setAcquire(c5);
		assertEquals(0,c5.testValue);
		invoker.btnAcquire.doClick();
		assertEquals(1,c5.testValue);
		//test Drop
		MockCammand c6=new MockCammand(lifeForm);
		invoker.setDrop(c6);
		assertEquals(0,c6.testValue);
		invoker.btnDrop.doClick();
		assertEquals(1,c6.testValue);
		//test Move 
		MockCammand c=new MockCammand(lifeForm);
		invoker.setMove(c);
		assertEquals(0,c.testValue);
		invoker.btnMove.doClick();
		assertEquals(1,c.testValue);
		//test Attack
		MockCammand c7=new MockCammand(lifeForm);
		invoker.setAttack(c7);
		assertEquals(0,c7.testValue);
		invoker.btnAttack.doClick();
		assertEquals(1,c7.testValue);
		//test Reload
		MockCammand c8=new MockCammand(lifeForm);
		invoker.setReload(c8);
		assertEquals(0,c8.testValue);
		invoker.btnReload.doClick();
		assertEquals(1,c8.testValue);		
	}
}
