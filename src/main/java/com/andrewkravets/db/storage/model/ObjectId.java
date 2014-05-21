package com.andrewkravets.db.storage.model;

import java.io.Serializable;

/**
 * Created by andrey.kravets on 5/20/2014.
 */
public class ObjectId implements Serializable {

    final Long id;

    public ObjectId() {
        this.id = System.nanoTime();
    }

    @Override
    public String toString() {
        return Long.toString(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ObjectId objectId = (ObjectId) o;

        if (!id.equals(objectId.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
