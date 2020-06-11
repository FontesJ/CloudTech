package com.cloudtech.pi.service;

import com.cloudtech.pi.dao.ClimaDAO;
import com.cloudtech.pi.domain.Previsao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(readOnly= false)
public class ClimaServiceImpl implements ClimaService {

    @Autowired
    private ClimaDAO dao;

    @Override @Transactional(readOnly= false)
    public void salvar(Previsao previsao) {
        dao.save(previsao);
    }

    @Override @Transactional(readOnly= true)
    public void editar(Previsao previsao) {
        dao.update(previsao);
    }

    @Override @Transactional(readOnly= true)
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Override @Transactional(readOnly= true)
    public Previsao buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Override @Transactional(readOnly= true)
    public List<Previsao> buscarTodos() {
        return dao.findAll();
    }
}
