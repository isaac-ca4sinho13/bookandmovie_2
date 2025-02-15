package www.vog.dao;

import org.springframework.stereotype.Repository;
import www.vog.models.Livro;
import www.vog.repository.LivroRepository;

@Repository
public class LivroDAO {
    private final LivroRepository livroRepository;

    public LivroDAO(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public void create(Livro livro) {
        
        livroRepository.save(livro);
    }
}
