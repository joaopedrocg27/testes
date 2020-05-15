/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.ui.console.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The type Utils.
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Utils
{
    /**
     * Read line from console string.
     *
     * @param strPrompt the str prompt
     * @return the string
     */
    static public String readLineFromConsole(String strPrompt)
    {
        try
        {
            System.out.println("\n" + strPrompt);

            InputStreamReader converter = new InputStreamReader(System.in);
            BufferedReader in = new BufferedReader(converter);

            return in.readLine();
        } catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Read integer from console int.
     *
     * @param strPrompt the str prompt
     * @return the int
     */
    static public int readIntegerFromConsole(String strPrompt)
    {
        do
        {
            try
            {
                String strInt = readLineFromConsole(strPrompt);

                int iValor = Integer.parseInt(strInt);

                return iValor;
            } catch (NumberFormatException ex)
            {
                Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (true);
    }

    /**
     * Read double from console double.
     *
     * @param strPrompt the str prompt
     * @return the double
     */
    static public double readDoubleFromConsole(String strPrompt)
    {
        do
        {
            try
            {
                String strDouble = readLineFromConsole(strPrompt);

                double dValor = Double.parseDouble(strDouble);

                return dValor;
            } catch (NumberFormatException ex)
            {
                Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (true);
    }

    /**
     * Read date from console date.
     *
     * @param strPrompt the str prompt
     * @return the date
     */
    static public Date readDateFromConsole(String strPrompt)
    {
        do
        {
            try
            {
                String strDate = readLineFromConsole(strPrompt);

                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

                Date date = df.parse(strDate);

                return date;
            } catch (ParseException ex)
            {
                Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (true);
    }

    /**
     * Confirma boolean.
     *
     * @param sMessage the s message
     * @return the boolean
     */
    static public boolean confirma(String sMessage) {
        String strConfirma;
        do {
            strConfirma = Utils.readLineFromConsole("\n" + sMessage + "\n");
        } while (!strConfirma.equalsIgnoreCase("s") && !strConfirma.equalsIgnoreCase("n"));

        return strConfirma.equalsIgnoreCase("s");
    }

    /**
     * Apresenta e seleciona object.
     *
     * @param list    the list
     * @param sHeader the s header
     * @return the object
     */
    static public Object apresentaESeleciona(List list,String sHeader)
    {
        apresentaLista(list,sHeader);
        return selecionaObject(list);
    }

    /**
     * Apresenta e seleciona index int.
     *
     * @param list    the list
     * @param sHeader the s header
     * @return the int
     */
    static public int apresentaESelecionaIndex(List list,String sHeader)
    {
        apresentaLista(list,sHeader);
        return selecionaIndex(list);
    }

    /**
     * Apresenta lista.
     *
     * @param list    the list
     * @param sHeader the s header
     */
    static public void apresentaLista(List list,String sHeader)
    {
        System.out.println(sHeader);

        int index = 0;
        for (Object o : list)
        {
            index++;

            System.out.println(index + ". " + o.toString());
        }
        System.out.println("");
        System.out.println("0 - Cancelar");
    }

    /**
     * Seleciona object object.
     *
     * @param list the list
     * @return the object
     */
    static public Object selecionaObject(List list)
    {
        String opcao;
        int nOpcao;
        do
        {
            opcao = Utils.readLineFromConsole("Introduza opção: ");
            nOpcao = new Integer(opcao);
        } while (nOpcao < 0 || nOpcao > list.size());

        if (nOpcao == 0)
        {
            return null;
        } else
        {
            return list.get(nOpcao - 1);
        }
    }

    /**
     * Seleciona index int.
     *
     * @param list the list
     * @return the int
     */
    static public int selecionaIndex(List list)
    {
        String opcao;
        int nOpcao;
        do
        {
            opcao = Utils.readLineFromConsole("Introduza opção: ");
            nOpcao = new Integer(opcao);
        } while (nOpcao < 0 || nOpcao > list.size());

        return nOpcao - 1;
    }
}