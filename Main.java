    public class Main{
    public static void main(String[] args){
        Cantina cantina = new Cantina();

        //inserindos dados iniciais
        cantina.seeders();

        System.out.println("=======================================");
        System.out.println("|Bem vindo a cantina virtual! | v4");
        System.out.println("=======================================");

        cantina.login();
    }
}