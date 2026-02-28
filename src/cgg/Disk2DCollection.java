// generates a given amount of random disks on a specified canvas
package cgg;

import tools.Color;
import tools.Vec2;

public class Disk2DCollection {
    protected Disk2D[] disks;

    public Disk2DCollection(int amount, int width, int height) {
        this.disks = new Disk2D[amount];
        // calculate how to split the canvas optimally + what amount to get all Disks onto it without them overlapping
        // check "Circle Packing" for information
        // determine size iteratively 
        double diameter = 1.0;
        double spacing = 1.0;

        while(true) {
            int disksPerRow = (int) Math.floor(width/(diameter+spacing));
            int disksPerColumn = (int) Math.floor(height/(diameter+spacing));
            if (disksPerRow * disksPerColumn < amount) {
                // step back to last valid size
                diameter -= 1.0;
                break;
            }
            diameter += 1;
        }

        double radius = diameter/2;
        
        int disksPerRow = (int) Math.floor(width/(diameter+spacing));
        for (int i = 0; i < amount; i++) {
            int row = i / disksPerRow;
            int col = i % disksPerRow;
            double x = col * (diameter + spacing) + radius;
            double y = row * (diameter + spacing) + radius;

            Vec2 position = new Vec2(x, y);

            Color color = switch(row % 3) {
                case 1 -> Color.green;
                case 2 -> Color.blue;
                default -> Color.red;
                }; 

            disks[i] = new Disk2D(position, radius, color);
        }
    }

    public Color getColor(Vec2 pixelPosition) {
        for(Disk2D disk : disks) {
            if (disk.coversPoint(pixelPosition)) {
                return disk.color();
            }
        }
        return Color.black;
    }
}
