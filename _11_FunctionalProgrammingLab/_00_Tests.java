package _11_FunctionalProgrammingLab;

import java.util.function.IntToDoubleFunction;

public class _00_Tests {
    public static void main(String[] args) {

        IntToDoubleFunction i = (x) -> {return Math.sin(x);};
        System.out.println(i.applyAsDouble((2)));
    }
}
