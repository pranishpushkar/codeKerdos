package com.codekerdos.lld.mock.fileSystem;

import java.util.*;

public class FileSystem {

    private final Directory root;

    public FileSystem() {
        root = new Directory("");
    }

    public List<String> ls(String path) {

        Node node = traverse(path);

        if (node instanceof File) {
            return List.of(node.getName());
        }

        return ((Directory) node).listChildren();
    }

    public void mkdir(String path) {

        String[] directories = path.split("/");

        Directory currentDirectory = root;

        for (int index = 1; index < directories.length; index++) {

            String directoryName = directories[index];

            if (!currentDirectory.contains(directoryName)) {
                currentDirectory.addChild(new Directory(directoryName));
            }

            currentDirectory = (Directory) currentDirectory.getChild(directoryName);
        }
    }

    public void addContentToFile(String filePath, String content) {

        String[] path = filePath.split("/");

        Directory currentDirectory = root;

        for (int index = 1; index < path.length - 1; index++) {

            String directoryName = path[index];

            if (!currentDirectory.contains(directoryName)) {
                currentDirectory.addChild(new Directory(directoryName));
            }

            currentDirectory = (Directory) currentDirectory.getChild(directoryName);
        }

        String fileName = path[path.length - 1];

        if (!currentDirectory.contains(fileName)) {
            currentDirectory.addChild(new File(fileName));
        }

        File file = (File) currentDirectory.getChild(fileName);

        file.appendContent(content);
    }

    public String readContentFromFile(String filePath) {

        File file = (File) traverse(filePath);

        return file.getContent();
    }

    private Node traverse(String path) {

        if (path.equals("/")) {
            return root;
        }

        String[] directories = path.split("/");

        Node currentNode = root;

        for (int index = 1; index < directories.length; index++) {

            currentNode = ((Directory) currentNode).getChild(directories[index]);
        }

        return currentNode;
    }

}
