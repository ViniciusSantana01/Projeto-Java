import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.List;

//Listas para armazenar diferentes tipos de instituições
public class SistemaAcolhimento {
    private List<AbrigoInstitucional> abrigosInstitucionais;
    private List<CasaLar> casasLar;
    private List<Republica> republicas;
    private Scanner scanner;
    
 // Construtor inicializa listas e scanner
    public SistemaAcolhimento() {
        this.abrigosInstitucionais = new ArrayList<>();
        this.casasLar = new ArrayList<>();
        this.republicas = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }
 // Método para cadastrar Abrigo Institucional
public void cadastrarAbrigoInstitucional(Scanner scanner) {
    System.out.println("Cadastrando ABRIGO INSTITUCIONAL: Este serviço é semelhante ao de uma residência e deve ser inserido em áreas residenciais\n"
            + "Todavia, não podem ser identificado com placas, a fim de evitar a estigmatização dos acolhidos.\n"
            + "O abrigo também deve promover o uso dos equipamentos e serviços disponíveis na comunidade local aos usuários acolhidos. \n");
 
    // Solicita informações ao usuário
    System.out.print("Nome da instituição: ");
    String nome = scanner.nextLine();

    System.out.print("Cidade: ");
    String cidade = scanner.nextLine();

    System.out.print("Endereço: ");
    String endereco = scanner.nextLine();
 
    // Usa loop para garantir que o telefone seja um número válido
    String telefone;
    do {
        try {
            System.out.print("Telefone para contato (apenas números): ");
            telefone = Long.toString(scanner.nextLong());  // Lê o número como long e converte para String
            break;  // Se a conversão foi bem-sucedida, sai do loop
        } catch (InputMismatchException e) {
            System.out.println("Erro: Digite apenas números para o telefone.");
            scanner.nextLine();  // Limpar o buffer do scanner
        }
    } while (true);

    // Solicitar a quantidade de pessoas com base no tipo de instituição
    int tipoInstituicao;
    do {
        System.out.println(" --- TIPO DA INSTITUIÇÃO ---");
        System.out.println("[1] Crianças e Adolescentes");
        System.out.println("[2] Adultos e Famílias");
        System.out.println("[3] Mulheres em situação de violência");
        System.out.println("[4] Pessoas Idosas");

        System.out.print("Opção: ");
        tipoInstituicao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        if (tipoInstituicao >= 1 && tipoInstituicao <= 4) {
            break;  // Se a opção for válida, sai do loop
        } else {
            System.out.println("Opção inválida. Tente novamente.");
        }
    } while (true);
 
    // Usa switch para determinar o limite de ocupação com base no tipo de instituição
    int limiteOcupacao = obterLimiteOcupacao(tipoInstituicao);
   // Usa loops para garantir que a quantidade de pessoas seja válida
    int quantidadePessoas;
    do {
        System.out.print("Quantidade de pessoas que a instituição oferece (máximo: " + limiteOcupacao + "): ");
        quantidadePessoas = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        if (quantidadePessoas <= limiteOcupacao) {
            break;  // Se a quantidade for válida, sai do loop
        } else {
            System.out.println("Erro: A instituição excede o limite de pessoas permitido. Tente novamente.");
        }
    } while (true);

    // Criar uma instância de AbrigoInstitucional com os dados fornecidos e adicionar à lista
    AbrigoInstitucional abrigoInstitucional = new AbrigoInstitucional(nome, cidade, endereco, telefone, quantidadePessoas, Integer.toString(tipoInstituicao));
    abrigosInstitucionais.add(abrigoInstitucional);

    System.out.println("- AGRADECEMOS PELA SUA CONTRIBUIÇÃO! Seu cadastro será analisado e, caso não esteja em conformidade, será excluído -");
}
   //Método privado para obter o limite de ocupação com base no tipo de instituição
private int obterLimiteOcupacao(int tipoInstituicao) {
    switch (tipoInstituicao) {
        case 1:
            return 20;
        case 2:
            return 50;
        case 3:
            return 30;
        case 4:
            return 25;
        default:
            return 0;  // Valor padrão, caso o tipo de instituição seja desconhecido
    }
}
//Método para cadastrar Casa Lar
public void cadastrarCasaLar(Scanner scanner) {
    System.out.println("Cadastrando CASA-LAR: Este serviço é ofertado em unidade residencial e deve possuir em seu quadro de funcionários\n"
            + "profissionais habilitados, treinados e supervisionados pela equipe técnica de referência para auxiliar nas atividades da vida diária.\n");

    System.out.print("Nome da instituição: ");
    String nome = scanner.nextLine();

    System.out.print("Cidade: ");
    String cidade = scanner.nextLine();

    System.out.print("Endereço: ");
    String endereco = scanner.nextLine();

    String telefone;
    do {
        try {
            System.out.print("Telefone para contato (apenas números): ");
            telefone = Long.toString(scanner.nextLong());  // Lê o número como long e converte para String
            break;  // Se a conversão foi bem-sucedida, sai do loop
        } catch (InputMismatchException e) {
            System.out.println("Erro: Digite apenas números para o telefone.");
            scanner.nextLine();  // Limpar o buffer do scanner
        }
    } while (true);

    // Solicitar o tipo de instituição
    int tipoInstituicao;
    do {
        System.out.println(" --- TIPO DA INSTITUIÇÃO ---");

        System.out.println("[1] Crianças e Adolescentes");
        System.out.println("[2] Pessoas Idosas");
        System.out.println("[3] Residência Inclusiva");
        System.out.println("[4] Casa de Passagem");

        System.out.print("Opção: ");
        tipoInstituicao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        if (tipoInstituicao >= 1 && tipoInstituicao <= 4) {
            break;  // Se a opção for válida, sai do loop
        } else {
            System.out.println("Opção inválida. Tente novamente.");
        }
    } while (true);

    int limiteOcupacao = obterLimiteOcupacao(tipoInstituicao);

    int quantidadePessoas;
    do {
        System.out.print("Quantidade de pessoas que a instituição oferece (máximo: " + limiteOcupacao + "): ");
        quantidadePessoas = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        if (quantidadePessoas <= limiteOcupacao) {
            break;  // Se a quantidade for válida, sai do loop
        } else {
            System.out.println("Erro: A instituição excede o limite de pessoas permitido. Tente novamente.");
        }
    } while (true);

    // Criar uma instância de CasaLar com os dados fornecidos e adicionar à lista
    CasaLar casaLar = new CasaLar(nome, cidade, endereco, telefone, quantidadePessoas, Integer.toString(tipoInstituicao));
    casasLar.add(casaLar);

    System.out.println("- AGRADECEMOS PELA SUA CONTRIBUIÇÃO! Seu cadastro será analisado e, caso não esteja em conformidade, será excluído -");
}
   //Método para cadastrar Republica
public void cadastrarRepublica(Scanner scanner) {
    System.out.println("Cadastrando REPÚBLICA: Este serviço é semelhante ao de uma residência compartilhada por grupos de pessoas,\n"
            + "incluindo espaços de convivência e refeitório, com a finalidade de promoção de autonomia.\n");

    System.out.print("Nome da instituição: ");
    String nome = scanner.nextLine();

    System.out.print("Cidade: ");
    String cidade = scanner.nextLine();

    System.out.print("Endereço: ");
    String endereco = scanner.nextLine();

    String telefone;
    do {
        try {
            System.out.print("Telefone para contato (apenas números): ");
            telefone = Long.toString(scanner.nextLong());  // Lê o número como long e converte para String
            break;  // Se a conversão foi bem-sucedida, sai do loop
        } catch (InputMismatchException e) {
            System.out.println("Erro: Digite apenas números para o telefone.");
            scanner.nextLine();  // Limpar o buffer do scanner
        }
    } while (true);

    // Solicitar o tipo de instituição
    int tipoInstituicao;
    do {
        System.out.println(" --- TIPO DA INSTITUIÇÃO ---");
        System.out.println("[1] Jovens");
        System.out.println("[2] Adultos");
        System.out.println("[3] Idosos");
        System.out.println("[4] Pessoas em situação de rua");

        System.out.print("Opção: ");
        tipoInstituicao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        if (tipoInstituicao >= 1 && tipoInstituicao <= 4) {
            break;  // Se a opção for válida, sai do loop
        } else {
            System.out.println("Opção inválida. Tente novamente.");
        }
    } while (true);

    int limiteOcupacao = obterLimiteOcupacao(tipoInstituicao);

    // Verificar se é necessário escolher o tipo de unidade (apenas para o tipoInstituicao == 2)
    String tipoUnidade = null;
    if (tipoInstituicao == 2) {
        System.out.println(" --- Escolha o tipo de unidade ---");
        System.out.println("[1] Unidade Feminina");
        System.out.println("[2] Unidade Masculina");

        int opcaoTipoUnidade;
        do {
            System.out.print("Opção: ");
            opcaoTipoUnidade = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            if (opcaoTipoUnidade == 1 || opcaoTipoUnidade == 2) {
                tipoUnidade = (opcaoTipoUnidade == 1) ? "Feminina" : "Masculina";
                break;  // Se a opção for válida, sai do loop
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        } while (true);
    }

    int quantidadePessoas;
    do {
        System.out.print("Quantidade de pessoas que a instituição oferece (máximo: " + limiteOcupacao + "): ");
        quantidadePessoas = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        if (quantidadePessoas <= limiteOcupacao) {
            break;  // Se a quantidade for válida, sai do loop
        } else {
            System.out.println("Erro: A instituição excede o limite de pessoas permitido. Tente novamente.");
        }
    } while (true);

    // Criar uma instância de Republica com os dados fornecidos e adicionar à lista
    Republica republica = new Republica(nome, cidade, endereco, telefone, quantidadePessoas, Integer.toString(tipoInstituicao), tipoUnidade);
    republicas.add(republica);

    System.out.println("- AGRADECEMOS PELA SUA CONTRIBUIÇÃO! Seu cadastro será analisado e, caso não esteja em conformidade, será excluído -");
}
     //Método para listar todas as instituições cadastradas
public void listarInstituicoesCadastradas() {
    System.out.println(" --- Lista de Instituições Cadastradas --- \n");

    boolean haInstituicoes = false;

    if (!abrigosInstitucionais.isEmpty()) {
        haInstituicoes = true;
        System.out.println("ABRIGOS INSTITUICIONAIS:");
        for (AbrigoInstitucional abrigo : abrigosInstitucionais) {
            System.out.println(abrigo);
            exibirAvaliacoesComentarios(abrigo);
        }
    }

    if (!casasLar.isEmpty()) {
        haInstituicoes = true;
        System.out.println("\nCASAS LAR:");
        for (CasaLar casaLar : casasLar) {
            System.out.println(casaLar);
            exibirAvaliacoesComentarios(casaLar);
        }
    }

    if (!republicas.isEmpty()) {
        haInstituicoes = true;
        System.out.println("\nREPÚBLICAS:");
        for (Republica republica : republicas) {
            System.out.println(republica);
            exibirAvaliacoesComentarios(republica);
        }
    }

    if (!haInstituicoes) {
        System.out.println("Nenhuma instituição cadastrada no momento.");
    }
    
    System.out.println("Aperte 'ENTER' para continuar.");
    scanner.nextLine(); // Aguarda o usuário pressionar enter antes de voltar ao menu
}


     //Método para verificar se há instituições cadastradas
public boolean haInstituicoesCadastradas() {
    return !abrigosInstitucionais.isEmpty() || !casasLar.isEmpty() || !republicas.isEmpty();
}
//Método para buscar todas as instituições cadastradas por cidade
public void pesquisarPorLocalidade(Scanner scanner) {
    System.out.println(" - Pesquisando por Localidade -");

    if (!haInstituicoesCadastradas()) {
        System.out.println("Não há instituições cadastradas para pesquisa.");
        return;
    }

    System.out.print("Digite a cidade para pesquisa: ");
    String cidadePesquisa = scanner.nextLine();

    boolean encontrouInstituicao = false;

    // Pesquisar em Abrigos Institucionais
    for (AbrigoInstitucional abrigo : abrigosInstitucionais) {
        if (abrigo.getCidade().equals(cidadePesquisa)) {
            System.out.println("- ABRIGO INSTICIONAL ENCONTRADO:");
            System.out.println(abrigo);
            exibirAvaliacoesComentarios(abrigo);
            encontrouInstituicao = true;
        }
    }

    // Pesquisar em Casas Lar
    for (CasaLar casaLar : casasLar) {
        if (casaLar.getCidade().equals(cidadePesquisa)) {
            System.out.println("\n- CASA LAR ENCONTRADA:");
            System.out.println(casaLar);
            exibirAvaliacoesComentarios(casaLar);
            encontrouInstituicao = true;
        }
    }

    // Pesquisar em Repúblicas
    for (Republica republica : republicas) {
        if (republica.getCidade().equals(cidadePesquisa)) {
            System.out.println("\n-REPÚBLICA ENCONTRADA:");
            System.out.println(republica);
            exibirAvaliacoesComentarios(republica);
            encontrouInstituicao = true;
        }
    }

    if (!encontrouInstituicao) {
        System.out.println("Nenhuma instituição encontrada na cidade informada.");
    }

    System.out.println("Aperte 'ENTER' para continuar.");
    scanner.nextLine(); // Aguarda o usuário pressionar enter antes de voltar ao menu
}


public Instituicao buscarInstituicaoPorNome(String nomeInstituicao) {
    // Buscar em Abrigos Institucionais
    for (AbrigoInstitucional abrigo : abrigosInstitucionais) {
        if (abrigo.getNome().equals(nomeInstituicao)) {
            return abrigo;
        }
    }

    // Buscar em Casas Lar
    for (CasaLar casaLar : casasLar) {
        if (casaLar.getNome().equals(nomeInstituicao)) {
            return casaLar;
        }
    }

    // Buscar em Repúblicas
    for (Republica republica : republicas) {
        if (republica.getNome().equals(nomeInstituicao)) {
            return republica;
        }
    }
    // Retornar null se a instituição não for encontrada
    return null;
    
}

//Método para Avaliar e comentar todas as instituições cadastradas
public void avaliarEComentarInstituicao(Scanner scanner) {
    System.out.println("- Avaliando e Comentando uma Instituição -");

    if (!haInstituicoesCadastradas()) {
        System.out.println("Não há instituições cadastradas para avaliação e comentários.");
        return;
    }

    listarInstituicoesCadastradas(); // mostrar instituições 

    System.out.print("Digite o nome da instituição que deseja avaliar e comentar: ");
    String nomeInstituicao = scanner.nextLine();

    Instituicao instituicao = buscarInstituicaoPorNome(nomeInstituicao);

    if (instituicao != null) {
        // Solicitar nome do usuário, avaliação e comentário
        System.out.print("Digite seu nome: ");
        String nomeUsuario = scanner.nextLine();

        System.out.print("Digite sua avaliação (de 1 a 5): ");
        int avaliacao;
        do {
            try {
                avaliacao = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer do scanner

                if (avaliacao >= 1 && avaliacao <= 5) {
                    break;  // Se a avaliação for válida, sai do loop
                } else {
                    System.out.println("Erro: A avaliação deve ser um número de 1 a 5. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Digite um número inteiro de 1 a 5 para a avaliação.");
                scanner.nextLine(); // Limpar o buffer do scanner
            }
        } while (true);

        System.out.print("Deixe um comentário: ");
        String comentario = scanner.nextLine();

        // Adicionar a avaliação e o comentário à instituição específica
        instituicao.adicionarAvaliacaoComentario(nomeUsuario, avaliacao, comentario);

        System.out.println("Avaliação e comentário adicionados com sucesso!");
    } else {
        System.out.println("Instituição não encontrada.");
    }

    System.out.println("Aperte 'ENTER' para continuar.");
    scanner.nextLine(); // Aguarda o usuário pressionar enter antes de voltar ao menu
}

     //Método para exibir avaliações e comentários de todas as instituições cadastradas
public void exibirAvaliacoesComentarios(Instituicao instituicao) {
    System.out.println("Avaliações e Comentários:");

    List<Avaliacao> avaliacoes = instituicao.getAvaliacoes();

    if (avaliacoes.isEmpty()) {
        System.out.println("Essa instituição não possui avaliações.");
    } else {
        for (Avaliacao avaliacao : avaliacoes) {
            System.out.println(avaliacao);
        }
    }
    
}

public static void main(String[] args) {
    iniciarSistema();
}

public static void iniciarSistema() {
    Scanner scanner = new Scanner(System.in);
    SistemaAcolhimento sistema = new SistemaAcolhimento();

    int opcao;
    do {
        System.out.println("Bem-vindo ao sistema de Serviço de Acolhimento Institucional.");
        System.out.println(" - Escolha uma das opções abaixo -");
        System.out.println("Digite [1] para Cadastrar Instituições de abrigos, casa-lar ou República.");
        System.out.println("Digite [2] para Verificar todas as Instituições de abrigos, casa-lar ou República já cadastradas");
        System.out.println("Digite [3] para Pesquisar e visualizar instituições por localidade");
        System.out.println("Digite [4] para Avaliar e deixar um comentário para uma instituição");
        System.out.println("Digite [5] para Sair do aplicativo");

        opcao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner


        switch (opcao) {
            case 1: // Cadastrar instituições
                cadastrarInstituicao(scanner, sistema);
                break;
            case 2: // Verificar e listar instituições cadastradas
                if (sistema.haInstituicoesCadastradas()) {
                    sistema.listarInstituicoesCadastradas();
                } else {
                    System.out.println("Nenhuma instituição cadastrada ainda.");
                }
                break;
            case 3: // Pesquisar instiuição por localidade
                sistema.pesquisarPorLocalidade(scanner);
                break;
            case 4: // Avaliar e comentar
                sistema.avaliarEComentarInstituicao(scanner);
                break;
            case 5: // Sair da aplicação
                System.out.println("Saindo do aplicativo. Obrigado!");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }

    } while (opcao != 5);
    scanner.close(); // Fechar o scanner ao sair do loop
}
   //Método privado para cadastrar uma instituição com base no tipo escolhido pelo usuário
private static void cadastrarInstituicao(Scanner scanner, SistemaAcolhimento sistema) {
    int opcaoTipoInstituicao;
    do {
        System.out.println("Seleciona o tipo de instituição que deseja cadastrar:");
        System.out.println("[1] Abrigo Institucional");
        System.out.println("[2] Casa-lar");
        System.out.println("[3] República");
        System.out.println("[4] Voltar ao menu anterior");

        System.out.print("Opção: ");
        opcaoTipoInstituicao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        switch (opcaoTipoInstituicao) {
            case 1:
                // Cadastrar Abrigo Institucional
                sistema.cadastrarAbrigoInstitucional(scanner);
                break;
            case 2:
                // Cadastrar Casa-lar
                sistema.cadastrarCasaLar(scanner);
                break;
            case 3:
                // Cadastrar Republica
                sistema.cadastrarRepublica(scanner);
                break;
            case 4:
                System.out.println("Voltando ao menu anterior.");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }

    } while (opcaoTipoInstituicao != 4);
}
}
