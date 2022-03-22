package br.com.mertens.CatalogoVideo.application.usecase.category.create;

import br.com.mertens.CatalogoVideo.application.usecase.category.common.CategoryOutput;

public interface ICreateCategoryUseCase {
    
    CategoryOutput execute(CreateCategoryInputData input);
}
