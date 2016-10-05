package Studio1;

public class Fraction {
  
  private int num, denom;
  
  public Fraction(int num, int denom)
  {
    this.num = num;
    this.denom = denom;
  }
  
  private int getGcd(Fraction f)
  {
    int m, n, temp;
    
    m = f.getNum();
    n = f.getDenom();
    
    if (n == 0)
      return m;
    else if (m == 0)
      return n;
    else {
      while (n != 0) {
        temp = m % n;
        m = n;
        n = temp;
      }
      return m;
    }
  }
  
  public Fraction simplify()
  {
    int gcd = this.getGcd(this);
    return new Fraction(this.num / gcd, this.denom / gcd);
  }
  
  public Fraction add(Fraction f)
  {
    int numResult, denomResult;
    numResult = this.num * f.getDenom() + f.getNum() * this.denom;
    denomResult = this.denom * f.getDenom();
    return new Fraction(numResult, denomResult);
  }
  
  public Fraction subtract(Fraction f)
  {
    return this.add(new Fraction(-f.getNum(), f.getDenom()) );
  }
  
  public Fraction multiply(Fraction f)
  {
    return new Fraction(this.num * f.getNum(), this.denom * f.getDenom());
  }
  
  public Fraction divide(Fraction f)
  {
    return this.multiply(f.reciprocal());
  }
  
  public Fraction reciprocal()
  {
    return new Fraction(this.denom, this.num);
  }
  
  public int getDenom()
  {
    return this.denom;
  }
  
  public int getNum()
  {
    return this.num;
  }

  public static void main(String[] args) {

  }

}
