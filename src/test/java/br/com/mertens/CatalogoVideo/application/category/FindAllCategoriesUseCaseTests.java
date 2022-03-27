package br.com.mertens.CatalogoVideo.application.category;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

import br.com.mertens.CatalogoVideo.application.usecase.category.common.CategoryOutput;
import br.com.mertens.CatalogoVideo.application.usecase.category.findall.FindAllCategoriesUseCase;
import br.com.mertens.CatalogoVideo.domain.entity.Category;
import br.com.mertens.CatalogoVideo.domain.repository.ICategoryRepository;

@ExtendWith(SpringExtension.class)
public class FindAllCategoriesUseCaseTests {
    
    @InjectMocks
    private FindAllCategoriesUseCase useCase;

    @Mock
    private ICategoryRepository repository;

    @BeforeEach
    void initUseCase(){
        useCase = new FindAllCategoriesUseCase(repository);
    }

    @Test
    public void executeReturnFindAllCAtegories(){
        List<Category> categories = Arrays.asList(
            new Category("Action", "Action Description", true),
            new Category("Horror", "Horror Description", true),
            new Category("Suspense", "Suspense Description", true)
        );

        when(repository.findAll()).thenReturn(categories);

        List<CategoryOutput> actual = useCase.execute();

        assertThat(categories).isNotNull();
        assertThat(categories).hasSize(3);
        verify(repository, times(1)).findAll();

        assertThat(actual).isNotNull();
    }
}
