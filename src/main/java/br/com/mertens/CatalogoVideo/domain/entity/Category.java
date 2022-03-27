package br.com.mertens.CatalogoVideo.domain.entity;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import br.com.mertens.CatalogoVideo.domain.Exception.NullBlankException;

public class Category {

    private UUID id;

    private String name;

    private String description;

    private Boolean isActive = true;

    public Category(UUID id, String name, String description) {
        this.setId(id);
        this.setName(name);
        this.setDescription(description);
    }

    public Category(String name, String description) {
        this.setId(UUID.randomUUID());
        this.setName(name);
        this.setDescription(description);
    }

    public Category(String name, String description, Boolean isActive) {
        this.setId(UUID.randomUUID());
        this.setName(name);
        this.setDescription(description);
        if(isActive){
            this.activate();
        } else {
            this.deactivate();
        }
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (StringUtils.isBlank(name)) {
            throw new NullBlankException("Name cannot be null or blank");
        }
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isIsActive() {
        return this.isActive;
    }

    public Boolean getIsActive() {
        return this.isActive;
    }

    public Boolean activate() {
        return this.isActive = true;
    }

    public Boolean deactivate() {
        return this.isActive = false;
    }

    public void update(String name, String description, Boolean isActive) {
        this.setName(name);
        this.setDescription(description);
        if(isActive != null && !isActive.equals(this.getIsActive())){
            if(isActive){
                this.activate();
            } else {
                this.deactivate();
            }
        }
    }

}
