package com.fc.protocol.server.demo.entity;
/**
 * Created by jack on 2017/7/20.
 */
public class Test {
    private int id;
    private String name;
    private String note;
 
    public Test(){
    	
    }
    
    public Test(int id,String name,String note){
    	this.id = id;
    	this.name = name;
    	this.note = note;
    }
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getNote() {
        return note;
    }
 
    public void setNote(String note) {
        this.note = note;
    }
 
    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}