package br.com.mertens.CatalogoVideo.infrastructure.persistence;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.mertens.CatalogoVideo.domain.Exception.NullBlankException;
import br.com.mertens.CatalogoVideo.domain.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryPersistence {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "VARBINARY(16)")
    private UUID id;

    @Column
    @NotNull(message = "nome não pode ser nulo")
    @NotBlank(message = "nome não pode ser branco")
    private String name;

    @Column
    private String description;

    @Column
    private Boolean isActive = true;

    public Category fromThis(){
        return new Category(
            getId(), getName(), getDescription(), getIsActive());
    }

    public static CategoryPersistence from(Category category){
        if(category == null){
            throw new NullBlankException();
        }

        return new CategoryPersistence(
            category.getId(),
            category.getName(),
            category.getDescription(),
            category.getIsActive()
        );
    }

}
