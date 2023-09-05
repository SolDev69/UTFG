package cursedcreations.fangame;

import org.lwjgl.opengl.*;

import java.awt.*;
import java.util.ArrayList;

import static cursedcreations.fangame.Utils.print;
import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL46.*;

public class Main {
    private long window; // Handle to the window

    public void run() {
        init();
        loop();

        // Clean up resources
        glfwFreeCallbacks(window);
        glfwDestroyWindow(window);
        glfwTerminate();
    }

    int width = 800;
    int height = 800;
    private void init() {
        // Initialize GLFW
        if (!glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        // Configure GLFW
        glfwDefaultWindowHints(); // Optional, but it makes sense to use modern OpenGL
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // The window will stay hidden after creation
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); // The window will be resizable

        // Create the window
        window = glfwCreateWindow(width, height, "2D Game", 0, 0);
        if (window == 0) {
            throw new RuntimeException("Failed to create the GLFW window");
        }

        // Set up a key callback
        glfwSetKeyCallback(window, (window, key, scancode, action, mods) -> {
            if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE) {
                glfwSetWindowShouldClose(window, true); // We will detect this in the rendering loop
            }
        });

        // Make the OpenGL context current
        glfwMakeContextCurrent(window);
        // Enable v-sync
        glfwSwapInterval(1);

        // Make the window visible
        glfwShowWindow(window);
    }
    ArrayList<Pellet> pellets = new ArrayList<>();
    private void loop() {
        GL.createCapabilities(); // Initialize OpenGL bindings
        double yPos = 0.0;
        double xPos = 0.0;
        Character character = new Character(-0.5, -1, 0.04, 5);
        while (!glfwWindowShouldClose(window)) {

            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // Clear the framebuffer

            // Load a TrueType font
            Font font = new Font("Arial", Font.PLAIN, 18);

            instance = this;
            // Rendering code goes here
            int pelletSize=10;
            Pellet pellet = new Pellet(pelletSize, yPos, xPos);
            pellets.add(pellet);
            double pelletFall = -1.0 / 10.0;
            pellet.render();
            pellet.ymin = yPos;
            yPos -= pelletFall * pellet.getHeight(); // Move the pellet downwards
            print(pellet.y + " " + character.getY() + " + " + (pellet.y + 1.0/pellet.size));
            if (yPos > 2.0 || Utils.isCollided(character, pellet)) {
                yPos = 0.0; // Reset position when pellet goes off-screen
                xPos = Utils.getRandomDoubleInclusiveD(-.5/pelletSize,.5/pelletSize);
            }
            handleInput(character);
            character.render();
            glfwSwapBuffers(window); // Swap the color buffers
            glfwPollEvents(); // Poll for window events
        }
    }

    static Main instance;

    public static void main(String[] args) {
        instance = new Main();
        instance.run();
    }



    private void handleInput(Character character) {
//        if (glfwGetKey(window, GLFW_KEY_UP) == GLFW_PRESS) {
//            character.moveUp();
//        }
//        if (glfwGetKey(window, GLFW_KEY_DOWN) == GLFW_PRESS) {
//            character.moveDown();
//        }
        if (glfwGetKey(window, GLFW_KEY_LEFT) == GLFW_PRESS) {
            character.moveLeft();
        }
        if (glfwGetKey(window, GLFW_KEY_RIGHT) == GLFW_PRESS) {
            character.moveRight();
        }
    }
}
