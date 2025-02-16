package www.vog.spring_boot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import www.vog.models.Filme;
import www.vog.models.Premio;
import www.vog.repository.FilmeRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class FilmeController {

    private final FilmeRepository filmeRepository;

    public FilmeController(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }


    @GetMapping("/cadastrar_filme")
    public String exibirFormularioFilme(Model model) {
        model.addAttribute("filme", new Filme());
        return "cadastrar_filme";
    }


    @PostMapping("/cadastrar_filme")
    public String cadastrarFilme(@ModelAttribute Filme filme, Model model) {
        filmeRepository.save(filme);
        model.addAttribute("filme", filme);
        return "redirect:/listar_filme";
    }


    @GetMapping("/listar_filme")
    public String listarFilmes(Model model) {
        List<Filme> filmes = filmeRepository.findAll();
        model.addAttribute("filmes", filmes);
        return "listar_filme";
    }

    @GetMapping("/deletar_filme/{id}")
    public String deletarFilme(@PathVariable Long id) {
        filmeRepository.deleteById(id);
        return "redirect:/listar_filme";
    }

    @GetMapping("/cadastrar_premio/{id}")
    public String exibirFormularioPremio(@PathVariable Long id, Model model) {
        Filme filme = filmeRepository.findById(id).orElseThrow(() -> new RuntimeException("Filme não encontrado"));
        model.addAttribute("filme", filme);
        model.addAttribute("premio", new Premio());
        return "cadastrar_premio";
    }

    
    @PostMapping("/cadastrar_premio/{id}")
    public String cadastrarPremio(@PathVariable Long id, @ModelAttribute Premio premio, Model model) {
        Filme filme = filmeRepository.findById(id).orElseThrow(() -> new RuntimeException("Filme não encontrado"));
        filme.adicionarPremio(premio);
        filmeRepository.save(filme);
        return "redirect:/listar_filme";
    }


    @GetMapping("/editar_filme/{id}")
    public String exibirFormularioEdicao(@PathVariable Long id, Model model) {
        Optional<Filme> filme = filmeRepository.findById(id);
        if (filme.isPresent()) {
            model.addAttribute("filme", filme.get());
            return "editar_filme";
        } else {
            return "redirect:/listar_filme"; 
        }
    }

    
    @PostMapping("/atualizar_filme/{id}")
    public String atualizarFilme(@PathVariable Long id, @ModelAttribute Filme filmeAtualizado, Model model) {
        Optional<Filme> filmeExistente = filmeRepository.findById(id);
        if (filmeExistente.isPresent()) {
            Filme filme = filmeExistente.get();

            filme.setNome(filmeAtualizado.getNome());
            filme.setDiretor_a(filmeAtualizado.getDiretor_a());
            filme.setEstudio(filmeAtualizado.getEstudio());
            filme.setPais_origem(filmeAtualizado.getPais_origem());
            filme.setGenero(filmeAtualizado.getGenero());
            filme.setClassificacao_indicativa(filmeAtualizado.getClassificacao_indicativa());

            filmeRepository.save(filme);
        }
        return "redirect:/listar_filme";
    }



    @GetMapping("/buscar_filme")
public String buscarFilmePorId(@RequestParam(required = false) Long id, Model model) {
    if (id != null) {
        Optional<Filme> filme = filmeRepository.findById(id);
        if (filme.isPresent()) {
            model.addAttribute("filmes", List.of(filme.get()));
        } else {
            model.addAttribute("filme", List.of());
        }
    } else {
        List<Filme> filmes = filmeRepository.findAll();
        model.addAttribute("filmes", filmes);
    }
    return "listar_filme";
}
}