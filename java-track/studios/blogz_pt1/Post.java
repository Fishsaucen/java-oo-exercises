package blogz_pt1;

import java.util.Date;

public class Post {

  private String post;
  private String title;
  private User author;
  private final Date created;
  private Date modified;
  
  public Post(String post, String title, User author)
  {
    this.post = post;
    this.title = title;
    this.author = author;
    this.created = new Date();
    this.modified = this.created;
  }
  
  public String getPost() {
    return post;
  }

  public String getTitle() {
    return title;
  }

  public User getAuthor() {
    return author;
  }

  public Date getCreated() {
    return created;
  }

  public Date getModified() {
    return modified;
  }

  public void setPost(String post) {
    this.post = post;
    this.setModified();
  }

  public void setTitle(String title) {
    this.title = title;
    this.setModified();
  }

  private void setModified() {
    this.modified = new Date();
  }
  
  public String toString()
  {
    return this.author.getName() + "\n" + this.title + "\n" + this.created.toString() + "\n" + this.modified.toString() + 
            "\n" + this.post;
  }

  public static void main(String[] args) throws InterruptedException {
    
    User a = new User("aa59lk", "pass");
    Post p = new Post("hello", "hi", a);
    System.out.println(p.toString());
    System.out.println();
    
    Thread.sleep(10000);
    
    p.setPost("goodbye!");
    p.setTitle("bye");
    
    System.out.println(p.toString());

  }

}
