package restproject.cadastroapi.core.cep;

import restproject.cadastroapi.response.CepResponse;

public interface CepService {
    public CepResponse findCep(String cep);
}
