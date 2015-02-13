package org.lcm.services.ws.soap;

import org.lcm.model.core.Content;
import org.lcm.model.core.Resource;
import org.springframework.stereotype.Service;

import javax.activation.DataHandler;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by abelsromero on 13/02/2015.
 */
@Service
@WebService(portName = "resources",
        serviceName = "resourcesService",
        targetNamespace = Namespaces.BASE,
        endpointInterface = "org.lcm.services.ws.soap.ResourcesService")
public class ResourcesServiceImpl implements ResourcesService {

    @Override
    public String create(Resource resource) {
        return null;
    }

    @Override
    public String create(Resource resource, List<Content> contents) {
        return null;
    }

    @Override
    public String get(String id) {
        return null;
    }

    @Override
    public List<Content> getContents(DataHandler content) {
        return null;
    }

    @Override
    public Content getContentById(String contentId) {
        return null;
    }

    @Override
    public List<Resource> search(String condition) {
        return null;
    }

}
