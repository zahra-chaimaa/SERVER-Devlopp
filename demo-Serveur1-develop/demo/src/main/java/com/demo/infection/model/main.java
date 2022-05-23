package com.demo.infection.model;

import com.demo.infection.jcolibri.cbrcore.CBRQuery;
import com.demo.infection.jcolibri.cbrcore.CaseComponent;
import com.demo.infection.jcolibri.exception.ExecutionException;
import com.demo.infection.jcolibri.util.FileIO;


import java.io.IOException;
import java.net.URL;

public class main {
    public static void main(String[] args) throws ExecutionException {
        System.out.println("This is the main function is package com.demo.second");
        System.out.println("######################");
       URL file = FileIO.findFile("C:/demo-Serveur1-Devlop/demo-Serveur1-develop/demo/src/main/java/com/demo/infection/model/databaseconfig.xml");
        System.out.println("**"+ file);





            /********* Query Definition **********/

          CaseDescription queryDesc=new CaseDescription();
            // queryDesc.setAccommodation(TravelDescription.AccommodationTypes.ThreeStars);
            queryDesc.setId(1);
            queryDesc.setNip("20/05/2022");
            queryDesc.setJ("oui");
        queryDesc.setSa("oui");
        queryDesc.setT(50);
        queryDesc.setHt("oui");
        queryDesc.setGb(50);
        queryDesc.setCrp(55);
        queryDesc.setPct(55);
        queryDesc.setRx("oui");
        queryDesc.setSec("oui");
        queryDesc.setTou("oui");
        queryDesc.setDys("oui");
        queryDesc.setAus("oui");
        queryDesc.setDes("oui");
        queryDesc.setSu("oui");
        queryDesc.setPyu("oui");
        queryDesc.setBrm("oui");
        queryDesc.setDsp("oui");
        queryDesc.setLu("oui");
        queryDesc.setFr("oui");
        queryDesc.setKt("oui");
        queryDesc.setAbl("oui");
        queryDesc.setInfkt("oui");
        test1 test = new test1();
        test.configure();
        System.out.println("la configuration succée");
        test.preCycle();
        System.out.println("precycle marche");
        CBRQuery query = new CBRQuery();
        query.setDescription((CaseComponent) queryDesc);

        test.cycle(query,2);
System.out.println("cycle marche");


            //	System.out.println("Cycle finished. Type exit to idem");
            //}while(!reader.readLine().equals("exit"));








            //  try {
        // System.out.println("Running configure()");
        //test.configure();

        //System.out.println("Running preCycle()");
        //test.preCycle();
        //System.out.println(test.mycases);
        //System.out.println("Items of the case a");
        // for(CBRCase c: test.mycases.getCases())
        //    System.out.println(c);
        //The cycle will require a query description, so we'll make it before calling the cycle

        //System.out.println("Running the cycle");
        //} catch (ExecutionException e) {
        //  e.printStackTrace();
        //}

        // }
    }
}
