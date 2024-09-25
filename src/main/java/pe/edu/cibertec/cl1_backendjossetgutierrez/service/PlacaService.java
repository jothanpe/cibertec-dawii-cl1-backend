package pe.edu.cibertec.cl1_backendjossetgutierrez.service;
import pe.edu.cibertec.cl1_backendjossetgutierrez.dto.PlacaRequestDTO;
import java.io.IOException;

public interface PlacaService {
    String[] validarPlaca(PlacaRequestDTO placaRequest) throws IOException;
}
