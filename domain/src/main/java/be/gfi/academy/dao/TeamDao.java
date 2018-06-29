package be.gfi.academy.dao;

import be.gfi.academy.model.TeamVO;
import be.gfi.academy.model.UserVO;

import java.util.List;

public interface TeamDao {

    public static final String NAME_COLUMN = "name";

    /**
     * @param team The Team to create
     * */
    void create(TeamVO team);

    /**
     * @param team The Team to update
     * */
    void update(TeamVO team);

    /**
     * @param team The Team to delete
     * */
    void delete(TeamVO team);

    /**
     * @param id identifier of Team entity
     * @return the Team entity with the given id
     *         null if id cannot be found
     * */
    TeamVO find(Integer id);

    /**
     * @return List of all Teams
     * */
    List<TeamVO> findAll();

    /**
     * @param member User who is a member of these Teams
     * @return List of all Teams of which this User is a member
     * */
    List<TeamVO> findAllWithMember(UserVO member);

    /**
     * @param manager User managing these Teams
     * @return List of all Teams of which this User is a manager
     * */
    List<TeamVO> findAllWithManager(UserVO manager);
}
