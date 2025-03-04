package calculadoraaritmetica;

import java.util.Scanner;

public class CalculadoraAritmetica
{
    public static void main(String[] args)
    {
        System.out.println("Calculadora");

        Scanner entrada = new Scanner(System.in);
        double num1;
        double num2;

        System.out.println("Digite o primeiro número:");
        while (true)
        {
            String strNum1 = entrada.nextLine().replace(",", ".");
            try
            {
                num1 = Double.parseDouble(strNum1);
                break;
            }catch (NumberFormatException e)
            {
                System.out.println("Entrada inválida. Digite o primeiro número:");
            }
        }

        System.out.println("Digite o segundo número:");
        while(true)
        {
            String strNum2 = entrada.nextLine().replace(",", ".");
            try
            {
                num2 = Double.parseDouble(strNum2);
                break;
            }catch (NumberFormatException e)
            {
                System.out.println("Entrada inválida. Digite o segundo número:");
            }
        }

        System.out.println("Digite o operador: \n-> Para adição (+) \n-> Para subtração (-) \n-> Para multiplicação (*) \n-> Para divisão (/)");
        char operador;
        while (true)
        {
            String verificaEntrada = entrada.next();
            if (verificaEntrada.length() == 1 && "+-*/".contains(verificaEntrada))
            {
                operador = verificaEntrada.charAt(0);
                break;
            }else
            {
                System.out.println("Operador inválido! Digite apenas +, -, * ou /.");
            }
        }

        double resultado;
        switch (operador)
        {
            case '+':
            {
                resultado = num1+num2;
                System.out.println("Resultado da some é: " + resultado);
                break;
            }
            case '-':
            {
                resultado = num1-num2;
                System.out.println("Resultado da subtração é: " + resultado);
                break;
            }
            case '*':
            {
                resultado = num1*num2;
                System.out.println("Resultado da multiplicação é: " + resultado);
                break;
            }
            case '/':
            {
                resultado = num1/num2;
                System.out.println("Resultado da divisão é: " + resultado);
                break;
            }
            default:
                System.out.println("Algo deu errado");
                break;
        }
    }
}
