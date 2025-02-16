package www.vog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import www.vog.models.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
}