import java.util.Random;
import java.util.Scanner;

public class JogodaVelha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] tabuleiro =
                {{' ', ' ', ' '},
                        {' ', ' ', ' '},
                        {' ', ' ', ' '}};
        comecarjogo(scanner, tabuleiro);

    }

    private static void comecarjogo(Scanner scanner, char[][] tabuleiro) {
        imprimirTabuleiro(tabuleiro);
        while (true) {
            vezdoJogador(tabuleiro, scanner);

            if (validaFinal(tabuleiro)) {
                break;
            }
            imprimirTabuleiro(tabuleiro);
            vezdoComputador(tabuleiro);
            if (validaFinal(tabuleiro)) {
                break;
            }
            imprimirTabuleiro(tabuleiro);
        }
    }

    private static boolean alguemGanhou(char[][] tabuleiro, char simbolo) {
        if ((tabuleiro[0][0] == simbolo && tabuleiro [0][1] == simbolo && tabuleiro [0][2] == simbolo) ||
                (tabuleiro[1][0] == simbolo && tabuleiro [1][1] == simbolo && tabuleiro [1][2] == simbolo) ||
                (tabuleiro[2][0] == simbolo && tabuleiro [2][1] == simbolo && tabuleiro [2][2] == simbolo) ||

                (tabuleiro[0][0] == simbolo && tabuleiro [1][0] == simbolo && tabuleiro [2][0] == simbolo) ||
                (tabuleiro[0][1] == simbolo && tabuleiro [1][1] == simbolo && tabuleiro [2][1] == simbolo) ||
                (tabuleiro[0][2] == simbolo && tabuleiro [1][2] == simbolo && tabuleiro [2][2] == simbolo) ||

                (tabuleiro[0][0] == simbolo && tabuleiro [1][1] == simbolo && tabuleiro [2][2] == simbolo) ||
                (tabuleiro[0][2] == simbolo && tabuleiro [1][1] == simbolo && tabuleiro [2][0] == simbolo) ) {
            return true;
        }
        return false;
    }


    private static boolean validaFinal(char[][] tabuleiro) {
        if (alguemGanhou(tabuleiro, 'O')) {
            imprimirTabuleiro(tabuleiro);
            System.out.println("Computador ganhou ");
            return true;
        }

        if (alguemGanhou(tabuleiro, 'X')) {
            imprimirTabuleiro(tabuleiro);
            System.out.println("Jogador Ganhou");
            return true;
        }


        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                if (tabuleiro[i][j] == ' ') {
                    return false;
                }
            }
        }
        imprimirTabuleiro(tabuleiro);
        System.out.println("_________________________________________");
        System.out.println("o Jogo deu Velha");
        return true;
    }


    private static void vezdoComputador(char[][] tabuleiro) {
        System.out.println("_________________________________");

        Random computador = new Random();
        int jogadaComputador;
        while (true) {
            jogadaComputador = computador.nextInt((9) + 1);
            if (isValida(tabuleiro, jogadaComputador)) {
                break;
            }
        }

        posicionarJogadas(tabuleiro, Integer.toString(jogadaComputador), 'O');
        System.out.println(" Computador jogou " + jogadaComputador);
    }

    private static void vezdoJogador(char[][] tabuleiro, Scanner scanner) {
        String entradaUsuario;
        while (true) {
            System.out.println("Onde você quer jogar - 1 - 9: ");
            entradaUsuario = scanner.nextLine();
            if (isValida(tabuleiro, Integer.parseInt(entradaUsuario))) {
                break;
            } else {
                System.out.println("Sua jogada não é valida, jogue novamente: ");
            }
        }
        posicionarJogadas(tabuleiro, entradaUsuario, 'X');
    }

    private static void posicionarJogadas(char[][] tabuleiro, String posicao, char simbolo) {
        switch (posicao) {
            case "1" -> tabuleiro[0][0] = simbolo;
            case "2" -> tabuleiro[0][1] = simbolo;
            case "3" -> tabuleiro[0][2] = simbolo;
            case "4" -> tabuleiro[1][0] = simbolo;
            case "5" -> tabuleiro[1][1] = simbolo;
            case "6" -> tabuleiro[1][2] = simbolo;
            case "7" -> tabuleiro[2][0] = simbolo;
            case "8" -> tabuleiro[2][1] = simbolo;
            case "9" -> tabuleiro[2][2] = simbolo;
            default -> System.out.println(":(");
        }
    }

    private static boolean isValida(char[][] tabuleiro, int posicao) {
        switch (posicao) {
            case 1 -> {
                return (tabuleiro[0][0] == ' ');
            }
            case 2 -> {
                return (tabuleiro[0][1] == ' ');
            }
            case 3 -> {
                return (tabuleiro[0][2] == ' ');
            }
            case 4 -> {
                return (tabuleiro[1][0] == ' ');
            }
            case 5 -> {
                return (tabuleiro[1][1] == ' ');
            }
            case 6 -> {
                return (tabuleiro[1][2] == ' ');
            }
            case 7 -> {
                return (tabuleiro[2][0] == ' ');
            }
            case 8 -> {
                return (tabuleiro[2][1] == ' ');
            }
            case 9 -> {
                return (tabuleiro[2][2] == ' ');
            }
            default -> {
                return false;
            }
        }
    }

    private static void imprimirTabuleiro(char[][] tabuleiro) {

        System.out.println(tabuleiro[0][0] + " | " + tabuleiro[0][1] + " | " + tabuleiro[0][2]);
        System.out.println("---------");
        System.out.println(tabuleiro[1][0] + " | " + tabuleiro[1][1] + " | " + tabuleiro[1][2]);
        System.out.println("---------");
        System.out.println(tabuleiro[2][0] + " | " + tabuleiro[2][1] + " | " + tabuleiro[2][2]);
    }

}
