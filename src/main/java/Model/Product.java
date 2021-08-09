package Model;

public class Product {
    private int id;
    private String name;
    private float price;
    private int amount;
    private String colour;
    private String description;
    private String category;

    public Product(String name, int amount, String colour, String description, String category) {
        this.name = name;
        this.amount = amount;
        this.colour = colour;
        this.description = description;
        this.category = category;
    }

    public Product(int id, String name, int amount, String colour, String description, String category) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.colour = colour;
        this.description = description;
        this.category = category;
    }

    public Product(int id, String name, float price, int amount, String colour, String description, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.colour = colour;
        this.description = description;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
