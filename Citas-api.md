# Funcionamiento del Microservicio Paciente-API

Este microservicio proporciona una interfaz segura y eficiente para administrar la el calendario de cita, incluyendo la posibilidad de registrar Citas, Sistemas del cuerpo,Diagnosticos y sus revalidaciones, Archivos de estudios, Exploraciones Fisicas y Padecinmientos. De esta manera, se garantiza un manejo completo de la clinica.

## Características Microservicio Paciente-API:

1. **Citas:** Permite ingresar datos importantes de la cita como la fecha y el costo de esta.

2. **Sistemas del cuerpo:** Facilita el registro de Diagnosticos catalogandolos en base a en que sistema se hizo el diagnostico.

3. **Diagnosticos:** Diagnosticos hechos por los medicos los cuales se deben registrar de amnera historica.

4. **Revalidaciones:** Revalidaciones de diagnosticos previos en las que se pueden correjir errores o agregar nuevas observaciones.

5. **Estudios:** Datos de donde se encuntran guardados los archuivos de los estudios hechos.

6. **Exploraciones Fisicas:** Notaws sobre exploraciones fisicas hecas por los medicos en las citas.

7. **Padecimientos:** Detalles sobre lo que aqueja al paciente utilizados para sacar diagnosticos.

# Diagrama de la BD

![paciente-bd](/imagenes/citas-bd.png)

# Endpoints del microservicio Citas-API

## Cita

### Método Get

+ Endpoint: *{link del host}/citas-api/citas*

### Método Get
+ Endpoint: *{link del host}/citas-api/citas/{id}*

### Método Post

+ Endpoint: *{link del host}/citas-api/citas*

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

+ Endpoint: *{link del host}/citas-api/citas/{id}*

```json
{
    "idPaciente":2,
    "fechaHora":"2020-09-04T10:44:46",
    "idPacienteType":2,
    "idStatus":2,
    "numeroSesion":2,
    "costoTratamiento":1100.05
}

```
### Método Delete

+ Endpoint: *{link del host}/citas-api/catalogosSistemas/{id}*

## Catalogo Sistemas

### Método Get

+ Endpoint: *{link del host}/citas-api/catalogosSistemas*

### Método Get
+ Endpoint: *{link del host}/citas-api/catalogosSistemas/{id}*

### Método Post

+ Endpoint: *{link del host}/citas-api/catalogosSistemas*

```json
{
    "sistema":"Motor",
    "subsistema":"Oseo"

}

```
### Método Put

+ Endpoint: *{link del host}/citas-api/catalogosSistemas/{id}*

```json
{
    "sistema":"Neural",
    "subsistema":"Limbar"

}

```
### Método Delete

+ Endpoint: *{link del host}/citas-api/catalogosSistemas/{id}*

## Cita Status

### Método Get

+ Endpoint: *{link del host}/citas-api/citaStatus*

### Método Get
+ Endpoint: *{link del host}/citas-api/citaStatus/{id}*

### Método Post

+ Endpoint: *{link del host}/citas-api/citaStatus*

```json
{
    "nombre":"Cancelada"
}

```
### Método Put

+ Endpoint: *{link del host}/citas-api/citaStatus/{id}*

```json
{
    "nombre":"Retrasada"
}

```
### Método Delete

+ Endpoint: *{link del host}/citas-api/pacienteType/{id}*

## Paciente Type

### Método Get

+ Endpoint: *{link del host}/citas-api/pacienteType*

### Método Get
+ Endpoint: *{link del host}/citas-api/pacienteType/{id}*

### Método Post

+ Endpoint: *{link del host}/citas-api/pacienteType*

```json
{
    "nombre":"Tercero"
}

```
### Método Put

+ Endpoint: *{link del host}/citas-api/pacienteType/{id}*

```json
{
    "nombre":"Cuarto"
}
```
### Método Delete

+ Endpoint: *{link del host}/citas-api/pacienteType/{id}*

## Diagnostico

### Método Get

+ Endpoint: *{link del host}/citas-api/diagnosticos*

### Método Get
+ Endpoint: *{link del host}/citas-api/diagnosticos/{id}*

### Método Post

+ Endpoint: *{link del host}/citas-api/diagnosticos*

```json
{
    "idCita":1,
    "idSistema":1,
    "fecha":"2020-09-04",
    "diagnostico":"Fractura de pie"

}

```
### Método Put

+ Endpoint: *{link del host}/citas-api/diagnosticos/{id}*

```json
{
    "idCita":1,
    "idSistema":1,
    "fecha":"2022-09-04",
    "diagnostico":"Fractura de craneo"

}

```
### Método Delete

+ Endpoint: *{link del host}/citas-api/diagnosticos/{id}*

## Revaloracion

### Método Get

+ Endpoint: *{link del host}/citas-api/revaloraciones*

### Método Get
+ Endpoint: *{link del host}/citas-api/revaloraciones/{id}*

### Método Post

+ Endpoint: *{link del host}/citas-api/revaloraciones*

```json
{
    "idDiagnostico":1,
    "idSistema":1,
    "fecha":"2020-09-04",
    "diagnostico":"Rasgadura de ligamento"

}

```
### Método Put

+ Endpoint: *{link del host}/citas-api/revaloraciones/{id}*

```json
{
    "idDiagnostico":9,
    "idSistema":1,
    "fecha":"2022-09-04",
    "diagnostico":"Derrame Cerebral"

}

```
### Método Delete

+ Endpoint: *{link del host}/citas-api/revaloraciones/{id}*

## Estudios

### Método Get

+ Endpoint: *{link del host}/citas-api/estudios*

### Método Get
+ Endpoint: *{link del host}/citas-api/estudios/{id}*

### Método Post

+ Endpoint: *{link del host}/citas-api/estudios*

```json
{
    "idCita":1,
    "ubicacion":"C:\\"
}

```
### Método Put

+ Endpoint: *{link del host}/citas-api/estudios/{id}*

```json
{
    "idCita":1,
    "ubicacion":"C:\\estudios"
}

```
### Método Delete

+ Endpoint: *{link del host}/citas-api/estudios/{id}*

+ ## Padecimientos

### Método Get

+ Endpoint: *{link del host}/citas-api/padecimientos*

### Método Get
+ Endpoint: *{link del host}/citas-api/padecimientos/{id}*

### Método Post

+ Endpoint: *{link del host}/citas-api/padecimientos*

```json
{
    "idCita":1,
    "fecha":"2018-09-04",
    "descripcion":"Se ha presentado Neumonía gripal, así como sobreinfecciones del tracto respiratorio por otros gérmenes, fundamentalmente bacterias",
    "evolucion":"El paciente ha presentado nuevos síntomas en la última semana, ha comunicado que ha estado presentando mareos frecuentes después de consumir cierto medicamento",
    "estado_actual":"Necesita revisión médica"
}
```
### Método Put

+ Endpoint: *{link del host}/citas-api/padecimientos/{id}*

```json
{
    "idCita":1,
    "fecha":"2019-10-6",
    "descripcion":"Se ha presentado Neumonía gripal, así como sobreinfecciones del tracto respiratorio por otros gérmenes, fundamentalmente bacterias",
    "evolucion":"El paciente ha presentado nuevos síntomas en la última semana, ha comunicado que ha estado presentando mareos frecuentes después de consumir cierto medicamento",
    "estado_actual":"En tratamiento"
}

```
### Método Delete

+ Endpoint: *{link del host}/citas-api/padecimientos/{id}*

+ + ## Exploraciones Físicas

### Método Get

+ Endpoint: *{link del host}/citas-api/exploraciones-fisicas*

### Método Get
+ Endpoint: *{link del host}/citas-api/exploraciones-fisicas/{id}*

### Método Post

+ Endpoint: *{link del host}/citas-api/exploraciones-fisicas*

```json
{
    "exploracion":"Estatura: 1.81 cm; Peso: 89 kg; Presenta erupciones de la piel",
    "fecha":"2018-09-04",
    "idCita":1
}
```
### Método Put

+ Endpoint: *{link del host}/citas-api/exploraciones-fisicas/{id}*

```json
{
    "exploracion":"Estatura: 1.81 cm; Peso: 89 kg; No presenta rasgos remarcables",
    "fecha":"2019-10-6",
    "idCita":1
}

```
### Método Delete

+ Endpoint: *{link del host}/citas-api/exploraciones-fisicas/{id}*
