import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        if (args.length != 0) {
            ParkingLot _lot = new ParkingLot(args[0], 10);
            _lot.Handle();
        }
        else {
            System.out.println("Usage: exe test.txt");
        }
    }
}
