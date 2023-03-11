import java.util.ArrayList;
import java.util.Scanner;

public class Pagamento{
    private double troco;
    private double valorEntrada;
    private double valorCobrado;
    private boolean payPixConfirmed;
    private boolean payConfirmed;

    Scanner ler = new Scanner(System.in);

    public void pagamentoPix(String pix,double cash_pix){
        boolean enter = true;
        while(enter==true){
            System.out.println("|Valor cobrado: "+this.valorCobrado+" |Sua Chave"+pix+" |Valor dentro do pix: "+cash_pix);
            System.out.println("|(1)Confirmar Pagamento");
            System.out.println("|(2)Cancelar Pagamento");
            switch(ler.nextLine()){
                case "1":
                    if(cash_pix<this.valorCobrado){
                        System.out.println("|Saldo do pix insuficiente");
                        System.out.println("|Pagamento não confirmado");
                        enter = false;
                        payPixConfirmed=false;
                    }else{
                        payPixConfirmed=true;
                        enter = false;
                        System.out.println("|Pagamento confirmado");
                    }
                break;

                case "2":
                    enter = false;
                    payPixConfirmed=false;
                break;

                default:
                    System.out.println("|Operação inválida");
            }
        }
        System.out.println("====================================================");
    }

    public void pagamentoAvista(){
        boolean enter = true;
        while(enter==true){
            System.out.println("|(1)Confirmar pagamento");
            System.out.println("|(2)Cancelar pagamento");
            switch(ler.nextLine()){
                case "1":
                    System.out.println("|Digite um valor |Valor Cobrado: "+this.valorCobrado);
                    valorEntrada= ler.nextDouble();
                    if(valorEntrada<this.valorCobrado){
                        System.out.println("|Valor insuficiente");
                        System.out.println("|Pagamento não confirmado");
                    }else{
                        this.troco = valorEntrada - this.valorCobrado;

                        if(this.troco<=0){
                        }else{
                            System.out.println("|Troco: R$"+this.troco);
                            System.out.println("|Pagamento a vista confirmado");
                            enter=false;
                        }
                        payConfirmed=true;
                    }
                break;

                case "2":
                    payConfirmed=false;
                    enter = false;
                break;

                default:
                    System.out.println("|Operação inválida");
            }

        }
        System.out.println("====================================================");
    }

    // ------------------------------------------------------------------------- GETTERS SETTERS

    public double getValorCobrado() {
        return this.valorCobrado;
    }

    public void setValorCobrado(double valorCobrado) {
        this.valorCobrado = valorCobrado;
    }

    public double getTroco() {
        return this.troco;
    }

    public void setTroco(double troco) {
        this.troco = troco;
    }    

    public boolean isPayPixConfirmed() {
        return this.payPixConfirmed;
    }

    public boolean getPayPixConfirmed() {
        return this.payPixConfirmed;
    }

    public void setPayPixConfirmed(boolean payPixConfirmed) {
        this.payPixConfirmed = payPixConfirmed;
    }

    public boolean isPayConfirmed() {
        return this.payConfirmed;
    }

    public boolean getPayConfirmed() {
        return this.payConfirmed;
    }

    public void setPayConfirmed(boolean payConfirmed) {
        this.payConfirmed = payConfirmed;
    }
}