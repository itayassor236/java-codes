package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class ZooFrame extends JFrame implements ActionListener{
	static JFrame frame;
	static JLabel label;
	static JPanel p;
	static ZooPanel zp;
	private JMenu file;
	private JMenu background;
	private JMenu help;
	private JMenuItem image;
	private JMenuItem green;
	private JMenuItem none;
	private JMenuItem help1;
	private JMenuItem exit;
	private JButton add_animal;
	private JButton move_animal;
	private JButton clear;
	private JButton food;
	private JButton info;
	private JButton exit2;
	private BufferedImage img1, img2,pic=null;
	
	public ZooFrame()
	{
	this.setTitle("Zoo");
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
	zp=new ZooPanel();
	p=new JPanel(new FlowLayout());
	this.setLayout(new BorderLayout());
	add_animal=new JButton("Add Animal");
	p.add(add_animal);
	add_animal.addActionListener(this);
	move_animal=new JButton("Move Animal");
	p.add(move_animal);
	move_animal.addActionListener(this);
	clear=new JButton("Clear");
	p.add(clear);
	clear.addActionListener(this);
	food=new JButton("Food");
	p.add(food);
	food.addActionListener(this);
	info=new JButton("Info");
	p.add(info);
	info.addActionListener(this);
	exit2=new JButton("Exit");
	p.add(exit2);
	exit2.addActionListener(this);
	add_animal.setFocusable(false);
	move_animal.setFocusable(false);
	clear.setFocusable(false);
	food.setFocusable(false);
	info.setFocusable(false);
	exit2.setFocusable(false);
	this.setLayout(new BorderLayout());
	this.add(p,BorderLayout.SOUTH);
	this.setVisible(true);
	//setLayout(new BorderLayout());
	JMenuBar mb=new JMenuBar();
	this.setJMenuBar(mb);
    file=new JMenu("File");
	background=new JMenu("Background");
	help=new JMenu("Help");
	image=new JMenuItem("Image");
	green=new JMenuItem("Green");
	none=new JMenuItem("None");
    help1=new JMenuItem("Help");
	exit=new JMenuItem("Exit");
	mb.add(file);
	mb.add(background);
	mb.add(help);
	file.add(exit);
	background.add(image);
	background.add(green);
	background.add(none);
	help.add(help1);
	exit.addActionListener(this);
	image.addActionListener(this);
	green.addActionListener(this);
	none.addActionListener(this);
	help1.addActionListener(this);
//	this.add(p,BorderLayout.SOUTH);
	this.add(zp);
	this.setSize(800,600);
	this.setVisible(true);
	}
	

	
public void actionPerformed(ActionEvent e)
    {
		if(e.getSource()==exit||e.getSource()==exit2)
		{
			System.exit(0);
		}
		
	    if(e.getSource()==image)
	    {
	    	
//	    	 try { pic = ImageIO.read(new File("C://Users//User//git//java-codes//ZOO2//src//graphics//savanna.jpg")); }
//	    	 catch (IOException ie) { System.out.println("Cannot load image"); }
//	    	label=new JLabel(new ImageIcon("savanna.jpg"));
//    	label.setBounds(0, 0, 800, 600);
//	    	this.add(zp);
//    	label=new JLabel(new ImageIcon("C://Users//User//git//java-codes//ZOO2//src//graphics//savanna.jpg"));
//	    	this.add(label);
	    	zp.setBackground1(0);
	    	zp.setVisible(true);
	  
	    }
		if(e.getSource()==green)
		{
			//this.remove(label);
			//this.getContentPane().setBackground(Color.green);
			zp.setBackground1(1);
	    	zp.setVisible(true);
		}
		if(e.getSource()==none)
		{
//			this.remove(label);
//			this.getContentPane().setBackground(null);
			zp.setBackground1(2);
	    	zp.setVisible(true);
		}
		if(e.getSource()==help1)
		{
			JFrame f=new JFrame("Message");
			JLabel label2=new JLabel("<html>Home Work 2<br/>GUI</html>");
			f.setSize(250,250);
			f.setVisible(true);
			f.add(label2);
			ImageIcon logoIcon=new ImageIcon("C://Users//User//git//java-codes//ZOO2//src//graphics//helppic.jpeg");
			label2.setIcon(logoIcon);
			f.add(label2);
			JButton okButton=new JButton("OK");
			okButton.setFocusable(false);
			okButton.setBounds(150,150,70,30);
			label2.add(okButton);	
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{  
					f.dispose();
			    }
			});
		}
		if(e.getSource()==add_animal)
		{
			AddAnimalDialog aad=new AddAnimalDialog(zp);
		}
		if(e.getSource()==move_animal)
		{
			MoveAnimalDialog mad=new MoveAnimalDialog(zp);
		}
		if(e.getSource()==clear)
		{
			zp.clearList();
		}
		if(e.getSource()==food)
		{
		    JFrame foodframe=new JFrame("food for animals");
		    JLabel label3=new JLabel("please choose food");
		    foodframe.setSize(400,300);
			foodframe.setVisible(true);
			foodframe.add(label3);
			ImageIcon logoIcon2=new ImageIcon("C://Users//User//git//java-codes//ZOO2//src//graphics//helppic.jpeg");
			label3.setIcon(logoIcon2);
            JButton meat=new JButton("Meat");
            meat.setFocusable(false);
            meat.setBounds(240,200,100,20);
			label3.add(meat);	
			meat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{  
				
			    }
			});
			JButton cabbage=new JButton("Cabbage");
			cabbage.setFocusable(false);
			cabbage.setBounds(130,200,100,20);
			label3.add(cabbage);	
			cabbage.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{  
					
			    }
			});
		    JButton lettuce=new JButton("Lettuce");
		    lettuce.setFocusable(false);
		    lettuce.setBounds(20,200,100,20);
			label3.add(lettuce);	
			lettuce.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{  
				
			    }
			});
		}
		if(e.getSource()==info)
		{
			JFrame tableframe=new JFrame();
			AnimalsTable model = new AnimalsTable(zp);
			JTable table = new JTable(model);
			JDialog infotable=new JDialog(this,"info table",true);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setPreferredScrollableViewportSize(new Dimension(500, 70));
			table.setFillsViewportHeight(true);
			infotable.add(new JScrollPane(table));
			infotable.pack();
			infotable.setVisible(true);
		}
	
	}
	
	public static void main(String[] args)
	{
		ZooFrame zf=new ZooFrame();
		//new ZooFrame();
	}

	

}