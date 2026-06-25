package com.codekerdos.lld.memento;

public class Driver {

    public static void main(String[] args) {

        Editor editor1 = new Editor();
        Caretaker caretaker1 = new Caretaker();
        caretaker1.save(editor1);

        editor1.setContent("Hello");
        caretaker1.save(editor1);

        editor1.setContent("World");
        caretaker1.save(editor1);

        editor1.setContent("!!!");
        caretaker1.save(editor1);

        System.out.println("Editor1 current: " + editor1.getContent());

        caretaker1.undo(editor1);
        System.out.println("Editor1 after undo: " + editor1.getContent());

        caretaker1.undo(editor1);
        System.out.println("Editor1 after second undo: " + editor1.getContent());

        caretaker1.redo(editor1);
        System.out.println("Editor1 after redo: " + editor1.getContent());


        Editor editor2 = new Editor();
        Caretaker caretaker2 = new Caretaker();
        caretaker2.save(editor2);

        editor2.setContent("Hey");
        caretaker2.save(editor2);

        editor2.setContent("there");
        caretaker2.save(editor2);

        editor2.setContent("!!!");
        caretaker2.save(editor2);

        System.out.println("\nEditor2 current: " + editor2.getContent());

        caretaker2.undo(editor2);
        System.out.println("Editor2 after undo: " + editor2.getContent());

        caretaker2.undo(editor2);
        System.out.println("Editor2 after undo: " + editor2.getContent());

        caretaker2.redo(editor2);
        System.out.println("Editor2 after redo: " + editor2.getContent());
    }
}