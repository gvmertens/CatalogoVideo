package br.com.mertens.CatalogoVideo.application.usecase.category.delete;

import java.util.UUID;

public interface IRemoveCategoryUseCase {
    void execute(UUID id) throws Exception;
}
