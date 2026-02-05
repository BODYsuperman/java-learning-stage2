package com.alex.d6_enum2;

public class Test {
    public static void main(String[] args) {

        System.out.println(handleData1(1.002, Constant.UP));
        System.out.println(handleData(1.002, Constant.UP));

    }

    public  static  double handleData(double n , Constant flag){
        switch (flag){
            case Constant.DOWN :
                n = Math.floor(n);
                break;
            case Constant.UP:
                n = Math.ceil(n);
                break;
            case Constant.HALF_UP:
                n = Math.round(n);
                break;
            case Constant.DELETE_LEFT:
                n = (int)n;
                break;
            default:
                return n;
        }

        return n;
    }



    public static double handleData1(double n, Constant flag) {
        switch (flag) {
            case DOWN: return Math.floor(n);
            case UP: return Math.ceil(n);
            case HALF_UP: return Math.round(n);
            case DELETE_LEFT: return (int) n;
            default: return n;
        }
    }
}
