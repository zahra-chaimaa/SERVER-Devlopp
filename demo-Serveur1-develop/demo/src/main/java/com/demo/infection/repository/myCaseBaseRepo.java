package com.demo.infection.repository;

import com.demo.infection.jcolibri.cbrcore.CBRCase;
import com.demo.infection.jcolibri.cbrcore.CBRCaseBase;
import com.demo.infection.jcolibri.cbrcore.Connector;
import com.demo.infection.jcolibri.connector.DataBaseConnector;
import com.demo.infection.jcolibri.exception.InitializingException;
import com.demo.infection.jcolibri.util.FileIO;
import com.demo.infection.model.CaseDescription;
import com.demo.infection.model.casesSolution;
import org.springframework.data.mapping.model.CamelCaseSplittingFieldNamingStrategy;

import java.sql.*;
import java.util.Collection;
import java.util.Iterator;

public class myCaseBaseRepo {
    //will be using this to fill the casebase using a loop

    static final String DB_URL = "jdbc:mysql://localhost:3306/infection";
        static final String USER = "root";
        static final String PASS = "";

        public void fillCaseBase(CBRCaseBase _mycasebase, Connector _connector) {
              try {
                _mycasebase.init(_connector);
            } catch (InitializingException e) {
                e.printStackTrace();
            }



            Collection<CBRCase> casestolearn = new Collection<CBRCase>() {
                @Override
                public int size() {
                    return 0;
                }

                @Override
                public boolean isEmpty() {
                    return false;
                }

                @Override
                public boolean contains(Object o) {
                    return false;
                }

                @Override
                public Iterator<CBRCase> iterator() {
                    return null;
                }

                @Override
                public Object[] toArray() {
                    return new Object[0];
                }

                @Override
                public <T> T[] toArray(T[] a) {
                    return null;
                }

                @Override
                public boolean add(CBRCase cbrCase) {
                    return false;
                }

                @Override
                public boolean remove(Object o) {
                    return false;
                }

                @Override
                public boolean containsAll(Collection<?> c) {
                    return false;
                }

                @Override
                public boolean addAll(Collection<? extends CBRCase> c) {
                    return false;
                }

                @Override
                public boolean removeAll(Collection<?> c) {
                    return false;
                }

                @Override
                public boolean retainAll(Collection<?> c) {
                    return false;
                }

                @Override
                public void clear() {

                }
            };
            CBRCase aCase = new CBRCase();

            CaseDescription casedesctiption = new CaseDescription();
            casesSolution casesolution = new casesSolution();

            try {
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                System.out.println("CONNECTED TO THE DATABASE");
                String query = "SELECT * FROM casebase";
                Statement stm = conn.createStatement();
                ResultSet rs  = stm.executeQuery(query);

                while (rs.next()){
                    casedesctiption.setAbl(rs.getString("abl"));
                    casedesctiption.setBrm(rs.getString("brm"));
                    casesolution.setAutr(Integer.parseInt(rs.getString("autr")));
                }


                aCase.setDescription(casedesctiption);
                aCase.setSolution(casesolution);
                casestolearn.add(aCase);

                _mycasebase.learnCases(casestolearn);


            } catch (SQLException e) {
                e.printStackTrace();
            }


        }


    public Collection<CBRCase> colelctionCase() {

        Collection<CBRCase> casestolearn = new Collection<CBRCase>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<CBRCase> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(CBRCase cbrCase) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends CBRCase> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }
        };
        CBRCase aCase = new CBRCase();

        CaseDescription casedesctiption = new CaseDescription();
        casesSolution casesolution = new casesSolution();

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("CONNECTED TO THE DATABASE");
            String query = "SELECT * FROM casebase";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);

            while (rs.next()) {
                casedesctiption.setAbl(rs.getString("abl"));
                casedesctiption.setBrm(rs.getString("brm"));
                casesolution.setAutr(Integer.parseInt(rs.getString("autr")));
            }


            aCase.setDescription(casedesctiption);
            aCase.setSolution(casesolution);
            casestolearn.add(aCase);




        } catch (SQLException e) {
            e.printStackTrace();
        }


        return casestolearn;
    }
}
