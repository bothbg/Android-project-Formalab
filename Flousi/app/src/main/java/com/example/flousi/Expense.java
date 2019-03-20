
package com.example.flousi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

    public class Expense {
        int id;
        private String achat;
        private Float prix;
        String date;
        public static float totall ;

        public Expense(String achat, Float prix) {
            this.achat = achat;
            this.prix = prix;
            String pattern = "MM/dd/yyyy HH:mm:ss";

            DateFormat df = new SimpleDateFormat(pattern);
            Date today = Calendar.getInstance().getTime();

            date = df.format(today);

        }

        public static float getTotall() {
            return totall;
        }

        public static void setTotall(float totall) {
            Expense.totall = totall;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getAchat() {
            return achat;
        }

        public void setAchat(String achat) {
            this.achat = achat;
        }

        public Float getPrix() {
            return prix;
        }

        public void setPrix(Float prix) {
            this.prix = prix;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }



