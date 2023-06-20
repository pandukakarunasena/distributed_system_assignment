package ds.assignment.communication.client;

public class MainClass {

    public static void main(String[] args) throws InterruptedException {

        String host = args[0];
        int port = Integer.parseInt(args[1].trim());
        String operation = args[2];

        if (args.length != 3) {
            System.out.println("Usage CheckBalanceServiceClient <host> <port> <purchase(et)|restock(heck)");
            System.exit(1);
        }

        if ("restock".equals(operation)) {
            RestockItemServiceClient client = new RestockItemServiceClient(host, port);
            client.initializeConnection();
            client.processUserRequests();
            client.closeConnection();
        } else if ("purchase".equals(operation)) {
            PurchaseItemServiceClient client = new PurchaseItemServiceClient(host, port);
            client.initializeConnection();
            client.processUserRequests();
            client.closeConnection();
        } else {
            GetItemQuantityServiceClient client = new GetItemQuantityServiceClient(host, port);
            client.initializeConnection();
            client.processUserRequests();
            client.closeConnection();
        }
    }
}
