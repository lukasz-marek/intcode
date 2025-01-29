package org.lmarek.intcode.interpreter;

class Halt implements Instruction {
    @Override
    public void execute(Process process) {
        process.setStopped(true);
    }
}
