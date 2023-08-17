package DesignPattern.BridgePattern;

import java.rmi.Remote;

public class TestTheRemote {
    public static void main(String[] args) {
        
        RemoteButton theTV = new TVRemoteMute(new TVDevice(1, 2000));
        RemoteButton theTV2 = new TVRemotePause(new TVDevice(1, 2000));

        System.out.println("Test Tv with Mute");
        theTV.buttonFivePressed();
        theTV.buttonSixPressed();
        theTV.buttonNinePressed();

        System.out.println("\nTest TV with Pause");

        theTV2.buttonFivePressed();
        theTV2.buttonSixPressed();
        theTV2.buttonSixPressed();
        theTV2.buttonSixPressed();
        theTV2.buttonSixPressed();
        theTV2.buttonNinePressed();
        theTV2.deviceFeedback();


    }
}
