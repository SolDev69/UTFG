package mike.not.pike;

import static org.lwjgl.opengl.GL46.*;

public class Character implements Object {
    private final double width;
    private final double speed;
    private double x;
    private double y;

    Main instance = Main.getInstance();

    public Character(double x, double y, double speed, double width) {
        this.speed = speed;
        this.width = width;
        this.x = x;
        this.y = y;
    }

    public void moveUp() {
        if (y + (1/width) <= 1) {
            y += speed;
        } else { Utils.printDebug(y); }
    }

    public void moveDown() {
        if (y >= -1) {
            y -= speed;
        } else { Utils.printDebug(y); }
    }

    public void moveLeft() {
        Utils.printDebug("Character x" + x + " pellet x " + instance.pellets.get(instance.pellets.size()-1).x);
        if (x >= -1) {
            x -= speed;
        } else { Utils.printDebug(x); }
    }

    public void moveRight() {
        Utils.printDebug("Character x" + x + " pellet x " + instance.pellets.get(instance.pellets.size()-1).x);

        if (x + (1/width) <= 1) {
            x += speed;
        } else { Utils.printDebug(x); }
    }

    public void render() {
        glColor3f(1.0f, 0.0f, 0.0f); // Set color to red
        glBegin(GL_QUADS);
//        glVertex2f(x, y);
//        glVertex2f(x + width, y);
//        glVertex2f(x + width, y + height);
//        glVertex2f(x, y + height);
//        glEnd();
        glBegin(GL_QUADS);
        glVertex2d(x,y);
        glVertex2d(x+(1.0/width), y);
        glVertex2d(x+(1.0/width),y+(1.0/(width * 2)));
        glVertex2d(x, y+(1.0/(width * 2)));
        glEnd();
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }
    public double getHeight() {
        return width*2;
    }
}
