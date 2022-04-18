package br.com.mertens.CatalogoVideo.infrastructure.data;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mertens.CatalogoVideo.infrastructure.persistence.CategoryPersistence;

public interface SpringDataCategoryRepository extends JpaRepository<CategoryPersistence, UUID> {
    
}
