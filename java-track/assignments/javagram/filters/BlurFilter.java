package javagram.filters;

import javagram.Picture;
import java.awt.Color;
import java.util.Scanner;

public class BlurFilter implements Filter {
  // TODO: determine the blur depth by prompting the user. depth is how many pixels
  // away from the current pixel to calculate the weight. must be lower than whichever
  // is smaller (width / 2 - 1 or height / 2 - 1)
  private Scanner in = new Scanner(System.in);

  @Override
  public Picture process(Picture original) {
    
    Picture processed = new Picture(original.width(), original.height());
    int passes;
    int pass = 0;

    for (int i = 0; i < original.width(); ++i) {
      for (int j = 0; j < original.height(); ++j) {
        Color c = original.get(i, j);
        processed.set(i, j, c);
      }
    }
    
    passes = getInt("How many blur passes would you like?: ", 0, in);
    
    System.out.println("Processing...");
    for (; pass < passes; ++pass) {
      for (int i = 0; i < original.width(); ++i) {
        for (int j = 0; j < original.height(); ++j) {
          Color c = calculateWeight(i, j, processed);
          processed.set(i, j, c);
        }
      }
    }
    
    return processed;
  }
  
  private int getInt(String msg, int limit, Scanner in)
  {
    int result;
    System.out.println(msg);
    if (limit > 0) {
      do {
        result = in.nextInt();
        if (result > limit) {
          System.out.println(result + " is too high of a value. The max value is " + limit);
        }
      } while (result > limit);
    } else {
      result = in.nextInt();
      if (result <= 0) result = 1;
    }
    return result;
  }
  
  private Color calculateWeight(int x, int y, Picture p)
  {
    // you will probably need an arraylist of colors when using a variable blur
    // depth, make sure to skip over the center value when calculating adjacent weights
    final int adjacentWeight = 3;
    final int weight = 8;
    int numAdjacent = 0;
    
    Color top, bottom, left, right;
    top = bottom = left = right = null;
    /* (r * weight + top.r * adjacentWeight + bottom.r * adjacentWeight + 
     * left.r * adjacentWeight + right.r * adjacentWeight) / (adjacentWeight * 4) + weight;
     */
    int r = 0, g = 0, b = 0;

    if (x - 1 >= 0) {
      left = p.get(x-1, y);
      r += left.getRed() * adjacentWeight;
      g += left.getGreen() * adjacentWeight;
      b += left.getBlue() * adjacentWeight;
      numAdjacent++;
    }
    if (x + 1 < p.width()) {
      right = p.get(x+1, y);
      r += right.getRed() * adjacentWeight;
      g += right.getGreen() * adjacentWeight;
      b += right.getBlue() * adjacentWeight;
      numAdjacent++;
    }
    if (y - 1 >= 0) {
      top = p.get(x, y-1);
      r += top.getRed() * adjacentWeight;
      g += top.getGreen() * adjacentWeight;
      b += top.getBlue() * adjacentWeight;
      numAdjacent++;
    }
    if (y + 1 < p.height()) {
      bottom = p.get(x, y+1);
      r += bottom.getRed() * adjacentWeight;
      g += bottom.getGreen() * adjacentWeight;
      b += bottom.getBlue() * adjacentWeight;
      numAdjacent++;
    }
    
    r += p.get(x, y).getRed() * weight;
    g += p.get(x, y).getGreen() * weight;
    b += p.get(x, y).getBlue() * weight;
    
    r = r / ((adjacentWeight * numAdjacent) + weight);
    g = g / ((adjacentWeight * numAdjacent) + weight);
    b = b / ((adjacentWeight * numAdjacent) + weight);
    
    return new Color(r, g, b);
  }

}
