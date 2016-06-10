package lifeform;

import environment.Environment;
import gameplay.TimeObserver;
import weapon.Weapon;

/**
 * This class consists members and functions related to LifeForm.
 * @author : Sameer Kumar Kotra
 */
public abstract class LifeForm implements TimeObserver
{
	/**
	 * String to store the name of the LifeForm.
	 */
	private String myName;

	/**
	 * int to store the life points of the LifeForm. It can be accessed by sub
	 * classes.
	 */
	protected int currentLifePoints;

	/**
	 * int to store the strength of the LifeForm.
	 */
	protected int attachStrength;

	/**
	 * Weapon to store the weapon the LifeForm has.
	 */
	private Weapon weapon;

	/**
	 * int to store X coordinate in Environment.
	 */
	private int locationX;

	/**
	 * int to store Y coordinate in Environment.
	 */
	private int locationY;

	/**
	 * int to store the direction of the LifeForm.
	 */
	private int direction;

	/**
	 * int to store the max speed of the LifeForm.
	 */
	protected int maxSpeed;

	/**
	 * Create an instance of LifeForm with given values.
	 * @param name: The name of the life form.
	 * @param points :The current starting life points of the life form.
	 */
	public LifeForm(String name, int points)
	{
		myName = name;
		currentLifePoints = (points >= 0) ? points : 0;
		attachStrength = 0;
		weapon = null;
		locationX = -1;
		locationY = -1;
		direction = 0;
		maxSpeed = 0;
	}

	/**
	 * Create an instance of LifeForm with given values.
	 * @param name: The name of the life form.
	 * @param points : The current starting life points of the life form.
	 * @param strength: The Strength of the LifeForm.
	 */
	public LifeForm(String name, int points, int strength)
	{
		this(name, points);
		this.attachStrength = (strength >= 0) ? strength : 0;
	}

	/**
	 * Returns the name of the LifeForm.
	 * @return the name of the life form.
	 */
	public String getName()
	{
		return myName;
	}

	/**
	 * Returns the current life points of a LifeForm.
	 * @return the amount of current life points the life form has.
	 */
	public int getCurrentLifePoints()
	{
		return currentLifePoints;
	}

	/**
	 * Reduces the damage from current life points.
	 * @param damage : specifies the damage to the LifeForm.
	 */
	public void takeHit(int damage)
	{
		if (damage > 0)
		{
			currentLifePoints -= damage;
			currentLifePoints = (currentLifePoints >= 0) ? currentLifePoints : 0;
		}
	}

	/**
	 * Returns the strength of a LifeForm.
	 * @return the strength the life form has.
	 */
	public int getAttachStrength()
	{
		return attachStrength;
	}

	/**
	 * Used to attack a LifeForm.
	 * lifeForm1.attack(lifeForm2).
	 * lifeForm1:attacker.
	 * lifeForm2:attacked.
	 * @param lifeForm2 : It is attached by the calling LifeForm.
	 */
	public void attack(LifeForm lifeForm2)
	{
		Environment environment = Environment.getWorldInstance();
		int distance = environment.getDistance(this, lifeForm2);
		if (getCurrentLifePoints() > 0)
		{
			if (weapon == null || weapon.getActualAmmo() == 0)
			{
				if (distance <= 10)
				{
					lifeForm2.takeHit(getAttachStrength());
				}
			}
			else
			{

				lifeForm2.takeHit(weapon.fire(distance));
			}
		}
	}

	/**
	 * When the time is changed the timer notifies this method of the Observer.
	 * It performs nothing in here.
	 * @param time : updated time
	 */
	@Override
	public void updateTime(int time)
	{
	}

	/**
	 * Pickup the Weapon.
	 * @param weapon : The weapon to be picked up.
	 */
	public void pickUp(Weapon weapon)
	{
		if (this.weapon == null)
		{
			this.weapon = weapon;
		}
	}

	/**
	 * @return the weapon the LifeForm has.
	 */
	public Weapon getWeapon()
	{
		return weapon;
	}

	/**
	 * Drops the weapon the LifeForm has.
	 */
	public Weapon dropWeapon()
	{
		Weapon temp=weapon;
		weapon = null;
		return temp;
	}

	/**
	 * Reloads the weapon the lifeForm has.
	 */
	public void reload()
	{
		weapon.relod();
	}

	/**
	 * @return the x coordinate in environment.
	 */
	public int getX()
	{
		return this.locationX;
	}

	/**
	 * @return the y coordinate in environment.
	 */
	public int getY()
	{
		return this.locationY;
	}

	/**
	 * Sets the location X & Y value.
	 * @param x : value of X to be stored in LifeForm.
	 * @param y : value of Y to be stored in LifeForm.
	 */
	public void setLocationXY(int x, int y)
	{
		this.locationX = x;
		this.locationY = y;
	}

	/**
	 * Resets the location X , Y values.
	 */
	public void removeLocationXY()
	{
		this.locationX = -1;
		this.locationY = -1;
	}

	/**
	 * @return the direction of the LifeForm
	 *         0 - North
	 *         1 - East
	 *         2 - south
	 *         3- West
	 */
	public int getDirection()
	{
		return this.direction;
	}

	/**
	 * @param direction : direction to be stored.
	 *            0 - North
	 *            1 - East
	 *            2 - south
	 *            3- West
	 */
	public void setDirection(int direction)
	{
		this.direction = (direction >= 0) ? ((direction < 4) ? direction : 0) : 0;
	}

	/**
	 * @return max speed of the LifeForm.
	 */
	public int getMaxSpeed()
	{
		return this.maxSpeed;
	}

	/**
	 * @param maxSpeed : Speed to be stored.
	 */
	public void setMaxSpeed(int maxSpeed)
	{
		this.maxSpeed = (maxSpeed > 0) ? maxSpeed : 0;
	}

}
