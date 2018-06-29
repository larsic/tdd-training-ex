package be.gfi.academy.mappers;

import be.gfi.academy.model.UserVO;
import be.gfi.academy.dao.UserDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserMapper implements ResultSetMapper<UserVO> {

    @Override
    public UserVO mapResultSetToUser(ResultSet rs) throws SQLException {
        List<UserVO> users = mapResultSetToUsers(rs);
        if(users.isEmpty())
            return null;
        else
            return users.get(0);
    }

    @Override
    public List<UserVO> mapResultSetToUsers(ResultSet rs) throws SQLException {
        List<UserVO> users = new ArrayList<>();
        while(rs.next()){
            UserVO user = mapUserFromRow(rs);
            users.add(user);
        }
        return users;
    }

    protected UserVO mapUserFromRow(ResultSet rs) throws SQLException {
        UserVO user = new UserVO();
        user.setId(rs.getInt(UserDao.PK_COLUMN));
        user.setFirstName(rs.getString(UserDao.FIRST_NAME_COLUMN));
        user.setLasttName(rs.getString(UserDao.LAST_NAME_COLUMN));
        user.setEmail(rs.getString(UserDao.EMAIL_COLUMN));
        return user;
    }
}
