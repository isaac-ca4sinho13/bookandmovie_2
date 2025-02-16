package www.vog.spring_boot;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MeuErroController implements ErrorController {

    @RequestMapping(value = "/erro", method = {RequestMethod.GET, RequestMethod.POST})
    public String mostrarErro(Model model, HttpServletRequest request) {
        // Captura o status do erro
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        Integer statusCode = (status != null) ? Integer.valueOf(status.toString()) : null;

        // Captura a mensagem do erro (se houver)
        Object message = request.getAttribute(RequestDispatcher.ERROR_MESSAGE);
        String errorMessage = (message != null) ? message.toString() : "Nenhuma mensagem disponível";

        // Captura a exceção (se houver)
        Object exceptionObj = request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
        String exceptionMessage = (exceptionObj != null) ? exceptionObj.toString() : "Nenhuma exceção disponível";

        // Adiciona os detalhes do erro ao modelo
        model.addAttribute("statusCode", statusCode);
        model.addAttribute("errorMessage", errorMessage);
        model.addAttribute("exceptionMessage", exceptionMessage);

        return "erro"; // Nome da view (erro.html)
    }
}


