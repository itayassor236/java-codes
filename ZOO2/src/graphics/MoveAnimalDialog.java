package graphics;
import mobility.*;

import javax.swing.*;
import animals.Animal;
import animals.Bear;
import animals.Elephant;
import animals.Giraffe;
import animals.Lion;
import animals.Turtle;

import java.awt.GridLayout;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * The class that take care of move animal option
 * @author Bar Mor 205858103 and itay asor 318231925
 *
 */

public class MoveAnimalDialog extends JDialog implements ActionListener
{
	 JComboBox All;
	 JButton AnimalMove;
	 private JTextField x1;
	 private JTextField y1;
	 int Type;
	 Animal animal;
	 private String x,y;
	 private int x2,y2;
	 Point p;
	ZooPanel Z;
	 String S;
	 String animals[];
	 
	@SuppressWarnings("unused")
	public MoveAnimalDialog(ZooPanel Z)
	{
		this.Z=Z;
		int size2=Z.getArraysize();
		animals=new String[Z.getArraysize()];
		for(int i=0;i<Z.getArraysize();i++)
		{
			animals[i]=(String) Z.getListofanimals().get(i);
		}
		All=new JComboBox(animals);
		this.setLayout(new GridLayout(4,1));
		this.setSize(400,200);
		this.setTitle("Move Animal");
		

		JLabel labelAnimal=new JLabel("select animal");
		this.add(labelAnimal);
		All.addActionListener(this);
		this.add(All);
		JLabel labelX=new JLabel("enter x (0-800)");
		x1=new JTextField();
		this.add(labelX);
		this.add(x1);
		x1.addActionListener(this);
		JLabel labelY=new JLabel("enter y (0-600)");
		y1=new JTextField();
		this.add(labelY);
		this.add(y1);
		y1.addActionListener(this);
		JLabel move=new JLabel("Press to move");
		this.add(move);
		AnimalMove=new JButton("Accept");
		this.add(AnimalMove);
		AnimalMove.addActionListener(this);
		this.setVisible(true);
	
	}
		
		
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==All)
		{
			for(int i=0;i<Z.getArraysize();i++) 
			{
		       if(All.getSelectedIndex()==i)
		       {
		    	   Type=i;
		       }
			}
		}
		
		if (e.getSource()==AnimalMove)
		{
			x=x1.getText();
			y=y1.getText();
			x2=Integer.parseInt(x);
			y2=Integer.parseInt(y);
			while((x2<0||x2>800)||(y2<0||y2>600))
			{
				JOptionPane.showMessageDialog(null, "Wrong cordinates please enter again","Error",JOptionPane.WARNING_MESSAGE);
				x=x1.getText();
				y=y1.getText();
				x2=Integer.parseInt(x);
				y2=Integer.parseInt(y);
			}

		
	
			 p=new Point(x2,y2);
			if(Z.animalist.get(Type).move(p)>0)
			 {
				 Z.animalist.get(Type).setChanges(true);
				 JOptionPane.showMessageDialog(null, "Animal moved");
			 }
			 else
			 {
				JOptionPane.showMessageDialog(null, "Animal didnt moved");
			 }
				   
			 
					
					
	}
	}
}
 
	
		


