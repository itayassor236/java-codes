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
import meat.Meat;
import plants.Plant;

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
    private Plant pl=null;
    private boolean list=false;
    private Meat me=null;

    public ZooPanel()
    {
        this.setBackground(null);
        this.setVisible(true);
        try { pic = ImageIO.read(new File("C://Users//User//git//java-codes//ZOO2//src//graphics//savanna.jpg")); }
        catch (IOException ie) { System.out.println("Cannot load image"); }


    }


    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        //Graphics2D gr = (Graphics2D) g;
        if(back)
        {
            g.drawImage(pic,0,0,getWidth(),getHeight(), this);
        }
        back=false;
        if(this.arraysize>0)
        {
            for (int i = 0; i < this.arraysize; i++)
            {
                animalist.get(i).drawObject(g);
            }
        }
        if(pl!=null)
        {
            pl.drawObject(g);
        }
        if(me!=null)
        {
            me.drawObject(g);
        }

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
    public void setPlant(Plant p)
    {
        this.pl=p;
    }

    public void setMeat(Meat m)
    {
        this.me=m;
    }
    public int getArraysize()
    {
        return this.arraysize;
    }
    public void clearList()
    {
        animalist.clear();
        arraysize=0;
        list=true;


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

    public void manageZoo()
    {
        if(isChange())
        {
            repaint();
        }
        if(this.getArraysize()>0)
        {
            for (int i = 0; i < this.getArraysize(); i++) {
                for (int j = 0; j < this.getArraysize(); j++) {
                    double d = animalist.get(i).calcDistance(animalist.get(j).getLocation());
                    if (i != j && d<animalist.get(j).getweight() && animalist.get(i).getDiet().canEat(animalist.get(j).getFoodType())&&animalist.get(i).getweight()>=2*animalist.get(j).getweight()) {
                        this.setArraySize(this.getArraysize()-1);
                        animalist.remove(j);
                        repaint();
                    }

                }

                if(this.pl!=null)
                {
                    for(int v=0;v<this.arraysize;v++) {
                        double d1 = animalist.get(v).calcDistance(this.pl.getLocation());
                        if (animalist.get(v).checkDistance(d1) && animalist.get(v).eat(this.pl)) {
                            pl = null;
                            repaint();
                        }
                    }
                }
                if(this.me!=null)
                {
                    double d1 = animalist.get(i).calcDistance(this.me.getLocation());
                    for(int k=0;k<this.arraysize;k++) {
                        if (animalist.get(k).checkDistance(d1) && animalist.get(k).eat(this.me)) {
                            me = null;
                            repaint();
                        }
                    }
                }
            }
        }
    }

    public boolean isChange()
    {
        if(list)
        {
            list=false;
            return true;
        }
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