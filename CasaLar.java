// Definição da classe CasaLar, que é uma subclasse de Instituicao
public class CasaLar extends Instituicao {
    // Atributos específicos para CasaLar
    private int limiteOcupacao;
    private String tipoInstituicao;

    // Construtor da classe
    public CasaLar(String nome, String cidade, String endereco, String telefone, int limiteOcupacao, String tipoInstituicao) {
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
                return "Casa-lar para Crianças e Adolescentes";
            case "2":
                return "Casa-lar para Pessoas Idosas";
            case "3":
                return "Residência Inclusiva";
            case "4":
                return "Casa de Passagem";
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

    // Método adicional para obter o limite de ocupação com base no tipo de instituição
    public int obterLimiteOcupacao() {
        int tipo = Integer.parseInt(getTipoInstituicao());
        switch (tipo) {
            case 1:
                return 20;  // Limite para Crianças e Adolescentes
            case 2:
                return 15;  // Limite para Pessoas Idosas
            case 3:
                return 10;  // Limite para Residência Inclusiva
            case 4:
                return 5;   // Limite para Casa de Passagem
            default:
                return 0;   // Valor padrão
        }
    }
}
