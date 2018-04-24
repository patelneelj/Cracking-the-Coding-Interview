import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

class Stock {
	private String name;
	private long quantity;
	private long price;
	private float percNAV;

	public Stock(String name, long quantity, long price) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public float getPercNAV() {
		return percNAV;
	}

	public void setPercNAV(float percNAV) {
		this.percNAV = percNAV;
	}
}


public class NAV {
	
	public static double roundOfftoTwoDecimal(double val) {
		return Math.round(val * 100.0) / 100.0;
	}

	private static void calPercNavAndSet(Map<String, Stock> map, long nav) {
		for (Map.Entry<String, Stock> entry : map.entrySet()) {
			Stock stock = entry.getValue();
			stock.setPercNAV((float) stock.getPrice() * stock.getQuantity() * 100 / nav);
		}
	}

	private static long calculateNav(Map<String, Stock> portMap) {
		long nav = 0;
		for (Map.Entry<String, Stock> entry : portMap.entrySet()) {
			Stock stock = entry.getValue();
			nav += stock.getPrice() * stock.getQuantity();
		}
		return nav;
	}
	
	public static void main(String[] args) throws IOException {
		   File f = new File("E:/nav.txt");
			BufferedReader in = new BufferedReader(new FileReader(f));
		String line;
		while ((line = in.readLine()) != null) {
			if (line.isEmpty())
				break;

			String[] portfolio = line.split("\\|");
			String[] port = portfolio[0].split(":")[1].split(";");
			String[] bench = portfolio[1].split(":")[1].split(";");
			Map<String, Stock> portMap = new HashMap<String, Stock>();
			Map<String, Stock> benchMap = new HashMap<String, Stock>();

			SortedSet<String> stockNames = new TreeSet<String>();

			for (String stockStr : port) {
				String[] stock = stockStr.split(",");
				portMap.put(stock[0], new Stock(stock[0], Long.parseLong(stock[1]), Long.parseLong(stock[2])));
				stockNames.add(stock[0]);
			}

			for (String stockStr : bench) {
				String[] stock = stockStr.split(",");
				benchMap.put(stock[0], new Stock(stock[0], Long.parseLong(stock[1]), Long.parseLong(stock[2])));
				stockNames.add(stock[0]);
			}

			long portNAV = calculateNav(portMap);
			long benchNAV = calculateNav(benchMap);

			calPercNavAndSet(portMap, portNAV);
			calPercNavAndSet(benchMap, benchNAV);

			String seperator = "";
			for (String name : stockNames) {
				Stock portStock = portMap.get(name);
				Stock benchStock = benchMap.get(name);

				double diffPercNav = (portStock != null ? portStock.getPercNAV() : 0)
						- (benchStock != null ? benchStock.getPercNAV() : 0);
				String diffPercNavStr = String.format("%.2f", roundOfftoTwoDecimal(diffPercNav));
				if (diffPercNav == 0)
					diffPercNavStr = "-0.00";
				System.out.print(seperator + name + ":" + diffPercNavStr);
				seperator = ",";
			}
			System.out.println();
		}
	}

}
