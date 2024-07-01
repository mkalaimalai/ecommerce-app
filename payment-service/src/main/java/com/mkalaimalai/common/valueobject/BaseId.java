package com.mkalaimalai.common.valueobject;

import lombok.Data;

@Data
public abstract class BaseId<T> {

   private final T value;
}
