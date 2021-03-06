import org.junit.*;
import static org.junit.Assert.*;

public class ScrabbleTest{

  @Test
  public void scrabbleScore_returnAScrabbleScoreForALetter_1() {
    App app = new App();
    Integer score = 1;
    assertEquals (score, app.scrabbleScore("a"));
  }


  @Test
  public void scrabbleScore_returnAScrabbleScoreForAnyWord_correctScore(){
    App app = new App();
    Integer score = 33;
    assertEquals (score, app.scrabbleScore("adbfkjq"));
  }
}
