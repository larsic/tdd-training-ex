package be.gfi.academy.dao;

import be.gfi.academy.model.UserVO;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    public static final String PK_COLUMN = "id";
    public static final String FIRST_NAME_COLUMN = "firstName";
    public static final String LAST_NAME_COLUMN = "lastName";
    public static final String EMAIL_COLUMN = "email";

    /**
     * @param user The User to create
     * */
    UserVO create(UserVO user) throws SQLException;

    /**
     * @param user The User to update
     * */
    UserVO update(UserVO user) throws SQLException;

    /**
     * @param user The User to delete
     * */
    boolean delete(UserVO user) throws SQLException;

    /**
     * @return List of all Users
     * */
    List<UserVO> findAll() throws SQLException;

    /**
     * @param id identifier of User entity
     * @return the User entity with the given id
     *         null if id cannot be found
     * */
    UserVO find(Integer id) throws SQLException;
}
