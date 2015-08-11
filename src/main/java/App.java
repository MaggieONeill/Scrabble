import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/detector", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/detector.vtl");


      String word = request.queryParams("word");
      Integer totalScore = scrabbleScore(word);

      model.put("totalScore", totalScore);
      model.put("word", request.queryParams("word"));
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }

  public static Integer scrabbleScore(String myString){
    Integer score = 0;
    String[] myStringArray = myString.split("");

    String onePoint = "aeioulnrst";
    String twoPoints = "dg";
    String threePoints = "bcmp";
    String fourPoints = "fhvwy";
    String fivePoints = "k";
    String eightPoints = "jx";
    String tenPoints = "qz";

    for (String letter : myStringArray) {
      if (onePoint.contains(letter)) {
        score += 1;
      } else if (twoPoints.contains(letter)) {
        score += 2;
      } else if (threePoints.contains(letter)){
        score += 3;
      } else if (fourPoints.contains(letter)){
        score += 4;
      } else if (fivePoints.contains(letter)){
        score += 5;
      } else if (eightPoints.contains(letter)){
        score += 8;
      } else if (tenPoints.contains(letter)){
        score += 10;
      }
    }

    return score;
  }
}
