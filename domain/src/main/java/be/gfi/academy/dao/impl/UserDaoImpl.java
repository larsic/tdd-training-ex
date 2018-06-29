package be.gfi.academy.dao.impl;

import be.gfi.academy.model.UserVO;
import be.gfi.academy.ConnectionFactory;
import be.gfi.academy.dao.UserDao;
import be.gfi.academy.mappers.UserMapper;

import java.sql.*;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private static final String INSERT_USER_SQL = String.format("insert into user(%s, %s, %s) values (?, ?, ?)", UserDao.FIRST_NAME_COLUMN, UserDao.LAST_NAME_COLUMN, UserDao.EMAIL_COLUMN);
    private static final String UPDATE_USER_SQL = String.format("update user set %s = ? , %s = ?, %s = ? where id = ?", UserDao.FIRST_NAME_COLUMN, UserDao.LAST_NAME_COLUMN, UserDao.EMAIL_COLUMN);
    private static final String DELETE_USER_SQL = "delete from user where id = ?";
    private static final String SELECT_USERS_SQL = "select * from user";
    private static final String SELECT_USER_SQL = "select * from user where id = ?";

    private static final UserMapper mapper = new UserMapper();

    @Override
    public UserVO create(UserVO user) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = conn.prepareStatement(INSERT_USER_SQL, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, user.getFirstName());
        stmt.setString(2, user.getLasttName());
        stmt.setString(3, user.getEmail());
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        user.setId(rs.getInt(1));
        return user;
    }

    @Override
    public UserVO update(UserVO user) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = conn.prepareStatement(UPDATE_USER_SQL);
        stmt.setString(1, user.getFirstName());
        stmt.setString(2, user.getLasttName());
        stmt.setString(3, user.getEmail());
        stmt.setInt(4, user.getId());
        stmt.executeUpdate();
        return user;
    }

    @Override
    public boolean delete(UserVO user) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = conn.prepareStatement(DELETE_USER_SQL);
        stmt.setInt(1, user.getId());
        int rowsAffected = stmt.executeUpdate();
        return (rowsAffected > 0);
    }

    @Override
    public List<UserVO> findAll() throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        ResultSet rs = conn.createStatement().executeQuery(SELECT_USERS_SQL);
        return mapper.mapResultSetToUsers(rs);
    }

    @Override
    public UserVO find(Integer id) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = conn.prepareStatement(SELECT_USER_SQL);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        UserVO user = mapper.mapResultSetToUser(rs);
        return user;
    }
}
