package blogz_pt1;

import java.util.ArrayList;

public class Entity {
  
  // TODO: implement separated ids for a User and Post
  private final int uid;
  protected static int currentUid = 0;
  private static ArrayList<Entity> allEntities = new ArrayList<Entity>();
  
  public Entity(int uid) 
  {
    boolean validUid = false;
    try {
      validUid = Entity.isValidUid(uid);
    } catch (IllegalArgumentException e) {
      System.out.println("Error: invalid uid " + e.getMessage());
    }
    
    if (validUid) {
      this.uid = uid;
      currentUid++;
    } else 
      this.uid = -1;
  }
  
  private static boolean isValidUid(int uid) throws IllegalArgumentException 
  {
    if (uid >= 0 && Entity.isUniqueUid(uid)) 
      return true;
    else {
      throw new IllegalArgumentException();
    }
  }
  
  private static boolean isUniqueUid(int uid)
  {
    for (int i = 0; i < allEntities.size(); ++i) {
      if (uid == allEntities.get(i).getUid()) return false;
    }
    return true;
  }
  
  
  public int getUid()
  {
    return this.uid;
  }
  
  protected static int getCurrentUid()
  {
    return currentUid;
  }

  public static void main(String[] args) throws InterruptedException {

  }

}
