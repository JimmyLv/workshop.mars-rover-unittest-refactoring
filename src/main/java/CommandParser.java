public class CommandParser implements parser<String> {
    @Override
    public String[] parse(String input) {
        return input.split("");
    }
}
