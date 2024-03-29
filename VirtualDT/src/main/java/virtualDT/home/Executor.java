package virtualDT.home;

import java.sql.Connection;
import java.sql.SQLException;

public interface Executor<T> {

	T execute(Connection connection) throws SQLException;
}
