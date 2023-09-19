/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.my_company.eapp.util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class AddMapperAnnotation {

    public static void main(String[] args) throws IOException {
        // Ruta del directorio donde se encuentran las interfaces de mappers generadas
        String directoryPath = "src/main/java/com/my_company/eapp/dao";

        // Obtén una lista de todos los archivos en el directorio
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".java")) {
                    // Lee el contenido del archivo
                    List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);

                    // Verifica si la anotación @Mapper ya está presente
                    boolean hasMapperAnnotation = lines.stream().anyMatch(line -> line.contains("@Mapper"));

                    if (!hasMapperAnnotation) {
                        // Agrega la anotación @Mapper justo antes de la declaración de la interfaz
                        for (int i = 0; i < lines.size(); i++) {
                            if (lines.get(i).startsWith("public interface")) {
                                lines.add(i, "import org.apache.ibatis.annotations.Mapper;");
                                lines.add(i + 1, "@Mapper");
                                break;
                            }
                        }

                        // Escribe las líneas modificadas de vuelta al archivo
                        Files.write(file.toPath(), lines, StandardCharsets.UTF_8);
                    }
                }
            }
        }
    }
}

