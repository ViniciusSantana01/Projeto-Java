public class Avaliacao {
 // Atributos da classe
 private String nomeUsuario;  // Nome do usuário que fez a avaliação
 private int nota;  // Nota atribuída na avaliação
 private String comentario;  // Comentário associado à avaliação

 // Construtor da classe
 public Avaliacao(String nomeUsuario, int nota, String comentario) {
     this.nomeUsuario = nomeUsuario;
     this.nota = nota;
     this.comentario = comentario;
 }

 // Sobrescrita do método toString() para fornecer uma representação em string da avaliação
 @Override
 public String toString() {
     // Retorna uma string contendo informações sobre a avaliação
     return "Nome do Usuário: " + nomeUsuario + ", Avaliação: " + nota + ", Comentário: " + comentario;
 }
}
