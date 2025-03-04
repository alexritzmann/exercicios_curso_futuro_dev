package olamundo;

public class ExemploMath
{
    public static void main(String[] args)
    {
        double resultPow = Math.pow(5,2);
        System.out.println(resultPow);

        double resultSqrt = Math.sqrt(9);
        System.out.println(resultSqrt);


        double resultCbrt = Math.cbrt(27);
        System.out.println(resultCbrt);

        int resultAbs = Math.abs(-10);
        System.out.println(resultAbs);

        double resultFloor = Math.floor(29.9);
        System.out.println(resultFloor);

        double resultCeil = Math.ceil(30.1);
        System.out.println(resultCeil);

        double resultRound = Math.round(5.6);
        System.out.println(resultRound);

        System.out.println(Math.PI);

        double resultRandom = Math.random();
        System.out.println(resultRandom);

        double rand = Math.random() * (100-10) + 10;
        System.out.println("random 1: " + rand);

        rand = (int) (Math.random() * (5-1) + 10);
        System.out.println("random 2: " + rand);

    }





}
