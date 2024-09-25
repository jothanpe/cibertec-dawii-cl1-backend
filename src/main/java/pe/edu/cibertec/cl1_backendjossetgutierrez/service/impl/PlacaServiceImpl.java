package pe.edu.cibertec.cl1_backendjossetgutierrez.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.cl1_backendjossetgutierrez.dto.PlacaRequestDTO;
import pe.edu.cibertec.cl1_backendjossetgutierrez.service.PlacaService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class PlacaServiceImpl implements PlacaService {

    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    public String[] validarPlaca(PlacaRequestDTO placaRequest) throws IOException {
        String[] datosPlaca = null;
        Resource resource = resourceLoader.getResource("classpath:vehiculos.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (placaRequest.placa().equals(datos[1])) {
                    datosPlaca = new String[5];
                    datosPlaca[0] = datos[2];
                    datosPlaca[1] = datos[3];
                    datosPlaca[2] = datos[4];
                    datosPlaca[3] = datos[5];
                    datosPlaca[4] = datos[6];
                    break;
                }
            }
        } catch (IOException e) {
            datosPlaca = null;
            throw new IOException(e);
        }
        return datosPlaca;
    }
}
