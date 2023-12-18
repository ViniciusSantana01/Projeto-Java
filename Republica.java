// Definição da classe Republica, que é uma subclasse de Instituicao
public class Republica extends Instituicao {
    // Atributos específicos para Republica
    private int limiteOcupacao;
    private String tipoInstituicao;
    private String tipoUnidade;

    // Construtor da classe
    public Republica(String nome, String cidade, String endereco, String telefone, int limiteOcupacao, String tipoInstituicao, String tipoUnidade) {
        // Chamada ao construtor da superclasse (Instituicao)
        super(nome, cidade, endereco, telefone);

        // Inicialização dos atributos específicos
        this.limiteOcupacao = limiteOcupacao;
        this.tipoInstituicao = tipoInstituicao;
        this.tipoUnidade = tipoUnidade;
    }

    // Métodos de acesso aos atributos específicos da classe
    public int getLimiteOcupacao() {
        return limiteOcupacao;
    }

    public String getTipoInstituicao() {
        return tipoInstituicao;
    }

    public String getTipoUnidade() {
        return tipoUnidade;
    }

    // Implementação do método abstrato da superclasse para obter o tipo específico da instituição
    @Override
    public String getNomeTipo() {
        // Utilização de switch para retornar o nome do tipo com base no código armazenado em tipoInstituicao
        switch (tipoInstituicao) {
            case "1":
                return "República para Jovens";
            case "2":
                return "República para Adultos";
            case "3":
                return "República para Idosos";
            default:
                return "Tipo de República Desconhecido";
        }
    }

    // Implementação do método toString para gerar uma representação em string da instância
    @Override
    public String toString() {
        return "Nome: " + getNome() + ", Cidade: " + getCidade() + ", Endereço: " + getEndereco() +
                ", Telefone: " + getTelefone() + ", Limite de Ocupação: " + limiteOcupacao +
                ", Tipo da Instituicao: " + getNomeTipo() +
                (tipoUnidade != null ? ", Tipo de Unidade: " + tipoUnidade : "");
    }

    // Método adicional para obter o limite de ocupação com base no tipo de instituição e tipo de unidade
    public int obterLimiteOcupacao() {
        int tipo = Integer.parseInt(getTipoInstituicao());
        switch (tipo) {
            case 1:
                return 10;  // Limite para República para Jovens
            case 2:
                // Dependendo do tipo de unidade, retornar o limite correspondente
                if ("Feminina".equalsIgnoreCase(getTipoUnidade())) {
                    return 8;  // Limite para República para Adultos - Unidade Feminina
                } else if ("Masculina".equalsIgnoreCase(getTipoUnidade())) {
                    return 10; // Limite para República para Adultos - Unidade Masculina
                }
            case 3:
                return 6;   // Limite para República para Idosos
            default:
                return 0;   // Valor padrão
        }
    }
}
