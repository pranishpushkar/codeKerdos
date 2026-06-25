package com.codekerdos.lld.memento;

public class Editor {

    private String content = "";

    public void setContent(String content){
        this.content=content;
    }

    public String getContent(){
        return content;
    }

    public Memento saveMemento(){
        return new Memento(content);
    }

    public void restore(Memento memento){
        this.content = memento.getState();
    }

}
