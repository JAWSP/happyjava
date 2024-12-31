package day20;
/*
//대충 파일에 데이터 저장하는 얘
class FileStorage {
    public void save(String data) {
        System.out.println("data saved - " + data);
    }
}

class DataManager {
    private FileStorage fileStorage;

    public DataManager() {
        this.fileStorage = new FileStorage();
    }

    public void saveData(String data) {
        fileStorage.save(data);
    }
}
 */

interface DataSaver {
    public void save(String data);
}
class DataManager {
    private final DataSaver dataSaver;

    public DataManager(DataSaver dataSaver) {
        this.dataSaver = dataSaver;
    }

    public void saveData(String data) {
        dataSaver.save(data);
    }
}

//대충 데이타를 뚝딱하는 얘
class FileStorage implements DataSaver {

    @Override
    public void save(String data) {
        System.out.println("File saved - " + data);
    }
}

class DBstorage implements DataSaver {

    @Override
    public void save(String data) {
        System.out.println("DB commited -" + data);
    }
}

public class DIPex2 {
    public static void main(String[] args) {
        /*
        DataManager dataManager = new DataManager();
        dataManager.saveData("QWqw");
         */
        DataManager db = new DataManager(new DBstorage());
        db.saveData("qw");
    }
}
