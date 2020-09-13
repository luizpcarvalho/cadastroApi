package restproject.cadastroapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import restproject.cadastroapi.entity.PessoaEntity;

@Repository
public interface PessoaRepository extends CrudRepository<PessoaEntity, String> {
}
