package Studio1;

public class Rectangle {

  private double length, width, area, perimeter;
  
  public Rectangle(double len, double width) 
  {
    this.length = len;
    this.width = width;
    this.setArea();
    this.setPerimeter();
  }
  
  public boolean isAreaBigger(Rectangle r1)
  {
    return r1.getArea() > this.getArea() ? true : false;
  }

  public double getLength() {
    return length;
  }

  public void setLength(double length) {
    this.length = length;
    this.setArea();
    this.setPerimeter();
  }

  public double getWidth() {
    return width;
  }

  public void setWidth(double width) {
    this.width = width;
    this.setArea();
    this.setPerimeter();
  }

  public double getArea() {
    return area;
  }

  public void setArea() {
    this.area = this.length * this.width;
  }

  public double getPerimeter() {
    return perimeter;
  }

  public void setPerimeter() {
    this.perimeter = 2 * this.length + 2 * this.width;
  }

  public boolean isSquare() {
    return this.length == this.width ? true : false;
  }

  public static void main(String[] args) {

  }
}
