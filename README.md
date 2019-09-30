Taller 1 Ecosistemas Jose Luis Devera Gomez


Clases
/**
 *
 *Main esta clase se encarga de instanciar PApplet y Logica. Tambien define el tamaño del lienzo y tiene las funciones principales para el funcionamiento del codigo.

	Atributos
	
	*@parametro	Logica	log	se encargarga de la clase logica la cual tiene el funcionamiento del codigo y es necesaria porque Main es static.
 *
 *Logica esta clase se encarga de tener a las otras clases, instanciar las clases y hacer que funcionen los metodos.
	Atributos 
	*@parametro	PApplet app	Es la instancia para usar metodos de procesing.
	*@parametro	Comunicacion	comunicacion	Instancia encargada de que la comunicacion funcione.
	*@parametro	Int	pantalla	Se encarga del cambio de pantallas.
	*@parametro	
 *
 *Jugador
 *
 *Proyectil
 *
 *Enemigo
 *
 *Enemigo1 y 2
 *
 *Imagenes
 *
 *Comunicacion
 *
 *GeneradorEnemigos
 *
 */


Metodos
/**
 *Todos los metodos show() se encargaran de las acciones que requieran mostrar un objeto en el canvas.
 *
 *Todos los metodos run() son pertenecientens a los hilos y se encargan de la operaciones matematicas y cosa que no requieran del canvas.
 *
 *El metodo update() pertenece a la interfaz observer y se encarga de alertar cada vez que el observable tenga un cambio o algo que notificar.
 *
 *El metodo evaluate() se encarga de evaluar colisiones, en el metodo de la clase personaje se evalua que toque el suelo y se evalua que las balas hagan colision con el enemigo. En el caso de enemigo este evalua si el enemigo tocó al personaje.
 *
 *El metodo move() se encarga de la suma de velocidades a las cordenadas para que el objeto se mueva.
 *
 *El metodo sendMessage() se encarga de enviar mensajes entre los conectados.
 * 
 */
