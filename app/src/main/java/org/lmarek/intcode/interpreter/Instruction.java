package org.lmarek.intcode.interpreter;

interface Instruction {
    void execute(Process process);
}
