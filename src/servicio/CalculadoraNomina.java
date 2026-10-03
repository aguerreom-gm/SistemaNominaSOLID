package servicio;

import modelo.Empleado;

public class CalculadoraNomina {

    private final CalculadoraDeducciones calculadoraDeducciones;

    public CalculadoraNomina() {
        calculadoraDeducciones = new CalculadoraDeducciones();
    }

    public double calcularSalarioBruto(Empleado empleado) {
        return empleado.calcularSalarioBruto();
    }

    public double calcularDeducciones(Empleado empleado) {

        double salarioBruto = calcularSalarioBruto(empleado);

        return calculadoraDeducciones.calcularDeducciones(salarioBruto);
    }

    public double calcularSalarioNeto(Empleado empleado) {

        double salarioBruto = calcularSalarioBruto(empleado);

        return calculadoraDeducciones.calcularSalarioNeto(salarioBruto);
    }
}
