package br.com.mertens.CatalogoVideo.application.usecase.category.update;

import java.util.UUID;

import org.springframework.stereotype.Component;

import br.com.mertens.CatalogoVideo.application.exception.NotFoundException;
import br.com.mertens.CatalogoVideo.domain.entity.Category;
import br.com.mertens.CatalogoVideo.domain.repository.ICategoryRepository;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UpdateCategoryUseCase implements IUpdateUseCase {

    private ICategoryRepository repository;

    @Override
    public void execute(UUID id, UpdateCategoryInputData input) {
        Category category = repository.findById(id).orElseThrow(() -> new NotFoundException("Category %s Not Found", id));
        category.update(input.getName(), input.getDescription(), input.getIsActive());
        repository.update(category);
    }
    
}
