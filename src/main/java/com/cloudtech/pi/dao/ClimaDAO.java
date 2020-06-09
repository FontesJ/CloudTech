package com.cloudtech.pi.dao;

import com.cloudtech.pi.domain.Previsao;
import java.util.List;

public interface ClimaDAO {

    void save(Previsao clima);

    void update(Previsao clima);

    void delete(Long id);

    Previsao findById(Long id);

    List<Previsao> findAll();
}
