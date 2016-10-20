package blogz_pt1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class PostAndUserTest {
  
  private String[] userNames = {"aaaa1", "bbbb1", "cccc1", "dddd1", "eeee1", "ffff1", "gggg1"};
  private String[] passwords = {"a", "b", "c", "d", "e", "f", "g"};
  public static ArrayList<User> users = new ArrayList<User>();
  private String[] postsBody = {"a", "b", "c", "d", "e", "f", "g"};
  private String[] titles = {"1", "2", "3", "4", "5", "6", "7"};
  public static ArrayList<Post> posts = new ArrayList<Post>();
  private static boolean initialized = false;
  
  @Before
  public void init()
  {
    if (!initialized) {
      for (int i = 0; i < userNames.length; ++i) {
        users.add(new User(userNames[i], passwords[i]));
      }
  
      for (int i = 0; i < postsBody.length; ++i) {
        posts.add(new Post(postsBody[i], titles[i], users.get(i)));
      }
      initialized = true;
    }
  }

  @Test
  public void testUser() {
    for (int i = 0; i < users.size(); ++i) {
      assertEquals("Could not properly set name for User.", userNames[i], users.get(i).getName());
      assertEquals("Could not properly set password for User.", passwords[i], users.get(i).getPassword());
      assertEquals("Could not properly set id for User.", i, users.get(i).getId());
    }
  }

  @Test
  public void testIsValidPassword() {
    for (int i = 0; i < users.size(); ++i) {
      assertEquals("Error in isValidPassword().", true, users.get(i).isValidPassword(passwords[i]));
    }
  }

  @Test
  public void testGetAllUsers() {
    List allUsers = User.getAllUsers();
    for (int i = 0; i < users.size(); ++i) {
      assertEquals("Error with List returned by getAllUsers().", users.get(i), allUsers.get(i));
    }
  }

  @Test
  public void testGetName() {
    for (int i = 0; i < users.size(); ++i) {
      assertEquals("Error in getName().", userNames[i], users.get(i).getName());
    }
  }

  @Test
  public void testGetPassword() {
    for (int i = 0; i < users.size(); ++i) {
      assertEquals("Error in getPassword().", passwords[i], users.get(i).getPassword());
    }
  }

  @Test
  public void testGetId() {
    for (int i = 0; i < users.size(); ++i) {
      assertEquals("Error in getId().", i, users.get(i).getId());
    }
  }

  @Test
  public void testGetUid() {
    assertEquals("Error in getUid().", users.size(), User.getUid());
  }

  @Test
  public void testToString() {
    for (int i = 0; i < users.size(); ++i) {
      String str = userNames[i] + ", " + i + ", " + passwords[i];
      assertEquals("Error in toString().", str, users.get(i).toString());
    }
  }
  
  
  // Testing of Post begins here
 @Test
  public void testPost() {
    fail("Not yet implemented");
  }

  @Test
  public void testGetPost() {
    fail("Not yet implemented");
  }

  @Test
  public void testGetTitle() {
    fail("Not yet implemented");
  }

  @Test
  public void testGetAuthor() {
    fail("Not yet implemented");
  }

  @Test
  public void testGetCreated() {
    fail("Not yet implemented");
  }

  @Test
  public void testGetModified() {
    fail("Not yet implemented");
  }

  @Test
  public void testSetPost() {
    fail("Not yet implemented");
  }

  @Test
  public void testSetTitle() {
    fail("Not yet implemented");
  }

  @Test
  public void testPostToString() {
    fail("Not yet implemented");
  }

}
