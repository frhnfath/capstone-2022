package com.dicoding.picodiploma.recyclerviewsubmission;

import java.util.ArrayList;

class  PlayerData {
    private static String[] playerNames = {
            "Raul",
            "Iker Casillas",
            "Manuel Sanchis",
            "Santillana",
            "Sergio Ramos",
            "Fernando Hierro",
            "Francisco Gento",
            "Jose Camacho",
            "Pirri",
            "Michel"
    };

    private static String[] playerDeskripsi = {
            "Raul bermain untuk Real Madrid pada tahun 1994 sampai tahun 2010 dengan total penampilan sebanyak 741 penampilan.",
            "Iker Casillas bermain untuk Real Madrid pada tahun 1999 sampai tahun 2015 dengan total penampilan sebanyak 725 penampilan.",
            "Manuel Sanchis bermain untuk Real Madrid pada tahun 1983 sampai tahun 2001 dengan total penampilan sebanyak 710 penampilan.",
            "Santillana bermain untuk Real Madrid pada tahun 1971 sampai tahun 1988 dengan total penampilan sebanyak 645 penampilan.",
            "Sergio Ramos bermain untuk Real Madrid pada tahun 2005 sampai sekarang dengan total penampilan sebanyak 640 penampilan.",
            "Fernando Hierro bermain untuk Real Madrid pada tahun 1989 sampai tahun 2003 dengan total penampilan sebanyak 601 penampilan.",
            "Francisco Gento bermain untuk Real Madrid pada tahun 1953 sampai tahun 1971 dengan total penampilan sebanyak 601 penampilan.",
            "Jose Camacho bermain untuk Real Madrid pada tahun 1973 sampai tahun 1989 dengan total penampilan sebanyak 577 penampilan.",
            "Pirri bermain untuk Real Madrid pada tahun 1964 sampai tahun 1980 dengan total penampilan sebanyak 561 penampilan.",
            "Michel bermain untuk Real Madrid pada tahun 1981 sampai tahun 1996 dengan total penampilan sebanyak 559 penampilan."
    };

    private static int[] playerImages = {
            R.drawable.raul,
            R.drawable.casillas,
            R.drawable.sanchis,
            R.drawable.santillana,
            R.drawable.ramos,
            R.drawable.hierro,
            R.drawable.gento,
            R.drawable.camacho,
            R.drawable.pirri,
            R.drawable.michel
    };

    static ArrayList<Player> getListData(){
        ArrayList<Player> list = new ArrayList<>();
        for (int position = 0; position < playerNames.length; position++) {
            Player player = new Player();
            player.setName(playerNames[position]);
            player.setDeskripsi(playerDeskripsi[position]);
            player.setPhoto(playerImages[position]);
            list.add(player);
        }
        return list;
    }


}
