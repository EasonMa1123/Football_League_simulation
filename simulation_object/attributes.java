

public class attributes{
    private int pace;
    private int shooting;
    private int passing;
    private int vision;
    private int tackle;
    private int physical;
    private int stamina;
    private int jumping;
    private int consistency;


    attributes(){
        this.pace = random_gen();
        this.shooting = random_gen();
        this.passing = random_gen();
        this.vision = random_gen();
        this.tackle = random_gen();
        this.physical = random_gen();
        this.stamina = random_gen();
        this.jumping = random_gen();
        this.consistency = random_gen();
    }

    private int random_gen(){return (int)(Math.random()*100);}

    public int[] getAllAttribute(){
        return new int[] {this.pace,
        this.shooting,
        this.passing,
        this.vision,
        this.tackle,
        this.physical,
        this.stamina,
        this.jumping,
        this.consistency};
    }

    public int getAttribute(String attribute){
        return switch (attribute) {
            case "pace" -> this.pace;
            case "shooting" -> this.shooting;
            case "passing" -> this.passing;
            case "vision" -> this.vision;
            case "tackle" -> this.tackle;
            case "physical" -> this.physical;
            case "stamina" -> this.stamina;
            case "jumping" -> this.jumping;
            case "consistency" -> this.consistency;
            default -> throw new IllegalArgumentException("Unknown attribute: " + attribute);
        };
    }
}