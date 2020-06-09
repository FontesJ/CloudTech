package com.cloudtech.pi.service;

import com.cloudtech.pi.domain.Previsao;
import java.util.List;

public interface ClimaService {

    void salvar(Previsao clima);

    void editar (Previsao clima);

    void excluir(Long id);

    Previsao buscarPorId(Long id);

    List<Previsao> buscarTodos();
}
