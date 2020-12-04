package hfdp2.chapter6_command_pattern.command;

import hfdp2.chapter6_command_pattern.model.Light;

public class LightOnCommand implements Command {
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
