package com.alex.d4_bigdecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalDemo1 {
    public static void main(String[] args) {

        double a = 0.1;
        double b = 0.2;

        double c = a + b;
        System.out.println(c);

        BigDecimal a1 = new BigDecimal(Double.toString(a));
        BigDecimal b1 = new BigDecimal(Double.toString(b));

        //recommended
        BigDecimal a11 = BigDecimal.valueOf(a);
        BigDecimal b11 = BigDecimal.valueOf(b);


//        BigDecimal c11 = a11.subtract(b11);
//        BigDecimal c11 = a11.multiply(b11);
//        BigDecimal c11 = a11.divide(b11);
        BigDecimal c11 = a11.add(b11);

        double res = c11.doubleValue();
        System.out.println(res);

        System.out.println("-----------------");

        BigDecimal i = BigDecimal.valueOf(1);
        BigDecimal j = BigDecimal.valueOf(3);

        BigDecimal k = i.divide(j, 2, RoundingMode.HALF_UP);
        System.out.println(k);

    }
}
