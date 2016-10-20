public class Course {
  
  private String courseName;
  private int credits, remainingSeats;
  private Student[] roster;
  private int currentSeat = 0;
  
  public Course(String course, int credits, int remainingSeats)
  {
    this.courseName = course;
    this.credits = credits;
    this.remainingSeats = remainingSeats;
    this.roster = new Student[remainingSeats];
  }
  
  public boolean addStudent(Student s)
  {
    if (remainingSeats < 1) return false;
    roster[currentSeat] = s;
    currentSeat++;
    remainingSeats--;
    return true;
  }
  
  public double averageGPA()
  {
    double gpaSum = 0.0;
    int numStudents = 0;
    for (Student s : roster) {
      if (s != null) {
        gpaSum += s.getGPA();
        numStudents++;
      }
    }
    if (numStudents > 0)
      return gpaSum / numStudents;
    else 
      return 0.0;
  }
  
  public String generateRoster()
  {
    String str = "";
    for (int i = 0; i < roster.length; ++i) {
      if (roster[i] != null)
        str += roster[i].toString();
      else 
        break;

      if (i+1 < roster.length && roster[i+1] != null)
        str += ", ";
    }
    return str;
  }
  
  public String getName()
  {
    return courseName;
  }
  
  public int getRemainingSeats()
  {
    return remainingSeats;
  }
  
  public String toString()
  {
    return courseName + " " + credits;
  }
  
  public static void main(String[] args)
  {
    Student s1 = new Student("a", "b", 1);
    Student s2 = new Student("a", "c", 2);
    Student s3 = new Student("b", "c", 3);
    Course c = new Course("course", 1, 3);
    c.addStudent(s1);
    c.addStudent(s2);
    c.addStudent(s3);
    System.out.println(c.generateRoster());
  }
}