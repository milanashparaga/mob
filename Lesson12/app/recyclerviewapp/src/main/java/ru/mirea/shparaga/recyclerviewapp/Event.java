package ru.mirea.shparaga.recyclerviewapp;

public class Event {
    private String eventName;
    private String description;
    private int imageName;

    public Event(String eventName, String description, int imageName) {
        this.eventName = eventName;
        this.description = description;
        this.imageName = imageName;
    }

    public String getEventName() {
        return eventName;
    }

    public String getDescription() {
        return description;
    }

    public int getImageName() {
        return imageName;
    }

    @Override
    public String toString() {
        return this.eventName + ": " + this.description;
    }
}