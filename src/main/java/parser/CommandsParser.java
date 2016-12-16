package parser;

import type.Command;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static type.Command.*;

public class CommandsParser implements Parser<String> {
    private static final List<Command> VALID_COMMANDS = Arrays.asList(L, R, M, B);

    @Override
    public List<Command> parse(String input) {
        String[] commandArray = input.split("");

        validateCommands(input, commandArray);

        return Arrays.stream(commandArray)
                .map(Command::valueOf)
                .collect(Collectors.toList());
    }

    private static void validateCommands(String input, String[] commandArray) {
        for (String command : commandArray) {
            if (!VALID_COMMANDS.contains(Command.valueOf(command))) {
                throw new IllegalArgumentException("Invalid command sequence: " + input);
            }
        }
    }
}
