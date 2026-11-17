public class match {
    private final club homeClub;
    private final club awayClub;

    public match(club homeClub, club awayClub) {
        if (homeClub == null || awayClub == null) {
            throw new IllegalArgumentException("A match must have a home and away club");
        }
        if (homeClub == awayClub) {
            throw new IllegalArgumentException("A club cannot play against itself");
        }

        this.homeClub = homeClub;
        this.awayClub = awayClub;
    }

    public club getHomeClub() {
        return homeClub;
    }

    public club getAwayClub() {
        return awayClub;
    }
}