package com.codekerdos.lld.mock.fileSystem;

public class File extends Node {

    private final StringBuilder content;

    public File(String name) {
        super(name);
        this.content = new StringBuilder();
    }

    public void appendContent(String newContent) {
        content.append(newContent);
    }

    public String getContent() {
        return content.toString();
    }

}
