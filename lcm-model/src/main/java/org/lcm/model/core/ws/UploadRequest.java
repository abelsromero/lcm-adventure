package org.lcm.model.core.ws;

import javax.activation.DataHandler;

/**
 * User: abelsromero
 * Date: 12/02/15
 */
public class UploadRequest {

    private String filename;
    private String mimeType;
    private DataHandler content;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public DataHandler getContent() {
        return content;
    }

    public void setContent(DataHandler content) {
        this.content = content;
    }
}
