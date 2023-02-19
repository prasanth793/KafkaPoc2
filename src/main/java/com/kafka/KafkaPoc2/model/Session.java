package com.kafka.KafkaPoc2.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("sessions")
public class Session {

    @Id
    private int id;
    @Field("session_title")
    private String sessionTitle;
    @Field("event_year")
    private String eventYear;
    @Field("speaker_id")
    private int speakerId;
    @Field("room_name")
    private String roomName;

    @Transient
    private Room room;

    public Session(int id, String sessionTitle, String eventYear, int speakerId, String roomName, Room room) {
        this.id = id;
        this.sessionTitle = sessionTitle;
        this.eventYear = eventYear;
        this.speakerId = speakerId;
        this.roomName = roomName;
        this.room = room;
    }

    public Session() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSessionTitle() {
        return sessionTitle;
    }

    public void setSessionTitle(String sessionTitle) {
        this.sessionTitle = sessionTitle;
    }

    public String getEventYear() {
        return eventYear;
    }

    public void setEventYear(String eventYear) {
        this.eventYear = eventYear;
    }

    public int getSpeakerId() {
        return speakerId;
    }

    public void setSpeakerId(int speakerId) {
        this.speakerId = speakerId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void build(){
        Room room  = new Room(roomName);
        setRoom(room);
    }




    //Inner Room Class
    public class Room{
        private String name;

        public Room() {
        }


        public Room(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
