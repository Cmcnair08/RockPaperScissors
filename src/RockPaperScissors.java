import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String playerA, playerB;
    String playAgain;

    do {
        playerA = getplayerMove(scanner, "Player A ");
        playerB = getplayerMove(scanner, "Player B");
        displayResult(playerA, playerB);
        System.out.print("Would you like to play again? [Y/N]: ");
        playAgain = scanner.next();
    } while (playAgain.equalsIgnoreCase("Y"));
    scanner.close();

    }
    private static String getplayerMove(Scanner scanner, String playerName){
        String move;
        do {
            System.out.print(playerName + ", enter your move (R,P,S): ");
            move= scanner.next();
        } while (!isValidMove(move));
        return move.toUpperCase();
        
    }

    private static boolean isValidMove(String move) {
        return move.equalsIgnoreCase("R") || move.equalsIgnoreCase("P") || move.equalsIgnoreCase("S");

    }
    private static void displayResult (String playerA, String playerB){
        System.out.println("Player A select: " + playerA);
        System.out.println("Player B select: " + playerB);

        if (playerA.equals(playerB)){
            System.out.println("It's a tie. ");
        } else if ((playerA.equals("R") && playerB.equals("S")) ||
                (playerA.equals("P") && playerB.equals("R")) ||
                        (playerA.equals("S") && playerB.equals("P"))) {
            System.out.println("Player A wins " + getWinningChant(playerA, playerB));
        } else {
            System.out.println("Player B wins " + getWinningChant(playerB, playerA));


        }
    }
    private static String getWinningChant(String winner, String loser) {
        if (winner.equals("R") && loser.equals("S")) return "Rock breaks Scissors";
        if (winner.equals("P") && loser.equals("R")) return "Paper covers Rock";
        if (winner.equals("S") && loser.equals("P")) return "Scissors beats Paper";
        return "";

    }
}
