

public class league {
    private final club[] clubs;
    private final fixture fixture;

    public league(club[] clubs) {

        if (clubs == null) {
            throw new IllegalArgumentException("Clubs cannot be null");
        }
        this.clubs = clubs.clone();
        this.fixture = new fixture(this.clubs);
    }

    public fixture getFixture() {
        return fixture;
    }
}