import java.util.ArrayList;
import java.util.List;

public abstract class Instituicao {
    // Atributos da classe
    private String nome;
    private String cidade;
    private String endereco;
    private String telefone;
    private List<Avaliacao> avaliacoes;  // Lista de Avaliacao associada à instituição

    // Construtor da classe
    public Instituicao(String nome, String cidade, String endereco, String telefone) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
        this.telefone = telefone;
        this.avaliacoes = new ArrayList<>();  // Inicializa a lista de avaliações como uma ArrayList
    }

    // Métodos de acesso aos atributos
    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    // Método para adicionar uma nova avaliação e comentário à instituição
    public void adicionarAvaliacaoComentario(String nomeUsuario, int nota, String comentario) {
        // Cria uma instância de Avaliacao e a adiciona à lista de avaliações
        Avaliacao novaAvaliacao = new Avaliacao(nomeUsuario, nota, comentario);
        avaliacoes.add(novaAvaliacao);
    }

    // Método abstrato para obter o tipo específico da instituição (Abrigo, CasaLar, Republica, etc.)
    public abstract String getNomeTipo();
}
