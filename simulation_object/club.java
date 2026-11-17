
import java.util.Arrays;

public class club{
    private nameGeneration generator = new nameGeneration();
    private player[] squadList = new player[25];
    private int money = 100000;
    private String Name  = generator.clubName();

    club(){
        
        Arrays.fill(squadList,new player(generator.playerName(),18));


    }
}