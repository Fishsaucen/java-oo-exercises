package javagram.filters;

import javagram.Picture;

public interface Filter {
  
  Picture process(Picture original);
}
