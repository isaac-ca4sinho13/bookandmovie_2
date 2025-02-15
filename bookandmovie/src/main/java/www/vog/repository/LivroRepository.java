package www.vog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import www.vog.models.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
}

