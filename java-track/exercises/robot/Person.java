package robot;

public class Person {
  
  private String name;
  private int posX, posY;
  
  public Person(String name, int posX, int posY)
  {
    this.name = name;
    this.posX = posX;
    this.posY = posY;
  }
  
  public int getPosX()
  {
    return posX;
  }
  
  public int getPosY()
  {
    return posY;
  }
  
  public String getName()
  {
    return name;
  }
}
