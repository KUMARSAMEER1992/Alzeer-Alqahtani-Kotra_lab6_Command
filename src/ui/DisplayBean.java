package ui;

import javax.swing.JLabel;

/**
 * @author Sameer Kumar Kotra
 */
public class DisplayBean
{
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
	private JLabel lifeForm;
	private JLabel direction;
	private JLabel weapon1;
	private JLabel weapon2;
	private JLabel lifeFormWeapon;

	DisplayBean()
	{
		/*
		 * lifeForm = new JLabel("H");
		 * direction = new JLabel("N");
		 * weapon1 = new JLabel("PI");
		 * weapon2 = new JLabel("PL");
		 * lifeFormWeapon = new JLabel("CH");
		 */
		lifeForm = new JLabel(EMPTY);
		direction = new JLabel(EMPTY);
		weapon1 = new JLabel(EMPTY);
		weapon2 = new JLabel(EMPTY);
		lifeFormWeapon = new JLabel(EMPTY);
	}

	public JLabel getLifeForm()
	{
		return lifeForm;
	}

	public void setLifeForm(JLabel lifeForm)
	{
		this.lifeForm = lifeForm;
	}

	public JLabel getDirection()
	{
		return direction;
	}

	public void setDirection(JLabel direction)
	{
		this.direction = direction;
	}

	public JLabel getWeapon1()
	{
		return weapon1;
	}

	public void setWeapon1(JLabel weapon1)
	{
		this.weapon1 = weapon1;
	}

	public JLabel getWeapon2()
	{
		return weapon2;
	}

	public void setWeapon2(JLabel weapon2)
	{
		this.weapon2 = weapon2;
	}

	public JLabel getLifeFormWeapon()
	{
		return lifeFormWeapon;
	}

	public void setLifeFormWeapon(JLabel lifeFormWeapon)
	{
		this.lifeFormWeapon = lifeFormWeapon;
	}

}
