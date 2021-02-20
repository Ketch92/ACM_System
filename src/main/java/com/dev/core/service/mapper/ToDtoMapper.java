package com.dev.core.service.mapper;

public interface ToDtoMapper<E, D> {
    D mapToDto(E entity);
}
