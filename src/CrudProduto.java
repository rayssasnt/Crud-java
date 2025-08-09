import java.util.ArrayList;
import java.util.Scanner;

public class CrudProduto{

    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static Usuario usuarioLogado = null;
    private static void inicarUser(){
        usuarios.add(new Usuario("adim",HashUtil.gerarHash("adim123"),
                "adim"));


        usuarios.add(new Usuario("Rayssa",HashUtil.gerarHash("rayssa123"),
                "Usuario"));
    }

    private static ArrayList<Produto> produtos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int proximoId = 1;

    public static void main(String[] args) {
        inicarUser();
        if (!login()) return;
        int opcao;

        do {
            mostrarMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer


            switch (opcao) {

                case 1: criarProduto(); break;
                case 2: listarProdutos(); break;
                case 3: atualizarProduto(); break;
                case 4: deletarProduto(); break;
                case 0: System.out.println("Encerrando...\uD83D\uDC4B"); break;
                default: System.out.println("Opção inválida. ❗");
            }
        }
        while (opcao != 0);
    }


    private static void mostrarMenu() {
        System.out.println("\n--- MENU PRODUTOS \uD83D\uDED2---");
        System.out.println("1 - Cadastrar produto ➕ ");
        System.out.println("2 - Listar produtos \uD83D\uDCCB");
        System.out.println("3 - Atualizar produto \uD83D\uDD04");
        System.out.println("4 - Deletar produto \uD83D\uDDD1\uFE0F");
        System.out.println("0 - Sair \uD83C\uDFC3\uD83D\uDCA8...");
        System.out.print("Escolha uma opção: ");
    }

    private static boolean login() {

        System.out.print("-----Login \uD83D\uDD10----\n");
        System.out.println("User: ");

        String login = scanner.nextLine();
        System.out.print("password: ");
        String password = scanner.nextLine();
        String senhaHash = HashUtil.gerarHash(password);


        for (Usuario u : usuarios) {
            if (u.getLogin().equals(login) && u.getSenhaHash().equals(senhaHash)) {
                usuarioLogado = u;
                System.out.println("login bem sucedido! , bem vindo \uD83E\uDEE1 " + u.getLogin());
                return true;
            }

        }
        System.out.println("Credenciais inválidas! ⚠\uFE0F");
        return false;
    }

    private static void criarProduto(){
        System.out.println("Nome do Produto: ");
        String nome = scanner.nextLine();

        System.out.println("Preço do Produto: ");
        double preco = scanner.nextDouble();

        Produto novo= new Produto(proximoId++ , nome , preco);
        produtos.add(novo);
        System.out.println("Produto criado com sucesso!");
    }

    private static void listarProdutos(){
        if(produtos.isEmpty()){
            System.out.println("nenhum produto encontrado ❌ ");
            return;

        }

        System.out.println("\n--- LISTA DE PRODUTOS ---");
        for (Produto p: produtos){

            System.out.println("ID: " + p.getId());
            System.out.println("Nome: " + p.getNome());
            System.out.println("Preço: " + p.getPreco());
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-");


        }

    }

    private static void atualizarProduto(){

        System.out.println("informe o ID do produto: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Produto p: produtos){
            if (p.getId() == id){
                System.out.println("Novo nome do produto: ");
                String new_nome = scanner.nextLine();

                System.out.println("Novo preço do produto: ");
                double new_preco = scanner.nextDouble();

                p.setNome(new_nome);
                p.setPreco(new_preco);

                System.out.println("Produto atualizado com sucesso! ✅");
                return;
            }
        }
        System.out.println("Produto com o ID" + id + "Não encontrado \uD83D\uDEA8");
    }

    private static void deletarProduto(){
        System.out.println("informe o ID do produto: ");
        int id = scanner.nextInt();

        for (Produto p: produtos){
            if (p.getId() == id){
                produtos.remove(p);
                System.out.println("Produto deletado com sucesso! ✅");
                return;
            }
        }
        System.out.println("Produto com o ID" + id + "Nao encontrado \uD83D\uDEA8");


    }

}
