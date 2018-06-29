package be.gfi.academy.model;

public class RequestVO extends ActionPointVO {

    protected Integer id;
    protected UserVO requester;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    protected RequestVO() {
        super(null);
    }

    public RequestVO(String name) {
        super(name);
    }

    @Override
    public String getTitle() {
        return super.getTitle();
    }

    @Override
    public void setTitle(String title) {
        super.setTitle(title);
    }

    public UserVO getRequester() {
        return requester;
    }

    public void setRequester(UserVO requester) {
        this.requester = requester;
    }
}
