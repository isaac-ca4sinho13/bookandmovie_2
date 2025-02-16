package www.vog.spring_boot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import www.vog.models.Livro;
import www.vog.repository.LivroRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class LivroController {

    private final LivroRepository livroRepository;

    public LivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @GetMapping("/cadastrar_livro")
    public String exibirFormulario(Model model) {
        model.addAttribute("livro", new Livro());
        return "cadastrar_livro";
    }

    @PostMapping("/cadastrar_livro")
    public String cadastrarLivro(@ModelAttribute Livro livro, Model model) {

        livroRepository.save(livro);
        model.addAttribute("livro", livro);
        return "redirect:/listar_livro";
    }

    @GetMapping("/listar_livro")
    public String listarLivros(Model model) {
        List<Livro> livros = livroRepository.findAll();
        model.addAttribute("livros", livros);
        return "listar_livro";
    }

    @GetMapping("/deletar_livro/{id}")
    public String deletarLivro(@PathVariable Long id) {
        livroRepository.deleteById(id);
        return "redirect:/listar_livro";
    }

    @GetMapping("/editar_livro/{id}")
    public String exibirFormularioEdicao(@PathVariable Long id, Model model) {
        Optional<Livro> livro = livroRepository.findById(id);
        if (livro.isPresent()) {
            model.addAttribute("livro", livro.get());
            return "editar_livro";
        } else {
            return "redirect:/listar_livro"; 
        }
    }

    
    @PostMapping("/atualizar_livro/{id}")
    public String atualizarLivro(@PathVariable Long id, @ModelAttribute Livro livroAtualizado, Model model) {
        Optional<Livro> livroExistente = livroRepository.findById(id);
        if (livroExistente.isPresent()) {
            Livro livro = livroExistente.get();

            livro.setNome(livroAtualizado.getNome());
            livro.setAutor_a(livroAtualizado.getAutor_a());
            livro.setQtd_paginas(livroAtualizado.getQtd_paginas());
            livro.setPais_origem(livroAtualizado.getPais_origem());
            livro.setGenero(livroAtualizado.getGenero());
            livro.setClassificacao_indicativa(livroAtualizado.getClassificacao_indicativa());

            livroRepository.save(livro);
        }
        return "redirect:/listar_livro";
    }


@GetMapping("/buscar_livro")
public String buscarLivroPorId(@RequestParam(required = false) Long id, Model model) {
    if (id != null) {
        Optional<Livro> livro = livroRepository.findById(id);
        if (livro.isPresent()) {
            model.addAttribute("livros", List.of(livro.get()));
        } else {
            model.addAttribute("livros", List.of());
        }
    } else {
        List<Livro> livros = livroRepository.findAll();
        model.addAttribute("livros", livros);
    }
    return "listar_livro";
}
}