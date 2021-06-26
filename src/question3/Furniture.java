package question3;

public class Furniture{
    // Do something
}

class Table extends Furniture{
    // Do something
}

class Chair extends Furniture{
    // Do something
}

class CoffeeTable extends Furniture{
    // Do something
}


interface FurnitureFactory{

    public Furniture createFurniture();
}

class TableCreator implements FurnitureFactory{

    @Override
    public Furniture createFurniture() {
        return new Table();
    }
}

class ChairCreator implements FurnitureFactory{

    @Override
    public Furniture createFurniture() {
        return new Chair();
    }
}

class CoffeeTableCreator implements FurnitureFactory{

    @Override
    public Furniture createFurniture() {
        return new CoffeeTable();
    }
}