package org.houssemnasri.exceptions;

public class GameNotCompletedException extends RuntimeException{

    public GameNotCompletedException(){
        super("The value you are trying to get won't be there until the game is completed");
    }
}
