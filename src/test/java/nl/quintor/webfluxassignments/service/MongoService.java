package nl.quintor.webfluxassignments.service;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.script.ExecutableMongoScript;
import org.springframework.stereotype.Service;

@Service
public class MongoService {

    private MongoOperations mongo;


    public MongoService(MongoOperations mongo) {
        this.mongo = mongo;
    }

    public void makeCollectionCapped(final String collection, final int size) {
        if (!mongo.collectionExists(collection)) {
            mongo.createCollection(collection);
        }
        mongo.scriptOps().execute(new ExecutableMongoScript("db.runCommand({\"convertToCapped\": \"" + collection + "\", size: " + size + "});"));
    }

    public void clearCollection(final String collection) {
        mongo.dropCollection(collection);

        makeCollectionCapped(collection, 8194);
    }

}
