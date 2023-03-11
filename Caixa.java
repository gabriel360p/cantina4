import java.util.ArrayList;
import java.util.Scanner;

public class Caixa{
    
    private double cash_total=0;

    Scanner ler = new Scanner(System.in);

    ArrayList<Produto> listaVendidos = new ArrayList();
    ArrayList<Integer> quantidadeList = new ArrayList();

    public void adicionarListas(Produto produto, int quantidade){
        listaVendidos.add(produto);
        quantidadeList.add(quantidade);
    }

    public void showVendidos(){
        System.out.println("|Produtos Vendidos: ");
        for(int i=0; i<listaVendidos.size();++i){
            System.out.println("|Quantidade vendida por venda: "+quantidadeList.get(i)+" |Nome: "+listaVendidos.get(i).getName()+" |Preco: "+listaVendidos.get(i).getPrice()+" |Validade: "+listaVendidos.get(i).getDuration());

        }
    }

    public void painelCaixa(){
        if(this.cash_total==0){
            System.out.println("|Caixa Vazio");
            System.out.println("====================================================");
        }else{
            boolean on10=true;
            while(on10==true){
                System.out.println("|(0)Sair");
                System.out.println("|(1)Produtos Vendidos");
                System.out.println("|(2)Total no caixa");
                switch(ler.nextInt()){
                    case 1:
                        showVendidos();
                    break;
                    case 2:
                        showCaixa();
                    break;
                    case 0:
                        on10=false;
                    break;
                }
            }
        }
    }

    public void showCaixa(){
        System.out.println("|Total no caixa: "+this.cash_total);
    }

    public void entrada(double valor){
        this.cash_total=this.cash_total+valor;
    }

    public double getCash_total() {
        return this.cash_total;
    }

    public void setCash_total(double cash_total) {
        this.cash_total = cash_total;
    }
   
}