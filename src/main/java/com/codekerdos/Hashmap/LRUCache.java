package com.codekerdos.Hashmap;

import java.util.*;

public class LRUCache {

    private class Node{

        private int key;
        private int value;
        private Node prev;
        private Node next;

        Node(int key, int value){

            this.key = key;
            this.value = value;

        }

    }

    private final int capacity;
    private final Map<Integer,Node> cache = new HashMap<>();
    private final Node dummyHead;
    private final Node dummyTail;

    LRUCache(int capacity){

        this.capacity = capacity;
        dummyHead = new Node(0,0);
        dummyTail = new Node(0, 0);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;

    }

    public int get(int key){
        if(!cache.containsKey(key)){
            return -1;
        }
        Node retrievedNode = cache.get(key);
        remove(retrievedNode);
        addToTail(retrievedNode);

        return retrievedNode.value;

    }

    public void put(int key, int value){
        if(!cache.containsKey(key)){
            Node newNode = new Node(key,value);
            cache.put(key,newNode);
            addToTail(newNode);

            if (cache.size() > capacity) {
                Node lruNode = dummyHead.next;
                remove(lruNode);
                cache.remove(lruNode.key);
            }
        }else{
            Node existingNode = cache.get(key);
            existingNode.value = value;
            remove(existingNode);
            addToTail(existingNode);
        }
    }

    private void remove(Node node){

        node.prev.next = node.next;
        node.next.prev = node.prev;

    }

    private void addToTail(Node node){

        Node prevNode = dummyTail.prev;
        prevNode.next = node;
        node.prev = prevNode;
        node.next = dummyTail;
        dummyTail.prev = node;

    }

}
