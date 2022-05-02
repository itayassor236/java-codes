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
	 JTextField X;
	 JTextField Y;
	 String Type;
	 Animal animal;
	 int x,y;
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
		this.add(labelX);
		X=new JTextField();
		this.add(X);
		X.addActionListener(this);
		JLabel labelY=new JLabel("enter y (0-600)");
		this.add(labelY);
		Y=new JTextField();
		this.add(Y);
		Y.addActionListener(this);
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
		
		if (e.getSource()==AnimalMove)
		{
			x=Integer.parseInt(X.getText());
			y=Integer.parseInt(Y.getText());
			if((x<0||x>800)||(y<0||y>600))
			{
				JOptionPane.showMessageDialog(null, "Wrong cordinates please enter again","Error",JOptionPane.WARNING_MESSAGE);
				x=Integer.parseInt(X.getText());
				y=Integer.parseInt(Y.getText());
			}

			else
			{
			 Type=(String)All.getSelectedItem();
			 for(int i=0;i<Z.getArraysize();i++)
			 {
				
				 if(animals[i].equals(Type))
				 {
					 p=new Point(x,y);
					 if(Z.animalist.get(i).move(p)>0)
					   {
						 Z.animalist.get(i).setChanges(true);
					     JOptionPane.showMessageDialog(null, "Animal moved");
					   }
					 else
					   {
						JOptionPane.showMessageDialog(null, "Animal didnt moved");
					   }
				    
				 }
					
					
			}
		   }
		}
		
	}


}