package cgg;

import tools.Color;
import tools.ImageWriter;

public class Image implements tools.Image {

    protected int width;
    protected int height;
    protected double[][][] pixels;

    // Provides storage for the image data.
    public Image(int width, int height) {
        this.width = width;
        this.height = height;
        this.pixels = new double[width][height][3];  // 3 = rgb
    }

    // Stores the RGB color components for one pixel addressed
    // by it's coordinates in the image.
    @Override
    public void setPixel(int x, int y, Color color) {
        pixels[x][y][0] = color.r();
        pixels[x][y][1] = color.g();
        pixels[x][y][2] = color.b();
    }

    // Stores the image data in a PNG file.
    public void writePng(String name) {
        // writePng expects double[], unwrap pixels which is [][][] to match that
        double[] dataIn = new double[width*height*3];
        int currentIndex = 0;
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < width; y++) {
                System.arraycopy(pixels[x][y], 0, dataIn, currentIndex, 3);
                currentIndex += 3; 
            }
        }

        ImageWriter.writePng(name, dataIn, this.width, this.height);
    }

    // Retrieves the RGB color components for one particular pixel addressed
    // by it's coordinates in the image.
    public Color getPixel(int x, int y) {
        return Color.black;
    }

    public void writeHdr(String name) {
        System.out.format("Implement function `cgg.Image.writeHdr` to actually write image `%s`\n", name);
        // ImageWriter.writeHdr(name, data, width, height);
    }

    public int width() {
        // This is just a dummy value to make the compiler happy. This
        // needs to be adjusted such that the actual width of the Image is
        // returned.
        return 0;
    }

    public int height() {
        // This is just a dummy value to make the compiler happy. This
        // needs to be adjusted such that the actual height of the Image is
        // returned.
        return 0;
    }
}
