package com.mateacademy.model.repository;

import com.mateacademy.model.entity.Model;

public interface ModelRepository<T extends Model> {

    T create(T item);

    T update(T item);

    T read(Long id);

    void delete(T item);

    void close();
}
