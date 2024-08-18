package com.mkalaimalai.common.domain.entity;

import lombok.Data;

import java.util.Objects;


@Data
public abstract class BaseEntity<ID>{
    private ID id;


}
