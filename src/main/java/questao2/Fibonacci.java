package questao2;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um numero para verificar se ele pertence a sequencia de Fibonacci: ");
        int numero = scanner.nextInt();

        int a = 0, b = 1, c = 0;

        while (c < numero) {
            c = a + b;
            a = b;
            b = c;
        }

        if (c == numero || numero == 0) {
            System.out.println("O numero " + numero + " pertence a sequencia de Fibonacci.");
        } else {
            System.out.println("O numero " + numero + " não pertence a sequencia de Fibonacci.");
        }
    }
}