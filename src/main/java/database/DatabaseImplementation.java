package database;

import lombok.AllArgsConstructor;
import lombok.Data;
import resource.DBNode;
import resource.data.Row;

import java.util.List;

@Data
@AllArgsConstructor
public class DatabaseImplementation implements Database {

    private Repository repository;


    @Override
    public DBNode loadResource() {
        return repository.getSchema();
    }

    @Override
    public List<Row> readDataFromTable(String tableName) {
        return repository.get(tableName);
    }

	@Override
	public List<Row> setTable(String from) {
		return repository.set(from);
	}

	@Override
	public List<Row> updateTable(String tableName) {
		return repository.update(tableName);
	}

	
}
