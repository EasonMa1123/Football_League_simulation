import java.util.List;

public class main {
    public static void main(String[] args) {
        club[] clubs = new club[20];
        for (int i = 0; i < 20; i++) {
            clubs[i] = new club();
        }
        league season = new league(clubs);

        System.out.println("Football League Fixtures");
        List<List<match>> rounds = season.getFixture().getRounds();
        for (int roundIndex = 0; roundIndex < rounds.size(); roundIndex++) {
            System.out.println("\nRound " + (roundIndex + 1));
            for (match game : rounds.get(roundIndex)) {
                System.out.printf("%s vs %s%n",
                        game.getHomeClub().getName(),
                        game.getAwayClub().getName());
            }
        }
    }
}
