package game;

import utilities.GraphicalShape;

import java.awt.*;
import java.awt.geom.Area;

public class StatusRibbon implements GraphicalShape{
    private final Game game;
    public StatusRibbon(Game game) {
        this.game = game;
    }

    @Override
    public void Paint(Graphics2D graphics) {
        graphics.setColor(Color.decode("#282828"));
        Area background = GetGraphicalShape();
        graphics.fill(background);
        graphics.setFont(new Font("Consolas", Font.PLAIN, 12));
        graphics.setColor(Color.decode("#E6DB74"));
        graphics.drawString(String.valueOf(game.Score), 20, 20);
        graphics.drawString(GetFormatedTimeFromSeconds(game.GetRuntimeInSeconds()), Game.CANVAS_WIDTH - 50, 20);
    }
    private String GetFormatedTimeFromSeconds(long seconds){
        String secondPart = (seconds%60) < 10 ? "0" + String.valueOf(seconds%60) : String.valueOf(seconds%60);
        return String.valueOf(seconds/60) + ":" + secondPart;
    }

    @Override
    public Area GetGraphicalShape() {
        Area area = new Area(new Rectangle(0, 0, Game.CANVAS_WIDTH, 30));
        return area;
    }
}
