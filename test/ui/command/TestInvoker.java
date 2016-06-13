package ui.command;

import org.junit.Test;

import junit.framework.TestCase;
import lifeform.Human;
import lifeform.LifeForm;

public class TestInvoker extends TestCase {

	@Test
	public void testInvoker()
	{
		Invoker invoker=new Invoker();
		LifeForm lifeForm=new Human("bob", 30, 10);
		MockCammand c=new MockCammand(lifeForm);
		invoker.setMove(c);
		assertEquals(0,c.testValue);
		invoker.btnMove.doClick();
		assertEquals(1,c.testValue);
		
		MockCammand c1=new MockCammand(lifeForm);
		invoker.setAcquire(c1);
		assertEquals(0,c1.testValue);
		invoker.btnAcquire.doClick();
		assertEquals(1,c1.testValue);
		
		
		MockCammand c2=new MockCammand(lifeForm);
		invoker.setReload(c2);
		assertEquals(0,c2.testValue);
		invoker.btnReload.doClick();
		assertEquals(1,c2.testValue);
		
		MockCammand c3=new MockCammand(lifeForm);
		invoker.setAttack(c3);
		assertEquals(0,c3.testValue);
		invoker.btnAttack.doClick();
		assertEquals(1,c3.testValue);
		
		MockCammand c4=new MockCammand(lifeForm);
		invoker.setDrop(c4);
		assertEquals(0,c4.testValue);
		invoker.btnDrop.doClick();
		assertEquals(1,c4.testValue);
		
		MockCammand c5=new MockCammand(lifeForm);
		invoker.setTurnWest(c5);
		assertEquals(0,c5.testValue);
		invoker.btnWest.doClick();
		assertEquals(1,c5.testValue);
		
		MockCammand c6=new MockCammand(lifeForm);
		invoker.setTurnEast(c6);
		assertEquals(0,c6.testValue);
		invoker.btnEast.doClick();
		assertEquals(1,c6.testValue);
		
		MockCammand c7=new MockCammand(lifeForm);
		invoker.setTurnSouth(c7);
		assertEquals(0,c7.testValue);
		invoker.btnSouth.doClick();
		assertEquals(1,c7.testValue);
		
		MockCammand c8=new MockCammand(lifeForm);
		invoker.setTurnNorth(c8);
		assertEquals(0,c8.testValue);
		invoker.btnNorth.doClick();
		assertEquals(1,c8.testValue);
		
		
	}
}
