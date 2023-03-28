package com.SberTech.CreditService.Mappers;

public interface IDtoMapper<entity, dto> {

    dto mapToDto(entity entity);
    entity mapToEntity(dto dto);
    entity updateEntity(entity entityForUpdate, dto dto);

}
