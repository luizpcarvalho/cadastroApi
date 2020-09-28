package restproject.cadastroapi.core.cep.viacep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restproject.cadastroapi.core.cep.CepService;
import restproject.cadastroapi.response.CepResponse;
import restproject.cadastroapi.response.ViaCepResponse;

@Service
public class ViaCepService implements CepService {

    @Autowired
    private ViaCepClient viaCepClient;

    @Override
    public CepResponse findCep(final String cep) {
        ViaCepResponse viaCepResponse = viaCepClient.get(cep);
        return new CepResponse(viaCepResponse);
    }
}
