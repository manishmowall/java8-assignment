package org.webonise.apple;

public class Apple {
    //considering weight of apple is integer type only.
    private final int weight;
    private final String color;

    public Apple(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }
}
