package robot;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class PartyBotTest {

  @Test
  public void testPartyBot() {
    PartyBot p = new PartyBot("p", 0, 0, 1, Direction.NORTH);
    assertEquals("Could not properly set PartyBot's name.", "p", p.getName());
    assertEquals("Could not propery set PartyBot's x position.", 0, p.getPosX());
    assertEquals("Could not properly set PartyBot's y position.", 0, p.getPosY());
    assertEquals("Could not properly set PartyBot's speed.", 1, p.getSpeed());
    assertEquals("Could not properly set PartyBot's direction.", Direction.NORTH, p.getDirection());
    assertEquals("songPos not properly initialized.", 0, p.getSongPos());
    assertEquals("partyLightsState not properly initialized.", true, p.isPartyLightsState());
    assertEquals("isSongPlaying not properly initialized.", false, p.isSongPlaying());
  }

  @Test
  public void testAddSong() {
    PartyBot p = new PartyBot("p", 0, 0, 1, Direction.NORTH);
    boolean songAdded;
    String[] songs = new String[] {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j" };
    
    for (int i = 0; i < 10; ++i) {
      songAdded = p.addSong(songs[i]);
      assertEquals("Could not add song.", true, songAdded);
    }
    
    String[] pSongs = p.getSongs();
    for (int i = 0; i < 10; ++i) {
      assertEquals("Songs were improperly added.", true, songs[i].equals(pSongs[i]));
    }
    
    assertEquals("Should not be able to add any more songs.", false, p.addSong("k"));
  }

  @Test
  public void testRemoveSong() {
    PartyBot p = new PartyBot("p", 0, 0, 1, Direction.NORTH);
    boolean songRemoved;
    String[] songs = new String[] {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j" };
    
    for (int i = 0; i < 10; ++i) {
      p.addSong(songs[i]);
    }
    
    songRemoved = p.removeSong("a");
    assertEquals("Could not remove song.", true, songRemoved);
    songRemoved = p.removeSong("e");
    assertEquals("Could not remove song.", true, songRemoved);
    songRemoved = p.removeSong("r");
    assertEquals("Should not be able to remove non-existant song.", false, songRemoved);
    
    String[] pSongs = p.getSongs();
    String[] s = new String[] {"b", "c", "d", "f", "g", "h", "i", "j" };
    for (int i = 0; i < s.length; ++i) {
      assertEquals("Songs are incorrect.", true, pSongs[i].equals(s[i]));
    }
    
    assertEquals("Wrong songPos.", 8, p.getSongPos());
  }

  @Test
  public void testToggleSongState() {
    PartyBot p = new PartyBot("p", 0, 0, 1, Direction.NORTH);
    String[] songs = new String[] {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j" };
    for (int i = 0; i < 10; ++i) {
      p.addSong(songs[i]);
    }
    boolean validSong = false;
    String s = p.toggleSongState();
    for (String str : songs) {
      if (str.equals(s))
        validSong = true;
    }
    assertEquals("Did not return a song.", true, validSong);
    validSong = false;
    assertEquals("Could not toggle songState.", true, p.isSongPlaying());
    s = p.toggleSongState();
    assertEquals("Did not return null.", null, s);
    assertEquals("Could not toggle songState.", false, p.isSongPlaying());
    
  }

  @Test
  public void testTogglePartyLightsState() {
    PartyBot p = new PartyBot("p", 0, 0, 1, Direction.NORTH);
    assertEquals("Party lights aren't working properly.", true, p.isPartyLightsState());
    p.togglePartyLightsState();
    assertEquals("Party lights aren't working properly.", true, p.isPartyLightsState());
  }

  @Test
  public void testGetSongs() {
    PartyBot p = new PartyBot("p", 0, 0, 1, Direction.NORTH);
    String[] songs = new String[] {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j" };
    for (int i = 0; i < 10; ++i) {
      p.addSong(songs[i]);
    }
    
    String[] s = p.getSongs();
    assertEquals("Did not return proper song list.", true, Arrays.equals(songs, s));
  }

}
