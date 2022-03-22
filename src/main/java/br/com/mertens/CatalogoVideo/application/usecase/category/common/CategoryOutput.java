package br.com.mertens.CatalogoVideo.application.usecase.category.common;

import java.util.UUID;

import br.com.mertens.CatalogoVideo.domain.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryOutput {
    
    private UUID id;

    private String name;

    private String description;

    private Boolean isActive;

    public static CategoryOutput fromDomain(Category domain){
        return new CategoryOutput(domain.getId(), domain.getName(), domain.getDescription(), domain.getIsActive());
    }


}
