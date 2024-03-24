package com.adamant.orderapi.util;

import org.modelmapper.ModelMapper;

public class ModelUtility {
  private static final ModelMapper modelMapper = new ModelMapper();

  public static <T> T mapDtoToEntity(Object dtoObj, Class<T> entityClassType) {
    if (dtoObj != null) {
      return modelMapper.map(dtoObj, entityClassType);
    }
    return null;
  }
}
