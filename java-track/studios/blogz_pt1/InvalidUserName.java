package blogz_pt1;

public class InvalidUserName extends Exception{
  
  private String name;
  
  public InvalidUserName(String name)
  {
    this.name = name;
  }
  
  public String getName()
  {
    return this.name;
  }

}
