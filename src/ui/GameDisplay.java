package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import environment.Environment;
import exceptions.AttachmentException;
import lifeform.Alien;
import lifeform.Human;
import lifeform.LifeForm;
import weapon.Attachment;
import weapon.ChainGun;
import weapon.Pistol;
import weapon.PlasmaCannon;
import weapon.Scope;
import weapon.Weapon;

/**
 * @author Sameer Kumar Kotra
 */
public class GameDisplay
{

	private JFrame frame;
	private JPanel legendPanel;
	private JPanel mapPanel;
	private JPanel mapArea;
	private DisplayBean[][] displaydetails;
	private int rows;
	private int cols;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		GameDisplay window = new GameDisplay();
		window.frame.setVisible(true);
	}

	/**
	 * Create the application.
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
	}

	/**
	 * 
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
	 * @param tempWeapon
	 * @return
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
	 * 
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

		btnNewButton = new JButton("check");
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					testDiaplay();
				}
				catch (AttachmentException e)
				{
					e.printStackTrace();
				}
			}
		});
		mapName.add(btnNewButton);
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

	// TODO remove test method.
	private void testDiaplay() throws AttachmentException
	{
		Environment environment = Environment.getWorldInstance();
		LifeForm lifeForm = new Human("Bob", 50, 10);
		// Setting to South.
		lifeForm.setDirection(2);
		LifeForm lifeForm1 = new Human("Bob", 50, 10);

		// with out Obstacle.
		environment.addLifeForm(2, 5, lifeForm);
		environment.addLifeForm(8, 5, lifeForm1);

		lifeForm = new Alien("Bob", 50);
		// Setting to West.
		lifeForm.setDirection(3);
		lifeForm1 = new Alien("Bob", 50);

		// with out Obstacle.
		environment.addLifeForm(2, 6, lifeForm);
		environment.addLifeForm(2, 2, lifeForm1);

		Weapon weapon1 = new Pistol();
		Weapon weapon2 = new ChainGun();
		Weapon weapon3 = new PlasmaCannon();
		environment.addWeapon(1, 1, weapon1);
		environment.addWeapon(1, 1, weapon2);
		environment.addWeapon(8, 8, weapon3);

		Scope scope = new Scope(weapon2);
		Scope scope2 = new Scope(weapon2);

		environment.addWeapon(8, 9, scope);
		environment.addWeapon(9, 9, scope);
		update();
	}

	/**
	 * @param i
	 * @param j
	 * @return
	 */
	private JPanel createCellPanel(int i, int j)
	{
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setHgap(1);
		flowLayout.setVgap(0);

		JPanel panel = new JPanel(flowLayout);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(new BorderLayout(0, 0));

		JPanel temp = new JPanel(flowLayout);
		temp.setBorder(new LineBorder(new Color(0, 0, 0)));
		temp.add(displaydetails[i][j].getLifeForm());
		panel.add(temp, BorderLayout.CENTER);

		temp = new JPanel(flowLayout);
		temp.setBorder(new LineBorder(new Color(0, 0, 0)));
		temp.add(displaydetails[i][j].getDirection());
		panel.add(temp, BorderLayout.NORTH);

		temp = new JPanel(flowLayout);
		temp.setBorder(new LineBorder(new Color(0, 0, 0)));
		temp.add(displaydetails[i][j].getWeapon1());
		panel.add(temp, BorderLayout.EAST);

		temp = new JPanel(flowLayout);
		temp.setBorder(new LineBorder(new Color(0, 0, 0)));
		temp.add(displaydetails[i][j].getWeapon2());
		panel.add(temp, BorderLayout.WEST);

		temp = new JPanel(flowLayout);
		temp.setBorder(new LineBorder(new Color(0, 0, 0)));
		temp.add(displaydetails[i][j].getLifeFormWeapon());
		panel.add(temp, BorderLayout.SOUTH);
		return panel;
	}

	/**
	 * 
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
