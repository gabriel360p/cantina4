public class Funcionario extends Pessoa{
    private String office;
    private double wage;
    private String registration;
    private String password;

    public Funcionario(String name, String telephone, String cpf,double wage,String office, String registration, String password) {
        super(name,telephone,cpf);
        this.office=office;
        this.wage=wage;
        this.registration=registration;
        this.password = password;
    }


    public Funcionario() {
    }


    public String toString(){
        return "|Nome: "+getName()+" |Função: "+getOffice()+" |Matricula: "+getRegistration();
    }

    // ------------------------------------------------------------------------- GETTERS SETTERS

    public String getOffice() {
        return this.office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public double getWage() {
        return this.wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public String getRegistration() {
        return this.registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

}
