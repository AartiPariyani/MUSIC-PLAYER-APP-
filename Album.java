package com.java;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;
    public Album(String name , String artist){
        this.name=name;
        this.artist=artist;
        this.songs= new ArrayList<Song>();
    }

    public Song findsong(String title){
        for(Song checksong:songs){
            if(checksong.getTitle().equals(title))
                return checksong;
        }
        return null;

    }
    public boolean add( String title, double duration){
        if(findsong(title)==null){
            songs.add(new Song(title,duration));
          //  System.out.println("title "+title+"Added successfully");
            return true;
        }
        else
           // System.out.println("song with name"+title+"already exist");
        return false;
    }
    public boolean addplaylist(int trackno, LinkedList<Song> playlist){
        int index=trackno-1;
        if (index>0 && index<this.songs.size()){
            playlist.add(this.songs.get(index));
            return true;
        }
        return false;

    }
    public boolean addplaylist(String title, LinkedList<Song> playlist){
        for(Song checksong:this.songs){
            if(checksong.getTitle().equals(title)){
                playlist.add(checksong);
                return true;
            }
        }
        return false;
    }
}
