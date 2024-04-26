package net.javaguides.usermanagement.model;


public class User {
    protected int id;
    protected String marca;
    protected String model;
    protected String detalii;
    protected String pret;

    public User() {}

    public User(String marca, String model, String detalii, String pret) {
        super();
        this.marca = marca;
        this.model = model;
        this.detalii = detalii;
        this.pret = pret;
    }

    public User(int id, String marca, String model, String detalii, String pret) {
        super();
        this.id = id;
        this.marca = marca;
        this.model = model;
        this.detalii = detalii;
        this.pret = pret;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getDetalii() {
        return detalii;
    }
    public void setDetalii(String detalii) {
        this.detalii = detalii;
    }
    public String getPret() {
        return pret;
    }
    public void setPret(String pret) {
        this.pret = pret;
    }
}