package actors;

import utilities.GraphicalShape;

import java.awt.*;
import java.awt.geom.Area;


public class Projectile implements GraphicalShape {
    private static final int WIDTH = 7;
    private static final int HEIGHT = 15;
    private static final double DRAWING_SCALE = 0.5;
    private static final int DELTA_Y = 5;

    public Projectile(Point location){
        this.location = location;
    }
    private Point location = new Point();

    public void Update(){
        this.location.setLocation(this.location.getX(), this.location.getY() - DELTA_Y);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.red);
        g2.fill(GetGraphicalShape());
    }

    public boolean IsOutsideWindow(){
        return this.GetGraphicalShape().getBounds2D().getMaxY() < 0;
    }

    @Override
    public Area GetGraphicalShape() {
        return new Area(new Rectangle(
                location.x, location.y,
                (int)(WIDTH * DRAWING_SCALE), (int)(HEIGHT * DRAWING_SCALE)));
    }
}