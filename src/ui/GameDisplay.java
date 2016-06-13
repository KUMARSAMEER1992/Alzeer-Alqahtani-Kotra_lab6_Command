package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import environment.Environment;
import lifeform.Alien;
import lifeform.Human;
import lifeform.LifeForm;
import weapon.Attachment;
import weapon.ChainGun;
import weapon.Pistol;
import weapon.PlasmaCannon;
import weapon.Weapon;

/**
 * This class Displays the Environment.
 * @author Sameer Kumar Kotra
 */
public class GameDisplay
{

	/**
	 * JFrame to display main content.
	 */
	private JFrame frame;
	/**
	 * JFrame to display legend panel.
	 */
	private JPanel legendPanel;
	/**
	 * JFrame to display Map Content.
	 */
	private JPanel mapPanel;
	/**
	 * JFrame to display the Cells in Environment.
	 */
	private JPanel mapArea;
	/**
	 * DisplayBean to store Display details of each Cell.
	 */
	private DisplayBean[][] displaydetails;
	/**
	 * int to store the number of rows displayed in the Map.
	 */
	private int rows;
	/**
	 * int to store the number of columns displayed in the Map.
	 */
	private int cols;

	public static void main(String[] args)
	{
		GameDisplay window = new GameDisplay();
	}

	/**
	 * Creates the Content of the panels.
	 */
	public GameDisplay()
	{
		rows = 10;
		cols = 10;
		displaydetails = new DisplayBean[10][10];
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < cols; j++)
			{
				displaydetails[i][j] = new DisplayBean();
			}
		}
		initialize();
		update();
		frame.setVisible(true);
	}

	/**
	 * Updates the display according to changes in the Environment.
	 */
	public void update()
	{
		Environment world = Environment.getWorldInstance();
		LifeForm tempLifeForm;
		Weapon tempWeapon;
		for (int i = 0; i < Environment.ROWS; i++)
		{
			for (int j = 0; j < Environment.COLS; j++)
			{
				tempLifeForm = world.getLifeForm(i, j);
				if (tempLifeForm != null)
				{
					if (tempLifeForm instanceof Human)
					{
						displaydetails[i][j].getLifeForm().setText(DisplayBean.HUMANSTRING);
					}
					else if (tempLifeForm instanceof Alien)
					{
						displaydetails[i][j].getLifeForm().setText(DisplayBean.ALIENSTRING);
					}
					tempWeapon = tempLifeForm.getWeapon();
					if (tempWeapon != null)
					{
						displaydetails[i][j].getLifeFormWeapon().setText(getWeaponStirng(tempWeapon));
					}
					else
					{
						displaydetails[i][j].getLifeFormWeapon().setText(DisplayBean.EMPTY);
					}
					switch (tempLifeForm.getDirection())
					{
					case 0:
						displaydetails[i][j].getDirection().setText(DisplayBean.NORTH);
						break;
					case 1:
						displaydetails[i][j].getDirection().setText(DisplayBean.EAST);
						break;
					case 2:
						displaydetails[i][j].getDirection().setText(DisplayBean.SOUTH);
						break;
					case 3:
						displaydetails[i][j].getDirection().setText(DisplayBean.WEST);
						break;
					}
				}
				else
				{
					displaydetails[i][j].getLifeForm().setText(DisplayBean.EMPTY);
					displaydetails[i][j].getLifeFormWeapon().setText(DisplayBean.EMPTY);
					displaydetails[i][j].getDirection().setText(DisplayBean.EMPTY);
				}

				tempWeapon = world.getWeapon(i, j, 1);
				if (tempWeapon != null)
				{
					displaydetails[i][j].getWeapon1().setText(getWeaponStirng(tempWeapon));
				}
				else
				{
					displaydetails[i][j].getWeapon1().setText(DisplayBean.EMPTY);
				}

				tempWeapon = world.getWeapon(i, j, 2);
				if (tempWeapon != null)
				{
					displaydetails[i][j].getWeapon2().setText(getWeaponStirng(tempWeapon));
				}
				else
				{
					displaydetails[i][j].getWeapon2().setText(DisplayBean.EMPTY);
				}

			}
		}
	}

	/**
	 * Returns the Weapon removing the Attachment.
	 * @param tempWeapon : Weapon to remove Attachment.
	 * @return the Weapon with out Attachment.
	 */
	private String getWeaponStirng(Weapon tempWeapon)
	{
		while (tempWeapon instanceof Attachment)
		{
			tempWeapon = ((Attachment) tempWeapon).getWeapon();
		}
		if (tempWeapon instanceof Pistol)
		{
			return DisplayBean.PISTOLSTRING;
		}
		else if (tempWeapon instanceof PlasmaCannon)
		{
			return DisplayBean.PLASMACANNONSTRING;
		}
		else if (tempWeapon instanceof ChainGun)
		{
			return DisplayBean.CHAINGUNSTRING;
		}
		return null;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 800, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		buildLegendPanel();
		buildMapPanel();

	}

	/**
	 * Builds the content of the Map Panel.
	 */
	private void buildMapPanel()
	{
		mapPanel = new JPanel();
		mapPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.getContentPane().add(mapPanel, BorderLayout.CENTER);
		mapPanel.setLayout(new BorderLayout(0, 0));
		JPanel mapName = new JPanel();
		mapPanel.add(mapName, BorderLayout.NORTH);
		JLabel lblMap = new JLabel("Map");
		lblMap.setFont(new Font("Tahoma", Font.BOLD, 15));
		mapName.add(lblMap);
		mapArea = new JPanel();
		mapPanel.add(mapArea, BorderLayout.CENTER);
		mapArea.setLayout(new GridLayout(rows, cols, 0, 0));

		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < cols; j++)
			{
				mapArea.add(createCellPanel(i, j));
			}
		}

	}

	/**
	 * Creates a panel for each cell in the Environment.
	 * @param row : Row to which panel to be added
	 * @param col : Column to which panel to be added.
	 * @return the JPanle created.
	 */
	private JPanel createCellPanel(int row, int col)
	{
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setHgap(1);
		flowLayout.setVgap(0);

		JPanel panel = new JPanel(flowLayout);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(new BorderLayout(0, 0));

		JPanel temp = new JPanel(flowLayout);
		temp.setBorder(new LineBorder(new Color(0, 0, 0)));
		temp.add(displaydetails[row][col].getLifeForm());
		panel.add(temp, BorderLayout.CENTER);

		temp = new JPanel(flowLayout);
		temp.setBorder(new LineBorder(new Color(0, 0, 0)));
		temp.add(displaydetails[row][col].getDirection());
		panel.add(temp, BorderLayout.NORTH);

		temp = new JPanel(flowLayout);
		temp.setBorder(new LineBorder(new Color(0, 0, 0)));
		temp.add(displaydetails[row][col].getWeapon1());
		panel.add(temp, BorderLayout.EAST);

		temp = new JPanel(flowLayout);
		temp.setBorder(new LineBorder(new Color(0, 0, 0)));
		temp.add(displaydetails[row][col].getWeapon2());
		panel.add(temp, BorderLayout.WEST);

		temp = new JPanel(flowLayout);
		temp.setBorder(new LineBorder(new Color(0, 0, 0)));
		temp.add(displaydetails[row][col].getLifeFormWeapon());
		panel.add(temp, BorderLayout.SOUTH);
		return panel;
	}

	/**
	 * Builds the legend panel content.
	 */
	private void buildLegendPanel()
	{
		legendPanel = new JPanel();
		legendPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.getContentPane().add(legendPanel, BorderLayout.EAST);
		legendPanel.setLayout(new GridLayout(10, 1, 2, 2));

		JLabel legendLabel = new JLabel("   Legend");
		legendLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		legendLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		legendPanel.add(legendLabel);
		legendPanel.add(new JLabel("  H - Human"));
		legendPanel.add(new JLabel("  A - Alien"));
		legendPanel.add(new JLabel("  N - North"));
		legendPanel.add(new JLabel("  E - East"));
		legendPanel.add(new JLabel("  S - South"));
		legendPanel.add(new JLabel("  W - West"));
		legendPanel.add(new JLabel("  PI - Pistol"));
		legendPanel.add(new JLabel("  Pl - Plasma Gun  "));
		legendPanel.add(new JLabel("  CH - Chain Gun"));
	}

}
