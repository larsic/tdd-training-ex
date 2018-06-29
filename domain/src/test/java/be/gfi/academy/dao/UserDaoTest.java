package be.gfi.academy.dao;

import be.gfi.academy.model.UserVO;
import be.gfi.academy.ConnectionFactory;
import be.gfi.academy.dao.impl.UserDaoImpl;
import be.gfi.academy.mappers.UserMapper;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class UserDaoTest {

    String countUsersSql = "select count(*) from user";
    String findUserSql = "select * from user where id = ?";
    UserMapper mapper = new UserMapper();


    @Test
    public void findAll() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void findByName() {
    }

    @Test
    public void findByTeam() {
    }

    @Test
    public void create() throws SQLException {
        int oldCount = countUsers();

        UserDao userDao = new UserDaoImpl();
        UserVO user = new UserVO();
        user.setEmail("newuser@test.com");
        user.setFirstName("new");
        user.setLasttName("user");
        user = userDao.create(user);

        int newCount = countUsers();
        assertEquals(oldCount +1, newCount);

        UserVO newUser = findUser(user.getId());
        assertEquals(newUser.getFirstName(), user.getFirstName());
        assertEquals(newUser.getLasttName(), user.getLasttName());
        assertEquals(newUser.getEmail(), user.getEmail());    }

    @Test
    public void update() {
    }

    @Test
    public void remove() {
    }


    private int countUsers() throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        ResultSet rs = conn.createStatement().executeQuery(countUsersSql);
        rs.first();
        return rs.getInt(1);
    }

    private UserVO findUser(Integer id) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = conn.prepareStatement(findUserSql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery(countUsersSql);
        if(!rs.first())
            return null;
        return mapper.mapResultSetToUser(rs);
    }

}
