package dao;

public class Principal {
    
    public static void main(String[] args) {
        Conexion conect = new Conexion();
        
        if(conect.conectarse() == true){
            System.out.println("Si conecta");
        }else{
            System.out.println("No conecta");
        }
    }
}
