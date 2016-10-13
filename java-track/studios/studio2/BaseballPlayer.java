package studio2;

enum Handedness {
  LEFT, RIGHT, AMBI;
}

enum Position {
  // FIRST, SECOND, THIRD refer to the base. LEFT, CENTER, RIGHT refer to position in outfield.
  PITCHER, CATCHER, FIRST, SECOND, THIRD, SHORTSTOP, LEFT, CENTER, RIGHT;
}

public class BaseballPlayer {

  private String name;
  private int hits, jerseyNum, rbi, runs, totalGames, totalHits, totalRuns, totalRbi;
  private Handedness battingHand, pitchingHand;
  private Position position;
  
  public BaseballPlayer(String name, int jerseyNum, Handedness battingHand, Position pos, Handedness pitchingHand)
  {
    this.name = name;
    this.jerseyNum = jerseyNum;
    this.battingHand = battingHand;
    this.pitchingHand = pitchingHand;
    this.position = pos;
    this.hits = 0;
    this.rbi = 0;
    this.runs = 0;
    this.totalGames = 0;
    this.totalHits = 0;
    this.totalRuns = 0;
    this.totalRbi = 0;
  }

  public BaseballPlayer(String name, int jerseyNum, Handedness battingHand, Position pos)
  {
    this.name = name;
    this.jerseyNum = jerseyNum;
    this.battingHand = battingHand;
    // assumes that a non-pitcher will never become a pitcher. should this be changed?
    this.pitchingHand = null;
    this.position = pos;
    this.hits = 0;
    this.rbi = 0;
    this.runs = 0;
    this.totalGames = 0;
    this.totalHits = 0;
    this.totalRuns = 0;
    this.totalRbi = 0;
  }

  public void startGame()
  {
    this.totalGames++;
    this.hits = 0;
    this.rbi = 0;
    this.runs = 0;
  }
  
  public void finishGame()
  {
    this.totalHits += this.hits;
    this.totalRuns += this.runs;
    this.totalRbi += this.rbi;
  }
  
  public void incHits()
  {
    this.hits++;
  }
  
  public void incRuns()
  {
    this.runs++;
  }
  
  public void incRbi()
  {
    this.rbi++;
  }

  public String getName() {
    return name;
  }

  public int getHits() {
    return hits;
  }

  public int getJerseyNum() {
    return jerseyNum;
  }

  public int getRbi() {
    return rbi;
  }

  public int getRuns() {
    return runs;
  }

  public int getTotalGames() {
    return totalGames;
  }

  public int getTotalHits() {
    return totalHits;
  }

  public int getTotalRuns() {
    return totalRuns;
  }

  public int getTotalRbi() {
    return totalRbi;
  }

  public Handedness getBattingHand() {
    return battingHand;
  }
  
  public Handedness getPitchingHand() {
    return pitchingHand;
  }

  public Position getPosition() {
    return position;
  }

  public void setPosition(Position position) {
    this.position = position;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
