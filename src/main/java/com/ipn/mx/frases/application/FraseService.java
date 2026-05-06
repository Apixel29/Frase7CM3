package com.ipn.mx.frases.application;

import com.ipn.mx.frases.domain.entities.Frase;

import java.io.ByteArrayInputStream;
import java.util.List;

public interface FraseService {
    public List<Frase> findAll();
    public Frase findById(Long id);

    //Lo usaremos para guardar o actualizar
    public Frase save(Frase frase);
    public void deleteById(Long id);

    public ByteArrayInputStream reportePDF(List<Frase> Frases);
}

