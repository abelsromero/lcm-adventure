package org.lcm.services;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lcm.backend.ResourceDao;
import org.lcm.backend.mongodb.embedded.EmbeddedMongoDatabase;
import org.lcm.model.core.Resource;
import org.lcm.services.ws.soap.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by abelsr on 11/07/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/META-INF/spring/applicationContext.xml" })
public class BootstrapTest {

    @Autowired
    private ResourcesService services;

    @Autowired
    private ResourceDao dao;

    @Autowired
    private static EmbeddedMongoDatabase db;

    @Test
    public void context_starts() {

        Assert.assertNotNull(services);
        Assert.assertNotNull(dao);

        Resource r = new Resource();
        r.setName("testResource");

        dao.create(r);

        dao.findAll();
        System.out.println(r);

        List<Resource> resources = dao.findAll();
        System.out.println("TOTAL:" +resources.size());
        
        db.close();
    }
    
    @AfterClass
    public static void close () throws InterruptedException {
        // Spring invokes the close method but the proc
//        db.close();
    }

}
