// Definição da classe AbrigoInstitucional, que é uma subclasse de Instituicao
public class AbrigoInstitucional extends Instituicao {
    // Atributos específicos para AbrigoInstitucional
    private int limiteOcupacao;
    private String tipoInstituicao;

    // Construtor da classe
    public AbrigoInstitucional(String nome, String cidade, String endereco, String telefone, int limiteOcupacao, String tipoInstituicao) {
        // Chamada ao construtor da superclasse (Instituicao)
        super(nome, cidade, endereco, telefone);
        
        // Inicialização dos atributos específicos
        this.limiteOcupacao = limiteOcupacao;
        this.tipoInstituicao = tipoInstituicao;
    }

    // Métodos de acesso aos atributos específicos
    public int getLimiteOcupacao() {
        return limiteOcupacao;
    }

    public String getTipoInstituicao() {
        return tipoInstituicao;
    }

    // Implementação do método abstrato da superclasse para obter o tipo específico da instituição
    @Override
    public String getNomeTipo() {
        // Utilização de switch para retornar o nome do tipo com base no código armazenado em tipoInstituicao
        switch (tipoInstituicao) {
            case "1":
                return "Abrigo Institucional para Crianças e Adolescentes";
            case "2":
                return "Abrigo Institucional para Adultos e Famílias";
            case "3":
                return "Abrigo Institucional para Mulheres em situação de violência";
            case "4":
                return "Abrigo Institucional para Pessoas Idosas";
            default:
                return "Tipo de Instituição Desconhecido";
        }
    }

    // Implementação do método toString para gerar uma representação em string da instância
    @Override
    public String toString() {
        return "Nome: " + getNome() + ", Cidade: " + getCidade() + ", Endereço: " + getEndereco() +
                ", Telefone: " + getTelefone() + ", Limite de Ocupação: " + limiteOcupacao +
                ", Tipo da Instituição: " + getNomeTipo();
    }
}
