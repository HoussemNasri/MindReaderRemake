package org.houssemnasri.exceptions;

public class NavigatorNotInitializedException extends RuntimeException{
    public NavigatorNotInitializedException(){
        super("You need to call AppNavigator.init() before using it");
    }
}
