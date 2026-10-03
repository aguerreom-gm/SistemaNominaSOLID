package vista;

import modelo.Empleado;
import modelo.EmpleadoAsalariado;
import modelo.EmpleadoPorHoras;
import modelo.EmpleadoPorComision;
import modelo.EmpleadoTemporal;
import servicio.CalculadoraNomina;

public class Main {

    public static void main(String[] args) {

        CalculadoraNomina calculadora =
                new CalculadoraNomina();

        Empleado asalariado =
                new EmpleadoAsalariado(
                        "Carlos",
                        3_000_000,
                        6
                );

        Empleado porHoras =
                new EmpleadoPorHoras(
                        "Pedro",
                        45,
                        30_000
                );

        Empleado comision =
                new EmpleadoPorComision(
                        "Laura",
                        2_500_000,
                        5,
                        25_000_000
                );

        Empleado temporal =
                new EmpleadoTemporal(
                        "Andrés",
                        2_000_000,
                        6
                );

        mostrarNomina(calculadora, asalariado);
        mostrarNomina(calculadora, porHoras);
        mostrarNomina(calculadora, comision);
        mostrarNomina(calculadora, temporal);
    }

    private static void mostrarNomina(
            CalculadoraNomina calculadora,
            Empleado empleado) {

        double bruto =
                calculadora.calcularSalarioBruto(empleado);

        double deducciones =
                calculadora.calcularDeducciones(empleado);

        double neto =
                calculadora.calcularSalarioNeto(empleado);

        System.out.println("Sistema de Nomina - Version 2");
        System.out.println(
                "Empleado: " + empleado.getNombre()
        );
        System.out.println(
                "Tipo: " + empleado.getTipoEmpleado()
        );
        System.out.println(
                "Salario bruto: $" + bruto
        );
        System.out.println(
                "Deducciones: $" + deducciones
        );
        System.out.println(
                "Salario neto: $" + neto
        );
    }
}
