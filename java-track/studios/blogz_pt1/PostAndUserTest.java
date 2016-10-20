package blogz_pt1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
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
      assertEquals("Could not properly set id for User.", i, users.get(i).getUid());
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
  public void testGetUid() {
    for (int i = 0; i < users.size(); ++i) {
      assertEquals("Error in getUid().", i, users.get(i).getUid());
    }
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
   for (int i = 0; i < posts.size(); ++i) {
     assertEquals("Could not instantiate post properly.", postsBody[i], posts.get(i).getPost());
     assertEquals("Could not instantiate title properly.", titles[i], posts.get(i).getTitle());
     assertEquals("Could not instantiate author properly.", users.get(i), posts.get(i).getAuthor());
   }
  }

  @Test
  public void testGetPost() {
    for (int i = 0; i < posts.size(); ++i) {
      assertEquals("Error, getPost() not working properly.", postsBody[i], posts.get(i).getPost());
    }
  }

  @Test
  public void testGetTitle() {
    for (int i = 0; i < posts.size(); ++i) {
      assertEquals("Error, getTitle() not working properly.", titles[i], posts.get(i).getTitle());
    }
  }

  @Test
  public void testGetAuthor() {
    for (int i = 0; i < posts.size(); ++i) {
      assertEquals("Error, getAuthor() not working properly.", users.get(i), posts.get(i).getAuthor());
    }
  }

  @Test
  public void testGetCreated() throws InterruptedException {
    Thread.sleep(1000);
    for (int i = 0; i < posts.size(); ++i) {
      Date d = new Date();
      // we're testing whether or not the value returned by getCreated() is less than d
      assertEquals("Error, getCreated() not working properly.", true, 
          posts.get(i).getCreated().compareTo(d) <= 0);
    }
  }

  @Test
  public void testGetModified() {
    for (int i = 0; i < posts.size(); ++i) {
      Date modified = posts.get(i).getModified();
      assertEquals("Error, getModified() not working properly.", true, 
          modified.compareTo(posts.get(i).getCreated()) >= 0);
    }
  }

  @Test
  public void testSetPost() {
    for (int i = 0, j = posts.size() - 1; i < posts.size() && j >= 0; ++i, --j) {
      posts.get(i).setPost(postsBody[j]);
      assertEquals("Error, setPost() not working properly.", postsBody[j], posts.get(i).getPost());
    }
  }

  @Test
  public void testSetTitle() {
    for (int i = 0, j = posts.size() - 1; i < posts.size() && j >= 0; ++i, --j) {
      posts.get(i).setTitle(titles[j]);
      assertEquals("Error, setTitle() not working properly.", titles[j], posts.get(i).getTitle());
    }
  }

  @Test
  public void testPostToString() {
    for (int i = 0; i < posts.size(); ++i) {
      String str = users.get(i).getName() + "\n" + titles[i] + "\n" + posts.get(i).getCreated().toString() +
          "\n" + posts.get(i).getModified().toString() + "\n" + postsBody[i];
      assertEquals("Error in toString() method.", true, posts.get(i).toString().equals(str));
    }
  }

}
