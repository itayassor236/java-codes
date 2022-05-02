package graphics;

import java.awt.Graphics;

public interface IDrawable {
public final static String PICTURE_PATH = "C://Users//User//git//java-codes//ZOO2//src//graphics//";
public void loadImages(String nm);
public void drawObject (Graphics g);
public String getColor();
}