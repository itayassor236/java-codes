package plants;

import food.EFoodType;
import graphics.ZooPanel;
import utilities.MessageUtility;

import java.awt.*;

/**
 * 07 April 2022
 * @author BarMor
 * @see Plant
 */
public class Lettuce extends Plant {
    public Lettuce(ZooPanel zp) {
        super(zp);
        MessageUtility.logConstractor("Lettuce", "Lettuce");
    }
}