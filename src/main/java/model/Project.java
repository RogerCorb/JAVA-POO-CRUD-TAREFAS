package model;

import java.util.Date;

public class Project {
    
    // estes são os atributos da classe que definimos no projeto
    // e que formaram o banco de dados 
    private int id;
    private String name;
    private String descripition;
    private Date createdAt;
    private Date updatedAt;

    // o modo construtor criado abaixo da classe Project 
    public Project(int id, String name, String descripition, Date createdAt,Date updatedAt) {
        this.id = id;
        this.name = name;
        this.descripition = descripition;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Project() {
        this.id = id;
        this.name = name;
        this.descripition = descripition;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    // getter and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripition() {
        return descripition;
    }

    public void setDescripition(String descripition) {
        this.descripition = descripition;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    // To String

    @Override
    public String toString() {
        return "Project{" + "id=" + id + ", name=" + name + ", descripition="
                + descripition + ", createdAt=" + createdAt + ", updatedAt="
                + updatedAt + '}';
    }    
}
