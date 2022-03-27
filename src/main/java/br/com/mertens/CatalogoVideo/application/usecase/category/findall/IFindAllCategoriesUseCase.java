package br.com.mertens.CatalogoVideo.application.usecase.category.findall;

import java.util.List;

import br.com.mertens.CatalogoVideo.application.usecase.category.common.CategoryOutput;

public interface IFindAllCategoriesUseCase {
    List<CategoryOutput> execute();
}
