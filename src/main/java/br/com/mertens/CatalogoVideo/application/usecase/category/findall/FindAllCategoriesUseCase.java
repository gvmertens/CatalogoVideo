package br.com.mertens.CatalogoVideo.application.usecase.category.findall;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.mertens.CatalogoVideo.application.usecase.category.common.CategoryOutput;
import br.com.mertens.CatalogoVideo.domain.repository.ICategoryRepository;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class FindAllCategoriesUseCase implements IFindAllCategoriesUseCase {

    private ICategoryRepository repository;

    @Override
    public List<CategoryOutput> execute() {
        var list = repository.findAll();
        return list.stream()
                .map(c -> CategoryOutput.fromDomain(c))
                .collect(Collectors.toList());
    }
    
}
