package environment;

import lifeform.LifeForm;
import ui.GameDisplay;
import weapon.Weapon;

/**
 * This class consists members and functions related to Environment.
 * Environment is a Singleton class.
 * @author : Sameer Kumar Kotra
 */
public class Environment
{

	/**
	 * Array of Cell to store multiple Cells.
	 */
	private Cell cells[][];

	// TODO
	public final static int ROWS = 10;
	public final static int COLS = 10;

	/**
	 * Environment to store instance.
	 */
	private static Environment theWorld;

	/**
	 * GameDispaly to hold display nstance.
	 */
	private GameDisplay display;

	/**
	 * Create an instance of Environment which has the given number of rows and
	 * Columns to store Cells.
	 * Constructor is private to create single ton pattern.
	 * @param row: Number of rows
	 * @param col :Number of columns.
	 */
	private Environment()
	{
		cells = new Cell[ROWS][COLS];
		for (int i = 0; i < ROWS; i++)
		{
			for (int j = 0; j < COLS; j++)
			{
				cells[i][j] = new Cell();
			}
		}
	}

	/**
	 * Singleton method.
	 * @return the Environment instance.
	 */
	public static Environment getWorldInstance()
	{
		if (theWorld == null)
			theWorld = new Environment();

		return theWorld;
	}

	/**
	 * Singleton method.
	 * Reset the instance of Environment used for testing.
	 */
	static void resetInstance()
	{
		theWorld = null;
	}

	/**
	 * Returns the Life form at cells[row][col].
	 * @return the LifeForm at specified location.
	 */
	public LifeForm getLifeForm(int row, int col)
	{
		if (row < ROWS && col < COLS)
		{
			return cells[row][col].getLifeForm();
		}
		else
		{
			return null;
		}
	}

	/**
	 * Adds the LifeForm to the Cell at cells[row][col]. Will not add if the row
	 * and column are invalid or if LifeForm already in the Cell.
	 * @param row: Row at which LifieForm to be added.
	 * @param col: column at which LifieForm to be added.
	 * @param entity: LifeForm object to be store in the Cell.
	 * @return true if added, false otherwise.
	 */
	public boolean addLifeForm(int row, int col, LifeForm entity)
	{
		if (row < ROWS && col < COLS)
		{
			entity.setLocationXY(row, col);
			return cells[row][col].addLifeForm(entity);
		}
		else
		{
			return false;
		}
	}

	/**
	 * Removes the LifeForm at the cells[row][col].
	 * @return LifeForm removed, null if none is present.
	 */
	public LifeForm removeLifeForm(int row, int col)
	{
		if (row < ROWS && col < COLS)
		{
			LifeForm temp = cells[row][col].removeLifeForm();
			if (temp != null)
			{
				temp.removeLocationXY();
			}
			return temp;
		}
		else
		{
			return null;
		}
	}

	/**
	 * Adds the weapon to the location.
	 * @param row: Row at which LifieForm to be added.
	 * @param col: column at which LifieForm to be added.
	 * @param weapon :Weapon to be stored.
	 * @return true if added, false otherwise.
	 */
	public boolean addWeapon(int row, int col, Weapon weapon)
	{
		if (row < ROWS && col < COLS)
		{
			return cells[row][col].addWeapon(weapon);
		}
		else
		{
			return false;
		}
	}

	/**
	 * Removes the weapon from the Cell at that position.
	 * @param row: Row at which LifieForm to be added.
	 * @param col: column at which LifieForm to be added.
	 * @param position : position at which weapon should be removed.
	 * @return Weapon if removed else null.
	 */
	public Weapon removeWeapon(int row, int col, int position)
	{
		if (row < ROWS && col < COLS)
		{
			return (cells[row][col].removeWeapon(position));
		}
		else
		{
			return null;
		}
	}

	/**
	 * Gets the weapon from the Cell at that position.
	 * @param row: Row at which LifieForm to be added.
	 * @param col: column at which LifieForm to be added.
	 * @param position : position at which weapon should be removed.
	 * @return Weapon if Present.
	 */
	public Weapon getWeapon(int row, int col, int position)
	{
		if (row < ROWS && col < COLS)
		{
			return (cells[row][col].getWeapon(position));
		}
		else
		{
			return null;
		}
	}

	/**
	 * Returns the distance between two LifeForms.
	 * @param lifeForm1
	 * @param lifeForm2
	 * @return distance between two lifeForms if present in the Environment else
	 *         returns -1.
	 */
	public int getDistance(LifeForm lifeForm1, LifeForm lifeForm2)
	{
		if (lifeForm1.getX() != -1 && lifeForm1.getY() != -1 && lifeForm2.getX() != -1 && lifeForm2.getY() != -1)
		{
			double temp = Math.pow((lifeForm2.getX() - lifeForm1.getX()), 2);
			temp += Math.pow((lifeForm2.getY() - lifeForm1.getY()), 2);
			temp = Math.sqrt(temp);
			temp *= 5;
			return (int) temp;
		}
		return -1;
	}

	/**
	 * moves the LifeForm in the direction it is facing.
	 * @param lifeForm : LifeForm to be moved.
	 */
	public void move(LifeForm lifeForm)
	{
		int x = lifeForm.getX();
		int y = lifeForm.getY();
		int temp;
		switch (lifeForm.getDirection())
		{
		case 0:
			temp = x - lifeForm.getMaxSpeed();
			while (temp != x)
			{
				if (checkCordinates(temp, y))
				{
					swapLocation(x, y, temp, y);
					break;
				}
				else
				{
					temp = temp + 1;
				}
			}
			break;
		case 1:
			temp = y + lifeForm.getMaxSpeed();
			while (temp != y)
			{
				if (checkCordinates(x, temp))
				{
					swapLocation(x, y, x, temp);
					break;
				}
				else
				{
					temp = temp - 1;
				}
			}
			break;
		case 2:
			temp = x + lifeForm.getMaxSpeed();
			while (temp != x)
			{
				if (checkCordinates(temp, y))
				{
					swapLocation(x, y, temp, y);
					break;
				}
				else
				{
					temp = temp - 1;
				}
			}
			break;
		case 3:
			temp = y - lifeForm.getMaxSpeed();
			while (temp != y)
			{
				if (checkCordinates(x, temp))
				{
					swapLocation(x, y, x, temp);
					break;
				}
				else
				{
					temp = temp + 1;
				}
			}
			break;
		}

	}

	/**
	 * TODO
	 * @param xOld
	 * @param yOld
	 * @param xNew
	 * @param yNew
	 */
	private void swapLocation(int xOld, int yOld, int xNew, int yNew)
	{
		LifeForm temp = cells[xOld][yOld].removeLifeForm();
		this.addLifeForm(xNew, yNew, temp);
	}

	/**
	 * TODO
	 * @param x
	 * @param y
	 * @return
	 */
	private boolean checkCordinates(int x, int y)
	{
		// if (row < cells.length && col < cells[row].length)
		if (x >= 0 && x < ROWS && y >= 0 && y < COLS)
		{
			if (cells[x][y].getLifeForm() == null)
			{
				return true;
			}
		}
		return false;
	}

	// TODO
	public void setDisplay(GameDisplay display)
	{
		this.display = display;
	}

	public void informDisplay()
	{
		if (display != null)
			display.update();
	}

}
