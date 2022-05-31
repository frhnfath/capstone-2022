package com.dicoding.submission;

import java.util.ArrayList;

public class KarakterData {
    public static String[][] data = new String[][]{
            {"Rendang Padang","Rendang from Minangkabau tribe is a food that has been spread throughout Indonesia because rendang is one of the mandatory menus of Padang Restaurant. Rendang has a spicy flavor and thick seasoning. Based on the rendang cooking process, rendang padang is very durable."},
            {"Mie Aceh","Mie Aceh (Aceh noodles) have a thick texture and yellowish color. Aceh noodles are served in the form of fried noodles and wet noodles with sliced beef or mutton. Aceh noodles which actually has a pungent taste and thick/thick seasoning."},
            {"Pempek Palembang","Pempek Palembang is one of Indonesian culinary from South Sumatra which is quite famous. Pempek is made from sago flour and fish (usually mackerel). Pempek is usually served with vinegar sauce. Pempek has several types, and among them the best known are pempek submarines that contain boiled eggs."},
            {"Kerak Telor Jakarta","This special food from Jakarta is actually a fusion of Portuguese cuisine. The egg crust is easy to find in Jakarta especially at the Jakarta Fair even the egg crust is often used as a classic culinary symbol of Betawi culture."},
            {"Asinan Bogor","Gudeg is a culinary that cannot be separated from the city of Yogyakarta even to the point that Yogyakarta has a nickname as the city of Gudeg. The original warm Gudeg in Yogyakarta has a very sweet taste. Gudeg is made from young coconut milk jackfruit which is usually enjoyed with rice, native chicken, and soy sauce eggs."},
            {"Soto Rawon Surabaya","This soup with rawon cuts of meat from Surabaya is very popular in the area of Java. Soto Rawon Surabaya has a characteristic located in the broth. The soup from Soto Rawon does not use soy sauce but instead uses Kluwek."},
            {"Bubur Manado","Manado porridge or Tinutuan porridge is a favorite special food from Sulawesi Island. Tinutuan in Manado means mixed. Inside the Manado porridge there are a variety of vegetables, animal side dishes such as fish, and vegetable side dishes such as tofu and tempeh."},
            {"Coto Makassar","Actually Coto has the same meaning as Soto. However, specifically for Soto from Makassar, ordinary people know him as Coto. Coto Makassar has its own uniqueness, which is in the form of contents and seasonings. The contents of Coto Makassar consist of beef and beef offal. Flavored peanut that is only found in Coto Makassar soup."},
            {"Papeda Maluku","Eastern Indonesia has staple foods made from sago. One of the most popular Maluku specialties made from sago is papeda. Papeda is a staple food of the Maluku region as a substitute for rice. Usually, papeda is enjoyed with the addition of animal side dishes such as fish sauce."},
    };
    public static ArrayList<Karakter> getListData(){
        ArrayList<Karakter> list = new ArrayList<>();
        for (String[] aData : data) {
            Karakter karakter = new Karakter();
            karakter.setName(aData[0]);
            karakter.setFrom(aData[1]);
            karakter.setPhoto(aData[2]);
            list.add(karakter);
        }
        return list;
    }
}
