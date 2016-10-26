package javagram.filters;

import javagram.Picture;
import java.awt.Color;
import java.util.Scanner;

public class BrightnessFilter implements Filter {
  
  private Scanner in = new Scanner(System.in);

  @Override
  public Picture process(Picture original) {

    Picture processed = new Picture(original.width(), original.height());
    
    int brightness = getBrightness(in);
    
    for (int i = 0; i < original.width(); ++i) {
      for (int j = 0; j < original.height(); ++j) {
        
        Color c = original.get(i, j);
        
        int r = c.getRed() + brightness;
        int g = c.getGreen() + brightness;
        int b = c.getBlue() + brightness;
        
        if (r < 0) r = 0;
        else if (r > 255) r = 255;
        
        if (g < 0) g = 0;
        else if (g > 255) g = 255;
        
        if (b < 0) b = 0;
        else if (b > 255) b = 255;
        
        processed.set(i, j, new Color(r, g, b));
      }
    }

    return processed;
  }
  
  private int getBrightness(Scanner in) 
  {
    System.out.println("Enter a brightness amount(use negative amounts to darken the image): ");
    int amount = in.nextInt();
    return amount;
  }

}
