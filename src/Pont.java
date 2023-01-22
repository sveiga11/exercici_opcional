public class Pont {

    //Declarem las variables del estat del pont, el numero de vehicles i el maxim de vehicles per pont, i el pont.
    private short estatPont; //0:El pont esta buit 1:Pasen els vehicles per l'esquerra 2:Pasen els vehicles per la dreta 2:Pont ple
    int numeroVehicles;
    private int maximVehicles;
    String pont;

    //Declarem les Variables
    public Pont(int max){
        estatPont = 0;
        numeroVehicles = 0;
        maximVehicles = max;
    }

    //Finalitzem l'execucio i returnem el valor del estat del pont a la funcio
    public synchronized short getEstatPont() {
        return estatPont;
    }

    //Motodes synchronized
    //Aquets metodes hem serveixen sincronitzar les funcions i que nomes un subproces pugui entrar al metode.

    public synchronized void arribarPont(short sentitCirculacio) {

        try {
            while ((estatPont !=0 && sentitCirculacio!= estatPont) || estatPont ==3) wait();

            if(estatPont == 0) estatPont = sentitCirculacio;
            if(++numeroVehicles == maximVehicles) estatPont = 3;


            //Declarem els posibles estats del pont
            switch (estatPont) {
                case 0: pont ="No hi ha cap vehicle al pont.";break;
                case 1: pont ="cotexes pasant per l'esquerra ";break;
                case 2: pont ="motos pasant per la dreta!";break;
                case 3: pont ="El pont esta ple de vehicles";break;
            }

            //Si al pont hi han menys de 3 vehicles indicara quants vehiciles hi han dins del pont
            if (estatPont != 3){
                System.out.println("Hi ha " + numeroVehicles + " " + pont);

            }

            //Si al pont hi han 3 vehicles es notoficara per que no pasi cap vehicle mes
            if (estatPont == 3){
                System.out.println("Hi han 3 vehicles al pont.");
                System.out.println(pont);
            }
            notifyAll();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public synchronized void sortirDelPont() {

        //Restem el numero de vehicles que hi ha dins del pont i indiquem quin es el vehicle que surt del pont
        numeroVehicles--;
        System.out.println(estatPont + " surt del pont");

        //Com al pont ja no queda cap vehicle o notifiquem
        if (numeroVehicles == 0){
            estatPont = 0;
            System.out.println("El pont es troba buit");
        }
        notifyAll();
    }
}