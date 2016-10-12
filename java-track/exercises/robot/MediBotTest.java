package robot;

import static org.junit.Assert.*;

import org.junit.Test;

public class MediBotTest {

  @Test
  public void testMediBot() {
    MediBot m = new MediBot("m", 0, 0, 1, Direction.NORTH, "advil", 200);
    assertEquals("Could not set MediBot's name.", "m", m.getName());
    assertEquals("Could not set MediBot's posX.", 0, m.getPosX());
    assertEquals("Could not set MediBot's posY.", 0, m.getPosY());
    assertEquals("Could not set MediBot's speed.", 1, m.getSpeed());
    assertEquals("Could not set MediBot's direction.", Direction.NORTH, m.getDirection());
    assertEquals("Could not set MediBot's medicine.", "advil", m.getMedicine());
    assertEquals("Could not set MediBot's medicine amount.", 100, m.getMedAmount());
  }

  @Test
  public void testAdministerMedicine() {
    Person p = new Person("Fred", 5, 8);
    MediBot m = new MediBot("m", 0, 0, 1, Direction.NORTH, "advil", 100);
    m.administerMedicine(p);
    assertEquals("Could not move to patient's x position.", 5, m.getPosX());
    assertEquals("Could not move to patient's y position.", 8, m.getPosY());
    assertEquals("Could not administer proper medicine amount.", 90, m.getMedAmount());
    assertEquals("Could not turn off alarm.", false, m.isAlarmState());
  }

  @Test
  public void testToggleAlarm() {
    MediBot m = new MediBot("m", 0, 0, 1, Direction.NORTH, "advil", 100);
    assertEquals("Alarm state was not properly initialized.", false, m.isAlarmState());
    m.toggleAlarm();
    assertEquals("Alarm state could not be toggled.", true, m.isAlarmState());
  }

  @Test
  public void testRefillMedicine() {
    MediBot m = new MediBot("m", 0, 0, 1, Direction.NORTH, "advil", 100);
    Person p = new Person("Fred", 0, 0);
    
    for (int i = 0; i < 5; ++i) m.administerMedicine(p);
    
    int excessMeds = 0;
    excessMeds = m.refillMedicine("advil", false, 20);
    assertEquals("Wrong amount of excess medicine returned.", 0, excessMeds);
    assertEquals("Could not properly refill MediBot's medicine.", 70, m.getMedAmount());
    
    excessMeds = m.refillMedicine("advil", false, 40);
    assertEquals("Wrong amount of excess medicine returned.", 10, excessMeds);
    assertEquals("Could not properly refill MediBot's medicine.", 100, m.getMedAmount());
    
    excessMeds = m.refillMedicine("arsenic", true, 40);
    assertEquals("Wrong amount of excess medicine returned.", 0, excessMeds);
    assertEquals("Could not properly refill MediBot's medicine.", 40, m.getMedAmount());
    assertEquals("Could not properly change MediBot's medicine type.", "arsenic", m.getMedicine());
    
    excessMeds = m.refillMedicine("advil", true, 200);
    assertEquals("Wrong amount of excess medicine returned.", 100, excessMeds);
    assertEquals("Could not properly refill Medibot's medicine.", 100, m.getMedAmount());
    assertEquals("Could not properly change MediBot's medicine type.", "advil", m.getMedicine());
    
    excessMeds = m.refillMedicine("water", false, 200);
    assertEquals("Wrong amound of excess medicine returned.", 200, excessMeds);
  }
}
