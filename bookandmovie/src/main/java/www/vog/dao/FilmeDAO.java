package www.vog.dao;

import org.springframework.stereotype.Repository;
import www.vog.models.Filme;
import www.vog.repository.FilmeRepository;

@Repository
public class FilmeDAO {
    private final FilmeRepository filmeRepository;

    public FilmeDAO(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    public void create(Filme filme) {
        
        filmeRepository.save(filme);
    }
}
