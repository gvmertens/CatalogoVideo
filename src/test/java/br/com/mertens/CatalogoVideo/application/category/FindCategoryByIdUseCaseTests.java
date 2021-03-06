package br.com.mertens.CatalogoVideo.application.category;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.mertens.CatalogoVideo.application.exception.NotFoundException;
import br.com.mertens.CatalogoVideo.application.usecase.category.common.CategoryOutput;
import br.com.mertens.CatalogoVideo.application.usecase.category.findbyid.FindCategoryByIdUseCase;
import br.com.mertens.CatalogoVideo.domain.entity.Category;
import br.com.mertens.CatalogoVideo.domain.repository.ICategoryRepository;

@ExtendWith(SpringExtension.class)
public class FindCategoryByIdUseCaseTests {
   
    @InjectMocks
    private FindCategoryByIdUseCase useCase;

    @Mock
    private ICategoryRepository repository;

    @BeforeEach
    void initUseCase(){
        useCase = new FindCategoryByIdUseCase(repository);
    }

    @Test
    public void executeReturnFindCategoryById() {
        Category category = new Category("Action", "Action Description", true);

        Optional<Category> opCategory = Optional.of(category);

        when(repository.findById(category.getId())).thenReturn(opCategory);

        CategoryOutput actual = useCase.execute(category.getId());
        repository.findById(category.getId());

        assertThat(opCategory).isNotNull();
        

        assertThat(actual).isNotNull();
    }

    @Test
    public void throwNotFoundExceptionWhenUUIDNotExists() {

        assertThrows(NotFoundException.class, () -> {
            CategoryOutput actual = useCase.execute(UUID.fromString("123e4567-e89b-12d3-a456-556642440000"));
        });
    }
}
