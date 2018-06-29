package be.gfi.academy.model;

public class StepVO extends ActionPointVO implements Comparable<StepVO>{

    protected Integer id;
    protected ObjectiveVO objective;
    protected Boolean status;
    protected Integer order;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    protected StepVO() {
        super(null);
    }

    public StepVO(String name) {
        super(name);
    }

    public ObjectiveVO getObjective() {
        return objective;
    }

    public void setObjective(ObjectiveVO objective) {
        this.objective = objective;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    @Override
    public int compareTo(StepVO otherStep){
        return this.getOrder().compareTo(otherStep.getOrder());
    }
}
