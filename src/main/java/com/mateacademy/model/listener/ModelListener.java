package com.mateacademy.model.listener;

import com.mateacademy.model.entity.Model;
import lombok.extern.log4j.Log4j;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

@Log4j
public class ModelListener<T extends Model> {

    @PrePersist
    public void prePersist(T t) {
        log.info("Pre-Persisting operation: " + t.getName());
    }

    @PostPersist
    public void postPersist(T t) {
        log.info("Post-Persist operation: " + t.getName());
    }

    @PreRemove
    public void preRemove(T t) {
        log.info("Pre-Removing operation: " + t.getName());
    }

    @PostRemove
    public void postRemove(T t) {
        log.info("Post-Remove operation: " + t.getName());
    }

    @PreUpdate
    public void preUpdate(T t) {
        log.info("Pre-Updating operation: " + t.getName());
    }

    @PostUpdate
    public void postUpdate(T t) {
        log.info("Post-Update operation: " + t.getName());
    }
}
