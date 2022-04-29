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

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ZooPanel extends JPanel implements ActionListener{

	private JButton add_animal;
	private JButton move_animal;
	private JButton clear;
	private JButton food;
	private JButton info;
	private JButton exit;
	private JPanel jp;
	private Image pic;
	
	public ZooPanel()
	{
		
		
//		this.setLayout(new BorderLayout());
//		add_animal=new JButton("Add Animal");
//		add_animal.addActionListener(this);
//		move_animal=new JButton("Move Animal");
//		move_animal.addActionListener(this);
//		clear=new JButton("Clear");
//		clear.addActionListener(this);
//		food=new JButton("Food");
//		food.addActionListener(this);
//		info=new JButton("Info");
//		info.addActionListener(this);
//		exit=new JButton("Exit");
//		exit.addActionListener(this);
//		//add_animal.setFocusable(false);
//		//move_animal.setFocusable(false);
////		clear.setFocusable(false);
////		food.setFocusable(false);
////		info.setFocusable(false);
////		exit.setFocusable(false);
//		this.add(add_animal);
//		this.add(move_animal);
//		this.add(clear);
//		this.add(food);
//		this.add(info);
//		this.add(exit);
//		this.setLayout(new BorderLayout());
//		this.setVisible(true);
//	}
//	public ZooPanel()
//	{
//		pic=new ImageIcon("C://Users//User//git//java-codes//ZOO2//src//graphics//savanna.jpg").getImage();
//	    this.setPreferredSize(new Dimension(800,600));
//	}
//	public void paintComponent(Graphics g) {
//	
//		 Graphics2D g2d=(Graphics2D) g;
//
//		 if(pic!=null)
//		 {
//		   g2d.drawImage(pic,0,0,getWidth(),getHeight(), this);
//		 }
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
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
	
}
