package com.codekerdos.lld.mock.fileSystem;

import java.util.*;

public class Directory extends Node {

    private final TreeMap<String, Node> children;

    public Directory(String name) {
        super(name);
        this.children = new TreeMap<>();
    }

    public boolean contains(String name) {
        return children.containsKey(name);
    }

    public Node getChild(String name) {
        return children.get(name);
    }

    public void addChild(Node node) {
        children.put(node.getName(), node);
    }

    public List<String> listChildren() {
        return new ArrayList<>(children.keySet());
    }

}
