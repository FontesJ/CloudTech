package com.cloudtech.pi.dao;

import com.cloudtech.pi.domain.Previsao;
import java.util.List;

public interface ClimaDAO {

    void save(Previsao previsao);

    void update(Previsao previsao);

    void delete(Long id);

    Previsao findById(Long id);

    List<Previsao> findAll();
}
