package com.company;


public class PlayerStats {

    int ID;
    String Name;
    int point = 0;
    int knights_played = 0;
    int length_of_road = 0;
    int resources_on_hand = 0;

    PlayerStats(int _id, String _Name){

    }



    public void updateplayerstats(int additional_points, int additional_knights, int current_length_of_road, int current_resources_on_hand){
        point = point+additional_points;
        knights_played = knights_played+additional_knights;
        length_of_road= current_length_of_road;
        resources_on_hand = current_resources_on_hand;

    }


    public boolean checkpointstoseeifwin(){

        return false;
    }




}
