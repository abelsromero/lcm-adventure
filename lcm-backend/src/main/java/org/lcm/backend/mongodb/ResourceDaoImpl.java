package org.lcm.backend.mongodb;

import java.util.List;

import org.lcm.backend.ResourceDao;
import org.lcm.model.core.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mongodb.WriteResult;

/**
 * Created by abelsromero on 13/02/2015.
 */
@Repository
public class ResourceDaoImpl implements ResourceDao {

    public static final String COLLECTION_NAME = "Resources";

    @Autowired
    private MongoOperations mongoOps;

    @Override
    public void create(Resource entity) {
        mongoOps.insert(entity);
    }

    @Override
    public Resource findById(String id) {
        return mongoOps.findById(id, Resource.class);
    }

    @Override
    public void update(Resource entity) {
        mongoOps.save(entity);
    }

    @Override
    public void update(String id, Resource entity) {
        if (entity.getId() == null)
            entity.setId(id);
        mongoOps.save(entity);
    }

    @Override
    public void delete(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        // TODO benchmark which one os faster
        WriteResult result = mongoOps.remove(query, Resource.class);
        System.out.println(result);
        // mongoOps.findAndRemove(query,Resource.class);
    }

    @Override
    public List<Resource> findAll() {
        return mongoOps.findAll(Resource.class);
    }
}
