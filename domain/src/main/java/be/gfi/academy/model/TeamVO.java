package be.gfi.academy.model;

import java.util.Set;

public class TeamVO {

    protected Integer id;
    protected String name;
    protected Set<UserVO> teamMembers;
    protected UserVO manager;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<UserVO> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(Set<UserVO> teamMembers) {
        this.teamMembers = teamMembers;
    }

    public UserVO getManager() {
        return manager;
    }

    public void setManager(UserVO manager) {
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
