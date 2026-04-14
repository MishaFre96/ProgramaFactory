package factory;

/**
*
* @author MishaFre96
*/

public abstract class Worker{
   
   /**
    * Declaración de atributos de la clase Worker:
    */
	
   private String name;
   private String address;
   private String dni;
   private double salary;
   
   // Constructor de la clase Worker:
   public Worker(String pName, String pAddress, String pDni){
       name = pName;
       address = pAddress;
       dni = pDni;
   }
   
   // Getters de los atributos "Name", "Address", "DNI" y "Salary".
   public String getName(){
       return name;
   }

   public String getAddress(){
       return address;
   }

   public String getDni(){
       return dni;
   }

   public double getSalary(){
       return salary;
   }
   
   // Setter para el atributo "Salary".
   public void setSalary(double salary){
       this.salary = salary;
   }
   
   // Setter para el atributo "Address" por si el empleado cambia de domicilio
   public void setAddress(String newAddress){
       this.address = newAddress;
   }
   
   /**
    * Sobreescritura del método "toString()" para imprimir los datos de "Worker" por pantalla.
    * 
    * @return String con los datos del "Worker".
    */
   
   @Override
   public String toString(){
       return "-> " + name + ", " + dni + ", " + address;
   }
   
   /**
    * @param object
    * 
    * Recibe un objeto Object.
    * Comprueba si el objeto recibido es el mismo al comparado.
    * Comprueba que el objeto recibido no sea nulo.
    * Comprueba si el objeto recibido es o no un Worker.
    * 
    * Una vez comprobado que el objeto pasado por parámetro es válido,
    * realiza un cast del objeto a la clase Worker y, por último,
    * compara los atributos DNI de ambos para devolver un boolean.
    * 
    * @return boolean; True si: los objetos comparados tienen mismo DNI 
    * o si es el mismo objeto. False si: el objeto pasado por parámetro es nulo
    * o si el objeto no es una instancia de la clase "Worker".
    */
   
   @Override
   public boolean equals(Object object){
       if (this == object) return true;
       if (object == null) return false;
       if (!(object instanceof Worker)) return false;

       Worker other = (Worker) object;
       return java.util.Objects.equals(this.dni, other.getDni());
   }
   
   /**
    * Método abstracto que calculará el sueldo de cada empleado
    * según el roll que desempeñe en la empresa.
    * 
    * @return double con el salario actualizado.
    */
   
   public abstract double computeSalary();
   
}
