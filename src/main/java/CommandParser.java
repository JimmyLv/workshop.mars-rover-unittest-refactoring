import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandParser implements Parser<String> {
    private static Pattern COMMAND_PATTERN = Pattern.compile("(L|R|M|B)*");

    private void validateCommands(String input) {
        Matcher matcher = COMMAND_PATTERN.matcher(input);
        if (!matcher.matches())
            throw new IllegalArgumentException("Invalid command sequence: " + input);
    }

    @Override
    public String[] parse(String input) {
        validateCommands(input);
        return input.split("");
    }
}
