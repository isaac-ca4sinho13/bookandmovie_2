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

    @GetMapping("/livroform")
    public String exibirFormulario(Model model) {
        model.addAttribute("livro", new Livro());
        return "index";
    }

    @PostMapping("/livrocadastro")
    public String cadastrarLivro(@ModelAttribute Livro livro, Model model) {

        livroRepository.save(livro);
        model.addAttribute("livro", livro);
        return "redirect:/listarlivros";
    }

    @GetMapping("/listarlivros")
    public String listarLivros(Model model) {
        List<Livro> livros = livroRepository.findAll();
        model.addAttribute("livros", livros);
        return "listar_livro";
    }

    @GetMapping("/deletarlivro/{id}")
    public String deletarLivro(@PathVariable Long id) {
        livroRepository.deleteById(id); // Deleta o livro pelo ID
        return "redirect:/listarlivros"; // Redireciona para a lista de livros após a exclusão
    }

    @GetMapping("/editarLivro/{id}")
    public String exibirFormularioEdicao(@PathVariable Long id, Model model) {
        Optional<Livro> livro = livroRepository.findById(id); // Busca o livro pelo ID
        if (livro.isPresent()) {
            model.addAttribute("livro", livro.get()); // Passa o livro para a view
            return "editar_livro"; // Página do formulário de edição
        } else {
            return "redirect:/listarlivros"; // Redireciona se o livro não for encontrado
        }
    }

    // Método para processar a atualização do livro
    @PostMapping("/atualizarLivro/{id}")
    public String atualizarLivro(@PathVariable Long id, @ModelAttribute Livro livroAtualizado, Model model) {
        Optional<Livro> livroExistente = livroRepository.findById(id); // Busca o livro pelo ID
        if (livroExistente.isPresent()) {
            Livro livro = livroExistente.get();
            // Atualiza os campos do livro
            livro.setNome(livroAtualizado.getNome());
            livro.setAutor_a(livroAtualizado.getAutor_a());
            livro.setQtd_paginas(livroAtualizado.getQtd_paginas());
            livro.setPais_origem(livroAtualizado.getPais_origem());
            livro.setGenero(livroAtualizado.getGenero());
            livro.setClassificacao_indicativa(livroAtualizado.getClassificacao_indicativa());

            livroRepository.save(livro); // Salva as alterações no banco de dados
        }
        return "redirect:/listarlivros"; // Redireciona para a lista de livros após a atualização
    }
}