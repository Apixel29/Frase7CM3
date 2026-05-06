package com.ipn.mx.frases.application.impl;

import com.ipn.mx.frases.application.FraseService;
import com.ipn.mx.frases.domain.entities.Frase;
import com.ipn.mx.frases.domain.repository.FraseRepository;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Stream;

@Service
public class FraseServiceImpl implements FraseService {
    @Autowired
    private FraseRepository dao;

    @Override
    @Transactional(readOnly = true)
    public List<Frase> findAll() {
        return dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Frase findById(Long id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Frase save(Frase frase) {
        return dao.save(frase);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        dao.deleteById(id);
    }

    @Override
    public ByteArrayInputStream reportePDF(List<Frase> Frases) {
        Document documento = new Document();
        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        try{
            PdfWriter.getInstance(documento, salida);
            documento.open();
            Font tipoLetra = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLUE);
            Paragraph parrafo = new Paragraph("Lista de Frases", tipoLetra);
            documento.add(parrafo);
            documento.add(Chunk.NEWLINE);

            Font tipoLetraTexto = FontFactory.getFont(FontFactory.HELVETICA, 10, BaseColor.BLUE);
            PdfPTable tabla = new PdfPTable(5);
            Stream.of("Id Frase", "Texto", "Autor")
                    .forEach(encabezados -> {
                        PdfPCell encabezadosTabla = new PdfPCell();
                        Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 9, BaseColor.BLUE);
                        encabezadosTabla.setHorizontalAlignment(Element.ALIGN_CENTER);
                        encabezadosTabla.setVerticalAlignment(Element.ALIGN_CENTER);
                        encabezadosTabla.setBorder(1);
                        encabezadosTabla.setPhrase(new Phrase(encabezados, headerFont));
                        tabla.addCell(encabezadosTabla);
                    });
            for(Frase frase : Frases){
                PdfPCell celdaId = new PdfPCell(
                        new Phrase(String.valueOf(frase.getId()), tipoLetraTexto)
                );
                celdaId.setHorizontalAlignment(Element.ALIGN_CENTER);
                celdaId.setVerticalAlignment(Element.ALIGN_MIDDLE);
                celdaId.setBorder(1);
                tabla.addCell(celdaId);

                PdfPCell celdaTexto = new PdfPCell(
                        new Phrase(frase.getAutor(),  tipoLetraTexto)
                );
                celdaTexto.setHorizontalAlignment(Element.ALIGN_CENTER);
                celdaTexto.setVerticalAlignment(Element.ALIGN_MIDDLE);
                celdaTexto.setBorder(1);
                tabla.addCell(celdaTexto);

                PdfPCell celdaAutor = new PdfPCell(
                        new Phrase(frase.getAutor(),  tipoLetraTexto)
                );
                celdaAutor.setHorizontalAlignment(Element.ALIGN_CENTER);
                celdaAutor.setVerticalAlignment(Element.ALIGN_MIDDLE);
                celdaAutor.setBorder(1);
                tabla.addCell(celdaAutor);
            }
            documento.add(tabla);
            documento.close();
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
