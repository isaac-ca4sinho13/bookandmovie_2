package www.vog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import www.vog.models.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, String> {
}