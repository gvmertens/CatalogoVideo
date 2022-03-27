package br.com.mertens.CatalogoVideo.application.usecase.category.findbyid;

import java.util.UUID;

import org.springframework.stereotype.Component;

import br.com.mertens.CatalogoVideo.application.exception.NotFoundException;
import br.com.mertens.CatalogoVideo.application.usecase.category.common.CategoryOutput;
import br.com.mertens.CatalogoVideo.domain.repository.ICategoryRepository;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class FindCategoryByIdUseCase implements IFindCategorybyIdUseCase {

    private ICategoryRepository repository;

    @Override
    public CategoryOutput execute(UUID id) {
        return repository.findById(id).map(
            CategoryOutput::fromDomain
        ).orElseThrow(() -> new NotFoundException("Category %s Not Found", id));
    }
    
}
