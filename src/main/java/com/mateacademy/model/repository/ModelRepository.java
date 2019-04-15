package com.mateacademy.model.repository;

import com.mateacademy.model.entity.Model;

public interface ModelRepository<T extends Model> {

    T create(T t);

    T update(T t);

    T read(Long id);

    void delete(T t);

    void close();
}
