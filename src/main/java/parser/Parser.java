package parser;

import type.Command;

import java.util.List;

public interface Parser<T> {
    List<Command> parse(T input);
}
