package com.eschool.schoolpage.dtos;

import java.time.LocalDateTime;
import java.util.List;

public record RecordCrearContenido(Long idMateria, String titulo, String detalleContenido, String archivo, List<FileObject> fileObjectList) {
}
