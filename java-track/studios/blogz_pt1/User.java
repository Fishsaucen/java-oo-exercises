package blogz_pt1;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

public class User extends Entity{

  private String name;
  private String password;
  // used to assign a user id, allow users to change their name 
  private static List<User> users = new ArrayList<User>();
  private static Pattern p = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]{4,11}");
  
  public User(String name, String password)
  {
    super(Entity.getCurrentUid());
    // prompt for valid username if it fails? delete user if fail?
    try {
      if (User.isValidUsername(name))
        this.name = name;
    } catch(InvalidUserName e) {
      System.out.println("Invalid User Name: " + e.getName());
    }
    this.password = User.hashPassword(password);
    users.add(this);
  }
  
  private static String hashPassword(String password)
  {
    return password;
  }
  
  public boolean isValidPassword(String password)
  {
    return User.hashPassword(password).equals(this.password) ? true : false;
  }
  
  private static boolean isValidUsername(String name) throws InvalidUserName
  {
    boolean valid = p.matcher(name).matches();
    
    if (valid)
      return true;
    else 
      throw new InvalidUserName(name);
  }
  
  public static List<User> getAllUsers()
  {
    return users;
  }

  public String getName() {
    return name;
  }

  public String getPassword() {
    return password;
  }

  public String toString()
  {
    return this.name + ", " + this.getUid() + ", " + this.password;
  }

  public static void main(String[] args) {
    User a = new User("aalke", "pass");
    System.out.println(a.toString());
    System.out.println(a.getUid());
    
    User b = new User("bolken", "posss");
    System.out.println(b.toString());
    System.out.println(b.getUid());
  }

}
