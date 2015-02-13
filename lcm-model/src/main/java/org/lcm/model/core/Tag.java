package org.lcm.model.core;

import org.springframework.data.annotation.Id;

/**
 * Created by abelsromero on 13/02/2015.
 */
// TODO: define how to implement this in mongo
//@Document(collection = "tags")
public class Tag {

    @Id
    private String id;
    private String name;

    private Tag parent;

    public Tag(){}

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

    public Tag getParent() {
        return parent;
    }

    public void setParent(Tag parent) {
        this.parent = parent;
    }

}
