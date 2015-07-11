package org.lcm.backend.mongodb.embedded;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import de.flapdoodle.embed.mongo.Command;
import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.ArtifactStoreBuilder;
import de.flapdoodle.embed.mongo.config.DownloadConfigBuilder;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.config.RuntimeConfigBuilder;
import de.flapdoodle.embed.mongo.config.Storage;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.config.IRuntimeConfig;
import de.flapdoodle.embed.process.extract.UserTempNaming;
import de.flapdoodle.embed.process.runtime.Network;

/**
 * Hello world!
 *
 */
public class EmbeddedMongoDatabase {

    private MongodExecutable mongodExecutable;
    private MongoClient mongo;

    private String name;
    private List<String> collections;
    private Integer port;

    public EmbeddedMongoDatabase() {
    }

    private void doStuff() {
//        documents.insertOne(new Document("testDoc", new Date()));
//        System.out.println(documents.count());
//        System.out.println(documents.getDocumentClass());
//        FindIterable<Document> cursor = documents.find();
//        cursor.forEach(new Block<Document>() {
//            public void apply(Document t) {
//                System.out.println(t);
//            }
//        });
    }

    public static void main(String[] args) throws UnknownHostException, IOException {

        EmbeddedMongoDatabase demo = new EmbeddedMongoDatabase();
        demo.setPort(10000);
        demo.setName("hola");
        try {
            demo.init();
            demo.doStuff();
        } finally {
            demo.close();
        }
    }

    public void init() throws UnknownHostException, IOException {

        Command command = Command.MongoD;

        IRuntimeConfig runtimeConfig = new RuntimeConfigBuilder().defaults(command)
                .artifactStore(new ArtifactStoreBuilder().defaults(command)
                        .download(new DownloadConfigBuilder().defaultsForCommand(command))
                        .executableNaming(new UserTempNaming()))
                .build();

        // Set storage to get persistence :D
        Storage replication = new Storage("/custom/databaseDir", null, 0);

        IMongodConfig mongodConfig = new MongodConfigBuilder().version(Version.Main.PRODUCTION)
                .net(new Net(port, Network.localhostIsIPv6())).replication(replication).build();

        MongodStarter runtime = MongodStarter.getInstance(runtimeConfig);

        mongodExecutable = runtime.prepare(mongodConfig);
        MongodProcess mongod = mongodExecutable.start();

        mongo = new MongoClient("localhost", port);
        MongoDatabase db = mongo.getDatabase(name);

        // documents = db.getCollection(COLLECTION_NAME);
    }

    public void close() {
        System.out.println(">> CLOSING");
        if (mongo != null) {
            mongo.close();
            System.out.println(">>> CLOSED");
        }
        if (mongodExecutable != null) {
            mongodExecutable.stop();
            System.out.println(">>> STOPPED");
        }
        System.out.println("fin");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCollections() {
        return collections;
    }

    public void setCollections(List<String> collections) {
        this.collections = collections;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

}
