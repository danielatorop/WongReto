package com.sophos.certificacion.wong.utils;


public class BasicUtils {

    private static long time;

    /***
     * @return Un objeto tipo long con el inicio de tiempo de ejecuión
     * @author Daniela toro
     */
    public static long setTime() {
        time = System.currentTimeMillis();
        return time;
    }

    /***
     * @param start Inicio del tiempo de ejecuion
     * @param end Finalizacion del tiempo de ejecucion
     * @return Un objeto tipo long con el inicio de tiempo de ejeución
     * @author Daniela toro
     */
    public static Double getTimeInSeconds(long start, long end) {
        return (double) ((end - start) / 1000);
    }

}

