package com.dev.core.service.mapper;

public interface ToEntityMapper<D, E> {
    E mapToEntity(D dto);
}
