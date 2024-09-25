package pe.edu.cibertec.cl1_backendjossetgutierrez.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.cl1_backendjossetgutierrez.dto.PlacaRequestDTO;
import pe.edu.cibertec.cl1_backendjossetgutierrez.dto.PlacaResponseDTO;
import pe.edu.cibertec.cl1_backendjossetgutierrez.service.PlacaService;

@RestController
@RequestMapping("/placa")
public class PlacaController {
    @Autowired
    private PlacaService placaService;

    @PostMapping("/datos")
    public PlacaResponseDTO validarPlaca(@RequestBody PlacaRequestDTO placaRequest) {
        System.out.println("request = " + placaRequest);
        try {
            String[] datosVehiculos = placaService.validarPlaca(placaRequest);
            if (datosVehiculos == null) {
                return new PlacaResponseDTO(
                "01",
                "ERROR: Placa no encontrada",
                "",
                "",
                "",
                "",
                "");
            }
            return new PlacaResponseDTO(
                "00",
                "",
                datosVehiculos[0],
                datosVehiculos[1],
                datosVehiculos[2],
                datosVehiculos[3],
                datosVehiculos[4]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new PlacaResponseDTO(
                "99",
                "ERROR: Error validando placa",
                "",
                "",
                "",
                "",
                "");
        }
    }
}
