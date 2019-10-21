import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.CancellationException;

public class ParkingLot
{
    private int capacity       = 0;
    private int CurrentCount   = 0;
    int         AvailableSlots = 0;
    DataModel   model          = null;

    LinkedList<vehicle> vehicles = new LinkedList<vehicle>();

    public ParkingLot(String path, int capacity) throws IOException {
        this.capacity = capacity;
        model = new DataModel(path);
        model.Read();
    }

    public void Handle()
    {
        for(int num=0; num<model.items.size(); num++)
        {
            DataItem item = model.items.get(num);
            if (item != null)
            {
                //item.Print();
                Process((item));
            }
        }
    }

    void Process(DataItem item)
    {
        if (item == null)
            return;

        if (item.IsArriving == 1) {
            vehicle v = new vehicle(item);
            Add(v);
        }
        else {
            remove(item.CarID);
        }
    }

    void Add(vehicle v)
    {
        if (CanAdd())
        {
            System.out.println("vehicle " + v.vehicleID + " ENTERING" );
            vehicles.add(v);
        }
    }

    void remove(int id)
    {
        vehicle v = FindById(id);
        if (v != null) {
            System.out.println("vehicle " + v.vehicleID + " LEAVINGS" );
            v.pay();
            vehicles.remove(v);
        }
    }

    vehicle FindById(int id)
    {
        for(int num=0; num < vehicles.size(); num++)
        {
            vehicle v = vehicles.get(num);
            if (v != null)
            {
                if (v.vehicleID == id)
                    return v;
            }
        }
        return null;
    }

    boolean IsEmpty()
    {
        return vehicles.size() == 0;
    }

    boolean IsFull()
    {
        return vehicles.size() >= capacity;
    }

    boolean CanAdd()
    {
        return !IsFull();
    }
}
