package org.webonise.apple;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by webonise on 22/9/16.
 */
public class Application {
    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(5, "green"));
        apples.add(new Apple(4, "red"));
        apples.add(new Apple(1, "green"));
        apples.add(new Apple(2, "red"));
        apples.add(new Apple(3, "green"));
        apples.add(new Apple(2, "red"));

        Application application = new Application();
        /*List<Apple> list = apples.stream().filter(apple -> apple.getWeight() <= 2).collect(Collectors.toList());
        for (Apple apple : list) {
            System.out.println(apple.getColor() + " : " + apple.getWeight());*/
        ApplePredicate applePredicate1 = (apple,includeColorFlag,includeWeightFlag) -> {includeColorFlag = false};
        application.prettyPrintApples(apples, applePredicate1);

    }

    public void prettyPrintApples(List<Apple> apples, ApplePredicate applePredicate) {
        boolean includeColorFlag = true;
        boolean includeWeightFlag = true;
        for (Apple apple : apples) {
            if (applePredicate.test(apple,includeColorFlag,includeWeightFlag)) {
                if (includeColorFlag) {
                    System.out.print(apple.getColor() + " : ");
                }
                if(includeWeightFlag)
                    System.out.println(apple.getWeight());
            }
        }
    }
}