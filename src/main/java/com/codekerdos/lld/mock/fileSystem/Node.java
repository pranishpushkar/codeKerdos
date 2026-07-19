package com.codekerdos.lld.mock.fileSystem;

public abstract class Node {

    protected final String name;

    protected Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}