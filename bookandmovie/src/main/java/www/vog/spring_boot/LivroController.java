package www.vog.spring_boot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import www.vog.models.Livro;
import www.vog.repository.LivroRepository;

@Controller
public class LivroController {

    private final LivroRepository livroRepository;

    // Injeta o LivroRepository no construtor
    public LivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @GetMapping("/livroform")
    public String exibirFormulario(Model model) {
        // Adiciona um novo objeto Livro ao modelo para o formulário
        model.addAttribute("livro", new Livro());
        return "index"; // Retorna a view "index" (formulário de cadastro)
    }

    @PostMapping("/livrocadastro")
    public String cadastrarLivro(@ModelAttribute Livro livro, Model model) {
        // Salva o livro no banco de dados usando o LivroRepository
        livroRepository.save(livro);

        // Adiciona o livro ao modelo para exibição na view "teste"
        model.addAttribute("livro", livro);
        return "teste"; // Retorna a view "teste" (página de confirmação)
    }
}