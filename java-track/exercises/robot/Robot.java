package robot;
enum Direction 
{
  NORTH, EAST, SOUTH, WEST;
}

public class Robot {
  
 
  protected String name;
  protected int posX, posY, speed;
  protected Direction direction;
  
  public Robot(String name, int posX, int posY, int speed, Direction direction)
  {
    this.name = name;
    this.posX = posX;
    this.posY = posY;
    this.speed = speed;
    this.direction = direction;
  }
  
  // methods
  public void move()
  {
    switch (this.direction) {
    case NORTH:
      this.posY += this.speed;
      break;
    case SOUTH:
      this.posY -= this.speed;
      break;
    case EAST:
      this.posX += this.speed;
      break;
    case WEST:
      this.posX -= this.speed;
      break;
    }
  }
  
  public void rotate(int direction)
  {
   
   switch (direction) {
   case -90:
     this.direction = Direction.values()[(this.direction.ordinal() + 1) % Direction.values().length];
     break;
   case 90:
     // modulo operator: implementation defined behavior? -x % y returns -x
     this.direction = Direction.values()[(this.direction.ordinal() + 3) % Direction.values().length];
     break;
   default:
     return;
   }
  }

  public void goToPos(int x, int y)
  {
    // make sure we can get to the location 
    int tempSpeed = this.speed;
    this.setSpeed(1);

    if (x < posX) {
      if (direction == Direction.WEST) {
        while (x < posX) move();
        
      } else if (direction == Direction.EAST) {
        for (int i = 0; i < 2; ++i) rotate(90);
        while (x < posX) move();

      } else if (direction == Direction.NORTH) {
        rotate(90);
        while (x < posX) move();
        
      } else {
        rotate(-90);
        while (x < posX) move();
      }
    } else if (x > posX) {
      if (direction == Direction.EAST) {
        while (x > posX) move();
        
      } else if (direction == Direction.WEST) {
        for (int i = 0; i < 2; ++i) rotate(90);
        while (x > posX) move();
        
      } else if (direction == Direction.NORTH) {
        rotate(-90);
        while (x > posX) move();
        
      } else {
        rotate(90);
        while (x > posX) move();
      }
    }

    if (y < posY) {
      if (direction == Direction.SOUTH) {
        while (y > posY) move();

      } else if (direction == Direction.NORTH) {
        for (int i = 0; i < 2; ++i) rotate(90);
        while (y < posY) move();

      } else if (direction == Direction.EAST) {
        rotate(-90);
        while (y < posY) move();

      } else {
        rotate(90);
        while (y < posY) move();
      }
    } else if (y > posY) {
      if (direction == Direction.NORTH) {
        while (y > posY) move();

      } else if (direction == Direction.SOUTH) {
        for (int i = 0; i < 2; ++i) rotate(90);
        while (y > posY) move();

      } else if (direction == Direction.EAST) {
        rotate(90);
        while (y > posY) move();
        
      } else {
        rotate(-90);
        while (y > posY) move();
      }
    }
    
    this.setSpeed(tempSpeed);
  }

  public int getDistance(Robot bot)
  {
    return (int)Math.sqrt( (this.posX - bot.posX) * (this.posX - bot.posX) + (this.posY - bot.posY) * (this.posY - bot.posY) );
  }
  
  // getters
  public String getName()
  {
    return this.name;
  }
  
  public int getPosX()
  {
    return this.posX;
  }
  
  public int getPosY()
  {
    return this.posY;
  }
  
  public int getSpeed()
  {
    return this.speed;
  }
  
  public Direction getDirection()
  {
    return this.direction;
  }
  // setters
  
  public void setName(String name) {
    this.name = name;
  }

  public void setPosX(int posX) {
    this.posX = posX;
  }

  public void setPosY(int posY) {
    this.posY = posY;
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }

  public String toString()
  {
    return "name: " + this.name + ", position x: " + this.posX + ", position y: " + this.posY + ", speed: " + this.speed + 
            ", direction: " + this.direction;
  }

  public static void main(String[] args) {
    
    Robot ultron = new Robot("ultron", 0, 0, 2, Direction.NORTH);
    Robot robby = new Robot("robby", 8, 12, 3, Direction.WEST);
    System.out.println("ultron: " + ultron);
    for (int i = 0; i < 4; ++i) {
      ultron.rotate(90);
      System.out.println(ultron.getDirection());
    }
    
    System.out.println();
    
    for (int i = 0; i < 4; ++i) {
      ultron.rotate(-90);
      System.out.println(ultron.getDirection());
    }
    
    System.out.println();
    System.out.println("robby: " + robby);
    for (int i = 0; i < 4; ++i) {
      robby.rotate(90);
      System.out.println(robby.getDirection());
    }
    
    System.out.println();
    
    for (int i = 0; i < 4; ++i) {
      robby.rotate(-90);
      System.out.println(robby.getDirection());
    }
    
    // find their distance
    System.out.println("ultron's distance to robby: " + ultron.getDistance(robby));
    System.out.println("robby's distance to ultron: " + robby.getDistance(ultron));

    // move the robuts 
    ultron.move();
    ultron.move();
    robby.move();
    robby.move();
    
    // print their current values
    System.out.println(ultron);
    System.out.println(robby);
    
    // find their new distance
    System.out.println("ultron's distance to robby: " + ultron.getDistance(robby));
    System.out.println("robby's distance to ultron: " + robby.getDistance(ultron));
    
    System.out.println("ultron's distance to itself: " + ultron.getDistance(ultron));
    
  }

}
