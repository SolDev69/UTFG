package cursedcreations.fangame;

import static org.lwjgl.opengl.GL11.*;


public class Pellet implements Object {
    int size;
//    double[][] vertices = new double[4][2];
    double xmin, ymin, x, y;

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
        glColor3f(1.0f, 1.0f, 1.0f); // Set color to red
        glBegin(GL_QUADS);
//        glVertex2f(x, y);
//        glVertex2f(x + width, y);
//        glVertex2f(x + width, y + height);
//        glVertex2f(x, y + height);
//        glEnd();
        glBegin(GL_QUADS);
        x = 0 - xmin;
        y = 1.0 - ymin;
        glVertex2d(x, y);
        x = (1.0 / size) - xmin;
        y = 1.0 - ymin;

        glVertex2d(x,y);
        y = 1.0-(1.0 / size) - ymin;
        glVertex2d(x,y);
        x = 0 - xmin;
        y = 1.0-(1.0 / size) - ymin;
        glVertex2d(x,y);
        glEnd();
    }
    public double getHeight() {
        return 1.0/size;
    }
}