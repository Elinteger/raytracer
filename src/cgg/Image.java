package cgg;

import cgtools.*;

public class Image {
  protected int width;
  protected int height;
  protected double[][][] pixels; 

  public Image(int width, int height) {
    this.width = width;
    this.height = height;
    // 3 because of rgb
    this.pixels = new double[width][height][3];
  }

  public void setPixel(int x, int y, Color color) {
    pixels[x][y][0] = color.r();
    pixels[x][y][1] = color.g();
    pixels[x][y][2] = color.b();
  }

  public void write(String filename) {
    // unravel double[][][] to double[] as thats expected from the prewritten function `ImageWriter.write()`
    double[] data = new double[width*height*3];
    int currentIndex = 0;
    for(int x = 0; x < width; x++) {
      for(int y = 0; y < height; y++) {
        System.arraycopy(pixels[x][y], 0, data, currentIndex, 3);
        currentIndex +=3;
      }
    }

    ImageWriter.write(filename, data, width, height);
  }
}
