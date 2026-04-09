package factory;

/**
*
* @author Mykhaylo Freyishyn Novychenko
*/

class Secretary extends Worker{
	
   /**
    * Declaración de atributos propios de "Secretary".
    */
	
   private static final double SALARYBASE = 1200.0;
   private Executive executive;
   
   // Constructor de la clase "Secretary".
   public Secretary(String pName, String pAddress, String pDni){
       super(pName, pAddress, pDni);
       setSalary(SALARYBASE);
   }
   
   /**
    * Método que devuelve el salario de "Secretary", en este caso el
    * "SALARYBASE".
    * 
    * @return double que corresponde a "SALARYBASE" de "SECRETARY".
    */
   
   @Override
   public double computeSalary(){
       return this.getSalary();
   }
   
   /**
    * Métoto setter para asignar un "Executive" a un "Secretary".
    * 
    * @param pExecutive objeto "Executive".
    */
   
   public void setExecutive(Executive pExecutive){
       this.executive = pExecutive;
   }
   
   /**
    * Método que devuelve el "Executive" asignado al objeto "Secretary".
    * 
    * @return objeto "Executive".
    */
   
   public Executive getExecutive(){
       return this.executive;
   }
   
   /**
    * Método que de vuelve un boolean que indica si hay o no asignado un "Executive".
    * 
    * @return boolean.
    */
   
   public boolean hasExecutive(){
       return this.executive != null;
   }
}
