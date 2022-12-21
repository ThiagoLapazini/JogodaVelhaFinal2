import org.w3c.dom.ls.LSOutput;

import java.util.Random;
import java.util.Scanner;

public class JogodaVelha {
    public static void main(String[] args) {
        char[][] tabuleiro =
                {{' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}};
        imprimirTabuleiro(tabuleiro);
        Scanner scanner = new Scanner(System.in);
        Random computador = new Random();
        int jogadaComputador = computador.nextInt((9)+1);


        jogadas(tabuleiro, scanner);
        imprimirTabuleiro(tabuleiro);
    }

    private static void jogadas(char[][] tabuleiro, Scanner scanner) {
        System.out.println("Onde você quer jogar - 1 - 9: ");
        String entradaUsuario = scanner.nextLine();
        switch(entradaUsuario){
            case "1": tabuleiro[0][0] = 'X';
                    break;
            case "2": tabuleiro[0][1] = 'X';
                break;
            case "3": tabuleiro[0][2] = 'X';
                break;
            case "4": tabuleiro[1][0] = 'X';
                break;
            case "5": tabuleiro[1][1] = 'X';
                break;
            case "6": tabuleiro[1][2] = 'X';
                break;
            case "7": tabuleiro[2][0] = 'X';
                break;
            case "8": tabuleiro[2][1] = 'X';
                break;
            case "9": tabuleiro[2][2] = 'X';
                break;
            default:
                System.out.println(":(");
        }
    }

    private static void imprimirTabuleiro(char[][] tabuleiro) {

        System.out.println(tabuleiro[0][0] + "|" + tabuleiro[0][1] + "|" + tabuleiro[0][2]);
        System.out.println("-+-+-");
        System.out.println(tabuleiro[1][0] + "|" + tabuleiro[1][1] + "|" + tabuleiro[1][2]);
        System.out.println("-+-+-");
        System.out.println(tabuleiro[2][0] + "|" + tabuleiro[2][1] + "|" + tabuleiro[2][2]);
    }



}