package ui;

import static org.junit.Assert.assertEquals;

import javax.swing.JOptionPane;

import org.junit.Test;

import environment.Environment;
import environment.TestEnvironment;
import lifeform.Alien;
import lifeform.Human;
import weapon.ChainGun;
import weapon.Pistol;
import weapon.PlasmaCannon;

/**
 * Test the Map of the Display.
 * @author Sameer Kumar Kotra
 */
public class TestGameDisplayMap
{

	/**
	 * Test the LifeForm is displayed Correctly.
	 */
	@Test
	public void testMapLifeForm()
	{
		Human human1 = new Human("bob1", 40, 10);
		Human human2 = new Human("bob2", 40, 10);
		Alien alien1 = new Alien("jadu1", 30);
		Alien alien2 = new Alien("jadu2", 30);

		Pistol pistol = new Pistol();
		ChainGun chainGun = new ChainGun();
		human2.pickUp(pistol);
		alien2.pickUp(chainGun);
		Environment environment = Environment.getWorldInstance();

		environment.addLifeForm(0, 0, human1);
		environment.addLifeForm(0, 1, alien1);
		environment.addLifeForm(0, 2, human2);
		environment.addLifeForm(0, 3, alien2);

		GameDisplay display = new GameDisplay();
		environment.setDisplay(display);

		// Human with out Weapon is displayed correctly.
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null,
				"At Cell 0,0 Human is displayed in center \n North is displayed at top and all other are NULL"));
		// Alien with out Weapon is displayed correctly.
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null,
				"At Cell 0,1 Alien is displayed in center \n North is displayed at top and all other are NULL"));
		// Human with Weapon is displayed correctly.
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null,
				"At Cell 0,2 Human is displayed in center \n North is displayed at top \n Pistol is displayed at down and all other are NULL"));
		// Alien with Weapon is displayed correctly.
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null,
				"At Cell 0,3 Alien is displayed in center \n North is displayed at top \n ChainGun is displayed at down and all other are NULL"));

		TestEnvironment.resetEnvironment();
	}

	/**
	 * Test the Weapon is displayed Correctly.
	 */
	@Test
	public void testMapWeapon()
	{
		Pistol pistol = new Pistol();
		ChainGun chainGun = new ChainGun();
		PlasmaCannon cannon = new PlasmaCannon();
		Environment environment = Environment.getWorldInstance();

		environment.addWeapon(0, 0, pistol);
		environment.addWeapon(0, 1, chainGun);
		environment.addWeapon(0, 2, cannon);

		environment.addWeapon(1, 0, chainGun);
		environment.addWeapon(1, 0, cannon);
		GameDisplay display = new GameDisplay();
		environment.setDisplay(display);

		// Pistol displayed correctly.
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null,
				"At Cell 0,0 Pistol is displayed to rigth side \n All other are NULL"));
		// ChainGun is displayed correctly.
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null,
				"At Cell 0,1 ChainGun is displayed to rigth side \n All other are NULL"));
		// PlasmaCannon is displayed correctly.
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null,
				"At Cell 0,2 PlasmaConnon is displayed to rigth side \n All other are NULL"));

		// Weapon1 and 2 displayed correctly.
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null,
				"At Cell 1,0 ChainGun to displayed on Rigth Side \n PlasmaCannon is displayed on Left side. "));
		TestEnvironment.resetEnvironment();
	}

	/**
	 * test Map receives update from Environment.
	 */
	@Test
	public void testReceiveUpdate()
	{
		Human human = new Human("bob1", 40, 10);
		Environment environment = Environment.getWorldInstance();
		human.setDirection(1);
		environment.addLifeForm(0, 0, human);
		GameDisplay display = new GameDisplay();
		environment.setDisplay(display);

		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "At Cell 0,0 Human is displayed."));

		environment.move(human);
		environment.informDisplay();
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "Human at Cell 0,0 is moved to 0,3"));
	}
}
