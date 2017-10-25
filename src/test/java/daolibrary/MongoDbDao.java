package daolibrary;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MongoDbDao {

    MongoCredential credential;
    MongoDatabase db;
    MongoClient client;

    private String URI;
    private String user;
    private String database;
    private char[] password;

    public  MongoDbDao(String URI, String database, String user, char[] password){
        this.URI = URI;
        this.user = user;
        this.password = password;
        this.database = database;
    }

    public  void connect(){
        client = new MongoClient(new ServerAddress(URI),Arrays.asList(sendCredentials()));
        db = client.getDatabase(database);

    }

    private MongoCredential sendCredentials(){
        return credential = MongoCredential.createCredential(user, database, password);
    }

    public String[][] getCollectionDataFrom(String collection){

        MongoCollection<Document> collections = db.getCollection(collection);
        FindIterable<Document> documents = collections.find();
        MongoCursor<Document> cursor = documents.iterator();

        List<List<String>> arrayOfData = new ArrayList<>();
        List<String> data = new ArrayList<>();
        int i = 0;

        while(cursor.hasNext()) {

            for (Map.Entry<String, Object> key: cursor.next().entrySet()) {
                if (!key.getKey().toString().equals("_id")) {
                    String value = key.getValue().toString();
                    data.add(value);
                }
            }

            arrayOfData.add(data);
            data = new ArrayList<>();
       }

        String[][] dataArray = new String[arrayOfData.size()][];

        for(List<String> values: arrayOfData){
            dataArray[i++] = values.toArray(new String[values.size()]);
        }

        // closing the connection
        client.close();

        return dataArray;

    }


}
