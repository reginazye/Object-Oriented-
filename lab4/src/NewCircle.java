import java.awt.Color;
import java.awt.Graphics;

public class NewCircle extends DrawableCircle {
	public Color anotherColor;

	public NewCircle(int newX, int newY, int newDiam, Color newColor) {
		super(newX, newY, newDiam, newColor);
		// newColor = anotherColor;

	}

	public void draw(Graphics g) {
		// draw the base circle in a different color
		g.setColor(anotherColor);
		super.draw(g);
		//draw the mickey mouse ears
		g.fillOval(getX() + getDiam() / 5 * 3, getY() - getDiam() / 2, getDiam() / 3 * 2, getDiam() / 3 * 2);
		g.fillOval(getX() - getDiam() / 4, getY() - getDiam() / 2, getDiam() / 3 * 2, getDiam() / 3 * 2);
	}
}
