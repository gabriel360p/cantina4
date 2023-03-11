public abstract class Produto{
    protected String name;
    protected double price;
    protected int amount;
    protected String duration;
    protected String quality;
    protected String provider;

    public Produto(String provider,String name, double price, int amount, String duration, String quality) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.duration = duration;
        this.quality = quality;
        this.provider = provider;
    }
    

    public Produto() {
    }


    public String toString(){
        return "|Nome: "+getName()+" |Preco: "+getPrice()+" |Quantidade: "+getAmount()+" |Data de Validade: "+getDuration()+" |Qualidade: "+getQuality()+" |Fornecedor: "+getProvider();
    }

    // ------------------------------------------------------------------------- GETTERS SETTERS

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDuration() {
        return this.duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getQuality() {
        return this.quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getProvider() {
        return this.provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

}