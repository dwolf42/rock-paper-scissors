import resources.Constants;

import java.util.Scanner;

public class Main {
    private static int usrWins;
    private static int cpuWins;

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        String usrMove;
        String cpuMove;

        System.out.println(Constants.WELCOME_MESSAGE);

        while (usrWins < 3 && cpuWins < 3) {
            System.out.println(Constants.USR_TURN + "\n");

            Scanner scanner = new Scanner(System.in);
            usrMove = scanner.nextLine();
            cpuMove = getTurnCPU();

            System.out.println("\n" + Constants.USR_CHOICE + usrMove);
            System.out.println(Constants.CPU_CHOICE + cpuMove + "\n");

            if (usrMove.equals(cpuMove)) {
                System.out.println(Constants.TURN_END + Constants.DRAW + "\n");
            } else if (isWinUSR(usrMove, cpuMove)) {
                System.out.println(Constants.TURN_END + Constants.USR_WINS + "\n");
                usrWins += 1;
            } else {
                System.out.println(Constants.TURN_END + Constants.CPU_WINS + "\n");
                cpuWins += 1;
            }
        }

        System.out.printf("The match is over: %s%n", usrWins > cpuWins ? Constants.USR_WINS + "\n" : Constants.CPU_WINS + "\n");
    }

    public static boolean isWinUSR(String usrMove, String cpuMove) {
        /*
         * Is usrMove is equal to rock, then check if cpuMove is equal to scissors.
         * If it is, player wins: rock > scissors.
         *
         * If usrMove is equal to paper, then check if cpuMove is equal to rock.
         * If it is, player wins: paper > rock.
         *
         * In the remaining case, playerMove is equal to scissors.
         * If cpuMove is equal to paper, player wins: scissors > paper.
         * */

        if (usrMove.equals("rock")) {
            return cpuMove.equals("scissors");
        } else if (usrMove.equals("paper")) {
            return cpuMove.equals("rock");
        } else {
            return cpuMove.equals("paper");
        }
    }

    public static String getTurnCPU() {
        int randomNumber = new java.util.Random().nextInt(3);

        switch (randomNumber) {
            case 0:
                return "rock";
            case 1:
                return "paper";
            default:
                return "scissors";
        }
    }
}