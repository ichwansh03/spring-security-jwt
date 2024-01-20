package com.ichwan.spring.service;

import java.util.List;
import java.util.stream.Stream;

public interface BaseService<R, T, ID> {

    R save(T t);

    R findById(ID id);

    void deleteById(ID id);

    R update(T t, ID id);

    List<R> findAll();
}
