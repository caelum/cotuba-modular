package cotuba.web.application;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cotuba.web.domain.Livro;

@Repository
public interface RepositorioDeLivros  extends JpaRepository<Livro, Long> {

}
