package be.gfi.academy.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ResultSetMapper<T> {
    T mapResultSetToUser(ResultSet rs) throws SQLException;
    List<T> mapResultSetToUsers(ResultSet rs) throws SQLException ;
}
