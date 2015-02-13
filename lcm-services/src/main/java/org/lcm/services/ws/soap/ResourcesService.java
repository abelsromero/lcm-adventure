package org.lcm.services.ws.soap;

import org.lcm.model.core.Content;
import org.lcm.model.core.Resource;

import javax.activation.DataHandler;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import java.util.List;

/**
 * Created by abelsromero on 13/02/2015.
 */
@WebService
public interface ResourcesService {

    @WebResult(targetNamespace = Namespaces.BASE)
    @RequestWrapper(targetNamespace = Namespaces.BASE)
    String create(@WebParam(name = "resource")Resource resource);

    @WebResult(targetNamespace = Namespaces.BASE)
    @RequestWrapper(targetNamespace = Namespaces.BASE)
    String create(@WebParam(name = "resource")Resource resource, @WebParam(name = "contents")List<Content> contents);

    @WebResult(targetNamespace = Namespaces.BASE)
    @RequestWrapper(targetNamespace = Namespaces.BASE)
    String get(@WebParam(name = "content")String id);

    @WebResult(targetNamespace = Namespaces.BASE)
    @RequestWrapper(targetNamespace = Namespaces.BASE)
    List<Content> getContents(@WebParam(name = "content")DataHandler content);

    @WebResult(targetNamespace = Namespaces.BASE)
    @RequestWrapper(targetNamespace = Namespaces.BASE)
    Content getContentById(@WebParam(name = "contentId")String contentId);

    @WebResult(targetNamespace = Namespaces.BASE)
    @RequestWrapper(targetNamespace = Namespaces.BASE)
    List<Resource> search (@WebParam(name = "condition") String condition);

}
