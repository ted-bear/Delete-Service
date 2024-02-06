package ru.digimatics.deleteservice.domain;

import java.io.Serializable;


/**
 * Специальный интерфейс помечающий, что сущность может храниться в БД
 */
public interface BaseEntity<K extends Serializable, T> {

    K getId();

    void setId(K entityId);
}
