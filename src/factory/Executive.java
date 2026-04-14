package factory;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MishaFre96
 */

public class Executive extends Worker{
	
    /**
     * Declaración de atributos de la clase "Executive".
     */
	
    private static final double COMISSION = 2.0;
    private static final double SALARYBASE = 2500.0;
    
    private List <Salesman> salesmen;
    private Secretary secretary;
    
    // Constructor de la clase "Executive".
    public Executive(String pName, String pAddress, String pDni){
        super(pName, pAddress, pDni);
        this.salesmen = new ArrayList<>();
        this.secretary = null;
        setSalary(SALARYBASE);
    }
    
    /**
     * Método que recalcula el salario de "Exectuive" en función de las ventas
     * de los "Salesman" y la comisión correspondiente.
     * 
     * @return double que representa el producto del total de ventas y la
     * comisión de "Executive".
     */
    
    @Override
    public double computeSalary(){
        double totalSales = this.salesmen.stream().map((salesman) -> salesman.getSalesMonth()).reduce(0.0, (initial, acumulated) -> initial + acumulated);
        double computedSalary = Math.floor((totalSales * COMISSION) / 100);
        return this.getSalary() + computedSalary;
    }
    
    /**
     * Método que añada un "Salesman" a la lista individual que tiene cada "Executive"
     * comprobando primero que este no sea nulo.
     * 
     * @param pNewSalesman; el "Salesman" que se añadirá a la lista.
     * @throws OverrideException excepción lanzada cuando el "Salesman" objetivo
     * ya tiene asignado un "Executive".
     */
    
    public void addSalesman(Salesman pNewSalesman) throws OverrideException {
        java.util.Objects.requireNonNull(pNewSalesman, "Salesman cannot be null");
        if(pNewSalesman.hasExecutive())throw new OverrideException("This Salesman already has an Executive");
        pNewSalesman.setExecutive(this);
        this.salesmen.add(pNewSalesman);
    }
    
    /**
     * Método que comprueba que el "Secretary" pasado por parámetro al método no sea nulo.
     * Comprueba si el objeto "secretary" ya tiene asignado un "Executive", lanza un error.
     * Si no tiene "Exectuvie" asignado, en el atributo de "Secretary" se asigna el "Executive"
     * a la vez que en el atributo de "Executive" se asigna dicho "Secretary".
     * 
     * @param pNewSecretary; el Objeto "secretary" que se le pasa por parámetro.
     * @throws OverrideException excepción lanzada si el objeto "Secretary" ya tiene asignado un "Executive".
     */
    
    public void setSecretary(Secretary pNewSecretary)throws OverrideException {
        java.util.Objects.requireNonNull(pNewSecretary, "Secretary cannot be null");
        if(pNewSecretary.hasExecutive())throw new OverrideException("This Secretary already has an Executive");
        pNewSecretary.setExecutive(this);
        this.secretary = pNewSecretary;
    }
    
    /**
     * Método que convierte ArrayList en Stream, convierte cada elemento en un String
     * con un salto de línea para poder imprimir por pantalla los "Salesman" asociados
     * a un "Executive".
     * 
     * @return String con todos los "Salesman" asociados a un "Executive".
     */
    
    public String listWorkers() {
    StringBuilder sb = new StringBuilder();
        if(secretary != null) {
            sb.append(secretary.getName()).append(" ")
            .append(secretary.getDni()).append(" ")
            .append(secretary.getAddress()).append(System.lineSeparator());
        }
        salesmen.forEach(s -> sb.append(s.getName()).append(" ")
                                .append(s.getDni()).append(" ")
                                .append(s.getAddress()).append(System.lineSeparator()));
        return sb.toString();
    }   
    
}
