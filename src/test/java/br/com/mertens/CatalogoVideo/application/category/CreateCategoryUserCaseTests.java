package br.com.mertens.CatalogoVideo.application.category;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.mertens.CatalogoVideo.application.usecase.category.common.CategoryOutput;
import br.com.mertens.CatalogoVideo.application.usecase.category.create.CreateCategoryInputData;
import br.com.mertens.CatalogoVideo.application.usecase.category.create.CreateCategoryUseCase;
import br.com.mertens.CatalogoVideo.domain.entity.Category;
import br.com.mertens.CatalogoVideo.domain.repository.ICategoryRepository;

@ExtendWith(SpringExtension.class)
public class CreateCategoryUserCaseTests {

    @InjectMocks
    private CreateCategoryUseCase useCase;

    @Mock
    private ICategoryRepository repository;

    @BeforeEach
    void initUseCase(){
        useCase = new CreateCategoryUseCase(repository);
    }

    @Test
    public void executeReturnCreatedCategory(){
        Category category = new Category("Action", "Action Category");

        when(repository.create(any(Category.class)))
        .thenReturn(category);

        CreateCategoryInputData input = new CreateCategoryInputData(
            category.getName(),
            category.getDescription(),
            category.getIsActive()
        );

        CategoryOutput actual = useCase.execute(input);
        repository.create(category);

        assertThat(actual.getName()).isEqualTo(category.getName());

    }
   
}
