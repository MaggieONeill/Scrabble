public class App {
  public static void main(String[] args) {

  }

  public Integer scrabbleScore(String myString){
    Integer score = 0;
    String  onePoint = "aeioulnrst";
    if( onePoint.contains(myString)){
      score += 1;
    } else{
      score += 0;
    }
    return score;
  }
}
