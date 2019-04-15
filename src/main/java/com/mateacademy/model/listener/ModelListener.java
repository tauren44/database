package com.mateacademy.model.listener;

import com.mateacademy.model.entity.Model;
import org.apache.log4j.Logger;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class ModelListener<T extends Model> {
    private static final Logger LOGGER = Logger.getLogger(ModelListener.class);

    @PrePersist
    public void prePersist(T t) {
        LOGGER.info("Pre-Persisting operation: " + t.getName());
    }

    @PostPersist
    public void postPersist(T t) {
        System.out.println("Post-Persist operation: " + t.getName());
    }

    @PreRemove
    public void preRemove(T t) {
        System.out.println("Pre-Removing operation: " + t.getName());
    }

    @PostRemove
    public void postRemove(T t) {
        System.out.println("Post-Remove operation: " + t.getName());
    }

    @PreUpdate
    public void preUpdate(T t) {
        System.out.println("Pre-Updating operation: " + t.getName());
    }

    @PostUpdate
    public void postUpdate(T t) {
        System.out.println("Post-Update operation: " + t.getName());
    }
}
