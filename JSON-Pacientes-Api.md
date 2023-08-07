# Funcionamiento del Microservicio Paciente-API

Este microservicio proporciona una interfaz segura y eficiente para administrar la información de los pacientes, incluyendo la posibilidad de registrar sus antecedentes familiares, patológicos, no patológicos, gineco obstétricos y perinatales. De esta manera, se garantiza un perfil completo y detallado de cada paciente.

## Características Microservicio Paciente-API:

1. **Pacientes:** Permite ingresar datos demográficos y personales de cada paciente, como nombre, apellidos, fecha de nacimiento, dirección, contacto, y otros detalles relevantes.

2. **Antecedentes Familiares:** Facilita el registro de información sobre condiciones médicas heredadas, brindando una visión holística de la historia médica de la familia.

3. **Antecedentes Patológicos:** Permite registrar condiciones médicas previas, cirugías, alergias y otras patologías relevantes que afecten la salud del paciente.

4. **Antecedentes No Patológicos:** Permite documentar aspectos importantes como hábitos alimenticios, actividad física y otros factores no médicos relevantes para el bienestar del paciente.

5. **Antecedentes Gineco Obstétricos:** Específicamente diseñado para pacientes femeninas, este apartado permite llevar un seguimiento detallado de la salud ginecológica y obstétrica.

6. **Antecedentes Perinatales:** Brinda la posibilidad de registrar datos cruciales sobre el desarrollo prenatal y nacimiento del paciente, proporcionando información valiosa para la atención pediátrica.

# Diagrama de la BD

![paciente-bd](/imagenes/pacientes-bd.png)

# Endpoints del microservicio Paciente-API

## Paciente

### Método Get

+ Endpoint: *{link del host}/api/pacientes*

Este endpoint permite realizar una solicitud GET para obtener la lista de todos los pacientes registrados en el sistema. Al acceder a este enlace, el servidor responderá con la información de todos los pacientes almacenados en formato JSON.

### Método Get
+ Endpoint: *{link del host}/api/pacientes/{id}*

Este enpoint permite obtener la información de un paciente asi como sus antecedente específico al proporcionar su ID único en la URL.

### Método Post

+ Endpoint: *{link del host}/api/pacientes*

Este endpoint consume un JSON en el cuerpo de la solicitud para crear un nuevo paciente en el sistema.

```json
{
    "nombre": "Shino",
    "apellidos": "García ",
    "fechaNacimiento": "1990-05-15",
    "direccion": "Calle Principal #123",
    "telefono": "555-123-4567",
    "email": "shino.garcia@example.com",
    "estado_civil": "Soltera",
    "escolaridad": "Administración de Empresas",
    "ocupacion": "Gerente de ventas"
}

```
### Método Put

+ Endpoint: *{link del host}/api/pacientes/{id}*

Este endpoint consume un JSON en el cuerpo de la solicitud para actualizar la información de un paciente existente. El JSON debe contener los datos actualizados del paciente, identificado por su ID único en la URL.

Este endpoint consume un JSON con el siguiente formato:

```json
{
    "nombre": "Shino",
    "apellidos": "Garcías ",
    "fechaNacimiento": "1991-05-15",
    "direccion": "Calle Principal #126",
    "telefono": "555-123-4566",
    "email": "shino.garcia@example.com",
    "estado_civil": "Casada",
    "escolaridad": "Administración de Empresas",
    "ocupacion": "Gerente de ventas"
}

```
### Método Delete

+ Endpoint: *{link del host}/api/pacientes/{id}*

Este endpoint permite realizar una solicitud DELETE para eliminar un paciente del sistema. Se debe proporcionar el ID único del paciente que se desea eliminar en la URL.

## Antecedente Patologico

### Metodo Get

+ Endpoint: *{link del host}/api/patologicos*

Este endpoint permite obtener la lista de todos los antecedentes patológicos registrados en el sistema. Al acceder a este enlace, el servidor responderá con la información de todos los antecedentes patológicos almacenados en formato JSON.

### Metodo Get
+ Endpoint: *{link del host}/api/patologicos/{id}*

Este endpoint permite obtener la información de los antecedentes patológicos de un paciente específico al proporcionar su ID único en la URL.

### Metodo Post

+ Endpoint: *{link del host}/api/patologicos/{id-paciente}*

Este endpoint consume un JSON en el cuerpo de la solicitud para crear los antecedentes patológicos de un paciente en el sistema. El JSON debe contener información sobre cirugías, adicciones, traumatismos, ETS, alergias y padecimientos articulares.

Este endpoint consume un JSON con el siguiente formato:

```json
{
  "cirugias": "Cirugia de vesícula en 2018",
  "adicciones": "No tiene",
  "traumatismos": "Lesión en la rodilla en 2016",
  "ets": "VIH positivo desde 2014",
  "alergias": "Penicilina",
  "padecimientos_articulares": "Osteoartritis"
}
```
### Método Put

+ Endpoint: *{link del host}/api/patologicos/{id}*

Este endpoint consume un JSON en el cuerpo de la solicitud para actualizar los antecedentes patológicos de un paciente existente. El JSON debe contener los datos actualizados del paciente identificado por su ID único en la URL.

Este endpoint consume el siguiente JSON:
```json
{
"cirugias": "Cirugia de apéndice",
"adicciones": "Ninguna",
"traumatismos": "Fractura de brazo en 2015",
"ets": "No tiene",
"alergias": "Polen",
"padecimientos_articulares": "Artritis reumatoide"
}
```
### Método Delete

+ Endpoint: *{link del host}/api/patologicos/{id}*

Este endpoint permite realizar una solicitud DELETE para eliminar los antecedentes patológicos de un paciente específico. Se debe proporcionar el ID único del paciente cuyos antecedentes patológicos se desean eliminar en la URL.

## Antecedente Perinatales

### Método Get

+ Endpoint: *{link del host}/api/perinatales*

Este endpoint permite obtener la lista de todos los antecedentes perinatales registrados en el sistema. Al acceder a este enlace, el servidor responderá con la información de todos los antecedentes perinatales almacenados en formato JSON.

### Método Get

+ Endpoint: *{link del host}/api/perinatales/{id}*

Este endpoint permite obtener la información de los antecedentes perinatales de un paciente específico al proporcionar su ID único en la URL.


### Método Post

+ Endpoint: *{link del host}/api/perinatales/{id-paciente}*

Este endpoint consume un JSON en el cuerpo de la solicitud para crear los antecedentes perinatales de un paciente en el sistema. El JSON debe contener información sobre la fecha de nacimiento, semanas de gestación (SDG), APGAR, talla al nacer, número de embarazos y peso al nacer.

Este endpoint consume el siguiente JSON:
```json
{
    "nacimiento": "2022-05-15",
    "sdg": 39,
    "apgar": "8/10",
    "talla": 49,
    "embarazos": 3,
    "pdp": "Bajo peso al nacer"
}
```
### Método Put
+ Endpoint: *{link del host}/api/perinatales/{id}*

Este endpoint consume un JSON en el cuerpo de la solicitud para actualizar los antecedentes perinatales de un paciente existente. El JSON debe contener los datos actualizados del paciente identificado por su ID único en la URL.

Este endpoint consume el siguiente JSON:

```json
{
    "nacimiento": "2022-05-15",
    "sdg": 39,
    "apgar": "8/10",
    "talla": 49,
    "embarazos": 3,
    "pdp": "Bajo peso al nacer"
}
```
### Método Delete
+ Endpoint: *{link del host}/api/perinatales{id}*

Este endpoint permite realizar una solicitud DELETE para eliminar los antecedentes perinatales de un paciente específico. Se debe proporcionar el ID único del paciente cuyos antecedentes perinatales se desean eliminar en la URL.

## Antecedentes familiares

### Método Get

+ Endpoint: *{link del host}/api/antecedentes-familiares*

Este endpoint se utiliza para obtener los antecedentes familiares de todos los pacientes. Al hacer una solicitud GET a este enlace, se devolverá una lista de antecedentes familiares registrados en el sistema para todos los pacientes.

### Método Post

+ Endpoint: *{link del host}/api/antecedentes-familiares/{id-paciente}*

Este endpoint permite agregar nuevos antecedentes familiares para un paciente específico identificado por su ID. Al hacer una solicitud POST a este enlace con los datos JSON proporcionados en el cuerpo de la solicitud, se registrarán los nuevos antecedentes familiares para el paciente correspondiente.

Este endpoint consume un JSON con el siguiente formato:

````json

{
  "cardiopatias": "No",
  "alergias": "Aspirina",
  "diabetes": "Si",
  "nefropatias": "No",
  "psiquiatricos": "No",
  "neurologicas": "No",
  "otros": "Ninguno"
}

````

### Método Put

+ Endpoint: *{link del host}/api/antecedentes-familiares/{id}*

Este endpoint se utiliza para actualizar los antecedentes familiares de un paciente específico. Se debe proporcionar el ID del antecedente familiar que se desea actualizar en la URL y los nuevos datos en el cuerpo de la solicitud en formato JSON. Los datos proporcionados en la solicitud PUT reemplazarán los antecedentes familiares existentes para ese paciente.

Este endpoint consume un JSON con el siguiente formato:

````json

{
  "cardiopatias": "Si",
  "alergias": "Polen",
  "diabetes": "Si",
  "nefropatias": "Si",
  "psiquiatricos": "Si",
  "neurologicas": "Si",
  "otros": "Ninguno"
}

````
### Método Delete

+ Endpoint: *{link del host}/api/antecedentes-familiares/{id}*

Este endpoint se utiliza para eliminar los antecedentes familiares de un paciente específico. Se debe proporcionar el ID del antecedente familiar que se desea eliminar en la URL. Al hacer una solicitud DELETE a este enlace, se eliminarán los antecedentes familiares correspondientes al paciente identificado por el ID.

### Método Get

+ Endpoint: *{link del host}/api/antecedentes-familiares/{id-paciente}*

Este endpoint se utiliza para obtener los antecedentes familiares de paciente especifico.

## Antecedentes No Patologicos

### Método Get

+ Endpoint: *{link del host}/api/no-patologicos*

Este endpoint se utiliza para obtener los antecedentes no patológicos de todos los pacientes. Al hacer una solicitud GET a este enlace, se devolverá una lista de los antecedentes no patológicos registrados en el sistema para todos los pacientes.

### Método Get

+ Endpoint: *{link del host}/api/no-patologicos/{id-paciente}*

Este endpoint permite obtener los antecedentes no patológicos de un paciente específico identificado por su ID. Al hacer una solicitud GET a este enlace con el ID del paciente en la URL, se devolverán los antecedentes no patológicos correspondientes a ese paciente.

### Método Post

+ Endpoint: *{link del host}/api/no-patologicos*

Este endpoint permite agregar nuevos antecedentes no patológicos para un paciente. Al hacer una solicitud POST a este enlace con los datos JSON proporcionados en el cuerpo de la solicitud, se registrarán los nuevos antecedentes no patológicos para el paciente.

Este endpoint consume un JSON con el siguiente formato:

````json

{
  "habitos": "Dieta balanceada y ejercicio moderado",
  "baño": "Diario",
  "habitacion": "Limpia y ordenada",
  "tabaquismo": "No",
  "alcoholismo": "Ocasionalmente",
  "vacunas": "Faltan algunas vacunas",
  "actividad_fisica": "Paseos diarios",
  "alimentacion": "Vegetariana",
  "estado_civil": "Divorciado/a",
  "zoonosis": "No"
}

````

### Método Put

+ Endpoint: *{link del host}/api/no-patologicos/{id}*

Este endpoint se utiliza para actualizar los antecedentes no patológicos de un paciente específico. Se debe proporcionar el ID de los antecedentes no patológicos que se desea actualizar en la URL y los nuevos datos en el cuerpo de la solicitud en formato JSON. Los datos proporcionados en la solicitud PUT reemplazarán los antecedentes no patológicos existentes para ese paciente.

Este endpoint consume un JSON con el siguiente formato:

````json

{
  "habitos": "Dieta alta en grasas y falta de ejercicio",
  "baño": "No se especifica",
  "habitacion": "No se especifica",
  "tabaquismo": "Sí, fuma regularmente",
  "alcoholismo": "No",
  "vacunas": "Vacunas al día",
  "actividad_fisica": "Activo/a",
  "alimentacion": "Prefiere comida rápida",
  "estado_civil": "Casado/a",
  "zoonosis": "No"
}

````

### Método Delete

+ Endpoint: *{link del host}/api/no-patologicos/{id}*

Este endpoint se utiliza para eliminar los antecedentes no patológicos de un paciente específico. Se debe proporcionar el ID de los antecedentes no patológicos que se desea eliminar en la URL. Al hacer una solicitud DELETE a este enlace, se eliminarán los antecedentes no patológicos correspondientes al paciente identificado por el ID.

## Antecedentes Gineco Obstetricos

### Método Get

+ Endpoint: *{link del host}/api/aGinecoObstetricos*

Este endpoint se utiliza para obtener los antecedentes gineco obstétricos de todos los pacientes. Al hacer una solicitud GET a este enlace, se devolverá una lista de los antecedentes gineco obstétricos registrados en el sistema para todos los pacientes.

### Método Get

+ Endpoint: *{link del host}/api/aGinecoObstetricos/{id-paciente}*

Este endpoint permite obtener los antecedentes gineco obstétricos de un paciente específico identificado por su ID. Al hacer una solicitud GET a este enlace con el ID del paciente en la URL, se devolverán los antecedentes gineco obstétricos correspondientes a ese paciente.

### Método Post

+ Endpoint: *{link del host}/api/aGinecoObstetricos*

Este endpoint permite agregar nuevos antecedentes gineco obstétricos para un paciente. Al hacer una solicitud POST a este enlace con los datos JSON proporcionados en el cuerpo de la solicitud, se registrarán los nuevos antecedentes gineco obstétricos para el paciente.

Este endpoint consume un JSON con el siguiente formato:

````json

{
  "menarca": "2012-06-15",
  "ritmo_menstrual": "regular",
  "IPSA": 2,
  "partos": 1,
  "FUP": "2023-07-20",
  "abortos": 0,
  "cesareas": 0
}

````

### Método Put

+ Endpoint: *{link del host}/api/aGinecoObstetricos/{id-paciente}*

Este endpoint se utiliza para actualizar los antecedentes gineco obstétricos de un paciente específico. Se debe proporcionar el ID del paciente cuyos antecedentes gineco obstétricos se desean actualizar en la URL y los nuevos datos en el cuerpo de la solicitud en formato JSON. Los datos proporcionados en la solicitud PUT reemplazarán los antecedentes gineco obstétricos existentes para ese paciente.

Este endpoint consume un JSON con el siguiente formato:

````json

{
    "menarca": "2012-06-15",
    "ritmo_menstrual": "regular",
    "IPSA": 2,
    "partos": 5,
    "FUP": "2023-07-20",
    "abortos": 0,
    "cesareas": 0
}


````

### Método Delete

+ Endpoint: *{link del host}/api/aGinecoObstetricos/{id}*

Este endpoint se utiliza para eliminar los antecedentes gineco obstétricos de un paciente específico. Se debe proporcionar el ID del paciente cuyos antecedentes gineco obstétricos se desean eliminar en la URL. Al hacer una solicitud DELETE a este enlace, se eliminarán los antecedentes gineco obstétricos correspondientes al paciente identificado por el ID.
