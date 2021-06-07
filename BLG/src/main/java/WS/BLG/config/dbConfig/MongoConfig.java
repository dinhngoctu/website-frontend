//package WS.BLG.config.dbConfig;
//
//import com.mongodb.ConnectionString;
//import com.mongodb.MongoClientSettings;
//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClients;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
//
//import java.util.Collection;
//import java.util.Collections;
//
//@Configuration
//@EnableMongoRepositories(basePackages = "WS.BLG.repository")
//public class MongoConfig extends AbstractMongoClientConfiguration {
//    @Override
//    protected String getDatabaseName() {
//        return "blg";
//    }
//
//    @Override
//    public MongoClient mongoClient() {
//        ConnectionString connectionString = new ConnectionString("mongodb://admin:admin@localhost:27017");
//        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
//                .applyConnectionString(connectionString)
//                .build();
//        return MongoClients.create(mongoClientSettings);
//    }
//
//    @Override
//    public Collection getMappingBasePackages() {
//        return Collections.singleton("WS.BLG");
//    }
//
//    @Override
//    protected boolean autoIndexCreation() {
//        return true;
//    }
//}
