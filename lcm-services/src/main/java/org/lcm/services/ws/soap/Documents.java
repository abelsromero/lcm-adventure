package org.lcm.services.ws.soap;

import org.lcm.services.ws.soap.schema.UploadRequest;
import org.lcm.services.ws.soap.schema.UploadResponse;

import javax.activation.DataHandler;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * User: abelsromero
 * Date: 12/02/15
 */
@WebService
public interface Documents {

    @WebMethod(action = "http://lcm.org/services/translator/ws/upload")
    @WebResult(targetNamespace = "http://lcm.org/services/translator/ws/schema")
    @ResponseWrapper(targetNamespace = "http://lcm.org/services/translator/ws/schema")
    @RequestWrapper(targetNamespace = "http://lcm.org/services/translator/ws/schema")
    UploadResponse upload(@WebParam(name = "request")UploadRequest request);

    @WebResult(targetNamespace = "http://lcm.org/services/translator/ws/schema")
    @RequestWrapper(targetNamespace = "http://lcm.org/services/translator/ws/schema")
    String simpleUpload(UploadRequest request);

    @WebResult(targetNamespace = "http://anotes.org/services/translator/ws/schema")
    @RequestWrapper(targetNamespace = "http://anotes.org/services/translator/ws/schema")
    String plainUpload(@WebParam(name = "filename") String filename, @WebParam(name = "mimeType")String mimeType, @WebParam(name = "content")DataHandler content);
}
