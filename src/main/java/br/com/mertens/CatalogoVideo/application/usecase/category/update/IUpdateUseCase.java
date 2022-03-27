package br.com.mertens.CatalogoVideo.application.usecase.category.update;

import java.util.UUID;

public interface IUpdateUseCase {
    void execute(UUID id, UpdateCategoryInputData input);
}
