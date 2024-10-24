package service;

public class CommandManager {
    public void runCommand(Command command) {
        command.execute();
    }
}