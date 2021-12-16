import java.util.HashMap;
import java.util.Scanner;

/**
 * @author aidancarey
 */
class Driver {

    /**
     * @param args array necessary to run main
     */
    public static void main(String[] args) {
        Player totals = new Player("Totals"); // new "player" that includes all statistics
        HashMap<String, Player> players = new HashMap<>(); // Store all players
        players.put("Totals", totals);

        boolean loggingAtBats = true; // boolean to end data entry
        int balls; // tracks the balls of current at bat
        int strikes; // tracks the strikes of current at bat
        while (loggingAtBats) {
            Scanner myObj = new Scanner(System.in);
            System.out.println("Enter batter's name: ");
            String playerName = myObj.nextLine(); // user entry for batter's name
            Player player = players.get(playerName); // try to retrieve batter from players
            if (player == null) { // if batter is not in system
                player = new Player(playerName); // create batter
                players.put(playerName, player); // add batter to players
                System.out.println(player.name + " is a new player"); // print message
            }

            /* Initialize data values */
            balls = 0;
            strikes = 0;
            boolean isAtBat = true;

            while (isAtBat) {
                System.out.println("The count is " + balls + "–" + strikes+ ".");
                System.out.println("Enter action: ");
                String action = myObj.nextLine();

                switch (action) { // switch to track different actions (i.e. strike swinging, ball, home run, etc.)
                    case "Ball", "ball" -> {
                        if (balls == 3) { // walk will occur
                            System.out.println("Walk!");
                            player.counts[balls][strikes].walks++;
                            totals.counts[balls][strikes].walks++;
                            isAtBat = false;
                        }
                        balls++;
                    }
                    case "Strike looking", "strike looking", "strike" -> {
                        if (strikes == 2) { // strikeout will occur
                            System.out.println("Strikeout looking!");
                            player.counts[balls][strikes].strikeouts_looking++;
                            totals.counts[balls][strikes].strikeouts_looking++;
                            isAtBat = false;
                        }
                        strikes++;
                    }
                    case "Strike swinging", "strike swinging" -> {
                        if (strikes == 2) { // strikeout will occur
                            System.out.println("Strikeout swinging!");
                            player.counts[balls][strikes].swings++;
                            player.counts[balls][strikes].strikeouts_swinging++;
                            totals.counts[balls][strikes].swings++;
                            totals.counts[balls][strikes].strikeouts_swinging++;
                            isAtBat = false;
                        }
                        strikes++;
                    }
                    case "Single", "single" -> {
                        player.counts[balls][strikes].swings++;
                        player.counts[balls][strikes].balls_in_play++;
                        player.counts[balls][strikes].singles++;
                        totals.counts[balls][strikes].swings++;
                        totals.counts[balls][strikes].balls_in_play++;
                        totals.counts[balls][strikes].singles++;
                        isAtBat = false;
                    }
                    case "Double", "double" -> {
                        player.counts[balls][strikes].swings++;
                        player.counts[balls][strikes].balls_in_play++;
                        player.counts[balls][strikes].doubles++;
                        totals.counts[balls][strikes].swings++;
                        totals.counts[balls][strikes].balls_in_play++;
                        totals.counts[balls][strikes].doubles++;
                        isAtBat = false;
                    }
                    case "Triple", "triple" -> {
                        player.counts[balls][strikes].swings++;
                        player.counts[balls][strikes].balls_in_play++;
                        player.counts[balls][strikes].triples++;
                        totals.counts[balls][strikes].swings++;
                        totals.counts[balls][strikes].balls_in_play++;
                        totals.counts[balls][strikes].triples++;
                        isAtBat = false;
                    }
                    case "Home run", "home run" -> {
                        player.counts[balls][strikes].swings++;
                        player.counts[balls][strikes].balls_in_play++;
                        player.counts[balls][strikes].home_runs++;
                        totals.counts[balls][strikes].swings++;
                        totals.counts[balls][strikes].balls_in_play++;
                        totals.counts[balls][strikes].home_runs++;
                        isAtBat = false;
                    }
                    case "Foul", "foul" -> {
                        player.counts[balls][strikes].swings++;
                        totals.counts[balls][strikes].swings++;
                        if (strikes != 2) {
                            strikes++; // increment strikes as long as count is not b–2
                        }
                    }
                    case "Sacrifice fly", "sacrifice fly", "Sac fly", "sac fly" -> {
                        player.counts[balls][strikes].swings++;
                        player.counts[balls][strikes].sac_flies++;
                        player.counts[balls][strikes].balls_in_play++;
                        totals.counts[balls][strikes].swings++;
                        totals.counts[balls][strikes].sac_flies++;
                        totals.counts[balls][strikes].balls_in_play++;
                        isAtBat = false;
                    }
                    case "Fly out", "fly out", "Pop out", "pop out" -> {
                        player.counts[balls][strikes].swings++;
                        player.counts[balls][strikes].fly_outs++;
                        player.counts[balls][strikes].balls_in_play++;
                        totals.counts[balls][strikes].swings++;
                        totals.counts[balls][strikes].fly_outs++;
                        totals.counts[balls][strikes].balls_in_play++;
                        isAtBat = false;
                    }
                    case "Ground out", "ground out", "Fielders choice", "fielders choice" -> {
                        player.counts[balls][strikes].swings++;
                        player.counts[balls][strikes].ground_outs++;
                        player.counts[balls][strikes].balls_in_play++;
                        totals.counts[balls][strikes].swings++;
                        totals.counts[balls][strikes].ground_outs++;
                        totals.counts[balls][strikes].balls_in_play++;
                        isAtBat = false;
                    }
                    case "Line out", "line out" -> {
                        player.counts[balls][strikes].swings++;
                        player.counts[balls][strikes].line_outs++;
                        player.counts[balls][strikes].hard_hit_balls++;
                        player.counts[balls][strikes].balls_in_play++;
                        totals.counts[balls][strikes].swings++;
                        totals.counts[balls][strikes].line_outs++;
                        totals.counts[balls][strikes].hard_hit_balls++;
                        totals.counts[balls][strikes].balls_in_play++;
                        isAtBat = false;
                    }
                    default -> { // used for ground outs, fly outs, reached on error, fielders choice, etc.
                        player.counts[balls][strikes].swings++;
                        player.counts[balls][strikes].balls_in_play++;
                        totals.counts[balls][strikes].swings++;
                        totals.counts[balls][strikes].balls_in_play++;
                        isAtBat = false;
                    }
                }
            }
            System.out.println("Are you still logging at bats? (y/n)"); // asks user whether they want to track another at bat
            String response = myObj.nextLine();
            if (response.equalsIgnoreCase("n") || response.equalsIgnoreCase("no")) {
                loggingAtBats = false;
            }
        }

        /* Print collective data */
        for (balls = 0; balls < 4; balls++) {
            for (strikes = 0; strikes < 3; strikes++) {
                System.out.println(balls + "–" + strikes + " Count:");
                System.out.println(totals.counts[balls][strikes].toString());
                System.out.println("\n");
            }
        }
    }
}
