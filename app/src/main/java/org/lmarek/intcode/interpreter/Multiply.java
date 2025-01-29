package org.lmarek.intcode.interpreter;

class Multiply implements Instruction {
    @Override
    public void execute(Process process) {
        var instructionPtr = process.getInstructionPointer();
        var addresses = process.getMemory().getSlice(instructionPtr + 1, 3);
        var operand1 = process.getMemory().get(addresses.get(0));
        var operand2 = process.getMemory().get(addresses.get(1));
        process.getMemory().set(addresses.get(2), operand1 * operand2);
        process.setInstructionPointer(instructionPtr + 4);
    }
}
