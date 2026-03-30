package com.example.estatisticas_service.estatisticas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/estatisticas")
public class EstatisticasController {

    @GetMapping("/jogadores")
    public String getEstatisticasJogadores() {
        // Lógica para calcular estatísticas dos jogadores
        return "Estatísticas dos jogadores";
    }
}
