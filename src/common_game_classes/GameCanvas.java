package common_game_classes;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {

    private final CanvasPaintListener canvasPaintListener;
    private long lastFrameTime;

    public GameCanvas(CanvasPaintListener canvasPaintListener){
        this.canvasPaintListener = canvasPaintListener;
        lastFrameTime = System.nanoTime();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f;
        lastFrameTime = currentTime;

        canvasPaintListener.onDrawFrame(this, g, deltaTime);
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }

    public int getLeft(){ return 0; }
    public int getRight(){ return getWidth() - 1; }
    public int getTop(){ return 0; }
    public int getBottom(){ return getHeight() - 1; }
}
