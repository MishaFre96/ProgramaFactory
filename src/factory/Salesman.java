package factory;

/**
*
* @author Mykhaylo Freyishyn Novychenko
*/

public class Salesman extends Worker{
	
   /**
    * Declaración de los atributos de la clase "Salesman".
    */
	
   private double salesMonth;
   private static final double COMISSION = 5.0;
   private static final double SALARYBASE = 1300.0;
   private Executive executive;
   
   // Constructor de la clase "Salesman".
   public Salesman(String pName, String pAddress, String pDni){
       super(pName, pAddress, pDni);
       this.salesMonth = 0.0;
       this.executive = null;
       setSalary(SALARYBASE);
   }
   
   // Getters para los atributos "salesMonth" y "getExecutive".
   public double getSalesMonth(){
       return salesMonth;
   }

   public Executive getExecutive(){
       return executive;
   }
   
   // Setter para asignar un "Executive" al "Salesman" en curso.
   public void setExecutive(Executive pExecutive){
       executive = pExecutive;
   }
   
   /**
    * Método sobreescrito que calcula el salario de "Salesman" aplicando
    * el cálculo de comisiones.
    * 
    * @return double que representa el salario de "Salesman" con el cálculo 
    * de comisiones aplicado.
    */
   
   @Override
   public double computeSalary(){
       double computedSalary = Math.floor((salesMonth * COMISSION) / 100);
       return this.getSalary() + computedSalary;
   }
   
   /**
    * Método que incrementa las ventas del mes con el importe de una venta.
    * 
    * @param pSale double del total vendido.
    */
   
   public void newSale(double pSale){
       if(pSale > 0.0) this.salesMonth += pSale;
   }
   
   /**
    * Método que establece a cero las comisiones cuando se cambia de mes.
    */
   
   public void changeMonth(){
       this.salesMonth = 0.0;
   }
   
   /**
    * Devuelve un boolean si el "Salesman" tiene o no asignado un "Executive".
    * 
    * @return boolean. True = hay asignado. False = no hay asignado.
    */
   
   public boolean hasExecutive(){
       return this.executive != null;
   }
   
}
