package com.java;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums=new ArrayList<>();
    public static void main(String[] args) {
        Album album = new Album("album1", "AC/DC");
        album.add("hawaye", 4.5);
        album.add("perfect", 5.5);
        album.add("highway to hell", 4.4);
        album.add("saiya", 3.3);
        albums.add(album);
        album= new Album("album2", "emenure");
        album.add("red wood", 4.2);
        album.add("traffic", 5.6);
        album.add("maa", 6.9);

        albums.add(album);
        LinkedList<Song> playlist1 = new LinkedList<>();
        albums.get(0).addplaylist("hawaye", playlist1);
        albums.get(0).addplaylist("saiya", playlist1);
        albums.get(1).addplaylist("red wood", playlist1);
        albums.get(1).addplaylist("traffic", playlist1);

        playlist(playlist1);

    }
    private static void playlist(LinkedList<Song> playlist){
        Scanner sc=new Scanner(System.in);
        boolean quit=false;
        boolean forward=true;
        ListIterator<Song> listiterator=playlist.listIterator();
        if (playlist.size()==0){
            System.out.println("This playlist has no song");
        }
        else {
            System.out.println("Now playing" + listiterator.next().toString());
            menu();
        }
        while (!quit){
            int choice=sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 0:
                    System.out.println("playlist complete");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listiterator.hasNext()) {
                            listiterator.next();
                        }
                        forward = true;
                    }
                    if (listiterator.hasNext()) {
                        System.out.println("now playing" + listiterator.next().toString());

                    } else{
                        System.out.println("no song ,we rached end of the playlist");
                    forward = false;
                    }
                    break;

                case 2:
                    if(forward) {
                        if (listiterator.hasPrevious()) {
                            listiterator.previous();
                        }
                        forward = false;
                    }
                    if (listiterator.hasNext()) {
                            System.out.println("now playing" + listiterator.previous().toString());
                        } else {
                            System.out.println("we are first song");
                            forward = false;
                        }
                        break;

                case 3:
                    if(forward) {
                        if (listiterator.hasPrevious()) {
                            System.out.println("Now playing" + listiterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("we are at the start of the list ");
                        }
                    }
                    else {
                        if(listiterator.hasNext()){
                            System.out.println("now playing"+listiterator.next().toString());
                            forward=true;
                        }
                        else
                        {
                            System.out.println("we have reached end of the list");

                        }

                        }
                    break;
                case 4:
                    printlist(playlist);

                    break;
                case 5:
                    menu();
                    break;
                case 6:
                    if (playlist.size()>0){
                        listiterator.remove();
                        if (listiterator.hasNext()){
                            System.out.println("now playing"+listiterator.next().toString());
                        }
                        else {
                            if (listiterator.hasPrevious())
                            System.out.println("now playing"+listiterator.previous().toString());
                        }
                    }

            }
        }
    }
    private static void menu(){
        System.out.println("Available option are :");
        System.out.println("press 0 for quit\n"+
                "press 1 for paly next song\n"+
                "press 2 for play previous song\n"+
                "press 3 for replay current song\n"+
                "press 4 list of all song\n"+
                "press 5 for print all available options\n "+
                "press 6 for delete current song\n");
    }
    private static void printlist(LinkedList<Song> playlist){
        System.out.println("-------------------");
        Iterator<Song> iterator= playlist.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("-------------------");
    }

}
