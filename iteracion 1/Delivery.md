    Cátedra: Programación Orientada a Objetos II 						2019
_ _ _

# Sistema Gestión de Envíos y Pedidos
# Nyan
![Nyan Cat](original.gif)

## Grupo: Click para descargar mas RAM.

1. Gomez Maximiliano David
2. Molina Sebastián
3. Zgarbik Axel Nicolas 

## Visión 

Desarrollaremos una aplicación donde se pueden registrar tanto usuarios, como también empresas proveedoras de productos. Ambos deben poner una dirección donde se buscará los productos (si es una empresa) o donde se enviarán los productos (si es un cliente). La aplicación, a su vez, permite a las empresas mostrar sus catálogos de productos y los clientes pueden elegir y armar su orden.
Ademas de eso proveer al cliente recomendaciones y ofertas correspondientes en su búsqueda, teniendo en cuenta sus elecciones y preferencias.

## Lista de características

1. Logeo con cuentas de google o faceboook.
2. El manejo de comidas a traves de categorias.
3. La posibilidad de que cada cliente arme sus propios productos.
4. El sistema tiene la cualidad de recomendarle comida en base a sus busquedas.
5. En base a la informacion del usuario proveerle descuentos y beneficios.
6. El emitira una notificacion por cada pedido al proveedor de servicio.

## Análisis de Dominio

La aplicacion se desarrollara para plataforma web, la primera version saldra para web, pero teniendo en cuenta el futuro desarrollo de una aplicacion. El uso de la pagina estara destinado para mayores de 16 años (ya que se pueden realizar pagos en ella). El sistema manejara ubicaciones para mostras las posibilidades de servicios de la zona. 

## Bocetos de Interfaz de Usuario

Pantalla 1

## Casos de Uso

### Actores

1. Comercio: Es el negocio que desea vender sus productos a través de nuestra página.
2. Cliente: Es la persona que desea comprar productos a través de nuesta página.
3. Administrador: Persona encargada de la gestión de la página.


...

#### Registro de comercio
##### Actores: 
Comercio
##### Objetivo: 
El objetivó de este caso de uso es el registro de un nuevo comercio que proveera un servicio o productos a clientes
##### Flujo Principal:
1. El actor selecciona registrar.
2. El sistema devuelve las opciones de registro.
3. El actor selecciona registrar como comercio.
4. El sistema muestra el formulario para registrar como comercio
5. El actor completa el formulario y acepta
6. El sistema verifica que todos los campos obligatorios esten correctamente cargados.
7. El sistema muestra el mensaje de Registrado con exito.
8. El actor selecciona el ok.
9. Termina el caso de uso.
##### Flujo Alternativo:
6.1 El sistema detecta que falta un campo obligatorio a cargar o mal cargado.
6.2 Muestra un mensaje con el error.
6.3 Vuelve al paso 5 del flujo principal.

#### Gestión de Inventario
##### Actor: 
Comercio
##### Objetivo: 
el comercio cargara los productos con el stock de los ingredientes de estos, la cantidad y el valor de cada uno.
##### Flujo Principal:
1. El actor selecciona la pestaña Inventario.
2. El sistema devuelve las opciones de esa pestaña.
3. El actor selecciona nuevo.
4. El sistema devuelve el formulario para los productos y los ingredientes.
5. El actor llena el formulario.
6. El actor presiona el botón aceptar.
7. El sistema registra el nuevo inventario.
8. Termina el caso de uso.
##### Flujo Alternativo:
#Modificación
2.1 El actor selecciona modificar.
2.2 El sistema devuelve los productos e ingredientes.
2.3 El actor cambia lo que necesita
2.4 El actor presiona el botón aceptar.
2.5 El sistema registra la modificación.
2.6 vuelve al paso 8 del flujo principal.
#Eliminación
2.1 El actor selecciona eliminar.
2.2 El sistema devuelve los productos e ingredientes.
2.3 El actor elimina lo que necesita.
2.4 El actor presiona el botón aceptar.
2.5 El sistema registra la modificación.
2.6 vuelve al paso 8 del flujo principal.

#### Generar Estadísticas
##### Actor: 
Comercio
##### Objetivo: 
A través del sistema proveer de estadísticas al comercio (producto más vendido, ingrediente más pedido, etc.).
##### Flujo Principal:
1. El actor pulsa la pestaña estadísticas.
2. El sistema solicita un margen de tiempo.
3. El actor ingresa el margen.
4. El sistema devuelve las estadísticas de ese margen de tiempo. 
##### Flujo Alternativa:
2.1 El sistema no encuentra estadísticas en ese margen de tiempo.
2.2 El sistema emite un mensaje con el error.
2.3 Vuelve al paso 2 del flujo principal.

#### Iniciar Sesión
##### Actor: 
Comercio
##### Objetivo: 
El comercio ya registrado accede a la pagina web.
##### Flujo Principal:
1. El actor selecciona Ingresar.
2. El sistema pide Usuario y contraseña.
3. El sistema verifica la existencia del Usuario.
4. El sistema verifica que el usuario tenga esa contraseña.
5. El actor ingresa a la página web.
6. Termina el caso de uso.
##### Flujo Alternativo:
#Usuario Inválido
3.1 El sistema no encuentra el usuario.
3.2 Emite un mensaje de error.
3.3 Vuelve al paso 2 del flujo principal.
#Contraseña Inválida
4.1 El sistema verifica que el usuario ingresado no tiene esa contraseña.
4.2 El sistema emite un mensaje de error.
4.3 Vuelve al paso 2 del flujo principal.

## Arquitectura

Para desarrollar nuestro proyecto usaremos los siguientes programas y herramientas:
- Visual Studio Code
- GitHub
- Insomnia
- Apache NetBeans 11
- Javalin
- Junit
- Maven


## Variante de aplicacion
La aplicacion existente en la cual nos basamos es en pedidosya, globo, rappi. Nuestro sistema difiere de sus mecanicas con la cualidad de poder seleccionar los ingredientes de nuestro pedido, haciendo que nuestros clientes tengan la posibilidad de hacer pedidos personalizados.
Otra variante con este sistema es en el cual las empresas tendran nuevas ideas para cambiar sus menus e incorporar distintos tipos nuevos de comida. 

