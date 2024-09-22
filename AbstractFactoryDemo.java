import java.text.MessageFormat;
import java.util.List;
import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

abstract class Product {
  protected String description;

  public abstract void makeComputer(int cpu, int ram, int storage, int display);

  public String getInfo() {
    return this.description;
  }
}

class PC extends Product {
  public void makeComputer(int cpu, int ram, int storage, int display) {
    this.description = MessageFormat.format("DELL PC: CPU {0}, RAM {1}, STORAGE {2}, DISPLAY {3}", cpu, ram, storage,
        display);
  }
}

class Laptop extends Product {
  public void makeComputer(int cpu, int ram, int storage, int display) {
    this.description = MessageFormat.format("DELL Laptop: CPU {0}, RAM {1}, STORAGE {2}, DISPLAY {3}", cpu, ram,
        storage, display);
  }
}

class IMac extends Product {
  public void makeComputer(int cpu, int ram, int storage, int display) {
    this.description = MessageFormat.format("APPLE iMac: CPU {0}, RAM {1}, STORAGE {2}, DISPLAY {3}", cpu, ram,
        storage, display);
  }
}

class MacBook extends Product {
  public void makeComputer(int cpu, int ram, int storage, int display) {
    this.description = MessageFormat.format("APPLE MacBook: CPU {0}, RAM {1}, STORAGE {2}, DISPLAY {3}", cpu, ram,
        storage, display);
  }
}

abstract class OrderSystem {
  List<Product> productList = new ArrayList<>();

  void placeOrder(String type, int cpu, int ram, int storage, int display) {
    var product = create(type, cpu, ram, storage, display);
    productList.add(product);
  }

  void listOrders() {
    for (var product : productList)
      System.out.println(product.getInfo());
  }

  abstract Product create(String type, int cpu, int ram, int storage, int display);
}

class Order extends OrderSystem {
  Map<String, Supplier<Product>> creator = new HashMap<>();

  public Product create(String type, int cpu, int ram, int storage, int display) {
    Product product = this.creator.get(type.toLowerCase()).get();
    product.makeComputer(cpu, ram, storage, display);
    return product;
  }
}

class DellVendor extends Order {
  public DellVendor() {
    super();
    this.creator.put("pc", () -> new PC());
    this.creator.put("laptop", () -> new Laptop());
  }
}

class AppleVendor extends Order {
  public AppleVendor() {
    super();
    this.creator.put("imac", () -> new IMac());
    this.creator.put("macbook", () -> new MacBook());
  }
}

class Vendor {
  public Order getVendor(String vendorType) {
    Order vendor = null;

    switch (vendorType.toLowerCase()) {
      case "dell":
        vendor = new DellVendor();
        break;
      case "apple":
        vendor = new AppleVendor();
        break;
    }

    return vendor;
  }
}

public class AbstractFactoryDemo {

  public static void main(String[] args) {

    Vendor vendor = new Vendor();

    Order order = vendor.getVendor("Dell");
    order.placeOrder("PC", 16, 64, 2048, 64);
    order.placeOrder("Laptop", 32, 128, 2048, 128);

    order.listOrders();

    order = vendor.getVendor("apple");
    order.placeOrder("imac", 4, 16, 512, 16);
    order.placeOrder("macbook", 8, 32, 1024, 32);

    order.listOrders();
  }
}
