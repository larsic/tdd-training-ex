package be.gfi.academy.model;

import java.util.Calendar;
import java.util.List;

public class ObjectiveVO {

    protected Integer id;
    protected ObjectiveCategoryVO category;
    protected String title;
    protected String description;
    protected Calendar deadLine;
    protected UserVO owner;
    protected State state;
    protected List<StepVO> steps;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ObjectiveCategoryVO getCategory() {
        return category;
    }

    public void setCategory(ObjectiveCategoryVO category) {
        this.category = category;
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

    public Calendar getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Calendar deadLine) {
        this.deadLine = deadLine;
    }

    public UserVO getOwner() {
        return owner;
    }

    public void setOwner(UserVO owner) {
        this.owner = owner;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<StepVO> getSteps() {
        return steps;
    }

    public void setSteps(List<StepVO> steps) {
        this.steps = steps;
    }

    public enum State{
        IN_PROGRESS, ACHIEVED, ABANDONED;
    }


    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Objective : " + this.getDescription());
        if(this.getSteps().size() > 0){
            builder.append(System.lineSeparator());
            StepVO first = getSteps().get(0);
            builder.append(String.format("Actionpoints  : %d : %s",  first.getOrder(), first.getDescription()));
            builder.append(System.lineSeparator());
            if(this.getSteps().size() > 1){
                getSteps()
                        .stream()
                        .skip(1)
                        .forEach(ap -> {builder.append(String.format("              : %d : %s", ap.getOrder(), ap.getDescription()));
                            builder.append(System.lineSeparator());});
            }
        }
        return builder.toString();
    }

}






