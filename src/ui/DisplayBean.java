package ui;

import javax.swing.JLabel;

/**
 * This class contains constants to be displayed and the Jlabel for contents of
 * the Cell in Environment.
 * @author Sameer Kumar Kotra
 */
public class DisplayBean
{
	/**
	 * Constants to be displayed on the Map.
	 */
	public final static String EMPTY = "  ";
	public final static String HUMANSTRING = "H";
	public final static String ALIENSTRING = "A";
	public final static String PISTOLSTRING = "PI";
	public final static String PLASMACANNONSTRING = "PL";
	public final static String CHAINGUNSTRING = "CH";
	public final static String NORTH = "N";
	public final static String EAST = "E";
	public final static String WEST = "W";
	public final static String SOUTH = "S";
	/**
	 * JLabel to display lifeForm.
	 */
	private JLabel lifeForm;
	/**
	 * JLabel to display direction of LifeForm.
	 */
	private JLabel direction;
	/**
	 * JLabel to display the weapon in the cell.
	 */
	private JLabel weapon1;
	/**
	 * JLabel to display the weapon in the cell.
	 */
	private JLabel weapon2;
	/**
	 * JLabel to display the weapon LifeForm holding.
	 */
	private JLabel lifeFormWeapon;

	/**
	 * Constructs the DisaplayBean with default value.
	 */
	DisplayBean()
	{
		lifeForm = new JLabel(EMPTY);
		direction = new JLabel(EMPTY);
		weapon1 = new JLabel(EMPTY);
		weapon2 = new JLabel(EMPTY);
		lifeFormWeapon = new JLabel(EMPTY);
	}

	/**
	 * @return the LifeForm label.
	 */
	public JLabel getLifeForm()
	{
		return lifeForm;
	}

	/**
	 * @return the direction label.
	 */
	public JLabel getDirection()
	{
		return direction;
	}

	/**
	 * @return the weapon label.
	 */
	public JLabel getWeapon1()
	{
		return weapon1;
	}

	/**
	 * @return the weapon label.
	 */
	public JLabel getWeapon2()
	{
		return weapon2;
	}

	/**
	 * @return the lifeFormWeapon label.
	 */
	public JLabel getLifeFormWeapon()
	{
		return lifeFormWeapon;
	}
}
