package br.com.mertens.CatalogoVideo.application.category;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.mertens.CatalogoVideo.application.usecase.category.update.UpdateCategoryInputData;
import br.com.mertens.CatalogoVideo.application.usecase.category.update.UpdateCategoryUseCase;
import br.com.mertens.CatalogoVideo.domain.entity.Category;
import br.com.mertens.CatalogoVideo.domain.repository.ICategoryRepository;

@ExtendWith(SpringExtension.class)
public class UpdateCategoryUseCaseTests {
    
    @InjectMocks
    private UpdateCategoryUseCase useCase;

    @Mock
    private ICategoryRepository repository;

    @BeforeEach
    void initUseCase(){
        useCase = new UpdateCategoryUseCase(repository);
    }

    @Test
    public void executeReturnUpdatedCategory() throws Exception{
        Category category = new Category("Action", "Action Description", true);
        Category expected = new Category("Action 2", "Description", true);

        Optional<Category> opCategory = Optional.of(category);

        when(repository.findById(category.getId())).thenReturn(opCategory);

        UpdateCategoryInputData input = new UpdateCategoryInputData();
        input.setName("Action 2");
        input.setDescription("Description");

        category.update(input.getName(), 
            input.getDescription(), input.getIsActive());

        doNothing().when(repository).update(category);

        useCase.execute(category.getId(), input);

        assertThat(category).isNotNull();
        
        assertThat(category.getName()).isEqualTo(expected.getName());
        
    }

}
