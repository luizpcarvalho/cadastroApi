package restproject.cadastroapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import restproject.cadastroapi.request.PessoaRequest;

@Repository
public interface PessoaRepository extends CrudRepository<PessoaRequest, Long> {
}
