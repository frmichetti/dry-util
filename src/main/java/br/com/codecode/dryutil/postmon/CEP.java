package br.com.codecode.dryutil.postmon;

public class CEP {

    String bairro;

    long cep;

    String cidade;

    CidadeInfo cidade_info;

    EstadoInfo estado_info;

    String logradouro;

    @Override
    public String toString() {

	return "\n [bairro=" + bairro + ", cidade=" + cidade + ", cep=" + cep + ", logradouro=" + logradouro
		+ ", \nestado_info=" + estado_info + ", \ncidade_info=" + cidade_info + "]";
    }

}
