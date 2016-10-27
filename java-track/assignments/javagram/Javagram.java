package javagram;

import javagram.filters.*;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class Javagram {

	public static void main(String[] args) {

		// Create the base path for images		
		String[] baseParts = {System.getProperty("user.dir"), "images"};
		int chosenFilter;
		String dir = String.join(File.separator, baseParts);
		String relPath;
		String workingDir = "path not set";
		Picture picture = null;
		Scanner in = new Scanner(System.in);
		
		// prompt user for image to filter and validate input
		do {
			
			String imagePath = "path not set";
			
			// try to open the file
			try {
				
				System.out.println("Image path (relative to " + dir + "):");
				relPath = in.next();
				
				String[] relPathParts = relPath.split(File.separator);
				imagePath = dir + File.separator + String.join(File.separator, Arrays.asList(relPathParts));
				workingDir = dir;
				// get working directory without file name. need this to list files later.
				for (int i = 0; i < relPathParts.length - 1; ++i) {
				  workingDir += File.separator + relPathParts[i];
				}
				workingDir += File.separator;
				
				picture = new Picture(imagePath);
				
			} catch (RuntimeException e) {
				System.out.println("Could not open image: " + imagePath);
			}
			
		} while(picture == null);
		
		// TODO - prompt user for filter and validate input
		Filter filter = null;
		do {
      try {
        chosenFilter = displayFilterMenu(in);
		// TODO - pass filter ID int to getFilter, and get an instance of Filter back 
        filter = getFilter(chosenFilter-1);			
      } catch(RuntimeException e) {
        System.out.println("Invalid option for filter selected, please try again.");
      }
		} while(filter == null);
		
		// filter and display image
		Picture processed = filter.process(picture);
		processed.show();
		
		System.out.println("Image successfully filtered");
		
		// get list of files in current working directory
		File f;
		ArrayList<String> fileNames;
		if (!workingDir.equals("path not set")) {
      f = new File(workingDir);
      fileNames = new ArrayList<String>(Arrays.asList(f.list()));
		} else {
		  fileNames = null;
		}
		// save image, if desired
		
		System.out.println("Save image to (relative to " + dir + ") (type 'exit' to quit w/o saving):");
		String fileName = in.next();
		
		// TODO - if the user enters the same file name as the input file, confirm that they want to overwrite the original
		if (fileName.equals("exit")) {
			System.out.println("Image not saved");
		} else {
		  if (overwriteFile(in, fileNames, fileName)) {
        String absFileName = dir + File.separator + fileName;
        processed.save(absFileName);
        System.out.println("Image saved to " + absFileName);
		  } else System.out.println("Image not saved");
		}	
		// close input scanner
		in.close();
	}
	
	// TODO - refactor this method to accept an int parameter, and return an instance of the Filter interface
	// TODO - refactor this method to thrown an exception if the int doesn't correspond to a filter
	private static Filter getFilter(int ID) throws RuntimeException {
	  
	  switch (ID) {
	  case 0: return new BlueFilter();
	  case 1: return new InvertFilter();
	  case 2: return new BrightnessFilter();
	  case 3: return new BlurFilter();
	  default: throw new RuntimeException();
	  }
		
	}
	
	private static boolean overwriteFile(Scanner in, ArrayList<String> fileNames, String fileName)
	{
	  String response;
	  // file doesn't exist so safe to assume true
	  if (fileNames.equals(null)) return true;
	  else {
		  for (String file : fileNames) {
		    if (file.equals(fileName)) {
		      while (true) {
            System.out.println("Are you sure you want to overwrite \'" + fileName + "\'?[yes/no]");
            response = in.next();
            response = response.toLowerCase();
            if (response.equals("no") || response.equals("n"))
              return false;
            else if (response.equals("yes") || response.equals("y"))
              return true;
		      }
		    }
		  }
	  }
	  return true;
	}
	
	private static int displayFilterMenu(Scanner in)
	{
    System.out.println("1) Blue Filter\n" +
                       "2) Invert Filter\n" +
                       "3) Brightness Filter\n" +
                       "4) Blur Filter\n" +
                       "");
    System.out.println("Enter the number of the filter you would like to use: ");
    int id = in.nextInt();
    return id;
	}

}