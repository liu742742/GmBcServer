package com.entity;

public class Contract {
    private Integer id;

    private String date;

    private String publisher;

    private String name;

    private String description;

    private String address;

    private String type;

    private String artifact;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getArtifact() {
        return artifact;
    }

    public void setArtifact(String artifact) {
        this.artifact = artifact == null ? null : artifact.trim();
    }

    @Override
    public String toString() {
        return "Contract={" + "id=" + id + ", date='" + date + '\'' + ", publisher=" + publisher + ", name="
                + name + ", description=" + description + ", address=" + address + ", type=" + type + ",artifact="+artifact+"}";
    }
}