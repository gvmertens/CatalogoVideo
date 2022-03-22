package br.com.mertens.CatalogoVideo.application.usecase.category.create;

import org.springframework.stereotype.Component;

import br.com.mertens.CatalogoVideo.application.usecase.category.common.CategoryOutput;
import br.com.mertens.CatalogoVideo.domain.entity.Category;
import br.com.mertens.CatalogoVideo.domain.repository.ICategoryRepository;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CreateCategoryUseCase implements ICreateCategoryUseCase {

    private ICategoryRepository repository;

    @Override
    public CategoryOutput execute(CreateCategoryInputData input) {
        var created = repository.create(toDomain(input));
        return CategoryOutput.fromDomain(created);
    }
    
    private Category toDomain(CreateCategoryInputData input){
        return new Category(input.getName(), input.getDescription(), input.getIsActive());
    }
}
