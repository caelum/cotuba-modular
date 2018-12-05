package cotuba.web.application;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cotuba.web.domain.Capitulo;

@Repository
public interface RepositorioDeCapitulos extends JpaRepository<Capitulo, Long> {

}
