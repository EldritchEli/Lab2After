import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    private CarGroup carGroup;

    // Just a single image, TODO: Generalize

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, CarGroup carGroup) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.magenta);
        // Print an error message in case file is not found with a try/catch block
        Car saab95 = new Saab95();
        saab95.setY(100);
        Car scania = new Scania();
        scania.setY(200);
        carGroup.add(new Volvo240());
        carGroup.add(saab95);
        carGroup.add(scania);
        this.carGroup = carGroup;
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Car car: carGroup.getCars()) {
            BufferedImage texture;
            try {
                texture = ImageIO.read(DrawPanel.class.getResourceAsStream(car.getTexture()));
            } catch (IOException ex)
            {
                texture = null;
                ex.printStackTrace();
            }
            g.drawImage(texture,(int)car.getX(), (int)car.getY(), null);
        }
    }

    public CarGroup getCarGroup() {
        return carGroup;
    }
}
