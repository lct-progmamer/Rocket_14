package com.vti.entity;

public class CPU {
    private float price;
    private Processor processor;
    private Ram ram;


    public CPU(float price)
    {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public Ram getRam() {
        return ram;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }
    public class Processor{
        private int coreAmount;
        private String manufactuter;
        public float getCache()
        {
            return 4.3f;
        }
    }
    public class Ram{
        private float memory;
        private String manufactuter;
        public float getClockSpeed()
        {
            return 5.5f;

        }
    }

}
