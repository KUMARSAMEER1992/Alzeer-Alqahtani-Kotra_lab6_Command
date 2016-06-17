/**
 *  Name:Dalal Alzeer
 *  Course:CSC 561
 *  Instructor: Dr. Girard
 */
package ui.command;
import lifeform.LifeForm;
/**
 * MockCammand to test command
 */
public class MockCammand implements Command 
{
	int testValue;
	/**
	 * create MockCammand with test value
	 * @param lifeForm
	 */
	public MockCammand(LifeForm lifeForm)
	{
		testValue=0;
	}
	/**
	 * when execute a command, change test value
	 */
	@Override
	public void execute() 
	{
		testValue=1;
	}
	

}
