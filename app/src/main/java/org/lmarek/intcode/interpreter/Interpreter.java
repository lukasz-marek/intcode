package org.lmarek.intcode.interpreter;

import org.lmarek.intcode.program.Program;

import java.util.List;

public final class Interpreter {
    public List<Integer> run(Program program){
        var process = new Process(program);
        process.execute();
        return process.getMemory().getState();
    }
}
