package org.lmarek.intcode.program;

import java.util.List;

public record Program(List<Integer> integers) {
    public Program{
        integers = List.copyOf(integers);
    }
}
