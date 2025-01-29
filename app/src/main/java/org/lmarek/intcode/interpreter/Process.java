package org.lmarek.intcode.interpreter;

import lombok.Data;
import org.lmarek.intcode.program.Program;

@Data
final class Process {
  private final Memory memory;
  private final Decoder decoder = new Decoder();
  private int instructionPointer = 0;
  private boolean stopped;

  Process(Program program) {
    this.memory = new Memory(program.integers());
  }

  void execute() {
    while (!this.isStopped()) {
      var instruction = decoder.nextInstruction(this);
      instruction.execute(this);
    }
  }
}
