package com.mkalaimalai.common.valueobject;

import lombok.Data;

@Data
public abstract class BaseID<T> {

    private final T value;

}
