public class Main {
    public static void main(String[] args) {

        //Declarem el maxim de vehicles que hi poden entrar al pont
        Pont pont = new Pont(3);

        //Declarem els arrays dels sentits dels vehicles, cadascun amb 9 dades dins.
        Vehicle vehicleDreta[] = new Vehicle[9];
        Vehicle vehicleEsquerra[] = new Vehicle[9];

        //Amb aquests fors omplim els arrays i els executem.
        for (int i = 0; i < 9; i++) {
            vehicleDreta[i] = new Vehicle(pont,"Cotxe " + i, Vehicle.tipusVehicle.Cotxe, (short) 1);
            vehicleEsquerra[i] = new Vehicle(pont,"Moto " + i ,  Vehicle.tipusVehicle.Moto, (short) 2);
        }

        for (int i = 0; i < 9; i++) {
            vehicleDreta[i].start();
            vehicleEsquerra[i].start();
        }
    }
}
