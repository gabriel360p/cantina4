import java.util.Scanner;
public class Cliente extends Pessoa{
    private String pix;
    private double pixcash;


    public Cliente() {
    }

    
    public Cliente(String name, String telephone, String cpf, String pix, double pixcash) {
        super(name,telephone,cpf);
        this.pix=pix;
        this.pixcash=pixcash;
    }

    public String toString(){
        return "|Nome: "+getName()+" |Chave pix: "+getPix()+" |Valor dentro do pix: "+getPixcash();
    }

    public String getPix() {
        return this.pix;
    }

    public void setPix(String pix) {
        this.pix = pix;
    }

    public double getPixcash() {
        return this.pixcash;
    }

    public void setPixcash(double pixcash) {
        this.pixcash = pixcash;
    }

}
