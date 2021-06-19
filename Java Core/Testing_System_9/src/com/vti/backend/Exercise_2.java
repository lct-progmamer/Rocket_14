package com.vti.backend;

import com.vti.entity.CPU;
import com.vti.entity.Car;

public class Exercise_2 {
    public void question_1()
    {
        CPU cpu = new CPU(4542.3f);
        CPU.Processor processor = cpu.new Processor();
        cpu.setProcessor(processor);
        CPU.Ram ram = cpu.new Ram();
        cpu.setRam(ram);
        System.out.println( "Cache : " + cpu.getProcessor().getCache());
        System.out.println("Clock speed : " +cpu.getRam().getClockSpeed());
    }
    public void question_2()
    {
        Car car1 = new Car("Mazda" , "8WD");
        Car.Engine engine = car1.new Engine("Crysler");
        car1.setEngine(engine);
        System.out.println("Engine : " + car1.getEngine().getEngineType());

    }



}
