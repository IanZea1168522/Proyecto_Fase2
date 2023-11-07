/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_fase1_zea_1168522_izaguirre_1170522;

/**
 *
 * @author izeac
 */
import static java.awt.image.ImageObserver.WIDTH;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.awt.Component;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import javax.swing.JLabel;
import java.awt.Image;
import javax.swing.ImageIcon;
public class Operador 
{
    // Verifica si alguno de los campos contiene el carácter '|'
    private boolean tieneCaracterInvalido(String... campos) 
    {
        for (String campo : campos) 
        {
            if (campo.contains("|")) 
            {
                return true;
            }
        }
        return false;
    }
    //verifica que no hayan usuarios repetidos
    public boolean verificarCoincidenciaEnLista(List<String> lista, String cadenaBuscada) 
    {
        for (String elemento : lista) 
        {
            String[] partes = elemento.split("\\|"); // Dividir el elemento por "|"
            if (partes.length > 0 && partes[2].equals(cadenaBuscada)) 
            {
                return true; // Se encontró una coincidencia
            }
        }
        return false; // No se encontró ninguna coincidencia
    }

    public void escribirLista(List<String> lista, String ruta, String strError)
    {
        for (int i = 0; i < lista.size(); i++) 
        {
            LlenarArchivo(ruta, lista.get(i), strError);
        }
    }

// Comprueba si algún campo está vacío o si la fecha es nula
    private boolean camposVacios(String usuario, String nombre, String apellido, String contraseña, int telefono, String eMail, LocalDate fecha, String ruta) 
    {
        return usuario.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || contraseña.isEmpty() || telefono < 0 || eMail.isEmpty() || telefono < 1 || fecha == null || ruta.isEmpty();
    }

    // Verifica si las listas listaPunts y listaRes son válidas (no vacías ni nulas)
    public boolean listasValidas(List<String> listaPunts, List<String> listaRes) 
    {
        return (listaPunts != null && !listaPunts.isEmpty()) && (listaRes != null && !listaRes.isEmpty());
    }
    //verifica que ninguno de los campos se pase del límite establecido
    private boolean camposExcedenLimite(String usuario, String nombre, String apellido, String contraseña, String eMail, String rutaFoto) 
    {
        return usuario.length() > 20 || nombre.length() > 30 || apellido.length() > 30 || contraseña.length() > 40 || eMail.length() > 40 || rutaFoto.length() > 200;
    }
    // Determina el rol del usuario
    private int determinarRol(String strError, String rutaIn) 
    {
        if (comprobar(rutaIn, strError) == 0) 
        {
            return 1;
        }
        return 0;
    }
    //escribe el contenido en el archivo
    public boolean LlenarArchivo(String strPath,String strContenido,String strError)
    {
        File Archivo = new File(strPath);
        
        try
        {
                FileWriter Escribir = new FileWriter(Archivo,true);
                BufferedWriter bw = new BufferedWriter(Escribir);
                bw.write(strContenido+ System.getProperty( "line.separator" ));
                bw.close();
                Escribir.close();
                
                return true;
        }
        catch(IOException ex)
        {
            strError= ex.getMessage();
            return false;
        } 
        
    }
    //borra el contenido de un archivo
    private static boolean borrarContenidoArchivo(String strPath) 
    {
        try 
        {
            // Abre el archivo en modo de escritura sin añadir contenido (append = false)
            FileWriter escribir = new FileWriter(strPath, false);
            escribir.close();
            return true;
        } 
        catch (IOException ex) 
        {
            JOptionPane.showMessageDialog(null, "No",  "non", WIDTH);
            return false;
        }
    }
    //método para convertir el contenido de un archivo a lista, para facilitar su manipulación
    public List<String> Obtener(String strPath,String strError)
    {
        //variable tipo archivo (en este caso es un txt)
        File Archivo = new File(strPath);
        //si se encuentra el archivo en la ruta indicada, pasa
        if(Archivo.exists()==true)
        {
            //se crea la lista a enviar
            List<String> ListaPunteo = new ArrayList<>();
            //se crea la variable que nos leerá el archivo
            FileReader LecturaArchivo;
            //try/cacht en caso que el archivo enviado no sea el indicado
            try {
                //se le envía el archivo a leer al lector
                LecturaArchivo = new FileReader(Archivo);
                //búfer de datos
                BufferedReader LeerArchivo = new BufferedReader(LecturaArchivo);
                //string que me guarda el texto por línea
                String Linea;
                //try/catch en caso que se envíe un archivo que no es el solicitado
                try 
                {
                    //la variable "Linea" adquiere el valor de la primera línea del archivo
                    Linea=LeerArchivo.readLine();
                    //se crea otro string donde se va a almacenar el texto por cada línea del archivo
                    String modeloNum = ""; 
                    //ciclo para leer linea por linea el archivo, mientras que la linea no sea null (no haya llegado al final del archivo), se repetirá el ciclo
                    while(Linea != null)
                    {
                        //si en la línea hay texto, se escribe
                        if(!"".equals(Linea))
                        {
                            //la variable modeloNum, adquiere el valor de lo que está en la línea que se está leyendo
                            modeloNum = Linea;
                        }
                        //se agrega ese modelo a la lista
                        ListaPunteo.add(modeloNum);
                        //pasa a la siguiente línea para que el ciclo continue 
                        Linea=LeerArchivo.readLine();
                    }
                    //se cierra el archivo
                    LecturaArchivo.close();
                    //se termina de leer
                    LeerArchivo.close();
                    //no habrá mensaje de error
                    strError="";
                    //se retorna la lista ya llena
                    return ListaPunteo;
                    
                }
                //catch para mostrar el mensaje de error
                catch (IOException ex) 
                {
                    //mensaje de error
                    strError= ex.getMessage();
                    //la lista se retorna nula
                    return null;
                }
            } 
            //catch para mostrar el mensaje de error
            catch (FileNotFoundException ex) 
            {
                //mensaje de error
                strError= ex.getMessage();
                //la lista se retorna nula
                return null;
            }            
        }
        //si el archivo no se encuentra en la ruta indicada, se muestra un mensaje de error y la lista que se envía estará vacía
        else
        {
            //mensaje de error
            strError="No existe el archivo";
            //lista nula
            return null;
        }
    }
    //método que cuenta los renglones 
    public int comprobar(String strPath,String strError)
    {
        //variable tipo archivo (en este caso es un txt)
        File Archivo = new File(strPath);
        //si se encuentra el archivo en la ruta indicada, pasa
        if(Archivo.exists()==true)
        {
            //se crea la variable que nos leerá el archivo
            FileReader LecturaArchivo;
            //try/cacht en caso que el archivo enviado no sea el indicado
            try {
                //se le envía el archivo a leer al lector
                LecturaArchivo = new FileReader(Archivo);
                //búfer de datos
                BufferedReader LeerArchivo = new BufferedReader(LecturaArchivo);
                //string que me guarda el texto por línea
                String Linea;
                //try/catch en caso que se envíe un archivo que no es el solicitado
                try 
                {
                    //la variable "Linea" adquiere el valor de la primera línea del archivo
                    Linea=LeerArchivo.readLine();
                    //se crea otro string donde se va a almacenar el texto por cada línea del archivo
                    int contador = 0; 
                    //ciclo para leer linea por linea el archivo, mientras que la linea no sea null (no haya llegado al final del archivo), se repetirá el ciclo
                    while(Linea != null)
                    {
                        //si en la línea hay texto, se escribe
                        if(!"".equals(Linea))
                        {
                            //se cuenta cada línea
                            contador++;
                        }
                        //pasa a la siguiente línea para que el ciclo continue 
                        Linea=LeerArchivo.readLine();
                    }
                    //se cierra el archivo
                    LecturaArchivo.close();
                    //se termina de leer
                    LeerArchivo.close();
                    //no habrá mensaje de error
                    strError="";
                    //se envía la cantidad de objetos que hay
                    return contador;
                }
                //catch para mostrar el mensaje de error
                catch (IOException ex) 
                {
                    //mensaje de error
                    strError= ex.getMessage();
                    //la lista se retorna nula
                    return -1;
                }
            } 
            //catch para mostrar el mensaje de error
            catch (FileNotFoundException ex) 
            {
                //mensaje de error
                strError= ex.getMessage();
                //la lista se retorna nula
                return -1;
            }            
        }
        //si el archivo no se encuentra en la ruta indicada, se muestra un mensaje de error y la lista que se envía estará vacía
        else
        {
            //mensaje de error
            strError="No existe el archivo";
            //lista nula
            return -1;
        }
    }
    //método para hacer una incersión a la base de datos (archivos de bloque e indizado)
    public void ingresar(String strError, String usuario, String nombre, String apellido, String contraseña, LocalDate fecha, int telefono, String eMail, String ruta, String resul, String edit, String contraRe)
    {
        try
        {
            //se declaran las variables a utilizar
            LocalDateTime fechaHoraActual = LocalDateTime.now();
            DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            //se obtnenen las rutas a utilizar
            String rutaIn = "C:\\MEIA\\indices_usuario.txt";
            String rutaDesIn = "C:\\MEIA\\Desc_indices_usuario.txt";
            String rutaCar = "C:\\MEIA\\bloques";
            //para modificar el contenido de los docs, se usarán listas
            List<String> listaIn = new ArrayList<>();
            List<String> listaOrIn = new ArrayList<>();
            List<String> listaDesIn;
            //si hay elementos en el archivo, que se agreguen a la lista, de lo contrario no es necesario
            if(comprobar(rutaIn, strError) > 0)
            {
                listaIn = Obtener(rutaIn, strError);
                listaOrIn = Obtener(rutaIn, strError);
            }
            //llenar la lista del descriptor
            listaDesIn = Obtener(rutaDesIn, strError);
            //comprobar que ningún campo contenga "|" para que no se arruine el funcionamiento de los archivos
            if (tieneCaracterInvalido(usuario, nombre, apellido, contraRe, String.valueOf(fecha), eMail, String.valueOf(telefono), ruta)) 
            {
                //throw new Exception("El string contiene el carácter '|'");
            }
            //verificar que ningún campo esté vacío
            if (camposVacios(usuario, nombre, apellido, contraRe, telefono, eMail, fecha, ruta)) 
            {
                JOptionPane.showMessageDialog(null, "Por favor llene todos los campos antes de continuar", "Error", WIDTH);
            } 
            else 
            {
                //si la contraseña no es segura, solicitar que la cambie
                if (resul.equals("Contraseña insegura") || resul.equals("Contraseña poco segura")) 
                {
                    JOptionPane.showMessageDialog(null, "La contraseña no es lo suficientemente segura, intente con otra", "Error", WIDTH);
                }
                //comprobar que ningún campo se exeda de los límites
                else if (camposExcedenLimite(usuario, nombre, apellido, contraRe, eMail, ruta)) 
                {
                    JOptionPane.showMessageDialog(null, "Alguno de los campos excede el número máximo de caracteres, vuelva a intentarlo", "Error", WIDTH);
                }
                //comprobar si ya existe ese nombre de usuario
                else if(verificarCoincidenciaEnLista(listaIn, usuario))
                {
                    JOptionPane.showMessageDialog(null, "Nombre de usuario ya existente, intente con otro", "Error", WIDTH);
                }
                else 
                {
                    //se busca el rol del usuario a crear
                    int rol = determinarRol(strError, rutaIn);
                    //creamos el registro
                    String todo = usuario + "|" + nombre + "|" + apellido + "|" + contraseña + "|" + rol + "|" + fecha + "|" + eMail + "|" + telefono + "|" + ruta + "|" + "1";
                    //creamos una lista para su descriptor, y lo llenamos con los datos creados
                    List<String> descGenerico = new ArrayList<String>();
                    descGenerico.add("Usuario_Bloque_1");
                    descGenerico.add(String.valueOf(fechaHoraActual.format(forma)));
                    descGenerico.add(edit);
                    descGenerico.add(String.valueOf(fechaHoraActual.format(forma)));
                    descGenerico.add(edit);
                    descGenerico.add("1");
                    descGenerico.add("0");
                    descGenerico.add("1");
                    descGenerico.add("3");
                    //se crea un contador y un bool para poder verificar en que bloque quedará incertado el elemento
                    boolean existe = true;
                    int ident = 1;
                    //ahora variables que indiquen el bloque y su posición
                    int posi = 1;
                    int bloque = 1;
                    String index = "";
                    //ahora con el usuario ya creado, se procede a realizar la inserción, primero comprobando en que bloque se debe ingresar
                    if(carpetaEstaVacia(rutaCar))
                    {
                        LlenarArchivo("C:\\MEIA\\bloques\\Usuario_Bloque_1.txt",todo,strError);
                        escribirLista(descGenerico, "C:\\MEIA\\bloques\\Desc_Usuario_Bloque_1.txt", strError);
                        index = String.valueOf(bloque) + "." + String.valueOf(posi);
                    }
                    else
                    {
                        while (existe) 
                        {
                            String nombreArch = "Usuario_Bloque_" + String.valueOf(ident) + ".txt";
                            existe = archivoExisteEnCarpeta(rutaCar, nombreArch);
                            if (existe == true) 
                            {
                                String rutaBloque = "C:\\MEIA\\bloques\\" + nombreArch;
                                String rutaDesBloque = "C:\\MEIA\\bloques\\Desc_" + nombreArch;
                                List<String> listaBloque = Obtener(rutaBloque, strError);
                                List<String> listaDesBloque = Obtener(rutaDesBloque, strError);
                                if (listaBloque.size() < Integer.parseInt(listaDesBloque.get(8))) 
                                {
                                    // Editar el archivo de bloque
                                    listaBloque.add(todo);
                                    borrarContenidoArchivo(rutaBloque);
                                    escribirLista(listaBloque, rutaBloque, strError);
                                    // Editar el archivo descriptor de bloque
                                    listaDesBloque.set(3, String.valueOf(fechaHoraActual.format(forma)));
                                    listaDesBloque.set(4, edit);
                                    listaDesBloque.set(5,String.valueOf((Integer.parseInt(listaDesBloque.get(5)))+ 1));
                                    listaDesBloque.set(7,String.valueOf((Integer.parseInt(listaDesBloque.get(7)))+ 1));
                                    borrarContenidoArchivo(rutaDesBloque);
                                    escribirLista(listaDesBloque, rutaDesBloque, strError);
                                    posi = listaBloque.size();
                                    index = String.valueOf(ident) + "." + String.valueOf(posi);
                                    ident = ident +1;
                                    break;
                                } 
                            }
                            ident = ident + 1;
                        }
                        ident = ident -1;
                        if(existe == false)
                        {
                            LlenarArchivo("C:\\MEIA\\bloques\\Usuario_Bloque_" + String.valueOf(ident) + ".txt",todo,strError);
                            descGenerico.set(0, "Usuario_Bloque_" + String.valueOf(ident));
                            escribirLista(descGenerico, "C:\\MEIA\\bloques\\Desc_Usuario_Bloque_" + String.valueOf(ident) + ".txt", strError);
                            index = String.valueOf(ident) + "." + String.valueOf(posi);
                        }
                    }
                    //modificamos el índice 
                    if(listaIn.isEmpty())
                    {
                        listaDesIn.set(1, String.valueOf(fechaHoraActual.format(forma)));
                        listaDesIn.set(2, edit);
                        listaDesIn.set(3, String.valueOf(fechaHoraActual.format(forma)));
                        listaDesIn.set(4, edit);
                        listaDesIn.set(5, "1");
                        listaDesIn.set(6, "0");
                        listaDesIn.set(7, "1");
                        listaDesIn.set(8, "1");
                        listaDesIn.set(9, "1");
                    }
                    String siguiente = "0";
                    if (!listaIn.isEmpty()) 
                    {
                        listaDesIn.set(3, String.valueOf(fechaHoraActual.format(forma)));
                        listaDesIn.set(4, edit);
                        listaDesIn.set(5, String.valueOf(Integer.parseInt(listaDesIn.get(5))+1));
                        listaDesIn.set(7, String.valueOf(Integer.parseInt(listaDesIn.get(7))+1));
                        listaDesIn.set(8, String.valueOf(ident));
                        //siguiente = String.valueOf(Integer.parseInt(siguiente)+1);
                    }
                    String todoIn = String.valueOf(listaIn.size() + 1) + "|" + index + "|" + usuario + "|" + siguiente + "|" + "1";
                    listaIn.add(todoIn);
                    listaDesIn.set(9, String.valueOf(encontrarElementoMasPequeño(listaIn) + 1));
                    listaOrIn.add(todoIn);
                    if(listaOrIn.size() > 1)
                    {
                        ordenarListaPorPosicion2(listaOrIn);
                        listaIn = editarSig(listaIn, listaOrIn);
                    }
                    borrarContenidoArchivo(rutaIn);
                    escribirLista( listaIn, rutaIn, strError);
                    borrarContenidoArchivo(rutaDesIn);
                    escribirLista( listaDesIn, rutaDesIn, strError);
                }
            }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Datos ingresados erróneos, vuelve a intentarlo", "Error", WIDTH);
        }
    }
    
    public List<String> editarSig(List<String> OG, List<String> Or)
    {
        for (int i = 0; i < (OG.size()-1); i++) 
        {
            String[] primero = Or.get(i).split("\\|");
            String[] siguiente = Or.get((i+1)).split("\\|");
            int posi = Integer.parseInt(primero[0])-1;
            String[] Original = OG.get(posi).split("\\|");
            Original[3] = siguiente[0];
            OG.set(posi, String.join("|", Original));
        }
        return OG;
    }
    
    public int encontrarElementoMasPequeño(List<String> lista) 
    {
        if (lista.isEmpty()) 
        {
            return -1; // Devuelve -1 si la lista está vacía
        }
        int posicionMasPequenio = 0;
        String[] cadenaMasPequenio = lista.get(0).split("\\|");
        for (int i = 1; i < lista.size(); i++) 
        {
            String[] elemento = lista.get(i).split("\\|");
            if (elemento[2].compareTo(cadenaMasPequenio[2]) < 0) 
            {
                cadenaMasPequenio = elemento;
                posicionMasPequenio = i;
            }
        }
        return posicionMasPequenio;
    }
    
    public static void ordenarListaPorPosicion2(List<String> lista) 
    {
        Collections.sort(lista, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] partes1 = o1.split("\\|");
                String[] partes2 = o2.split("\\|");
                String valor1 = partes1[2]; // Valor en la posición 2
                String valor2 = partes2[2]; // Valor en la posición 2
                return valor1.compareTo(valor2);
            }
        });
    }
    
    public boolean archivoExisteEnCarpeta(String rutaCarpeta, String nombreArchivo) {
    File carpeta = new File(rutaCarpeta);
    
    // Verificar si la carpeta existe y es un directorio
    if (carpeta.exists() && carpeta.isDirectory()) {
        File[] archivos = carpeta.listFiles();

        if (archivos != null) {
            for (File archivo : archivos) {
                if (archivo.isFile() && archivo.getName().equals(nombreArchivo)) {
                    return true; // El archivo existe en la carpeta
                }
            }
        }
    }
    
    return false; // El archivo no existe en la carpeta
}
    //comprueba si la carpeta está vacía
    public boolean carpetaEstaVacia(String rutaCarpeta) 
    {
        File carpeta = new File(rutaCarpeta);
        // Verificar si la carpeta existe
        if (!carpeta.exists() || !carpeta.isDirectory()) 
        {
            // La carpeta no existe o no es una carpeta válida
            return false;
        }
        // Obtener la lista de archivos en la carpeta
        String[] archivos = carpeta.list();
        // Si la lista de archivos es nula o tiene longitud 0, la carpeta está vacía
        return archivos == null || archivos.length == 0;
    }
    public String obtenerNuevaRutaImg(Component parentComponent)
    {
        JFileChooser dialogo = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imágenes (*.jpg, *.png)", "jpg", "png");
        File ficheroImagen;
        String rutaArchivo;
        dialogo.setFileFilter(filtro);

        int valor = dialogo.showOpenDialog(parentComponent);
        if (valor == JFileChooser.APPROVE_OPTION) {
            ficheroImagen = dialogo.getSelectedFile();
            rutaArchivo = ficheroImagen.getPath();
            // Verificar que el archivo existe y tiene una extensión permitida
            if (ficheroImagen.exists() && (rutaArchivo.endsWith(".jpg") || rutaArchivo.endsWith(".png"))) {
                return rutaArchivo;
            } else {
                // Mostrar un mensaje de error si el archivo no cumple con los requisitos
                JOptionPane.showMessageDialog(parentComponent, "Seleccione un archivo válido (.jpg o .png)", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return null;
    }
    public int punt(String cod, List<String> punteos)
    {
        //variable que guarda la puntuación final
        int puntu = 0;
        //puntuación va a ser igual a segundo número por el total de caracteres de la contraseña
        puntu = puntu + (cod.length() * Integer.parseInt(punteos.get(1)));
        //se crea la variable que guarde la cantidad de mayusculas en el string
        int mayus = 0;
        //se crea la variable que guarde la cantidad de letras en el string
        int letras = 0;
        //se crea la variable que guarde la cantidad de numeros en el string
        int nums = 0;
        //se crea la variable que guarde la cantidad de caracteres especiales en el string
        int especiales = 0;
        //se crea la variable que compruebe si solo hay letras
        boolean soloLetras = true;
        //se crea la variable que compruebe si solo hay numeros
        boolean soloNums = true;
        //ciclo para recorrer cada caracter del string
        for (char caracter : cod.toCharArray()) 
        {
            //se comprueba si el caracter está en mayuscula o no
            if(Character.isUpperCase(caracter))
            {
                //en caso que si, se le suma a la variable
                mayus++;
            }
            //se comprueba si el caracter es letra o no
            if(Character.isLetter(caracter))
            {
                //en caso que si, se agrega una unidad al contador
                letras++;
                //si hay por lo menos 1 letra significa que no hay solo numeros, por lo tanto se vuelve falso
                soloNums = false;
            }
            //se comprueba si el caracter es letra o no
            if(Character.isDigit(caracter))
            {
                //en caso que si, se agrega una unidad al contador
                nums++;
                //si hay por lo menos 1 numero significa que no hay solo letras, por lo tanto se vuelve falso
                soloLetras = false;
            }
            //se comprueba si el caracter es especial o no (si pertenece a /¿?%$#)
            if(caracter == '/' || caracter == '¿' || caracter == '?' || caracter == '%' || caracter == '$' || caracter == '#')
            {
                //en caso que si, se agrega una unidad al contador
                especiales++;
                //si hay por lo menos 1 especial significa que no hay solo numeros o solo letras, por lo tanto se vuelven falsos
                soloNums = false;
                soloLetras = false;
            }
        }
        //se calcula nuevamente la puntuación (tomando en cuenta solo mayúsculas
        puntu = puntu + (mayus * Integer.parseInt(punteos.get(2)));
        //se calcula nuevamente la puntuación (tomando en cuenta solo si son letras
        puntu = puntu + (letras + Integer.parseInt(punteos.get(3)));
        //se calcula nuevamente la puntuación (tomando en cuenta solo si son numeros
        puntu = puntu + (nums + Integer.parseInt(punteos.get(4)));
        //se calcula nuevamente la puntuación (tomando en cuenta solo si son numeros
        puntu = puntu + (especiales *( cod.length()+ Integer.parseInt(punteos.get(5))));
        //si solo hay letras se hace la resta
        if(soloLetras)
        {
            //si solo hay letras, se hace la resta
            puntu = puntu - Integer.parseInt(punteos.get(6));
        }
        //si solo hay numeros se hace la resta
        if(soloNums)
        {
            puntu = puntu - Integer.parseInt(punteos.get(7));
        }
        //se retorna el punteo
        return puntu;
    }
    
    // Determina el estado de la contraseña en función de la puntuación
    public String obtenerEstadoContraseña(int puntuacion, List<String> listaRes) 
    {
        int[] limites = new int[4];
        for (int i = 0; i < 4; i++) 
        {
            limites[i] = Integer.parseInt(listaRes.get(i).split(",")[1]);
        }
        if (puntuacion <= limites[0]) 
        {
            return "Contraseña insegura";
        } 
        else if (puntuacion <= limites[1]) 
        {
            return "Contraseña poco segura";
        } 
        else if (puntuacion <= limites[2]) 
        {
            return "Contraseña segura";
        } 
        else 
        {
            return "Contraseña muy segura";
        }
    }
    public String duplicarImagen(String rutaImagenOriginal) 
    {
        Path origen = Paths.get(rutaImagenOriginal);
        Path destino = Paths.get("C:\\MEIA\\imgs", origen.getFileName().toString());
        try 
        {
            Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING);
            return destino.toString();
        } 
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Datos ingresados erróneos, vuelve a intentarlo", "Error", WIDTH);
        }
        return null;
    }
    public String buscar(List<String> lista, int inicio, String buscado, String strError)
    {
        String encontrado = "";
        int posicion = inicio;
        while(posicion != -1)
        {
            if(buscado.equals(lista.get(posicion).split("\\|")[2]))
            {
                encontrado = lista.get(posicion);
                break;
            }
            posicion = Integer.parseInt(lista.get(posicion).split("\\|")[3]) - 1;
        }
        if(!encontrado.equals(""))
        {
            String rutaBloque = "C:\\MEIA\\bloques\\Usuario_Bloque_" + encontrado.split("\\|")[1].split("\\.")[0] + ".txt";
            List<String> listaBlo = Obtener(rutaBloque, strError);
            encontrado = listaBlo.get(Integer.parseInt(encontrado.split("\\|")[1].split("\\.")[1])-1);
            return encontrado;
        }
        else
        {
            return null;
        }
    }
    public void SetImageLabel(JLabel label,String imagePath, Component parentComponent)
    {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        label.setIcon(scaledIcon);
        parentComponent.repaint();
    }
    public String buscarIn(List<String> lista, int inicio, String buscado)
    {
        int posicion = inicio;
        while(posicion != -1)
        {
            if(buscado.equals(lista.get(posicion).split("\\|")[2]))
            {
                return lista.get(posicion);
            }
            posicion = Integer.parseInt(lista.get(posicion).split("\\|")[3]) - 1;
        }
        return null;
    }
    public void cambiarStatus(String cambioIn, String cambioBlo, String usuario, String strError, String rutaIn, String rutaDesIn, List<String> listaIn, List<String> listaDesIn)
    {
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String rutaBlo = "C:\\MEIA\\bloques\\Usuario_Bloque_" + cambioIn.split("\\|")[1].split("\\.")[0] + ".txt";
        String rutaDesBlo = "C:\\MEIA\\bloques\\Desc_Usuario_Bloque_" + cambioIn.split("\\|")[1].split("\\.")[0] + ".txt";
        List<String> listaBlo = Obtener(rutaBlo, strError);
        List<String> listaDesBlo = Obtener(rutaDesBlo, strError);
        String[] partesIn = cambioIn.split("\\|");
        String[] partesBlo = cambioBlo.split("\\|");
        partesIn[4] = "0";
        partesBlo[9] = "0";
        listaIn.set((Integer.parseInt(partesIn[0])-1), String.join("|", partesIn));
        listaBlo.set((Integer.parseInt(partesIn[1].split("\\.")[1])-1), String.join("|", partesBlo));
        listaDesIn.set(3, String.valueOf(fechaHoraActual.format(forma)));
        listaDesIn.set(4, usuario);
        listaDesIn.set(5,String.valueOf(Integer.parseInt(listaDesIn.get(5)) - 1));
        listaDesIn.set(6,String.valueOf(Integer.parseInt(listaDesIn.get(6)) + 1));
        listaDesBlo.set(3, String.valueOf(fechaHoraActual.format(forma)));
        listaDesBlo.set(4, usuario);
        listaDesBlo.set(5,String.valueOf(Integer.parseInt(listaDesBlo.get(5)) - 1));
        listaDesBlo.set(6,String.valueOf(Integer.parseInt(listaDesBlo.get(6)) + 1));
        borrarContenidoArchivo(rutaIn);
        borrarContenidoArchivo(rutaDesIn);
        borrarContenidoArchivo(rutaBlo);
        borrarContenidoArchivo(rutaDesBlo);
        escribirLista(listaIn, rutaIn, strError);
        escribirLista(listaDesIn, rutaDesIn, strError);
        escribirLista(listaBlo, rutaBlo, strError);
        escribirLista(listaDesBlo, rutaDesBlo, strError);
    }
    public void cambiarDatos(String reemplazo, String cambioIn, String usuario, String strError, String rutaIn, String rutaDesIn, List<String> listaIn, List<String> listaDesIn)
    {
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String rutaBlo = "C:\\MEIA\\bloques\\Usuario_Bloque_" + cambioIn.split("\\|")[1].split("\\.")[0] + ".txt";
        String rutaDesBlo = "C:\\MEIA\\bloques\\Desc_Usuario_Bloque_" + cambioIn.split("\\|")[1].split("\\.")[0] + ".txt";
        List<String> listaBlo = Obtener(rutaBlo, strError);
        List<String> listaDesBlo = Obtener(rutaDesBlo, strError);
        String[] partesIn = cambioIn.split("\\|");
        listaBlo.set((Integer.parseInt(partesIn[1].split("\\.")[1])-1), reemplazo);
        listaDesBlo.set(3, String.valueOf(fechaHoraActual.format(forma)));
        listaDesBlo.set(4, usuario);
        borrarContenidoArchivo(rutaBlo);
        borrarContenidoArchivo(rutaDesBlo);
        escribirLista(listaBlo, rutaBlo, strError);
        escribirLista(listaDesBlo, rutaDesBlo, strError);
        JOptionPane.showMessageDialog(null, "Cambios realizados con éxito", "Listo", WIDTH);
    }
    public void condensar(String usuario)
    {
        String strError= "";
        List<String> listaTodo = new ArrayList<>();
        List<List<String>> descriptores = new ArrayList<>();
        String rutaCar = "C:\\MEIA\\bloques";
        int indice = 1;
        String nombreArch = "Usuario_Bloque_" + String.valueOf(indice) + ".txt";
        boolean existe = archivoExisteEnCarpeta(rutaCar, nombreArch);
        while(existe)
        {
            List<String> listaBloque = Obtener(("C:\\MEIA\\bloques\\Usuario_Bloque_" + String.valueOf(indice) + ".txt"), strError);
            for (int i = 0; i < listaBloque.size(); i++) 
            {
                if(listaBloque.get(i).split("\\|")[9].equals("1"))
                {
                    listaTodo.add(listaBloque.get(i));
                }
            }
            descriptores.add(Obtener(("C:\\MEIA\\bloques\\Desc_Usuario_Bloque_" + String.valueOf(indice) + ".txt"),strError));
            indice = indice + 1;
            nombreArch = "Usuario_Bloque_" + String.valueOf(indice) + ".txt";
            existe = archivoExisteEnCarpeta(rutaCar, nombreArch);
        }
        String rutaDesIn = "C:\\MEIA\\Desc_indices_usuario.txt";
        String rutaIn = "C:\\MEIA\\indices_usuario.txt";
        List<String> descAntiguo = Obtener(rutaDesIn,strError);
        borrarContenidoArchivo(rutaIn);
        borrarArchivosEnCarpeta(rutaCar);
        String rutaPuntuacion = "C:\\MEIA\\puntuacion.txt";
        String rutaResultado = "C:\\MEIA\\resultado.txt";
        List<String> listaPunts = Obtener(rutaPuntuacion, strError);
        List<String> listaRes = Obtener(rutaResultado, strError);
        int puntuacion = punt("123456D", listaPunts);
        String resul = obtenerEstadoContraseña(puntuacion, listaRes);
        for (int i = 0; i < listaTodo.size(); i++) 
        {
            String[] partes = listaTodo.get(i).split("\\|");
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fecha = LocalDate.parse(partes[5], formato);
            ingresar(strError, partes[0], partes[1], partes[2], partes[3], fecha, Integer.parseInt(partes[7]), partes[6], partes[8], resul, usuario, "123456D");
        }
        List<String> descNuevo = Obtener(rutaDesIn,strError);
        descNuevo.set(1, descAntiguo.get(1));
        descNuevo.set(2, descAntiguo.get(2));
        borrarContenidoArchivo(rutaDesIn);
        escribirLista(descNuevo, rutaDesIn, strError);
        indice = 1;
        nombreArch = "Usuario_Bloque_" + String.valueOf(indice) + ".txt";
        existe = archivoExisteEnCarpeta(rutaCar, nombreArch);
        while(existe)
        {
            List<String> listaDesBloque = Obtener(("C:\\MEIA\\bloques\\Desc_Usuario_Bloque_" + String.valueOf(indice) + ".txt"), strError);
            listaDesBloque.set(1, descriptores.get(indice-1).get(1));
            listaDesBloque.set(1, descriptores.get(indice-1).get(1));
            borrarContenidoArchivo(("C:\\MEIA\\bloques\\Desc_Usuario_Bloque_" + String.valueOf(indice) + ".txt"));
            escribirLista(listaDesBloque, ("C:\\MEIA\\bloques\\Desc_Usuario_Bloque_" + String.valueOf(indice) + ".txt"), strError);
            indice = indice + 1;
            nombreArch = "Usuario_Bloque_" + String.valueOf(indice) + ".txt";
            existe = archivoExisteEnCarpeta(rutaCar, nombreArch);
        }
    }
    public static void borrarArchivosEnCarpeta(String rutaCarpeta) {
        File carpeta = new File(rutaCarpeta);
        if (carpeta.exists() && carpeta.isDirectory()) {
            File[] archivos = carpeta.listFiles();
            if (archivos != null) {
                for (File archivo : archivos) {
                    if (archivo.isFile()) {
                        if (archivo.delete()) {
                            System.out.println("Archivo eliminado: " + archivo.getName());
                        } else {
                            System.err.println("No se pudo eliminar el archivo: " + archivo.getName());
                        }
                    }
                }
            }
        } else {
            System.err.println("La carpeta no existe o no es un directorio válido: " + rutaCarpeta);
        }
    }
}
