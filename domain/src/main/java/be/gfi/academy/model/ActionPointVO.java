package be.gfi.academy.model;

import java.util.Calendar;

public abstract class ActionPointVO {

    protected Integer id;
    protected String title;
    protected String description;
    protected Calendar reminderDate;
    protected UserVO agent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ActionPointVO(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Calendar getReminderDate() {
        return reminderDate;
    }

    public void setReminderDate(Calendar reminderDate) {
        this.reminderDate = reminderDate;
    }

    public UserVO getAgent() {
        return agent;
    }

    public void setAgent(UserVO agent) {
        this.agent = agent;
    }
}
