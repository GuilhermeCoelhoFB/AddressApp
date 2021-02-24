package br.cefetmg.address.controller;
import br.cefetmg.address.model.Person;
import br.cefetmg.address.model.AcessaBD;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
 
public class PersonHandler {
    AcessaBD app = new AcessaBD();
    Scanner in = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    
    public boolean verificaPessoa(Long id){
        Person atual = new Person();

        try{
            atual = app.getPersonById(id);
            //pessoa inserida com sucesso
        } catch(Exception e){
            e.printStackTrace();
            throw new NullPointerException();
        }
        if(atual==null){
            System.out.println("Pessoa não existe!");
            return false;
        }
        return true;
    }   

    public void inserir(String pNome, String uNome, String ruaNum, Integer cep, String cidade, LocalDate nasc){
        
        Person p = new Person(pNome, uNome, ruaNum, cep, cidade, nasc);
               
        try{
            app.insert(p);
        }
        catch(Exception e){
            System.out.println("Houve um problema na inserção de uma nova pessoa."); 
        }
    }
        
    public void atualizar(Long id, String pNome, String uNome, String ruaNum, Integer cep, String cidade, LocalDate nasc) throws NullPointerException{
        Person atual = new Person(pNome, uNome, ruaNum, cep, cidade, nasc);
        atual.setId(id);
            if(verificaPessoa(id)){
            
            try{
                app.update(atual);
                //pessoa atualizada com sucesso
            }
            catch(Exception e){
                e.printStackTrace();
                System.out.println("Houve um problema na atualização desta pessoa."); 
            }
        }
            else /*tenis da nike ta caro*/;
    }
    
    public Person deletar(Long id){
        Person banido = new Person();
        if(verificaPessoa(id)){
            try{
                banido = app.delete(id);
            }catch(Exception e){
                System.out.println("Tal ID não existe");
            }
            return banido;
            
        }
        else return null/*tenis da nike ta caro*/; 
    }
    
    public Person encontrar(Long id){
        Person encontrado = new Person();
        
        try{
            encontrado = app.getPersonById(id);
        } catch(Exception e){
            e.printStackTrace();
        }
        if(encontrado==null) 
            System.out.println("Pessoa com tal ID não existe");  
        return encontrado;
    }
    
    public List<Person> listar(){
        try {
            List<Person> pList = app.listAll();
            return pList;
        } catch(Exception e) {
            e.printStackTrace();
        }       
        return null;
    }
}