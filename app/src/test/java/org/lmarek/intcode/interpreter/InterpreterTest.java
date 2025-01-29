package org.lmarek.intcode.interpreter;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.lmarek.intcode.program.Program;

class InterpreterTest {
  private final Interpreter sut = new Interpreter();

  static Stream<Arguments> samplePrograms() {
    return Stream.of(
        Arguments.of(List.of(1, 0, 0, 0, 99), List.of(2, 0, 0, 0, 99)),
        Arguments.of(List.of(2, 3, 0, 3, 99), List.of(2, 3, 0, 6, 99)),
        Arguments.of(List.of(2, 4, 4, 5, 99, 0), List.of(2, 4, 4, 5, 99, 9801)),
        Arguments.of(List.of(1, 1, 1, 4, 99, 5, 6, 0, 99), List.of(30, 1, 1, 4, 2, 5, 6, 0, 99)),
        Arguments.of(
            List.of(1, 9, 10, 3, 2, 3, 11, 0, 99, 30, 40, 50),
            List.of(3500, 9, 10, 70, 2, 3, 11, 0, 99, 30, 40, 50)));
  }

  @ParameterizedTest
  @MethodSource("samplePrograms")
  void successfullyExecutesSmallPrograms(List<Integer> program, List<Integer> expectedOutput) {
    // when
    var result = sut.run(new Program(program));
    // then
    assertThat(result).isEqualTo(expectedOutput);
  }
}
