

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class fixture {
    private final List<List<match>> rounds;

    public fixture(club[] clubs) {
        if (clubs == null) {
            throw new IllegalArgumentException("Clubs cannot be null");
        }
        for (club team : clubs) {
            if (team == null) {
                throw new IllegalArgumentException("Clubs cannot contain null");
            }
        }

        this.rounds = generateRounds(clubs.clone());
    }

    public List<List<match>> getRounds() {
        return rounds;
    }

    private List<List<match>> generateRounds(club[] clubs) {
        List<List<match>> firstLeg = new ArrayList<>();
        if (clubs.length < 2) {
            return Collections.unmodifiableList(firstLeg);
        }

        int teamSlots = clubs.length + clubs.length % 2;
        club[] rotation = new club[teamSlots];
        System.arraycopy(clubs, 0, rotation, 0, clubs.length);

        int firstLegRoundCount = teamSlots - 1;
        for (int roundNumber = 0; roundNumber < firstLegRoundCount; roundNumber++) {
            List<match> round = new ArrayList<>();
            for (int pairing = 0; pairing < teamSlots / 2; pairing++) {
                club first = rotation[pairing];
                club second = rotation[teamSlots - 1 - pairing];
                if (first == null || second == null) {
                    continue;
                }

                if ((roundNumber + pairing) % 2 == 0) {
                    round.add(new match(first, second));
                } else {
                    round.add(new match(second, first));
                }
            }
            firstLeg.add(Collections.unmodifiableList(round));
            rotateTeams(rotation);
        }

        List<List<match>> allRounds = new ArrayList<>(firstLeg);
        for (List<match> round : firstLeg) {
            List<match> returnRound = new ArrayList<>();
            for (match game : round) {
                returnRound.add(new match(game.getAwayClub(), game.getHomeClub()));
            }
            allRounds.add(Collections.unmodifiableList(returnRound));
        }

        return Collections.unmodifiableList(allRounds);
    }

    private void rotateTeams(club[] teams) {
        club lastTeam = teams[teams.length - 1];
        for (int i = teams.length - 1; i > 1; i--) {
            teams[i] = teams[i - 1];
        }
        teams[1] = lastTeam;
    }
}
