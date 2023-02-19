package com.kafka.KafkaPoc2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Document("speakers")
public class Speaker {

    @Id
    private int id;
    @Field(name = "first_name")
    private String firstName;
    @Field("last_name")
    private String lastName;
    private boolean favourite;
    private String company;
    @Field("twitter_handle")
    private String twitterHandle;

    @Transient
    private List<Session> sessions;

    public Speaker(int id, String firstName, String lastName, boolean favourite, String company, String twitterHandle, List<Session> sessions) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.favourite = favourite;
        this.company = company;
        this.twitterHandle = twitterHandle;
        this.sessions = sessions;
    }

    public Speaker() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTwitterHandle() {
        return twitterHandle;
    }

    public void setTwitterHandle(String twitterHandle) {
        this.twitterHandle = twitterHandle;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    @Override
    public String toString() {
        return "Speaker{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", favourite=" + favourite +
                ", company='" + company + '\'' +
                ", twitterHandle='" + twitterHandle + '\'' +
                ", sessions=" + sessions +
                '}';
    }
}
