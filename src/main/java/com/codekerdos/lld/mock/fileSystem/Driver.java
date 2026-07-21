package com.codekerdos.lld.mock.fileSystem;


public class Driver {

    public static void main(String[] args) {

        FileSystem fileSystem = new FileSystem();

        // Create directories
        fileSystem.mkdir("/home/docs");
        fileSystem.mkdir("/home/photos");
        fileSystem.mkdir("/temp");

        // Add file contents
        fileSystem.addContentToFile("/home/docs/notes.txt", "Hello");
        fileSystem.addContentToFile("/home/docs/notes.txt", " World");

        fileSystem.addContentToFile("/home/docs/todo.txt", "Buy Milk");

        fileSystem.addContentToFile("/temp/log.txt", "Application Started");

        // List root
        System.out.println("ls(\"/\")");
        System.out.println(fileSystem.ls("/"));
        System.out.println();

        // List home
        System.out.println("ls(\"/home\")");
        System.out.println(fileSystem.ls("/home"));
        System.out.println();

        // List docs
        System.out.println("ls(\"/home/docs\")");
        System.out.println(fileSystem.ls("/home/docs"));
        System.out.println();

        System.out.println("ls(\"/home/docs/notes.txt\")");
        System.out.println(fileSystem.ls("/home/docs/notes.txt"));
        System.out.println();

        // System.out.println("ls(\"/\")");
        // System.out.println(fileSystem.ls("/temp1"));
        // System.out.println();

        System.out.println("readContentFromFile(\"/home/docs/notes.txt\")");
        System.out.println(fileSystem.readContentFromFile("/home/docs/notes.txt"));
        System.out.println();

        System.out.println("readContentFromFile(\"/temp/log.txt\")");
        System.out.println(fileSystem.readContentFromFile("/temp/log.txt"));

        //System.out.println(fileSystem.readContentFromFile("/temp1/log.txt"));

    }
}
