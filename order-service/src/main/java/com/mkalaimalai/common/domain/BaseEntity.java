package com.mkalaimalai.common.domain;

import lombok.Data;

@Data
public abstract class BaseEntity<ID> {

    private ID id;
}
