package org.webonise.apple;

@FunctionalInterface
public interface ApplePredicate {
    boolean test(Apple apple, boolean includeColorFlag, boolean includeWeightFlag);
}
