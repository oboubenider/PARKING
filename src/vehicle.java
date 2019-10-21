public class vehicle
{
    int vehicleID;
    ticket AssignedTicket;
    double price = 0;

    public vehicle(DataItem item)
    {
        vehicleID = item.CarID;
        price = item.Price;
        AssignedTicket = new ticket(item.ArrivedAt, item.DepartureDate);
    }

    public double pay()
    {
        AssignedTicket.IsDone();
        return AssignedTicket.DurationofStay()* price;
    }
}
