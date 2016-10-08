package robot;

import java.util.Scanner;
import java.util.ArrayList;

public class RobotMenu 
{
  
  private ArrayList<Robot> robots;
  private Scanner in;
  
  public static void main(String[] args) 
  {
    int option;
    RobotMenu rm = new RobotMenu();
    
    do {
      option = rm.startMenu();
      rm.processInput(option);
    } while (option != 6);
  }
  
  public RobotMenu() 
  {
    in = new Scanner(System.in);
    robots = new ArrayList<Robot>();
  }
  
  public int startMenu() 
  {
    int option;
    System.out.println("Welcome to the Robot creation menu\n");
    System.out.println("1.) Create a Robot\n" + "2.) Display the list of available Robots\n" +
                          "3.) Move a Robot\n" + "4.) Rotate a Robot\n" + "5.) Compute the distance between two Robots\n" +
                          "6.) Exit\n");
    System.out.println("Enter an option:\n");
    option = in.nextInt();
    while (option < 0 || option > 6) {
      System.out.println("Invalid value " + option + ", please enter an option 1-6\n");
      option = in.nextInt();
    }
    return option;
  }
  
  void processInput(int option) 
  {
    switch (option) {
    case 1:
      createRobot();
      break;
    case 2:
      displayRobots();
      break;
    case 3:
      displayRobots();
      Robot r = selectRobot();
      r.move();
      System.out.println("Robot " + r.getName() + " has been moved!\n");
      break;
    case 4:
      displayRobots();
      Robot r3 = selectRobot();
      System.out.println("Which direction would you like to rotate the robot?[90: left, -90: right]: ");
      int dir = in.nextInt();
      while (dir != 90 && dir != -90) {
        System.out.println("Invalid direction, please enter 90 for left or -90 for right: ");
        dir = in.nextInt();
      }
      System.out.println("Current robot attributes: " + r3);
      break;
    case 5:
      displayRobots();
      Robot r1 = selectRobot();
      Robot r2 = selectRobot();
      int distance = r1.getDistance(r2);
      System.out.println("The distance between the two robots is " + distance);
      break;
    }
  }
  
  private void displayRobots() 
  {
    for (int i = 0; i < robots.size(); ++i) {
      System.out.println((i+1) + ".)" + robots.get(i));
    }
  }
  
  private void createRobot()
  {
    // name, x pos, y pos, speed, direction
    System.out.println("Enter a name for the robot: ");
    String name = in.next();

    System.out.println("Enter the x position of the robot: ");
    int xPos = in.nextInt();

    System.out.println("Enter the y position of the robot: ");
    int yPos = in.nextInt();

    System.out.println("Enter the speed of the robot: ");
    int speed = in.nextInt();

    System.out.println("Enter the direction of the robot[north, south, east, or west]: ");
    String dir = in.next();

    boolean validDirection = false;
    while (!validDirection) {
      for (Direction d : Direction.values()) {
        if (d.name().equals(dir.toUpperCase())) validDirection = true;
      }
      if (validDirection) break;
      System.out.println("Invalid direction, please enter north, south, east, or west: ");
      dir = in.next();
    }

    Direction direction;
    if (dir.equals("NORTH")) {
      direction = Direction.NORTH;
    } else if (dir.equals("SOUTH")) {
      direction = Direction.SOUTH;
    } else if (dir.equals("EAST")) {
      direction = Direction.EAST;
    } else {
      direction = Direction.WEST;
    }

    Robot bot = new Robot(name, xPos, yPos, speed, direction);
    robots.add(bot);
  }
  
  private Robot selectRobot() {
    System.out.println("Select a robot: ");
    int option = in.nextInt();
    while (option < 1 || option > robots.size()) {
      System.out.println("Invalid selection, try again: ");
      option = in.nextInt();
    }
    return robots.get(option-1);
  }

}
