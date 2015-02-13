package org.lcm.model.core;

import org.springframework.data.annotation.Id;

import javax.activation.DataHandler;

/**
 * Created by abelsromero on 13/02/2015.
 */
// TODO: see how to handle binary data
//@Document(collection = "contents")
public class Content {

    @Id
    private String id;
    private String name;

    private DataHandler data;

    public Content(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DataHandler getData() {
        return data;
    }

    public void setData(DataHandler data) {
        this.data = data;
    }

}
