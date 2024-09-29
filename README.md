# Guía de Colaboración

🐸🐼🐧🦊🦁

## Flujo de Trabajo

### 1. Clonar el repositorio
Primero, debes clonar el repositorio en tu máquina local. Creas una carpeta y abres una terminal allí.
Ejecutas el siguiente comando:

```bash
git clone https://github.com/alhexmbs/pry_dae_farmacia.git
````

Luego cambias de directorio

```bash
cd pry_dae_farmacia
````
Abres ese proyecto en NetBeans.

> ⚠️ Importante: A partir de ahora, abre la terminal siempre en este directorio para ejecutar los comandos de Git. Esto se llama la "carpeta del proyecto" (pry_dae_farmacia).

## ⚠️ REGLAS BÁSICAS DE COLABORACIÓN
- No modifiques el main: Solo trabaja en tu propio módulo o sección asignada.
- Respeta el trabajo de tus compañeros: No modifiques los módulos o interfaces de otros sin su consentimiento.

---

# PRIMEROS PASOS
## 1. Crea una rama nueva
Si es la primera vez que trabajas en el proyecto, estarás en la rama **main**. Crea tu propia rama para trabajar y evitar conflictos con el código principal:
```bash
git checkout -b rama-tuNombre
````

>Ahora estás en tu rama. Puedes realizar cambios en tu módulo sin afectar el trabajo de los demás.

#### 🐼 Consejos mientras trabajas
- No cierres la terminal mientras haces cambios.
- Guarda y haz commits con frecuencia para no perder el progreso.

## 2. Subir tus cambios
Cuando hayas hecho todos los cambios en tu módulo, sigue estos pasos para guardarlos en GitHub:
1. Añadir los archivos modificados
```bash
git add .
````

2. Hacer un commit con un mensaje claro
```bash
git commit -m "Implementé la validación de formularios"
````

3. Sube tu rama a GitHub
```bash
git push origin rama-tuNombre
````

## 3. Si ya terminaste y todo está correcto regresa a la rama principal (**main**):
```bash
git checkout main
````

---

# SI EL PROYECTO YA HA SIDO MODIFICADO
## 1. Traer los cambios recientes de main
Es posible que otros miembros hayan hecho cambios en el proyecto. Antes de seguir trabajando, asegúrate de traer los cambios más recientes.
Primero, asegúrate de estar en la rama main y luego actualiza tu copia local con los cambios más recientes del repositorio remoto:
```bash
git pull origin main
````
## 2. Cambia a tu rama
Una vez que has actualizado tu proyecto, puedes volver a tu rama personal y continuar trabajando:
```bash
git checkout rama-tuNombre
````
>⚠️ Recuerda: Siempre sincroniza los cambios de main antes de comenzar a trabajar para evitar conflictos.

#### Y así repites el proceso

Happy coding 😊👨‍💻👩‍💻
