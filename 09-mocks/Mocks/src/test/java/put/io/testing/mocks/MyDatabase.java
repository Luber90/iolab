package put.io.testing.mocks;

import put.io.students.fancylibrary.database.IFancyDatabase;

import java.util.Collections;
import java.util.List;

public class MyDatabase implements IFancyDatabase {
    public void connect(){

    }
    public <T> void persist(T var1){

    }
    public void close(){

    }
    public List<Expense> queryAll(){
        return Collections.emptyList();
    }
}
