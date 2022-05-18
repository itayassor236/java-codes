package plants;

import food.EFoodType;
import graphics.ZooPanel;
import utilities.MessageUtility;

import java.awt.*;

/**
 * 07 April 2022
 * @author ItayAsor
 * @see Plant
 */
public class Cabbage extends Plant {
    public Cabbage(ZooPanel zp) {
        super(zp);
        MessageUtility.logConstractor("Cabbage", "Cabbage");
    }

}