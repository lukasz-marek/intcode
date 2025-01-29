package org.lmarek.intcode.interpreter;

class Decoder {
  Instruction nextInstruction(Process process) {
    var instructionPtr = process.getInstructionPointer();
    var opcode = process.getMemory().get(instructionPtr);
    return switch (opcode) {
      case 99 -> new Halt();
      case 1 -> new Add();
      case 2 -> new Multiply();
      default ->
          throw new IllegalStateException(
              "Unknown opcode: %d at address %d".formatted(opcode, instructionPtr));
    };
  }
}
