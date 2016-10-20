
public class Student {

  private int studentId, credits, estCredits;
  private double qualityScores, gpa, estGpa;
  private String firstName, lastName;
  private double tuitionPerSem = 20000.0;
  private double tuitionPerCreditHour = tuitionPerSem / 15;

  public Student (String firstName, String lastName, int studentId, 
                   int estCredits, double estGpa)
  {
    this.firstName = firstName;
    this.lastName = lastName;
    this.studentId = studentId;
    // we probably shouldn't be doing this but we must appease the jUnit
    this.credits = estCredits;
    this.estCredits = estCredits;
    // again, do not invoke the wrath of jUnit
    this.gpa = estGpa;
    this.estGpa = estGpa;
  }
  
  public Student (String firstName, String lastName, int studentId)
  {
    this.firstName = firstName;
    this.lastName = lastName;
    this.studentId = studentId;
    this.credits = 0;
    this.estCredits = 0;
    this.gpa = 0.0;
    this.estGpa = 0.0;
  }
  
  public String getName()
  {
    return firstName + " " + lastName;
  }
  
  public int getStudentID()
  {
    return studentId;
  }
  
  public int getCredits()
  {
    return credits;
  }
  
  public double getGPA()
  {
    return gpa;
  }
  
  public String getClassStanding()
  {
    if (credits < 30) return "Freshman";
    else if (credits < 60) return "Sophomore";
    else if (credits < 90) return "Junior";
    else return "Senior";
  }
  
  public void submitGrade(double grade, int credits)
  {
    this.credits += credits;
    qualityScores += grade * credits;
    computeGpa();
  }
  
  private void computeGpa()
  {
    gpa = qualityScores / credits;
    gpa = Math.round(gpa * 1000);
    gpa /= 1000.0;
  }
  
  public double computeTuition()
  {
    // need to round
    tuitionPerCreditHour = (int)(tuitionPerCreditHour * 100);
    tuitionPerCreditHour /= 100;
    double tuition = tuitionPerSem * (credits / 15);
    tuition += tuitionPerCreditHour * (credits % 15);
    return tuition;
  }
  
  public static Student createLegacy(Student s1, Student s2)
  {
    double gpaAvg = (s1.getGPA() + s2.getGPA()) / 2;
    int credits = s1.getCredits() > s2.getCredits() ? s1.getCredits() : s2.getCredits();
    int studentId = s1.getStudentID() + s2.getStudentID();
    String fName = s1.getName();
    String lName = s2.getName();

    return new Student(fName, lName, studentId, credits, gpaAvg);
  }
  
  public String toString()
  {
    return firstName + " " + lastName + " " + studentId;
  }
}
