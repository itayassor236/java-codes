package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import animals.Animal;

public class ZooPanel extends JPanel implements ActionListener{

	private JButton add_animal;
	private JButton move_animal;
	private JButton clear;
	private JButton food;
	private JButton info;
	private JButton exit;
	private JPanel p;
	private BufferedImage pic=null;
	static ArrayList<Animal> animalist=new ArrayList<Animal>();
	private int arraysize=0;
	private ArrayList<String> listofanimals= new ArrayList<String>();
	private Graphics g1=null;
	private boolean back=false;
	
	public ZooPanel()
	{
		this.setBackground(null);
		this.setVisible(true);
		 try { pic = ImageIO.read(new File("C://Users//User//git//java-codes//ZOO2//src//graphics//savanna.jpg")); }
    	 catch (IOException ie) { System.out.println("Cannot load image"); }
		 
		//g1=this.getComponentGraphics(g1)
//		p=new JPanel(new FlowLayout());
//		this.setLayout(new BorderLayout());
//		add_animal=new JButton("Add Animal");
//		p.add(add_animal);
//		add_animal.addActionListener(this);
//		move_animal=new JButton("Move Animal");
//		p.add(move_animal);
//		move_animal.addActionListener(this);
//		clear=new JButton("Clear");
//		p.add(clear);
//		clear.addActionListener(this);
//		food=new JButton("Food");
//		p.add(food);
//		food.addActionListener(this);
//		info=new JButton("Info");
//		p.add(info);
//		info.addActionListener(this);
//		exit=new JButton("Exit");
//		p.add(exit);
//		exit.addActionListener(this);
//		add_animal.setFocusable(false);
//		move_animal.setFocusable(false);
//		clear.setFocusable(false);
//		food.setFocusable(false);
//		info.setFocusable(false);
//		exit.setFocusable(false);
//		this.setLayout(new BorderLayout());
//		this.add(p,BorderLayout.SOUTH);
//		this.setVisible(true);
	}
//	public ZooPanel()
//	{
//		pic=new ImageIcon("C://Users//User//git//java-codes//ZOO2//src//graphics//savanna.jpg").getImage();
//	    this.setPreferredSize(new Dimension(800,600));
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
	    //Graphics2D gr = (Graphics2D) g;
	   if(back)
	   {
	      g.drawImage(pic,0,0,getWidth(),getHeight(), this);
	   }
	   back=false;
	   if(this.arraysize>0)
	   { animalist.get(0).drawObject(g);}
	     
	}
	public void setBackground1(int num)
	{
		if(num==0)
		{ 
			 setBackground(null);
//			 try { pic = ImageIO.read(new File("C://Users//User//git//java-codes//ZOO2//src//graphics//savanna.jpg")); }
//	    	 catch (IOException ie) { System.out.println("Cannot load image"); }
			 back=true;
			 this.repaint();
		}
		if(num==1)
		{
			this.setBackground(null);
			this.setBackground(Color.green);
			
			
			
			
		}
		if(num==2)
		{
			this.setBackground(null);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		if(e.getSource()==add_animal)
//		{
//			AddAnimalDialog aad=new AddAnimalDialog(this);
//		}
//		if(e.getSource()==move_animal)
//		{
//			MoveAnimalDialog mad=new MoveAnimalDialog(this);
//		}
//		if(e.getSource()==clear)
//		{
//			this.clearList();
//		}
//		if(e.getSource()==food)
//		{
//			
//		}
		
	}
	public void setArraySize(int num)
	{
		try
		{
			
		
		  if(num>0&&num<11)
		  {
			this.arraysize=num;
		  }
		  else
		  {
		    throw new ArrayIndexOutOfBoundsException();
		  }
		}
		
			catch(ArrayIndexOutOfBoundsException error) {
				
				JOptionPane.showMessageDialog(null, "number not in range !!"); 
			}
		
	}
	
	public int getArraysize()
	{
		return this.arraysize;
	}
	public void clearList()
	{
			animalist.clear();
			arraysize=0;
		
	}
//	public void setBackground(int num)
//	{
//		setBackground(null);
//		if(num==1)
//		{
//			this.paintComponent(this.getGraphics());
//		}
//		if(num==2)
//		{
//			this.paintComponent(this.getGraphics());
//			setBackground(Color.GREEN);
//		}
//	}
	public ArrayList getListofanimals() {
		return listofanimals;
	}
	public void setListofanimals(String name) {
		this.listofanimals.add(name);
	}
	public void setFood(int pick)
	{
		if(pick==0)
		{
			
		}
		if(pick==1)
		{
			
		}
		if(pick==2)
		{
			
		}
	}
	public void manageZoo()
	{
		if(isChange())
		{
			repaint();
		}
	}
	
	public boolean isChange()
	{
		for(int i=0;i<this.arraysize;i++)
		{
			if(animalist.get(i).getChanges())
			{
				animalist.get(i).setChanges(false);
				return true;
			}
		}
		return false;
	}
}
