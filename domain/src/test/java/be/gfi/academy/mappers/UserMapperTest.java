package be.gfi.academy.mappers;

import be.gfi.academy.model.UserVO;
import org.junit.Test;

import java.sql.SQLException;

import static be.gfi.academy.dao.UserDao.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UserMapperTest {

    UserMapper mapper = new UserMapper();

    @Test
    public void mapUser() throws SQLException {
        UserVO dbUser = getTestUser();
        DummyResultSet dummeRS = new UserResultSet(dbUser);
        UserVO mappedUser = mapper.mapResultSetToUser(dummeRS);
        assertNotNull(mappedUser);
        assertEquals(mappedUser.getId(), dbUser.getId());
        assertEquals(mappedUser.getFirstName(), dbUser.getFirstName());
        assertEquals(mappedUser.getLasttName(), dbUser.getLasttName());
        assertEquals(mappedUser.getEmail(), dbUser.getEmail());
    }

    private UserVO getTestUser(){
        UserVO user = new UserVO();
        user.setId(1);
        user.setFirstName("new");
        user.setLasttName("user");
        user.setEmail("newuser@test.com");
        return user;
    }

    class UserResultSet extends DummyResultSet{

        private final UserVO user;

        public UserResultSet(UserVO user){
            super(1);
            this.user = user;
        }

        @Override
        public String getString(int columnIndex) throws SQLException {
            switch(columnIndex) {
                case 2: return user.getFirstName();
                case 3: return user.getLasttName();
                case 4: return user.getEmail();
                default: throw new SQLException("Invalid column index");
            }
        }

        @Override
        public int getInt(int columnIndex) throws SQLException {
            switch(columnIndex) {
                case 1: return user.getId();
                default: throw new SQLException("Invalid column index");
            }
        }

        @Override
        public String getString(String columnLabel) throws SQLException {
            switch(columnLabel) {
                case FIRST_NAME_COLUMN: return user.getFirstName();
                case LAST_NAME_COLUMN: return user.getLasttName();
                case EMAIL_COLUMN: return user.getEmail();
                default: throw new SQLException("Invalid column label");
            }
        }

        @Override
        public int getInt(String columnLabel) throws SQLException {
            switch(columnLabel) {
                case PK_COLUMN: return user.getId();
                default: throw new SQLException("Invalid column label");
            }
        }

    }

}
