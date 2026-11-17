import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class fixtureTest {
    @Test
    void createsHomeAndAwayMatchesForEveryPair() {
        club[] clubs = {new club(), new club(), new club(), new club()};

        List<List<match>> rounds = new fixture(clubs).getRounds();

        assertEquals(6, rounds.size());
        assertEquals(12, rounds.stream().mapToInt(List::size).sum());
        for (int first = 0; first < clubs.length; first++) {
            for (int second = first + 1; second < clubs.length; second++) {
                club firstClub = clubs[first];
                club secondClub = clubs[second];
                assertEquals(1, countMatches(rounds, firstClub, secondClub));
                assertEquals(1, countMatches(rounds, secondClub, firstClub));
            }
        }
    }

    @Test
    void supportsOddNumberOfClubsAndReturnsImmutableRounds() {
        fixture fixture = new fixture(new club[]{new club(), new club(), new club()});

        assertEquals(6, fixture.getRounds().size());
        assertEquals(6, fixture.getRounds().stream().mapToInt(List::size).sum());
        assertThrows(UnsupportedOperationException.class,
                () -> fixture.getRounds().add(new ArrayList<>()));
        assertThrows(UnsupportedOperationException.class,
                () -> fixture.getRounds().get(0).clear());
    }

    @Test
    void returnLegUsesTheOppositeHomeClub() {
        List<List<match>> rounds = new fixture(new club[]{new club(), new club()}).getRounds();
        match firstLeg = rounds.get(0).get(0);
        match returnLeg = rounds.get(1).get(0);

        assertNotSame(firstLeg.getHomeClub(), returnLeg.getHomeClub());
        assertEquals(firstLeg.getHomeClub(), returnLeg.getAwayClub());
        assertEquals(firstLeg.getAwayClub(), returnLeg.getHomeClub());
    }

    private int countMatches(List<List<match>> rounds, club home, club away) {
        return (int) rounds.stream()
                .flatMap(List::stream)
                .filter(game -> game.getHomeClub() == home && game.getAwayClub() == away)
                .count();
    }
}
