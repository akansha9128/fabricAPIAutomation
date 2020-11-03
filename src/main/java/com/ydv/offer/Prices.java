package com.ydv.offer;

public class Prices {
        private Number sale;

        private String currency;

        private Number base;


        public String getCurrency ()
        {
            return currency;
        }

        public void setCurrency (String currency)
        {
            this.currency = currency;
        }

    public Number getBase() {
        return base;
    }

    public void setBase(Number base) {
        this.base = base;
    }

    public Number getSale() {
        return sale;
    }

    public void setSale(Number sale) {
        this.sale = sale;
    }
}
