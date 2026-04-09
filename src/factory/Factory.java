package factory;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mykhaylo Freyishyn Novychenko
 */

public class Factory {
	
    /**
     * Declaración de los atributos de "Factory".
     */
	
    private String name;
    private List<Worker> workers;
    
    /**
     * Constructor vacío para inicializar la lista de workers.
     */
    
    public Factory(){
        this.name = "";
        this.workers = new ArrayList<>();
    }
    
    /**
     * Constructor para nombrar la lista de workers e inicializar la lista.
     * 
     * @param pName String para nombrar la lista de "Workers".
     */
    
    public Factory(String pName){
        this();
        this.name = pName;
    }
    
    /**
     * Setter para asignar nombre a la lista "workers".
     * 
     * @param pName string con el nombre a asignar.
     */
    
    public void setName(String pName){
        this.name = pName;
    }
    
    /**
     * Método que recupera el nombre asignado a la lista "workers".
     * 
     * @return String con el nombre de la lista.
     */
    
    public String getName(){
        return this.name;
    }
    
    /**
     * Método que comprueba que el objeto pasado no es nulo.
     * Compara por DNI si el objeto ya está incluido en la lista.
     * Añade a la lista.
     * 
     * @param pNewWorker objeto Worker para añadir a la lista.
     * @throws OverrideException si el "Worker" ya está incluido.
     */
    
    public void addWorker(Worker pNewWorker) throws OverrideException {
        java.util.Objects.requireNonNull(pNewWorker, "Worker cannot be null");
        for (Worker w : workers) {
            if (java.util.Objects.equals(w.getDni(), pNewWorker.getDni())) {
                throw new OverrideException("Worker already exists in the Factory");
            }
        }
        this.workers.add(pNewWorker);
    }
    
    /**
     * Metodo que devuelve una lista de trabajadores de "Factory".
     * 
     * @return List copia de los "workers".
     */
    
     public List<Worker> getWorkers() {
        return new ArrayList<>(this.workers);
    }
    
    /**
     * Devuelve el objeto "Worker" con el DNI que se le pasa.
     * Si no lo encuentra lanza una excepción.
     * 
     * @param pDni String con el DNI del "Worker" que buscamos.
     * @return objeto "Worker" con el DNI que queremos.
     * @throws NotFoundException excepción lanzada si no se encuentra el "Worker" deseado.
     */
     
    public Worker getWorker(String pDni)throws NotFoundException{
        for(Worker w : workers){
            if(w.getDni().equals(pDni)) return w;
        }
        throw new NotFoundException("Worker with dni " + pDni + " not found");
    }
    
    /**
     * Método que contruye un String con el lista de todos los "Workers" de la "Factory"
     * y el salario que deben cobrar redondeado hacia abajo.
     * 
     * @return String con todos los "Workers" y sus datos.
     */
    
    public String listSalaryWorkers() {
        StringBuilder sb = new StringBuilder();
        workers.forEach((w) -> {
            double sal = w.computeSalary();
            long salInt = (long) sal; 
            sb.append(w.getName()).append(" ")
                    .append(w.getDni()).append(" ")
                    .append(salInt).append(System.lineSeparator());
        });
        return sb.toString();
    }

    /**
     * Método sobreescrito toString().
     * 
     * @return String con el nombre de "Factory".
     */
    
    @Override
    public String toString() {
        return this.name;
    }
    
}
