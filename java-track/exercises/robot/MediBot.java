package robot;

public class MediBot extends Robot
{
  private String medicine;
  // in cc
  final private int maxMedAmount = 100;
  private int medAmount;
  private boolean alarmState;
  
  public MediBot(String name, int posX, int posY, int speed, Direction direction, String medicine, int medAmount)
  {
    super(name, posX, posY, speed, direction);
    this.medicine = medicine;
    if (medAmount <= maxMedAmount)
      this.medAmount = medAmount;
    else 
      this.medAmount = maxMedAmount;
    this.alarmState = false;
  }
  
  // Person is a dummy class for example purposes
  public void administerMedicine(Person p)
  {
    toggleAlarm();
    goToPos(p.getPosX(), p.getPosY());
    medAmount -= 10;
    toggleAlarm();
  }
  
  public void toggleAlarm()
  {
    if (!alarmState) {
      alarmState = true;
      System.out.println("WEEEEOOOO! WEEEOOOO!");
    } else 
      alarmState = false;
  }
  
  // returns excess medicine
  public int refillMedicine(String type, boolean changeType, int amount)
  {
    // check if medicine is of a different type
    if (!type.toUpperCase().equals(medicine.toUpperCase()) && changeType) {
      if (amount > maxMedAmount) {
        setMedicine(type);
        setMedAmount(maxMedAmount);
        return amount - maxMedAmount;
      } else {
        setMedicine(type);
        setMedAmount(amount);
        return 0;
      }
    } else if (getMedAmount() < maxMedAmount && type.toUpperCase().equals(medicine.toUpperCase())) {
      int refillAmt = maxMedAmount - getMedAmount();
      if (amount < refillAmt) {
        setMedAmount(getMedAmount() + amount);
        return 0;
      } else {
        setMedAmount(getMedAmount() + refillAmt);
        return amount - refillAmt;
      }
    } else 
      return amount;
  }
  
  @Override
  public String toString() {
    return "MediBot [medicine=" + medicine + ", medAmount=" + medAmount + ", alarmState=" + alarmState + ", name="
        + name + ", posX=" + posX + ", posY=" + posY + ", speed=" + speed + ", direction=" + direction + "]";
  }

  public String getMedicine() {
    return medicine;
  }

  public int getMedAmount() {
    return medAmount;
  }

  public boolean isAlarmState() {
    return alarmState;
  }

  private void setMedicine(String medicine) {
    this.medicine = medicine;
  }

  private void setMedAmount(int medAmount) {
    this.medAmount = medAmount;
  }

  public static void main(String[] args)
  {
    MediBot med = new MediBot("medibot", 5, 2, 4, Direction.EAST, "advil", 200);
    System.out.println(med.toString());
    med.toggleAlarm();
  }
}
