# Guidelines

Cada pantalla a la que se va a navegar debe ser un paquete.
Dentro de cada paquete de pantalla, debe haber un <package_name>Composite.kt y un <package_name>Export.kt.

- Composite: Debe haber un solo composable, el cual utiliza los composables de todos los demás archivos en el mismo paquete.
Este solo puede tener composables de hasta 1 nivel, no abusar del nesting.

- Export: Debe haber un solo composable, el cual toma un ViewModel (si fuera necesario) y contiene el Composite.
El composable Export debe ser el único utilizado fuera del paquete.

Además, puede haber los siguientes archivos:

- Page: Si la pantalla posee varias páginas, cada una, así como sus composables base, deben ubicarse en archivos distintos.
- Dialog: Cuadros de diálogo.