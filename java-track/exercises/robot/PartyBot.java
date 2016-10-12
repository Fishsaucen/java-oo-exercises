package robot;

import java.util.Arrays;

public class PartyBot extends Robot {
  
  final private int maxSongs = 10;
  private String[] songs = new String[maxSongs];
  private int songPos;
  private boolean partyLightsState, isSongPlaying;
  
  public PartyBot(String name, int posX, int posY, int speed, Direction direction)
  {
    super(name, posX, posY, speed, direction);
    this.songPos = 0;
    this.partyLightsState = true;
    this.isSongPlaying = false;
  }
  
  // returns true if song is added, false otherwise
  public boolean addSong(String song)
  {
    if (songPos < maxSongs) {
      songs[songPos] = song;
      songPos++;
      return true;
    } else 
      return false;
  }
  
  // returns true if song was successfully removed, false otherwise
  public boolean removeSong(String song)
  {
    int i = 0;
    for (;i < maxSongs; ++i) {
      if (song.toUpperCase().equals(songs[i].toUpperCase())) break;
    }
    if (i == songPos) {
      songs[i] = null;
      return true;
    } else if (i == maxSongs) {
      return false;
    } else {
      for (int j = i; j < songPos - 1; ++j) {
        songs[j] = songs[j+1];
      }
      songPos--;
      return true;
    }
  }
  
  // returns a song if switched on, null if switched off
  public String toggleSongState()
  {
    if (!isSongPlaying) {
      isSongPlaying = true;
      return playSong();
    } else {
      isSongPlaying = false;
      return null;
    }
  }
  
  private String playSong()
  {
    return songs[(int)(Math.random() * songPos)];
  }
  
  public void togglePartyLightsState()
  {
    // party bot never rests
    partyLightsState = true;
  }

  @Override
  public String toString() {
    return "PartyBot [maxSongs=" + maxSongs + ", songs=" + Arrays.toString(songs) + ", songPos=" + songPos
        + ", partyLightsState=" + partyLightsState + ", isSongPlaying=" + isSongPlaying + ", name=" + name + ", posX="
        + posX + ", posY=" + posY + ", speed=" + speed + ", direction=" + direction + "]";
  }

  public int getMaxSongs() {
    return maxSongs;
  }

  public String[] getSongs() {
    return songs;
  }

  public int getSongPos() {
    return songPos;
  }

  public boolean isPartyLightsState() {
    return partyLightsState;
  }

  public boolean isSongPlaying() {
    return isSongPlaying;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
