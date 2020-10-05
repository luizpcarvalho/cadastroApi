package restproject.cadastroapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restproject.cadastroapi.entity.EnderecoEntity;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, String> {
    EnderecoEntity findByCep(String cep);
}
