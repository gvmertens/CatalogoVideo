package br.com.mertens.CatalogoVideo.application.usecase.category.findbyid;

import java.util.UUID;

import br.com.mertens.CatalogoVideo.application.usecase.category.common.CategoryOutput;

public interface IFindCategorybyIdUseCase {
    CategoryOutput execute(UUID id) throws Exception;
}
