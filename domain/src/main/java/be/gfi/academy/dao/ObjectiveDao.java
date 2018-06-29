package be.gfi.academy.dao;

import be.gfi.academy.model.ObjectiveVO;
import be.gfi.academy.model.UserVO;

import java.util.List;

public interface ObjectiveDao {
    public static final String TITLE_COLUMN = "title";
    public static final String DESCRIPTION_COLUMN = "description";
    public static final String DEADLINE_COLUMN = "deadline";
    public static final String STATE_COLUMN = "state";

    /**
     * @param objective The Objective to create
     * */
    void create(ObjectiveVO objective);

    /**
     * @param objective The Objective to update
     * */
    void update(ObjectiveVO objective);

    /**
     * @param objective The Objective to delete
     * */
    void delete(ObjectiveVO objective);

    /**
     * @param id identifier of Objective entity
     * @return the Objective entity with the given id
     *         null if id cannot be found
     * */
    ObjectiveVO find(Integer id);

    /**
     * @return List of all Objectives
     * */
    List<ObjectiveVO> findAll();

    /**
     * @param owner User owning these Objectives
     * @return List of all Objectives owned by this user
     * */
    List<ObjectiveVO> findAll(UserVO owner);
}
