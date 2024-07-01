package com.mkalaimalai.common.domain;

import lombok.Data;

@Data
public abstract class AggregateRoot<ID> extends BaseEntity<ID> {
}
