package org.lcm.services.ws.soap;

import org.lcm.services.ws.soap.schema.UploadRequest;
import org.lcm.services.ws.soap.schema.UploadResponse;
import org.springframework.stereotype.Service;

import javax.activation.DataHandler;
import javax.jws.WebService;

/**
 * User: abelsromero
 * Date: 12/02/15
 */
@Service
@WebService(portName = "documents",
        serviceName = "documentsService",
        targetNamespace = "http://lcm.org/services/ws",
        endpointInterface = "org.lcm.services.ws.soap.Documents")
public class DocumentsImpl implements Documents {

    @Override
    public UploadResponse upload(UploadRequest request) {
        UploadResponse response = new UploadResponse();
        response.setId("12345678");
        return response;
    }

    @Override
    public String simpleUpload(UploadRequest request) {
        return "1234-simple";
    }

    @Override
    public String plainUpload(String filename, String mimeType, DataHandler content) {
        return "1234-plain";
    }

}
