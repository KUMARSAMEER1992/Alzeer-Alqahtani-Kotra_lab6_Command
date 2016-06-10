package environment;

import java.util.ArrayList;

import lifeform.LifeForm;
import weapon.Weapon;

/**
 * This class consists members and functions related to Cell. Each Cell can hold
 * one life form.
 * @author : Sameer Kumar Kotra
 */

public class Cell
{
	/**
	 * LifeForm to store the LifeForm in the cell.
	 */
	private LifeForm entity;

	/**
	 * Weapon to store weapons in cell.
	 */
	private ArrayList<Weapon> weapons;

	/**
	 * Create an instance of Cell.
	 */
	public Cell()
	{
		entity = null;
		weapons = new ArrayList<Weapon>();
	}

	/**
	 * Adds the LifeForm to the Cell. Will not add if LifeForm already in the
	 * Cell.
	 * @param entity: LifeForm object to be store in the Cell.
	 * @return true if added, false otherwise.
	 */
	public boolean addLifeForm(LifeForm entity)
	{
		if (this.entity == null)
		{
			this.entity = entity;
			return true;
		}
		return false;
	}

	/**
	 * Removes the LifeForm from the Cell.
	 * @return LifeForm removed, null if none is present.
	 */
	public LifeForm removeLifeForm()
	{
		if (entity != null)
		{
			LifeForm temp = entity;
			entity = null;
			return temp;
		}
		return null;
	}

	/**
	 * Returns the LifeForm in the Cell.
	 * @return LifeForm present in the Cell.
	 */
	public LifeForm getLifeForm()
	{
		return entity;
	}

	/**
	 * returns the weapon if present or returns null;
	 * @param position : specifies the number 1 or 2.
	 * @return weapon if present or null.
	 */
	public Weapon getWeapon(int position)
	{
		if (0 < position && position < 3)
		{
			if (position <= weapons.size())
			{
				return weapons.get(position - 1);
			}
			return null;
		}
		return null;
	}

	/**
	 * Adds the weapon to the Cell.
	 * @param weapon :weapon to be added to the Cell.
	 * @return True if added else false.
	 */
	public boolean addWeapon(Weapon weapon)
	{
		if (weapons.size() < 2)
		{
			weapons.add(weapon);
			return true;
		}
		return false;
	}

	/**
	 * Removes the weapon from the Cell at that position.
	 * @param position : position at which weapon should be removed.
	 * @return Weapon if removed else null.
	 */
	public Weapon removeWeapon(int position)
	{
		if (0 < position && position < 3)
		{
			if (position <= weapons.size())
			{
				return weapons.remove(position - 1);
			}
			return null;
		}
		return null;
	}
}