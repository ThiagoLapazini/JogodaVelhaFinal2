import java.util.Random;
import java.util.Scanner;

public class JogodaVelha {
    public static void main(String[] args) {
        char[][] tabuleiro =
                {{' ', ' ', ' '},
                        {' ', ' ', ' '},
                        {' ', ' ', ' '}};
        imprimirTabuleiro(tabuleiro);
        Random computador = new Random();
        int jogadaComputador;
        while (true) {
            jogadaComputador = computador.nextInt((9) + 1);
            if (isValida(tabuleiro, jogadaComputador)) {
                break;
            }


        }
        posicionarJogadas(tabuleiro, Integer.toString(jogadaComputador),'O');
        vezdoJogador(tabuleiro);
        imprimirTabuleiro(tabuleiro);
    }
        private static void vezdoJogador (char[][] tabuleiro){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Onde você quer jogar - 1 - 9: ");
            String entradaUsuario = scanner.nextLine();
            posicionarJogadas(tabuleiro, entradaUsuario, 'X');
        }

    private static void posicionarJogadas(char[][] tabuleiro, String posicao, char simbolo) {
        switch (posicao) {
            case "1":
                tabuleiro[0][0] = simbolo;
                break;
            case "2":
                tabuleiro[0][1] = simbolo;
                break;
            case "3":
                tabuleiro[0][2] = simbolo;
                break;
            case "4":
                tabuleiro[1][0] = simbolo;
                break;
            case "5":
                tabuleiro[1][1] = simbolo;
                break;
            case "6":
                tabuleiro[1][2] = simbolo;
                break;
            case "7":
                tabuleiro[2][0] = simbolo;
                break;
            case "8":
                tabuleiro[2][1] = simbolo;
                break;
            case "9":
                tabuleiro[2][2] = simbolo;
                break;
            default:
                System.out.println(":(");
        }
    }

    private static boolean isValida (char[][] tabuleiro, int posicao){
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

        private static void imprimirTabuleiro (char[][] tabuleiro){

            System.out.println(tabuleiro[0][0] + "|" + tabuleiro[0][1] + "|" + tabuleiro[0][2]);
            System.out.println("-+-+-");
            System.out.println(tabuleiro[1][0] + "|" + tabuleiro[1][1] + "|" + tabuleiro[1][2]);
            System.out.println("-+-+-");
            System.out.println(tabuleiro[2][0] + "|" + tabuleiro[2][1] + "|" + tabuleiro[2][2]);
        }

    }
