package graphics;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import animals.Animal;
import animals.Bear;
import animals.Elephant;
import animals.Giraffe;
import animals.Lion;
import animals.Turtle;

public class AddAnimalDialog extends JDialog implements ActionListener{
	private JPanel panel;
	private JLabel l1;
	private JLabel l2;
	private JLabel l3;
	private JLabel l4;
	private JLabel l5;
	private int animaltype=0,hspeed=0,vspeed=0,size1,lc=0,bc=0,ec=0,gc=0,tc=0,i=0;
	private JComboBox cbox;
	private JComboBox abox;
	private JComboBox hspeedbox;
	private JComboBox vspeedbox;
	private JButton create;
	private JTextField size;
	private String animalcolor=" ",name;
	private String colors[]={"Natural","Red","Blue"};
	private String animals[]= {"Lion","Bear","Elephant","Giraffe","Turtle"};
	private String intnums[]= {"1","2","3","4","5","6","7","8","9","10"};
	private ZooPanel zPanel;
	private Animal newanimal;
	public AddAnimalDialog(ZooPanel zp)
	{
		super();
		
		zPanel=new ZooPanel();
		this.zPanel=zp;
		create=new JButton("Create");
		create.addActionListener(this);
		abox=new JComboBox(animals);
		cbox=new JComboBox(colors);
		hspeedbox=new JComboBox(intnums);
		vspeedbox=new JComboBox(intnums);
		l1=new JLabel("Pick an animal :");
		l2=new JLabel("Pick Horizontal speed :");
		l3=new JLabel("Pick Vetical speed :");
		l4=new JLabel("Enter size from 50 to 300");
		l5=new JLabel("Pick animal color");
		this.add(l1);
		this.add(abox);
		abox.addActionListener(this);
		this.add(l2);
		this.add(hspeedbox);
		hspeedbox.addActionListener(this);
		this.add(l3);
		this.add(vspeedbox);
		vspeedbox.addActionListener(this);
		size=new JTextField();
		this.add(l4);
		this.add(size);
		size.addActionListener(this);
		this.add(l5);
		this.add(cbox);
		cbox.addActionListener(this);
		this.setLayout(new GridLayout(6,1));
		this.setSize(400,200);
		this.setVisible(true);
		this.setTitle("Add Animal");
		this.add(create);
		
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==abox)
		{
			if(abox.getSelectedIndex()==0)
			{
				animaltype=1;
			}
			if(abox.getSelectedIndex()==1)
			{
				animaltype=2;
			}
			if(abox.getSelectedIndex()==2)
			{
				animaltype=3;
			}
			if(abox.getSelectedIndex()==3)
			{
				animaltype=4;
			}
			if(abox.getSelectedIndex()==4)
			{
				animaltype=5;
			}
		}
		
		if(e.getSource()==hspeedbox)
		{
			hspeed=hspeedbox.getSelectedIndex()+1;
		}
		if(e.getSource()==vspeedbox)
		{
			vspeed=vspeedbox.getSelectedIndex()+1;
		}
		if(e.getSource()==cbox)
		{
			if(cbox.getSelectedIndex()==0)
			{
				animalcolor=colors[0];
			}
			if(cbox.getSelectedIndex()==1)
			{
				animalcolor=colors[1];
			}
			if(cbox.getSelectedIndex()==2)
			{
				animalcolor=colors[2];
			}
		}
		if(e.getSource()==create)
		{
			if(animaltype==0||animalcolor==" "||vspeed==0||hspeed==0)
			{
				JOptionPane.showMessageDialog(null, "Missing deatails!!");
			}
			else
			{
			     size1=Integer.parseInt(size.getText());
			     if(size1<50||size1>300)
			     {
				   JOptionPane.showMessageDialog(null, "Error size!!");
			     }
			     else
			     {
			    	 if(animaltype==1)
			    	 { 
			    		 lc++;
			    		 name="Lion"+lc;
			    		 newanimal=new Lion(size1,animalcolor,hspeed,vspeed);
			    		 newanimal.setName(name);
			    		 zPanel.setArraySize(zPanel.getArraysize()+1);
			    		 zPanel.animalist.add(newanimal);
			    		 zPanel.setListofanimals(name);
			    		 JOptionPane.showMessageDialog(null, "Animal added");
			    		
			    		 
			    	 }
			    	 if(animaltype==2)
			    	 {
			    		 bc++;
			    		 name="Bear"+bc;
			    		 newanimal=new Bear(size1,animalcolor,hspeed,vspeed);
			    		 newanimal.setName(name);
			    		 zPanel.setArraySize(zPanel.getArraysize()+1);
			    		 zPanel.animalist.add(newanimal);
			    		 zPanel.setListofanimals(name);
			    		 JOptionPane.showMessageDialog(null, "Animal added");
			    	     
			    		 
			    		 
			    	 }
			    	 if(animaltype==3)
			    	 {
			    		 ec++;
			    		 name="Elephant"+ec;
			    		 newanimal=new Elephant(size1,animalcolor,hspeed,vspeed);
			    		 newanimal.setName(name);
			    		 zPanel.setArraySize(zPanel.getArraysize()+1);
			    		 zPanel.animalist.add(newanimal);
			    		 zPanel.setListofanimals(name);
			    		 JOptionPane.showMessageDialog(null, "Animal added");
			    		 
			    	 }
			    	 if(animaltype==4)
			    	 {
			    		 gc++;
			    		 name="Giraffe"+gc;
			    		 newanimal=new Giraffe(size1,animalcolor,hspeed,vspeed);
			    		 newanimal.setName(name);
			    		 zPanel.setArraySize(zPanel.getArraysize()+1);
			    		 zPanel.animalist.add(newanimal);
			    		 zPanel.setListofanimals(name);
			    		 JOptionPane.showMessageDialog(null, "Animal added");
			    		 
			    		 
			    	 }
			    	 if(animaltype==5)
			    	 {
			    		 tc++;
			    		 name="Turtle"+tc;
			    		 newanimal=new Turtle(size1,animalcolor,hspeed,vspeed);
			    		 newanimal.setName(name);
			    		 zPanel.setArraySize(zPanel.getArraysize()+1);
			    		 zPanel.animalist.add(newanimal);
			    		 zPanel.setListofanimals(name);
			    		 JOptionPane.showMessageDialog(null, "Animal added");
			    		 
			    	 }
			    	 
			     }
			}
		}
	}

}
