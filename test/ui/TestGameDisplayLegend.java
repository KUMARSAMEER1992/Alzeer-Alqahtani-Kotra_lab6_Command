package ui;

import static org.junit.Assert.assertEquals;

import javax.swing.JOptionPane;

import org.junit.Test;

/**
 * Test the Legend of the Display.
 * @author Sameer Kumar Kotra
 */
public class TestGameDisplayLegend
{

	/**
	 * test Legend displayed Correctly.
	 */
	@Test
	public void testLegend()
	{
		GameDisplay display = new GameDisplay();
		// Test Human.
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "Legend displayed \n H - Human"));
		// Test Alien.
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "Legend displayed \n A - Alien"));
		// Test Weapons
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "Legend displayed \n PI - Pistol"));
		assertEquals(JOptionPane.YES_OPTION,
				JOptionPane.showConfirmDialog(null, "Legend displayed \n Pl - Plasma Gun"));
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "Legend displayed \n CH - Chain Gun"));

	}

}
