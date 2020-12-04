package hfdp2.chapter6_command_pattern.test;

import hfdp2.chapter6_command_pattern.command.GarageDoorOpenCommand;
import hfdp2.chapter6_command_pattern.command.LightOnCommand;
import hfdp2.chapter6_command_pattern.control.SimpleRemoteControl;
import hfdp2.chapter6_command_pattern.model.GarageDoor;
import hfdp2.chapter6_command_pattern.model.Light;

public class RemoteControlTest {
    public static void main(String[] args) {
        SimpleRemoteControl remote = new SimpleRemoteControl();
        Light light = new Light();
        GarageDoor garageDoor = new GarageDoor();
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        GarageDoorOpenCommand garageDoorOpenCommand = new GarageDoorOpenCommand(garageDoor);
        remote.setCommand(lightOnCommand);
        remote.buttonWasPressed();
        remote.setCommand(garageDoorOpenCommand);
        remote.buttonWasPressed();
    }
}
