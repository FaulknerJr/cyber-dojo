/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FaulknerJr
 */
public class HundredDoors {
    public void run(){

        playingWithDoors();
    }
    
    public void playingWithDoors(){
        int [] doors = new int[101];
        for(int i = 0; i < doors.length; ++i){
            doors[i] = 0;
        }
        for(int i = 1; i < 101; ++i){
            int j = i;
            while(j < 100){
                if(j % i == 0) {
                    if (doors[j] == 0) {
                        doors[j] = 1;
                    } else {
                        doors[j] = 0;
                    }
                }
                j = (j + i);
            }
        }
        int doorsOpen = 0;
        int doorsClosed = 0;

        System.out.println("Opened doors are 1. Closed doors are 0");

        for(int i = 1; i < doors.length; ++i){
            if(doors[i] == 1){
                ++doorsOpen;
            } else {
                ++doorsClosed;
            }
            System.out.println("Index " + i + " [" + doors[i] + "]");
        }
        
        System.out.println("Doors opened: " + doorsOpen);
        System.out.println("Doors closed: " + doorsClosed);
        System.out.println("Total doors: " + (doorsOpen + doorsClosed));
    }
}
