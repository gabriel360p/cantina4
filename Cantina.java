import java.util.ArrayList;
import java.util.Scanner;

public class Cantina implements Auth{
    private int quantidade;
    private double precoPedido;
    
    Funcionario funcionarioLogado;

    Scanner ler = new Scanner(System.in);

    // Pedido objetoPedido = new Pedido();
    Caixa caixa = new Caixa();
    Pagamento pay = new Pagamento();

    // // ------------------------------------------------------------------------
    //Cliente padrão
    Cliente cliente = new Cliente("Jorge","351216","3522352","123abc",600);

    //nessas duas arraylists fica salvo a os produtos que o cliente escolheu, e tmb a quantidade de produtos que o cliente escolheu
    ArrayList<Produto> pedido = new ArrayList();
    ArrayList<Integer> quantidadeList = new ArrayList();
    ArrayList<Double> precoList = new ArrayList();
    
    //armazenamento de funcionarios
    ArrayList<Funcionario> funcionarios = new ArrayList();
    //funcionarios padrões
    //@Overload
    Admin funcionarioAdmin = new Admin("Roberto","351216","3522352",3000,"Administrador","321","321");
    //@Overload
    Comum funcionarioComum = new Comum("Marcos","351216","3522352",1200,"Vendedor","123","123");    

    //armazenamento de produtos
    ArrayList<Produto> armazem = new ArrayList();
    //produtos padrões
    //@Overload
    ProdutoIndustrial produtoIndustrial = new ProdutoIndustrial("Nestle","Iorgute",4,12,"20/12/2023","Boa");
    //@Overload
    ProdutoCaseiro produtoCaseiro = new ProdutoCaseiro("Casa do hotdog","Cachorro Quente",6,43,"20/12/2023","Boa");   
    // // ------------------------------------------------------------------------

    //inicializar o "banco"
    public void seeders(){
        armazem.add(produtoCaseiro);
        armazem.add(produtoIndustrial);
        funcionarios.add(funcionarioComum);
        funcionarios.add(funcionarioAdmin);
    }   

    //CRUD -> PRODUTOS -- add, remove, update and show
    public void adicionarProduto(){//add
        System.out.println("====================================================");
        System.out.println("|Tipo de produto");
        System.out.println("|(1)Industrial");
        System.out.println("|(2)Caseiro");
        System.out.println("|(0)Sair");

        switch(ler.nextLine()){
            case "1":
                //@Overload
                ProdutoIndustrial produtoIndustrial = new ProdutoIndustrial();

                System.out.println("|Insira os dados do produto: ");

                System.out.println("|Fornecedor");
                String fornecedor = ler.nextLine();
                produtoIndustrial.setProvider(fornecedor);
                
                System.out.println("|Nome");
                String nome = ler.nextLine();
                produtoIndustrial.setName(nome);

                System.out.println("|Quantidade");
                int quantidade = ler.nextInt();
                produtoIndustrial.setAmount(quantidade);

                System.out.println("|Preço");
                double preco = ler.nextDouble();
                produtoIndustrial.setPrice(preco);

                System.out.println("|Data de Validade");
                ler.nextLine();
                String dataValidade = ler.nextLine();
                produtoIndustrial.setDuration(dataValidade);

                System.out.println("|Qualidade");
                String qualidade = ler.nextLine();
                produtoIndustrial.setQuality(qualidade);

                //adicionando ao armazem
                armazem.add(produtoIndustrial);
                System.out.println("====================================================");
            break;

            case "2":
                //@Overload
                ProdutoCaseiro produtoCaseiro = new ProdutoCaseiro();

                System.out.println("|Insira os dados do produto: ");
                System.out.println("|Fornecedor");
                fornecedor = ler.nextLine();
                produtoCaseiro.setProvider(fornecedor);
                
                System.out.println("|Nome");
                nome = ler.nextLine();
                produtoCaseiro.setName(nome);

                System.out.println("|Quantidade");
                quantidade = ler.nextInt();
                produtoCaseiro.setAmount(quantidade);

                System.out.println("|Preço");
                preco = ler.nextDouble();
                produtoCaseiro.setPrice(preco);

                System.out.println("|Data de Validade");
                ler.nextLine();
                dataValidade = ler.nextLine();
                produtoCaseiro.setDuration(dataValidade);

                System.out.println("|Qualidade");
                qualidade = ler.nextLine();
                produtoCaseiro.setQuality(qualidade);

                //adicionando ao armazem
                armazem.add(produtoCaseiro);
                System.out.println("====================================================");
            break;
        }
    }
    public void removerProduto(){//remove
        System.out.println("|Produtos armazenados");

        for(Produto produto : armazem){
            if(produto.getAmount()<=0){
            }else{
                System.out.println("|Posicao: "+armazem.indexOf(produto)+""+produto.toString());
                System.out.println("====================================================");
            }
        }

        System.out.println("|Indique a posição do produto que deseja remover");
        int position = ler.nextInt();

        //removendo o produto de acordo com a sua localização na arraylist
        armazem.remove(position);

        System.out.println("|Lista Atualizada");
        for(Produto produto : armazem){
            if(produto.getAmount()<=0){
            }else{
                System.out.println("|Posicao: "+armazem.indexOf(produto)+""+produto.toString());
                System.out.println("====================================================");
            }
        }
    }
    public void editarProduto(){//update
        //vou guardar o objeto que precisa ser modificado, temporariamente ele recebe esse abaixo, apenas para inicializar
        Produto objetoProduto;

        //listando os produtos
        if(armazem.size()==0){
            System.out.println("|Nenhum produto armazenado");
        }else{
            System.out.println("|Produtos armazenados: ");
                for(Produto produto : armazem){
                    if(produto.getAmount()<=0){
                    }else{
                        System.out.println("|Posicao: "+armazem.indexOf(produto)+""+produto.toString());
                        System.out.println("====================================================");
                    }
                }
            }
            System.out.println("|Indique a posição do produto que deseja editar");
            int position = ler.nextInt();
            
            //pegando o objeto produto que deve ser editado
            objetoProduto = armazem.get(position);

            boolean on=true;
            while(on==true){
                System.out.println("====================================================");
                System.out.println("|Produto => "+objetoProduto.toString());
                System.out.println("|(1)Alterar Fornecedor");
                System.out.println("|(2)Alterar Nome do produto");
                System.out.println("|(3)Alterar Valor");
                System.out.println("|(4)Alterar Quantidade");
                System.out.println("|(5)Alterar Data de Validade");
                System.out.println("|(6)Alterar Qualidade de produto");
                System.out.println("|(0)Sair");

                switch(ler.nextLine()){
                    case "1":
                        System.out.println("|Nome do Fornecedor: ");
                        objetoProduto.setProvider(ler.nextLine());
                    break;
                    case "2":
                        System.out.println("|Nome do Produto: ");
                        objetoProduto.setName(ler.nextLine());
                    break;
                    case "3":
                        System.out.println("|Valor: ");
                        objetoProduto.setPrice(ler.nextDouble());
                    break;
                    case "4":
                        System.out.println("|Quantidade");
                        objetoProduto.setAmount(ler.nextInt());
                    break;
                    case "5":
                        System.out.println("|Data de Validade");
                        objetoProduto.setDuration(ler.nextLine());
                    break;
                    case "6":
                        System.out.println("|Qualidade");
                        objetoProduto.setQuality(ler.nextLine());
                    break;
                    case "0":
                        on=false;
                    break;

                    default:
                        System.out.println("|Operação inválida");
                }
            }

            System.out.println("====================================================");
            for(Produto produto : armazem){
                if(produto.getName()==null){
                }else{
                    System.out.println("|Posicao: "+armazem.indexOf(produto)+" "+produto.toString());
                    System.out.println("====================================================");
                }
            }        
    }
    public void showProduto(){//show
        System.out.println("|Inventário da Cantina");
        System.out.println("====================================================");
        //aq ele só vai mostrar os produtos que estão cadastrados e se possuem estoque
        if(armazem.size()==0){
            System.out.println("|Nenhum produto disponivel");
        }else{
            for(Produto produto : armazem){
                if(produto.getAmount()<=0){
                }else{
                    System.out.println("|Posicao: "+armazem.indexOf(produto)+""+produto.toString());
                    System.out.println("====================================================");
                }
            }
        }
    }
    public void painelProduto(){//painel de controle do produto
        boolean on8=true;
        while(on8==true){
            System.out.println("|Sobre os produtos");
                System.out.println("|(0)Sair");
                System.out.println("|(1)Adicionar");
            if(armazem.size()==0){
            }else{
                System.out.println("|(2)Editar");
                System.out.println("|(3)Deletar");
                System.out.println("|(4)Todos os produtos");
            }
            ler.nextLine();
            switch(ler.nextLine()){
                case "1":
                    adicionarProduto();
                break;
                
                case "2":
                    editarProduto();
                break;

                case "3":
                    removerProduto();
                break;

                case "4":
                    showProduto();
                break;  
                case "0":
                    on8=false;
                break;  
                default:
                    System.out.println("|Operação inválida");
                    System.out.println("====================================================");
            }
        }
    }

    //CRUD -> FUNCIONARIOS -- add, remove, update and show
    public void adicionarFuncionario(){//add
        if(funcionarioLogado instanceof Admin){
            System.out.println("|(1)Usuario comum");
            System.out.println("|(2)Usuario Administrador");
            switch(ler.nextLine()){
                case "1":
                    //@Overload
                    Comum funcionarioComum = new Comum();
                    System.out.println("|Nome do funcionario");
                    String nome = ler.nextLine();
                    funcionarioComum.setName(nome);

                    System.out.println("|Matricula do funcionario");
                    String matricula = ler.nextLine();
                    funcionarioComum.setRegistration(matricula);

                    System.out.println("|Função do funcionario");
                    String funcao = ler.nextLine();
                    funcionarioComum.setOffice(funcao);

                    System.out.println("|Senha do funcionario");
                    String senha = ler.nextLine();
                    funcionarioComum.setPassword(senha);

                    funcionarios.add(funcionarioComum);
                break;

                case "2":
                    //@Overload
                    Admin funcionarioAdmin = new Admin();

                    System.out.println("|Nome do funcionario");
                    nome = ler.nextLine();
                    funcionarioAdmin.setName(nome);

                    System.out.println("|Matricula do funcionario");
                    matricula = ler.nextLine();
                    funcionarioAdmin.setRegistration(matricula);

                    System.out.println("|Senha do funcionario");
                    senha = ler.nextLine();
                    funcionarioAdmin.setPassword(senha);

                    funcionarioAdmin.setOffice("Admin");

                    funcionarios.add(funcionarioAdmin);
                break;
                default:
                    System.out.println("|Operação inválida");

            }
        }else{
            System.out.println("|Você não tem permissão de Administrador");
        }
    }
    public void editarFuncionario(){//update
        if(funcionarioLogado instanceof Admin){
            if(funcionarios.size()==0){
                System.out.println("|Nenhum funcionario cadastrado");
            }else{
                System.out.println("|Funcionarios: ");
                for(Funcionario pessoa : funcionarios){
                    System.out.println("|Posicao: "+funcionarios.indexOf(pessoa)+""+pessoa.toString());
                    System.out.println("====================================================");
            }
                System.out.println("|Escolha pelo indice");
                int position = ler.nextInt();
                Funcionario pessoa = funcionarios.get(position);

                boolean on9=true;
                while(on9==true){
                    System.out.println("|Funcionario => "+pessoa.toString());
                    System.out.println("|(1)Nome");
                    System.out.println("|(2)Telefone");
                    System.out.println("|(3)CPF");
                    System.out.println("|(4)Salario");
                    System.out.println("|(5)Funcao");
                    System.out.println("|(6)Matricula");
                    System.out.println("|(7)Tornar Administrador");
                    System.out.println("|(0)Sair");
                    switch(ler.nextLine()){
                        case "1":
                            System.out.println("|Alterar nome: ");
                            ler.nextLine();
                            pessoa.setName(ler.nextLine());
                        break;
                        case "2":
                            System.out.println("|Alterar Telefone: ");
                            ler.nextLine();
                            pessoa.setTelephone(ler.nextLine());
                        break;
                        case "3":
                            System.out.println("|Alterar CPF: ");
                            ler.nextLine();
                            pessoa.setCpf(ler.nextLine());
                        break;
                        case "4":
                            System.out.println("|Alterar Salario: ");
                            ler.nextDouble();
                            pessoa.setWage(ler.nextDouble());
                        break;
                        case "5":
                            System.out.println("|Alterar Funcao: ");
                            ler.nextLine();
                            pessoa.setOffice(ler.nextLine());
                        break;
                        case "6":
                            System.out.println("|Alterar Matricula: ");
                            ler.nextLine();
                            pessoa.setRegistration(ler.nextLine());
                        break;
                        case "7":
                            Admin funcionarioAdmin = new Admin(pessoa.getName(),pessoa.getTelephone(),pessoa.getCpf(),pessoa.getWage(),"Administrador",pessoa.getRegistration(),pessoa.getPassword());
                            funcionarios.remove(position);
                            funcionarios.add(position,funcionarioAdmin);
                            
                            System.out.println("|Atualização Concluída");
                            System.out.println("====================================================");
                        break;
                        case "0":
                            on9=false;
                        break;
                    default:
                        System.out.println("|Operação inválida");   
                        System.out.println("====================================================");
                    }
                }
            }
        }else{
            System.out.println("|Você não tem permissão de Administrador");   
        }
    }
    public void removerFuncionario(){//remove
        if(funcionarioLogado instanceof Admin){
            if(funcionarios.size()==0){
                System.out.println("|Nenhum funcionario cadastrado");
            }else{
                System.out.println("|Funcionarios: ");
                for(Funcionario pessoa : funcionarios){
                    System.out.println("|Posicao: "+funcionarios.indexOf(pessoa)+""+pessoa.toString());
                    System.out.println("====================================================");
            }

            System.out.println("|Escolha pelo indice");
            int position = ler.nextInt();
            funcionarios.remove(position);
            }
        }else{
            System.out.println("|Você não tem permissão de Administrador");
        }
    }
    public void showFuncionario(){//show
        if(funcionarioLogado instanceof Admin){
            if(funcionarios.size()==0){
                System.out.println("|Nenhum funcionario cadastrado");
            }else{
                System.out.println("|Funcionarios: ");
                for(Funcionario pessoa : funcionarios){
                    System.out.println("|Posicao: "+funcionarios.indexOf(pessoa)+""+pessoa.toString());
                    System.out.println("====================================================");
                }
            }
        }else{
            System.out.println("|Você não tem permissão de Administrador");
        }
    }
    public void painelFuncionario(){//painel de controle de funcionario
        if(funcionarioLogado instanceof Admin){
            boolean on7=true;
            while(on7==true){
                System.out.println("|Sobre os Funcionarios");
                    System.out.println("|(0)Sair");
                    System.out.println("|(1)Adicionar");
                if(funcionarios.size()==0){
                }else{
                    System.out.println("|(2)Editar");
                    System.out.println("|(3)Deletar");
                    System.out.println("|(4)Todos os funcionarios");
                }

                switch(ler.nextLine()){
                    case "1":
                        adicionarFuncionario();
                    break;
                    
                    case "2":
                        editarFuncionario();
                    break;

                    case "3":
                        removerFuncionario();
                    break;

                    case "4":
                        showFuncionario();
                    break;  

                    case "0":
                        on7=false;
                    break;
                    default:
                        System.out.println("|Operação Inválida");
                        System.out.println("====================================================");
                }
            }    
        }else{
            System.out.println("|Você não tem permissão de Administrador");
        }
    }

    //CLIENTE -- update and show
    public void editarCliente(){//editar cliente
        if(funcionarioLogado instanceof Admin){
            boolean on10=true;
            while(on10==true){
                System.out.println("====================================================");
                System.out.println("|Cliente => "+cliente.toString());
                System.out.println("|(1)Nome");
                System.out.println("|(2)Telefone");
                System.out.println("|(3)CPF");
                System.out.println("|(4)Pix");
                System.out.println("|(5)Valor interno do pix");
                System.out.println("|(0)Sair");
                ler.nextLine();
                switch(ler.nextLine()){
                    case "1":
                        System.out.println("|Alterar nome: ");
                        // ler.nextLine();
                        cliente.setName(ler.nextLine());
                    break;
                    case "2":
                        System.out.println("|Alterar Telefone: ");
                        // ler.nextLine();
                        cliente.setTelephone(ler.nextLine());
                    break;
                    case "3":
                        System.out.println("|Alterar CPF: ");
                        // ler.nextLine();
                        cliente.setCpf(ler.nextLine());
                    break;
                    case "4":
                        System.out.println("|Alterar Pix: ");
                        // ler.nextLine();
                        cliente.setPix(ler.nextLine());
                    break;
                    case "5":
                        System.out.println("|Alterar valor interno do pix: ");
                        // ler.nextDouble();
                        cliente.setPixcash(ler.nextDouble());
                    break;
                    case "0":
                        on10=false;
                    break;
                    default:
                    System.out.println("|Operação inválida");

                }
            }
        }else{
            System.out.println("|Você não tem permissão de Administrador");
        }
    }
    public void painelCliente(){//painel de controle do cliente
        if(funcionarioLogado instanceof Admin){
            boolean on6=true;
            while(on6==true){
                System.out.println("|Clinete: "+cliente.toString());
                System.out.println("|(0)Sair");
                System.out.println("|(1)Editar");

                switch(ler.nextLine()){
                    case "0":
                        on6=false;
                    break;
                    
                    case "1":
                        editarCliente();
                    break;
                }
            }
        }else{
            System.out.println("|Você não tem permissão de Administrador");
        }
    }

    // // ------------------------------------------------------------------------


    // // ------------------------------------------------------------------------
    //PEDIDOS -- mexendo com pedidos dos clientes 
    public void painelPedido(){//painel de controle do pedido
        boolean on2=true;
        while(on2==true){            
            System.out.println("|(1)Pedido");
            System.out.println("|(2)Encerrar");

            if(pedido.size()==0){
            }else{
                System.out.println("|(3)Remover um produto da lista");
                System.out.println("|(4)Listar produtos pedido");
                System.out.println("|(5)Pagar Pedido");
            }
            ler.nextLine();
            switch(ler.nextLine()){
                case "1":
                    showProduto();

                    System.out.println("|Indique a posição do produto e depois a quantidade");
                    int position = ler.nextInt();

                    //capturando a posição do objeto e colocando dentro da ArrayList pedido
                    Produto produto = armazem.get(position);
                    System.out.println("|Produto escolhido: "+produto.toString());
                    
                    System.out.println("|Indique a quantidade: ");
                    quantidade = ler.nextInt();

                    //verificando se tem estoque suficiente
                    while(quantidade>produto.getAmount()){
                        System.out.println("|Estoque insuficiente |Quantidade Disponivel: "+produto.getAmount());
                        quantidade= ler.nextInt();
                    }

                    pedido.add(produto);
                    quantidadeList.add(quantidade);
                    precoList.add(produto.getPrice());

                break;

                case "2":
                    on2=false;
                    pedido.clear();
                    precoList.clear();
                    quantidadeList.clear();
                break;

                case "3":
                    System.out.println("====================================================");

                    System.out.println("|Sua lista: ");
                    for(int i=0; i<pedido.size();++i){
                        System.out.println("|Quantidade solicitada: "+quantidadeList.get(i)+" |Nome: "+pedido.get(i).getName()+" |Preco: "+pedido.get(i).getPrice()+" |Validade: "+pedido.get(i).getDuration());
                    }

                    System.out.println("|Indique a posicao do produto");
                    position = ler.nextInt();

                    pedido.remove(position);
                    precoList.remove(position);
                    quantidadeList.remove(position);

                    System.out.println("|Produto removido da lista de pedido");
                    System.out.println("====================================================");
                break;

                case "4":
                    System.out.println("====================================================");
                    System.out.println("|Sua lista: ");
                    for(int i=0; i<pedido.size();++i){
                        System.out.println("|Quantidade solicitada: "+quantidadeList.get(i)+" |Nome: "+pedido.get(i).getName()+" |Preco: "+pedido.get(i).getPrice()+" |Validade: "+pedido.get(i).getDuration());
                    }
                    System.out.println("====================================================");
                break;

                case "5":
                    on2=false;

                    // calculaPedido();
                    // pay.setValorCobrado(precoPedido);


                    System.out.println("|Selecione a forma de pagemento");
                    System.out.println("|(1)Pix");
                    System.out.println("|(2)A vista");
                    System.out.println("|(0)Cancelar");
                    switch(ler.nextLine()){
                        case "1":
                            calculaPedido();
                            pay.setValorCobrado(precoPedido);
                            pay.pagamentoPix(cliente.getPix(),cliente.getPixcash());
                        break;
                        case "2":
                            calculaPedido();
                            pay.setValorCobrado(precoPedido);
                            pay.pagamentoAvista();
                        break;
                        case "0":
                            pedido.clear();    
                            precoList.clear();    
                            quantidadeList.clear();   
                        break;
                        default:
                            System.out.println("|Operação inválida");
                            System.out.println("====================================================");
                    }

                    //controle do estoque
                    if(pay.getPayPixConfirmed()==true){
                        for(int i=0; i<pedido.size();++i){
                            pedido.get(i).setAmount(pedido.get(i).getAmount()-quantidadeList.get(i));
                        }
                        
                        //diminuindo da conta do cliente
                        cliente.setPixcash(cliente.getPixcash()-pay.getValorCobrado());

                        caixa.entrada(pay.getValorCobrado());
                        //caso o pagamento foi concluido e todos os outros processos forem feitos, ele irar mandar para a classe caixa os dados
                        
                        for(int i=0; i<pedido.size();++i){
                            caixa.adicionarListas(pedido.get(i),quantidadeList.get(i));
                        }
                        
                        //zerando a arraylist
                        pedido.clear();
                        precoList.clear();
                        quantidadeList.clear();
                    }

                    if(pay.getPayConfirmed()==true){
                        for(int i=0; i<pedido.size();++i){
                            pedido.get(i).setAmount(pedido.get(i).getAmount()-quantidadeList.get(i));
                        }
                        
                        caixa.entrada(pay.getValorCobrado());
                        //caso o pagamento foi concluido e todos os outros processos forem feitos, ele irar mandar para a classe caixa os dados
                        for(int i=0; i<pedido.size();++i){
                            caixa.adicionarListas(pedido.get(i),quantidadeList.get(i));
                        }
                        

                        //zerando a arraylist
                        pedido.clear();
                        precoList.clear();
                        quantidadeList.clear();
                    }
                break;
                default:
                    System.out.println("|Operação inválida");
                    System.out.println("====================================================");
            }
        }

        System.out.println("====================================================");
    }
    public void calculaPedido(){
        for(int i=0; i<quantidadeList.size();++i){
            precoPedido += quantidadeList.get(i) * precoList.get(i);                               
        }
    }

    // // ------------------------------------------------------------------------


    // // ------------------------------------------------------------------------
    //INTERFACES - Auth - 
    //o registro deve ser feito de maneira interna, portanto terá um usuário padrão, em adicionar novo funcionario
    //@Override
    public void login(){//aqui será feito a autenticação do funcionario
        boolean logado=false;
        while(logado==false){
            System.out.println("|Insira duas vezes a matricula para confirmar");
            String matricula = ler.nextLine();
            matricula = ler.nextLine();

            System.out.println("|Insira sua Senha");
            String senha = ler.nextLine();

            //logando
            for(Funcionario funcionario : funcionarios){

                if((funcionario.getPassword().equals(senha))&&(funcionario.getRegistration().equals(matricula))){

                    // pegando o funcionario logado
                    funcionarioLogado=funcionarios.get(funcionarios.indexOf(funcionario));
                    logado=true;

                    if(funcionario instanceof Admin){
                        painelAdmin();
                    }else{
                        painelPrincipal();
                    }

                    break;
                }else{
                    logado=false;
                }
            }
        }

    }
    // // -------------------------------------------------------------------------


    // // -------------------------------------------------------------------------
    public void painelAdmin(){
        System.out.println("=======================================");  
        System.out.println("|Logado => "+funcionarioLogado.toString());
        System.out.println("======================================="); 
        boolean on5=true;
        while(on5==true){
            System.out.println("|(1)Funcionarios");
            System.out.println("|(2)Cliente");
            System.out.println("|(3)Deslogar");
            System.out.println("|(4)Desligar");
            switch(ler.nextLine()){
                case "1":
                    painelFuncionario();
                break;
                case "2":
                    painelCliente();
                break;
                case "3":
                    on5=false;
                    funcionarioLogado = null;
                    login();
                break;
                case "4":
                    on5=false;
                    System.out.println("|Ate Logo!");
                    System.exit(0);
                break;
                case "5":
                    caixa.painelCaixa();
                break;
                default:
                    System.out.println("|Operação inválida");
            }

        }
    }
    public void painelPrincipal(){
        System.out.println("=======================================");  
        System.out.println("|Logado => "+funcionarioLogado.toString());
        System.out.println("=======================================");  
        boolean on4=true;
        while(on4==true){
            System.out.println("|(1)Produtos");
            System.out.println("|(2)Iniciar Novo Pedido");
            System.out.println("|(3)Deslogar");
            System.out.println("|(4)Desligar");
            System.out.println("|(5)Caixa");

            switch(ler.nextLine()){
                case "1":
                    painelProduto();
                break;
                case "2":
                    painelPedido();
                break;
                case "3":
                    on4=false;
                    funcionarioLogado = null;
                    login();
                break;
                case "4":
                    on4=false;
                    System.out.println("|Ate Logo!");
                    System.exit(0);
                break;
                case "5":
                    caixa.painelCaixa();
                break;
                default:
                    System.out.println("|Operação inválida");
            }
        }
    }
    // // -------------------------------------------------------------------------
}