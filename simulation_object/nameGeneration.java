public class nameGeneration{
    private String[] first_name = {"ben","Josh","John","William","Alex","Clayton","Denis"};
    private String[] last_name = {"White","velon","Ame","Jacob","Wolfson"};
    private String[] club_first_name = {"Wolf","lion","Queen","King","Spur","Knight","Golden","Laker"};
    private String[] club_last_name = {"Ranger","United","FC"};

    

    public String playerName(){
        return first_name[(int)(first_name.length*Math.random())]+last_name[(int)(last_name.length*Math.random())];
    }

    public String clubName(){
        return club_first_name[(int)(club_first_name.length*Math.random())]+club_last_name[(int)(club_last_name.length*Math.random())];
    }
}