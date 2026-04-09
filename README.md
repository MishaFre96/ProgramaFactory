# ProgramaFactory

Este proyecto en Java fue un ejercicio de la asignatura IFCD15 – PROGRAMACIÓN JAVA SE 8 (ORACLE) del curso de Core Networks para el examen Oracle Certified Foundations Associate. Permite simular la estructura de una empresa con distintos tipos de empleados, calcular salarios según el rol y gestionar excepciones al asignar trabajadores o buscar empleados por DNI.

**Nota:** El enunciado en PDF es un ejercicio creado por mi profesor Pedro, es de su propiedad y tengo permiso para subirlo a GitHub.

## Estructura del proyecto

- src/factory/ → Contiene las clases Java: Worker.java, Salesman.java, Executive.java, Secretary.java, Factory.java, OverrideException.java, NotFoundException.java, Test.java y module-info.java
- PracticaJSE08OOFact_1.pdf → Enunciado original del ejercicio proporcionado por el profesor
- .gitignore → Ignora archivos compilados, temporales y configuraciones de IDE innecesarias
- Archivos de configuración de Eclipse (.project, .classpath, .settings/)

## Cómo usarlo

1. Abrir el proyecto en Eclipse o tu IDE favorito
2. Ejecutar Test.java para probar la funcionalidad:
   - Crear la fábrica y los trabajadores (Salesman, Executive, Secretary)
   - Asignar Salesman a Executive y Secretary a un Executive
   - Añadir ventas y calcular salarios
   - Gestionar excepciones al intentar asignar un trabajador ya ocupado o buscar un DNI inexistente
3. Se mostrará en consola:
   - Listado de trabajadores de cada Executive
   - Salarios calculados para todos los Workers
   - Mensajes de error si hay conflictos de asignación o trabajadores no encontrados

## Notas

- No se pueden asignar Salesman o Secretary a más de un Executive
- Los salarios de Salesman y Executive se calculan con comisiones redondeadas hacia abajo
- Secretary tiene un salario base fijo
