package br.com.mertens.CatalogoVideo.application.usecase.category.delete;

import java.util.UUID;

import org.springframework.stereotype.Component;

import br.com.mertens.CatalogoVideo.domain.repository.ICategoryRepository;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class RemoveCategoryUseCase implements IRemoveCategoryUseCase {

    private ICategoryRepository repository;

    @Override
    public void execute(UUID id) throws Exception {
       repository.remove(id);        
    }
    
}
