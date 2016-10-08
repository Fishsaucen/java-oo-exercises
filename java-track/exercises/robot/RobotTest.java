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
  public void testGetDistance() {
    fail("not yet implemented!");
  }
}
