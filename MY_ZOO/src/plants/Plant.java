package plants;
import graphics.ZooPanel;
import mobility.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import graphics.IDrawable;
import food.EFoodType;
import food.IEdible;
import mobility.Point;
import utilities.MessageUtility;

import javax.imageio.ImageIO;

/**
 * 07 April 2022
 * @author ItayAsor
 */
public abstract class Plant implements IEdible, Ilocatable,IDrawable {

    private double height;

    private Point location;
    private ZooPanel zp;
    private double weight;
    private BufferedImage img1=null;
    public Plant(ZooPanel z) {
        Random rand = new Random();
        this.location = new Point(400, 300);
        this.height = rand.nextInt(30);
        this.weight = rand.nextInt(12);
        this.zp=z;
        MessageUtility.logConstractor("Plant", "Plant");
    }


    /**
     *
     * @return food type
     */
    public EFoodType getFoodtype() {
        MessageUtility.logGetter(this.getClass().getSimpleName(), "getFoodType", EFoodType.VEGTABLE);
        return EFoodType.VEGTABLE;
    }

    /**
     *
     * @return height
     */
    public double getHeight() {
        MessageUtility.logGetter(this.getClass().getSimpleName(), "getHeight", this.height);
        return this.height;
    }

    /**
     *
     * @return location
     */
    public Point getLocation() {
        // MessageUtility.logGetter(this.getClass().getSimpleName(), "getLocation", this.location);
        return this.location;
    }

    /**
     *
     * @return weight
     */
    public double getWeight() {
        MessageUtility.logGetter(this.getClass().getSimpleName(), "getWeight", this.weight);
        return weight;
    }
    /**
     *
     * @param height
     * @return if is success or not
     */

    public boolean setHeight(double height) {

        boolean isSuccess = (height >= 0);
        if (isSuccess) {
            this.height = height;
        } else {
            this.height = 0;
        }
        MessageUtility.logSetter(this.getClass().getSimpleName(), "setHeight", height, isSuccess);
        return isSuccess;
    }

    /**
     *
     * @param newLocation
     * @return if is success or not
     */

    public boolean setLocation(Point newLocation) {
        boolean isSuccess = newLocation.checkBoundaries(newLocation);
        if (isSuccess) {
            this.location = newLocation;
        }
        MessageUtility.logSetter(this.getClass().getSimpleName(), "setLocation", newLocation, isSuccess);
        return isSuccess;
    }
    /**
     *
     * @param weight
     * @return if is success or not
     */

    public boolean setWeight(double weight) {
        boolean isSuccess = (weight >= 0);
        if (isSuccess) {
            this.weight = weight;
        } else {
            this.weight = 0;
        }
        MessageUtility.logSetter(this.getClass().getSimpleName(), "setWeight", weight, isSuccess);

        return isSuccess;
    }
    /**
     * @return class name
     */

    public String toString() {
        return "[" + this.getClass().getSimpleName() + "] ";
    }
    @Override
    public void loadImages(String nm) {
        if(nm=="cabbage")
        {
            try {
                this.img1 = ImageIO.read(new File(IDrawable.PICTURE_PATH + "\\" + nm + ".png"));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(nm=="lettuce")
        {
            try {
                this.img1 = ImageIO.read(new File(IDrawable.PICTURE_PATH + "\\" + nm + ".png"));
            } catch (IOException e) {

                e.printStackTrace();
            }
        }

    }

    @Override
    public void drawObject(Graphics g) {
       g.drawImage(img1,400,300,30,30,zp);
       zp.manageZoo();
    }

    @Override
    public String getColor() {
        return null;
    }

    @Override
    public EFoodType getFoodType() {
        return EFoodType.VEGTABLE;
    }
}
