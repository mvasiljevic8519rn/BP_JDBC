package database;

import resource.DBNode;
import resource.data.Row;

import java.util.List;

public interface Repository {

    DBNode getSchema();
    List<Row> set(String from);
    List<Row> get(String from);
    List<Row> update(String from);
}
