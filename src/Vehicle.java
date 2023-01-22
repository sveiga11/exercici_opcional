public class Vehicle extends Thread{

    //Cridem a la clase pont y a la variable del sentit de la circulacio
    private Pont pont;
    private short sentitCirculació;

    //Enumerem els tipus de vehicles. Cunjuntem variables.
    public enum tipusVehicle {
        Cotxe, Moto
    }

    //Declarem el contructor Vehicle per poder inicialitzar les variables de pont, vehicle, tipus de vehicle, i el sentit de la ciruclacio.
    public Vehicle(Pont pont, String vehicle, tipusVehicle tipusv, short sentit) {
        super(vehicle);
        this.pont = pont;
        sentitCirculació = sentit;
    }

    //Iniciem tots els metodes
    @Override
    public void run() {
        for(;;) {
            pont.arribarPont(sentitCirculació);
            creuarPont();
            pont.sortirDelPont();
        }
    }

    //Indiquem quin vehicle esta creuant el pont.
    private void creuarPont() {
        System.out.println(getName() + " esta creuant el pont");
        try {
            Thread.sleep((long) Math.random()*2000+1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
