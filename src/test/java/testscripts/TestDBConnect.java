package testscripts;

import daolibrary.MongoDbDao;

public class TestDBConnect {
    public static void main(String[] args) {
        MongoDbDao db = new MongoDbDao("127.0.0.1:27017", "flight_testing", "tester", "123456".toCharArray());
        db.connect();
        db.getCollectionDataFrom("testingdata");
    }
}
