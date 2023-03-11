public class Pessoa{
    protected String name;
    protected String telephone;
    protected String cpf;

    public Pessoa(String name, String telephone, String cpf) {
        this.name = name;
        this.telephone = telephone;
        this.cpf = cpf;
    }


    public Pessoa() {
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


}