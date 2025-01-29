package org.lmarek.intcode.interpreter;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
final class Memory {
    private final List<Integer> state;

    public Memory(List<Integer> initialState){
        this.state = new ArrayList<>(initialState);
    }

    void set(int address, int value){
        state.set(address, value);
    }

    int get(int address){
        return state.get(address);
    }

    List<Integer> getSlice(int startIndex, int length){
        return state.subList(startIndex, startIndex + length);
    }

    List<Integer> getState(){
        return List.copyOf(state);
    }
}
