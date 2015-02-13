package org.lcm.model.core;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by abelsromero on 13/02/2015.
 */
@Document(collection = "resources")
public class Resource {

    @Id
    private String id;
    private String name;

    private List<Tag> tags;

    // a resource may have one or more contents, but currently not shown in the DTOs
    // private List<Content> contents;

    public Resource(){}

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

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

}
