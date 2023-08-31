package cursedcreations.fangame;

import org.lwjgl.stb.STBImage;

import java.nio.ByteBuffer;

import static org.lwjgl.opengl.GL11.*;


public class Pellet {
    int size;
//    double[][] vertices = new double[4][2];
    double xmin, ymin;

    public Pellet(int size, double y, double x) {
        this.ymin=y;
        this.xmin=x;
        this.size=size;
//        this.vertices[0] = new double[] {0, 1-ymin};
//        this.vertices[1] = new double[] {1.0/size, 1-ymin};
//        this.vertices[2] = new double[] {1.0/size, (1.0/size)-ymin};
//        this.vertices[3] = new double[] {0, (1.0/size)-ymin};
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
        glVertex2d(0 - xmin,1.0 - ymin);
        glVertex2d((1.0 / size) - xmin,1.0 - ymin);
        glVertex2d((1.0 / size) - xmin,1.0-(1.0 / size) - ymin);
        glVertex2d(0 - xmin,1.0-(1.0 / size) - ymin);
        glEnd();
    }
    public double getHeight() {
        return 1.0/size;
    }
}