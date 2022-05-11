package animals;
import mobility.*;
import food.*;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import diet.IDiet;
import utilities.MessageUtility;
import graphics.IAnimalBehavior;
import graphics.IDrawable;
import graphics.ZooPanel;

/**
 * An abstract class of all animals
 * @version 1.4 07 April 2022
 * @author Bar_Mor
 *@see Roar
 */
public abstract class Animal extends Mobile implements IEdible,IDrawable,IAnimalBehavior{
	private String name;
	private double weight;
	private IDiet diet;
	private final int EAT_DISTANCE = 10;
	private int size;
	private String col;
	private int horSpeed;
	private int verSpeed;
	private boolean coordChanged;
	private Thread thread;
	private int x_dir=1;
	private int y_dir=1;
	private int eatCount;
	private ZooPanel pan;
	private BufferedImage img1=null, img2;
/**
 * 
 * @param name_
 * @param location_
 */
	public Animal(String name_,Point location_) 
	{
		super(location_);
		setName(name_);
		this.coordChanged=false;
		this.eatCount=0;
		MessageUtility.logConstractor("Animal", name_);
	}

	public Animal(Point point,int size,String col,int horSpeed,int verSpeed)
	{
		super(point);
		setName(" ");
		this.coordChanged=false;
		this.eatCount=0;
		this.size=size;
		this.col=col;
		this.horSpeed=horSpeed;
		this.verSpeed=verSpeed;
	}
	/**
	 * 
	 * @param food
	 */
	public abstract boolean eat(IEdible food);
	/**
	 * 
	 * @return weight
	 */
	public double getweight()
	{
		MessageUtility.logGetter(name,"getWeight()", this.weight);
		return this.weight;
	}
	/**
	 * 
	 * @param w
	 * @return true or false
	 */
	public boolean setWeight(double w)
	{
		if (w>0.0)
		{
			this.weight=w;
			MessageUtility.logSetter(name, "setWeight()",w, true);
			return true;
		}
		MessageUtility.logSetter(name, "setWeight()",w, false);
		return false;	
	}
	/**
	 * 
	 * @param name
	 * @return true
	 */
	public boolean setName(String name)
	{
		this.name=name;
		MessageUtility.logSetter(name, "setName()",name, true);
		return true;
	}
	/**
	 * 
	 * @return name
	 */
	public String getName()
	{
		MessageUtility.logGetter(name,"getName()", this.name);
		return this.name;
	}
	
	public void makesound()
	{
		
	}
	
	/**
	 * 
	 * @param d
	 * @return true
	 */
	public boolean setDiet(IDiet d)
	{
		this.diet=d;
		MessageUtility.logSetter(name, "setDiet()",d.getClass().getSimpleName(), true);
		return true;
	}
	/**
	 * 
	 * @return diet
	 */
	public IDiet getDiet()
	{
		MessageUtility.logGetter(name,"getDiet()", this.diet.getClass().getSimpleName());
		return this.diet;
	}
	/**
	 * 
	 * @param p3
	 * @return distance
	 */
	public double move(Point p3) 
	{
		double d=calcDistance(p3);
		if(d>0)
		{
		 super.setLocation(p3);
		 super.setTotalDistance(super.getTotalDistance()+d);
		 this.weight-=(d*weight*0.00025);
		}
		return d;
		
	}

	public abstract String toString();
	
	public int getEatCount()
	{
		return this.eatCount;
	}
	
	public void setEatCount()
	{
	this.eatCount+=1;
	}
	
	public boolean getChanges ()
	{
		return this.coordChanged;
	}
	public void setChanges (boolean state)
	{
		if(state)
		{
			this.coordChanged=true;
		}
		
	}
	public String getAnimalName()
	{
		return this.name;
	}
	public int getSize()
	{
		return this.size;
	}
	public void setSize(int snum)
	{
		this.size=snum;
	}
	public void eatInc()
	{
		this.eatCount++;
	}
	
	public String getColor()
	{
		return this.col;
	}
	public int gethspeed()
	{
		return horSpeed;
	}
	public int getvspeed()
	{
		return verSpeed;
	}
	public void drawObject(Graphics g)
	{
		if(this.x_dir==1) 
		 {
			 g.drawImage(img1, this.getxlocation()-this.size/2, this.getylocation()-this.size/10, this.size/2, this.size, this.pan);
		 }
		
		 else 
		 {
			 g.drawImage(img2, this.getxlocation(), this.getylocation()-this.size/10, this.size/2, this.size, this.pan);
		 }

	}
	public void loadImages(String nm)
	{
			if(col=="Blue")
			{try {
				this.img1 = ImageIO.read(new File(IDrawable.PICTURE_PATH+"\\"+nm+"_b_1.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			else if(col=="Red")
			{
				try {
					this.img1 = ImageIO.read(new File(IDrawable.PICTURE_PATH+"\\"+nm+"_r_1.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(col=="Natural")
			{
				try {
					this.img1 = ImageIO.read(new File(IDrawable.PICTURE_PATH+"\\"+nm+"_n_1.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
			{
				System.out.println("Cannot load image");
			}
	}

}	

