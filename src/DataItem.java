import java.util.Date;

public class DataItem
{
    // 1, 1, 10/20/2019 2:10:00, 10/20/2019 3:10:00, 1.2
    int CarID;
    int IsArriving;
    Date ArrivedAt;
    Date DepartureDate;
    double Price;

    public DataItem(int carID, int isArriving, Date arrivedAt, Date departureDate, double price)
    {
       CarID = carID;
        IsArriving = isArriving;
        ArrivedAt = arrivedAt;
        DepartureDate = departureDate;
        Price = price;

    }

    public void Print()
    {
        System.out.println(CarID);
        System.out.println(IsArriving);
        System.out.println(ArrivedAt);
        System.out.println(DepartureDate);
        System.out.println(Price);

    }
}
