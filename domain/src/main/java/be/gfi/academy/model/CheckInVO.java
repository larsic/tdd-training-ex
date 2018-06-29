package be.gfi.academy.model;

import java.util.Calendar;

public class CheckInVO {

    protected Integer id;
    protected UserVO organiser;
    protected UserVO attendee;
    protected String location;
    protected Calendar meetingDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserVO getOrganiser() {
        return organiser;
    }

    public void setOrganiser(UserVO organiser) {
        this.organiser = organiser;
    }

    public UserVO getAttendee() {
        return attendee;
    }

    public void setAttendee(UserVO attendee) {
        this.attendee = attendee;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Calendar getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(Calendar meetingDate) {
        this.meetingDate = meetingDate;
    }
}
