package cursedcreations.fangame;

import static org.lwjgl.opengl.GL46.*;

public class Character implements Object {
    private double x;
    private double y;
    private double speed;

    public Character(double x, double y, double speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public void moveUp() {
        y += speed;
    }

    public void moveDown() {
        y -= speed;
    }

    public void moveLeft() {
        x -= speed;
    }

    public void moveRight() {
        x += speed;
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
        glVertex2d(x+(1.0/speed), y);
        glVertex2d(x+(1.0/speed),y+(1.0/speed));
        glVertex2d(x, y+(1.0/speed));
        glEnd();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
