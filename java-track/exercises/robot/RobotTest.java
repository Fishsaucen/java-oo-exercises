package robot;

import static org.junit.Assert.*;

import org.junit.Test;

public class RobotTest {

  @Test
  public void testRobot() {
    // assertEquals("msg", assertion, foo(bar, baz));
    Robot testbot = new Robot("bot", 0, 0, 1, Direction.NORTH);
    // test the name, x pos, y pos, speed, and direction
    assertEquals("Could not name Robot.", "bot", testbot.getName());
    assertEquals("Could not set x pos.", 0, testbot.getPosX());
    assertEquals("Could not set y pos.", 0, testbot.getPosY());
    assertEquals("Could not set speed.", 1, testbot.getSpeed());
    assertEquals("Could not set direction.", Direction.NORTH, testbot.getDirection());
    
  }

  @Test
  public void testMove() {
    Robot testbot = new Robot("bot", 0, 0, 1, Direction.NORTH);
    for (int i = 0; i < 5; ++i) {
      assertEquals("Error in move(). Invalid translation.", i , testbot.getPosY());
      testbot.move();
    }
  }

  @Test
  public void testRotate() {
    Robot testbot = new Robot("bot", 0, 0, 1, Direction.NORTH);
    testbot.rotate(90);
    assertEquals("Could not rotate Robot.", Direction.WEST, testbot.getDirection());
    testbot.rotate(-90);
    assertEquals("Could not rotate Robot.", Direction.NORTH, testbot.getDirection());
  }

  @Test
  public void testGoToPos()
  {
    Robot r1 = new Robot("a", 0, 0, 1, Direction.NORTH);
    // > >
    r1.goToPos(4, 6);
    assertEquals("Robot could not move to X=4.", 4, r1.getPosX());
    assertEquals("Robot could not move to Y=6", 6, r1.getPosY());
    // < <
    r1.goToPos(1, 2);
    assertEquals("Robot could not move to X=1", 1, r1.getPosX());
    assertEquals("Robot could not move to Y=1", 2, r1.getPosY());
    
    // > <
    r1.goToPos(5, 1);
    assertEquals("Robot could not move to X=5", 5, r1.getPosX());
    assertEquals("Robot could not mvoe to Y=1", 1, r1.getPosY());
    
    // < >
    r1.goToPos(3, 8);
    assertEquals("Robot could not move to X=3", 3, r1.getPosX());
    assertEquals("Robot could not move to Y=8", 8, r1.getPosY());
    
    // > ==
    r1.goToPos(5, 8);
    assertEquals("Robot could not move to X=5", 5, r1.getPosX());
    assertEquals("Robot could not move to Y=8", 8, r1.getPosY());
    
    // < ==
    r1.goToPos(2, 8);
    assertEquals("Robot could not move to X=2", 2, r1.getPosX());
    assertEquals("Robot could not move to Y=8", 8, r1.getPosY());
    
    // == >
    r1.goToPos(2, 10);
    assertEquals("Robot could not move to X=2", 2, r1.getPosX());
    assertEquals("Robot could not move to Y=10", 10, r1.getPosY());
    
    // == <
    r1.goToPos(2, 4);
    assertEquals("Robot could not move to X=2", 2, r1.getPosX());
    assertEquals("Robot could not move to Y=4", 4, r1.getPosY());
  }
  @Test
  public void testGetDistance() {
    Robot r1 = new Robot("a", 0, 0, 0, Direction.NORTH);
    Robot r2 = new Robot("b", 2, 2, 0, Direction.NORTH);
    int distance = (int)(Math.sqrt((2-0) * (2-0) + (2-0) * (2-0)));
    assertEquals("getDistance() not working properly.", distance, r1.getDistance(r2));
    r1.setPosX(1);
    r1.setPosY(1);
    r2.setPosX(4);
    r2.setPosY(4);
    distance = (int)(Math.sqrt((4-1) * (4-1) + (4-1) * (4-1)));
    assertEquals("getDistance() not working properly.", distance, r2.getDistance(r1));
  }
  
}
