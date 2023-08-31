package cursedcreations.fangame;

import org.lwjgl.stb.STBImage;

import java.nio.ByteBuffer;

import static org.lwjgl.opengl.GL11.*;


public class Pellet {
    int size = 1;

    public Pellet(int size) {
        this.size=size;
    }

    public void render(double ymin) {
        glColor3f(1.0f, 0.0f, 0.0f); // Set color to red
        glBegin(GL_QUADS);
//        glVertex2f(x, y);
//        glVertex2f(x + width, y);
//        glVertex2f(x + width, y + height);
//        glVertex2f(x, y + height);
//        glEnd();
        glBegin(GL_QUADS);
        glVertex2d(0,1 - ymin);
        glVertex2d(1.0 /size,1 - ymin);
        glVertex2d(1.0 /size,(1.0 /size) - ymin);
        glVertex2d(0,(1.0 /size)-ymin);
        glEnd();
    }
    public double getHeight() {
        return 1.0/size;
    }
}