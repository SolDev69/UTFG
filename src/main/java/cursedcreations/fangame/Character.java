package cursedcreations.fangame;

import static cursedcreations.fangame.Utils.print;
import static org.lwjgl.opengl.GL46.*;

public class Character implements Object {
    private double width;
    private double x;
    private double y;
    private double speed;

    public Character(double x, double y, double speed, double width) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = width;
    }

    public void moveUp() {
        if (y + (1/width) <= 1) {
            y += speed;
        } else { print(y); }
    }

    public void moveDown() {
        if (y >= -1) {
            y -= speed;
        } else { print(y); }
    }

    public void moveLeft() {
        if (x >= -1) {
            x -= speed;
        } else { print(x); }
    }

    public void moveRight() {
        if (x + (1/width) <= 1) {
            x += speed;
        } else { print(x); }
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
}
