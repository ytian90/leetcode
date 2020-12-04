package hfdp2.chapter6_command_pattern.control;

import hfdp2.chapter6_command_pattern.command.Command;

public class SimpleRemoteControl {
    Command slot;
    public SimpleRemoteControl() {}

    public void setCommand(Command command) {
        this.slot = command;
    }

    public void buttonWasPressed() {
        slot.execute();
    }
}
