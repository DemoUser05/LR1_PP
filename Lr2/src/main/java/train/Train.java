package train;

public class Train {
    private String destination; // Пункт призначення
    private int trainNumber;    // Номер поїзду
    private String departureTime; // Час відправки
    private int generalSeats;   // Кількість загальних місць
    private int coupeSeats;     // Кількість місць у купе
    private int platskartSeats; // Кількість плацкартних місць
    private int luxurySeats;    // Кількість місць люкс

    // Конструктор
    public Train(String destination, int trainNumber, String departureTime, int generalSeats, int coupeSeats, int platskartSeats, int luxurySeats) {
        this.destination = destination;
        this.trainNumber = trainNumber;
        this.departureTime = departureTime;
        this.generalSeats = generalSeats;
        this.coupeSeats = coupeSeats;
        this.platskartSeats = platskartSeats;
        this.luxurySeats = luxurySeats;
    }

    // Методи доступу (геттери і сеттери)
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public int getGeneralSeats() {
        return generalSeats;
    }

    public void setGeneralSeats(int generalSeats) {
        this.generalSeats = generalSeats;
    }

    public int getCoupeSeats() {
        return coupeSeats;
    }

    public void setCoupeSeats(int coupeSeats) {
        this.coupeSeats = coupeSeats;
    }

    public int getPlatskartSeats() {
        return platskartSeats;
    }

    public void setPlatskartSeats(int platskartSeats) {
        this.platskartSeats = platskartSeats;
    }

    public int getLuxurySeats() {
        return luxurySeats;
    }

    public void setLuxurySeats(int luxurySeats) {
        this.luxurySeats = luxurySeats;
    }

    // Метод toString для виведення інформації про поїзд
    public String toString() {
        return "Поїзд: " +
                "Місцу призначення: '" + destination + '\'' +
                ", Номер поїзда: " + trainNumber +
                ", Час відправлення: '" + departureTime + '\'' +
                ", Кількість загальних місць: " + generalSeats +
                ", Місць-купе: " + coupeSeats +
                ", Плацкарт-місць: " + platskartSeats +
                ", Люкс-місць: " + luxurySeats +
                '}';
    }
}
