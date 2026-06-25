package com.codekerdos.lld.memento;

import java.util.*;

public class Caretaker {

    private Deque<Memento> undoStack = new ArrayDeque<>();
    private Deque<Memento> redoStack = new ArrayDeque<>();

    public void save(Editor editor){
        undoStack.push(editor.saveMemento());
        redoStack.clear();
    }

    public void undo(Editor editor) {
        if (undoStack.size() <= 1){ 
            return;
        }

        redoStack.push(undoStack.pop());
        editor.restore(undoStack.peek());
    }

    public void redo(Editor editor) {
        if (redoStack.isEmpty()) return;

        Memento m = redoStack.pop();
        undoStack.push(m);
        editor.restore(m);
    }



}
