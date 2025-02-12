package com.artur.estoqueapi.mappers.impl;

import com.artur.estoqueapi.domain.dto.stock.ItemCategoryDto;
import com.artur.estoqueapi.domain.entities.stock.ItemCategoryEntity;
import com.artur.estoqueapi.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ItemCategoryMapperImpl implements Mapper<ItemCategoryEntity, ItemCategoryDto> {

    private ModelMapper modelMapper;

    public ItemCategoryMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ItemCategoryDto mapTo(ItemCategoryEntity itemCategoryEntity) {
        return modelMapper.map(itemCategoryEntity, ItemCategoryDto.class);
    }

    @Override
    public ItemCategoryEntity mapFrom(ItemCategoryDto itemCategoryDto) {
        return modelMapper.map(itemCategoryDto, ItemCategoryEntity.class);
    }

}