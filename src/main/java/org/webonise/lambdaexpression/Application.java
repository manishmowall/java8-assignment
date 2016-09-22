package org.webonise.lambdaexpression;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Application {
   static List<Apple> apples = new ArrayList<>();
   static final Logger logger = Logger.getLogger(Application.class.getName());

   public static void main(String[] args) {

      Application application = new Application();
      application.generateApples();

      ApplePrinter applePrinter1 = (apple) -> Integer.toString(apple.getWeight());
      application.prettyPrintApples(apples, applePrinter1);

      logger.log(Level.INFO, "==================================================");
      ApplePrinter applePrinter2 = (apple) -> apple.getColor();
      application.prettyPrintApples(apples, applePrinter2);

      logger.log(Level.INFO, "==================================================");
      ApplePrinter applePrinter3 = (apple) -> apple.getWeight() < 3 ? "LIGHT" : "HEAVY";
      application.prettyPrintApples(apples, applePrinter3);

      logger.log(Level.INFO, "==================================================");
      AppleFilter appleFilter = (apple) -> apple.getWeight() < 3;
      application.prettyPrintApples(apples, appleFilter);

      logger.log(Level.INFO, "==================================================");
      AppleFilter appleFilter2 = (apple) -> apple.getColor() == "red" && apple.getWeight() < 3;
      application.prettyPrintApples(apples, appleFilter2);
   }

   public void prettyPrintApples(List<Apple> apples, ApplePrinter applePrinter) {
      for (Apple apple : apples) {
         logger.log(Level.INFO, "Apple " + apple.getId() + " " + applePrinter.getStringToPrint(apple));
      }
   }

   public void prettyPrintApples(List<Apple> apples, AppleFilter appleFilter) {
      List<Apple> appleSubset = new ArrayList<>();

      for (Apple apple : apples) {
         if (appleFilter.test(apple)) {
            appleSubset.add(apple);
         }
      }
      ApplePrinter applePrinter = (apple) -> "";
      prettyPrintApples(appleSubset, applePrinter);
   }

   public void generateApples() {
      apples.add(new Apple(5, "green", 1));
      apples.add(new Apple(4, "red", 2));
      apples.add(new Apple(1, "green", 3));
      apples.add(new Apple(2, "red", 4));
      apples.add(new Apple(3, "green", 5));
      apples.add(new Apple(2, "red", 6));
   }
}