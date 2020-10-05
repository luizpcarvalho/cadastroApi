package restproject.cadastroapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restproject.cadastroapi.entity.EnderecoEntity;
import restproject.cadastroapi.entity.PessoaEntity;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, String> { }
